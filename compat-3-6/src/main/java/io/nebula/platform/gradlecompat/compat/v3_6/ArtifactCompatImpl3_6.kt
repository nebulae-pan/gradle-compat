package io.nebula.platform.gradlecompat.compat.v3_6

import com.android.build.api.artifact.ArtifactType
import com.android.build.gradle.internal.scope.BuildArtifactsHolder
import com.android.build.gradle.internal.scope.InternalArtifactType
import io.nebula.platform.gradlecompat.api.IArtifactsCompat
import org.gradle.api.Project
import org.gradle.api.file.FileSystemLocation
import org.gradle.api.provider.Provider
import org.jetbrains.annotations.NotNull
import java.io.File

/**
 * Created by nebula on 2021/8/12
 */
class ArtifactCompatImpl3_6(
    private val project: Project,
    private val artifacts: BuildArtifactsHolder
) : IArtifactsCompat {

    override fun getArtifact(type: IArtifactsCompat.CompactTypes): File? {
        return artifacts.getFinalProduct(typeMapping(type)).get().asFile
    }

    override fun getAllArtifact(type: IArtifactsCompat.CompactTypes): List<File>? {
        return listOf(
            artifacts.getFinalProducts(multiTypeMapping(type)).get().toList().maxOf { it.asFile })
    }

    private fun multiTypeMapping(type: IArtifactsCompat.CompactTypes): ArtifactType<out FileSystemLocation> {
        return when (type) {
            IArtifactsCompat.CompactTypes.MERGED_ASSETS ->
                InternalArtifactType.MERGED_ASSETS
            else ->
                throw RuntimeException("cannot find type:$type in ArtifactCompat")
        }
    }

    private fun typeMapping(type: IArtifactsCompat.CompactTypes): ArtifactType<out FileSystemLocation> {
        return when (type) {
            IArtifactsCompat.CompactTypes.MERGED_ASSETS ->
                InternalArtifactType.MERGED_ASSETS
            IArtifactsCompat.CompactTypes.MERGED_NATIVE_LIBS ->
                InternalArtifactType.MERGED_NATIVE_LIBS
            else ->
                throw RuntimeException("cannot find type:$type in ArtifactCompat")
        }
    }
}