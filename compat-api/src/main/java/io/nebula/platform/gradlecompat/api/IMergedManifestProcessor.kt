package io.nebula.platform.gradlecompat.api

import org.gradle.api.artifacts.component.ComponentArtifactIdentifier
import java.io.File

/**
 * @author xinghai.pan
 * date: 2022-03-30 16:08
 */
interface IMergedManifestProcessor {

    fun processManifestFiles(action: (ComponentArtifactIdentifier, File) -> Unit)
}