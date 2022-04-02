package io.nebula.platform.gradlecompat.v7_1


import com.android.build.gradle.internal.plugins.AppPlugin
import com.android.build.gradle.internal.publishing.AndroidArtifacts
import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactScope
import com.android.build.gradle.internal.publishing.AndroidArtifacts.ConsumedConfigType
import io.nebula.platform.gradlecompat.api.IMergedManifestProcessor
import kotlin.Unit
import kotlin.jvm.functions.Function2
import org.gradle.api.Project
import org.gradle.api.artifacts.component.ComponentArtifactIdentifier
import org.jetbrains.annotations.NotNull

class MergedManifestProcessorImpl7_1 implements IMergedManifestProcessor {
    private Project mProject

    MergedManifestProcessorImpl7_1(Project project) {
        mProject = project
    }

    @Override
    void processManifestFiles(@NotNull Function2<? super ComponentArtifactIdentifier, ? super File, Unit> action) {
        mProject.afterEvaluate {
            mProject.plugins.getPlugin(AppPlugin).variantManager.mainComponents.forEach {
                def manifestArtifacts = it.variant
                        .variantDependencies
                        .getArtifactCollection(
                                ConsumedConfigType.RUNTIME_CLASSPATH,
                                ArtifactScope.ALL,
                                AndroidArtifacts.ArtifactType.MANIFEST
                        ).artifacts
                for (def artifact : manifestArtifacts) {
                    action.invoke(artifact.id, artifact.file)
                }
            }
        }
    }
}