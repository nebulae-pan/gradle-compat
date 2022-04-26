package io.nebula.platform.gradlecompat.compat.v3_6

import io.nebula.platform.gradlecompat.api.IMergedManifestProcessor
import org.gradle.api.Project
import org.gradle.api.artifacts.component.ComponentArtifactIdentifier
import java.io.File

class MergedManifestProcessorImpl3_6(project: Project) : IMergedManifestProcessor {
    override fun processManifestFiles(
        variantName: String,
        action: (ComponentArtifactIdentifier, File) -> Unit
    ) {
    }
}