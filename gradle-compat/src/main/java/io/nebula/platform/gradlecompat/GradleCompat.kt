package io.nebula.platform.gradlecompat

import io.nebula.platform.gradlecompat.api.IMergedManifestProcessor
import io.nebula.platform.gradlecompat.api.IVariantManager
import org.gradle.api.Project


object GradleCompat {
    private var compatCore: CompatCore? = null

    fun variantManager(project: Project): IVariantManager {
        return compatCore(project).getVariantManager()
    }

    fun mergedManifestProcessor(project: Project): IMergedManifestProcessor {
        return compatCore(project).getMergedProcessor()
    }

    private fun compatCore(project: Project): CompatCore {
        val core = compatCore ?: CompatCore(project).apply {
            compatCore = this
        }
        return core
    }
}