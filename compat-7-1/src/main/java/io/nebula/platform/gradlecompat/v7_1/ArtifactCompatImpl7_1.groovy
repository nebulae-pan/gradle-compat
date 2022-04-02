package io.nebula.platform.gradlecompat.v7_1

import com.android.build.api.artifact.Artifact
import com.android.build.api.artifact.Artifacts
import com.android.build.api.artifact.MultipleArtifact
import com.android.build.api.artifact.impl.ArtifactsImpl
import com.android.build.gradle.internal.scope.InternalArtifactType
import io.nebula.platform.gradlecompat.api.IArtifactsCompat
import org.gradle.api.Project
import org.gradle.api.file.FileSystemLocation
import org.gradle.api.provider.Provider
import org.jetbrains.annotations.NotNull

/**
 * Created by nebula on 2021/8/12
 */
class ArtifactCompatImpl7_1 implements IArtifactsCompat {
    private Project mProject
    private ArtifactsImpl mArtifacts

    ArtifactCompatImpl7_1(Project project, Artifacts artifacts) {
        mProject = project
        mArtifacts = (ArtifactsImpl) artifacts
    }

    @Override
    File getArtifact(@NotNull CompactTypes type) {
        return getFileByArtifacts(mArtifacts.get(typeMapping(type)))
    }

    @Override
    List<File> getAllArtifact(@NotNull CompactTypes type) {
        return getFileListByArtifacts(mArtifacts.getAll(multiTypeMapping(type)))
    }

    private static Artifact.Multiple multiTypeMapping(CompactTypes type) {
        switch (type) {
            case CompactTypes.MERGED_ASSETS:
                return MultipleArtifact.ASSETS.INSTANCE
            default:
                throw RuntimeException("cannot find type:$type in ArtifactCompat")
        }
    }

    private static Artifact.Single typeMapping(CompactTypes type) {
        switch (type) {
            case CompactTypes.MERGED_ASSETS:
                return InternalArtifactType.COMPRESSED_ASSETS.INSTANCE
            case CompactTypes.MERGED_NATIVE_LIBS:
                return InternalArtifactType.MERGED_NATIVE_LIBS.INSTANCE
            default:
                throw RuntimeException("cannot find type:$type in ArtifactCompat")
        }
    }

    private static File getFileByArtifacts(Provider<FileSystemLocation> provider) {
        def systemLocation = provider.getOrNull()
        if (systemLocation == null) {
            return null
        }
        return systemLocation.asFile
    }

    private static List<File> getFileListByArtifacts(Provider<List<FileSystemLocation>> provider) {
        def systemLocations = provider.getOrNull()
        if (systemLocations == null) {
            return null
        }
        return systemLocations.collect { it.asFile }
    }
}