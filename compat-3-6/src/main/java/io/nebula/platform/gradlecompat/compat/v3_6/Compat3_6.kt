package io.nebula.platform.gradlecompat.compat.v3_6

import io.nebula.platform.gradlecompat.api.IArtifactsCompat
import io.nebula.platform.gradlecompat.api.IMergedManifestProcessor
import io.nebula.platform.gradlecompat.api.IVariantManager
import io.nebula.platform.gradlecompat.api.ICompatVersionsFactory
import org.gradle.api.Project

/**
 * Created by nebula on 2021/8/12
 */
class Compat3_6(private val project: Project) : ICompatVersionsFactory {
    private val variantManager = VariantManagerImpl3_6(project)
    private val manifestProcessor = MergedManifestProcessorImpl3_6(project)

    override fun getArtifactsCompat(): IArtifactsCompat {
        TODO("Not yet implemented")
    }

    override fun getVariantManager(): IVariantManager {
        return variantManager
    }

    override fun getMergedProcessor(): IMergedManifestProcessor {
        return manifestProcessor
    }
}