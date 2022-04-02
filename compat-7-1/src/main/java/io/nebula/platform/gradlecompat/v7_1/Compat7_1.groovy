package io.nebula.platform.gradlecompat.v7_1

import io.nebula.platform.gradlecompat.api.IArtifactsCompat
import io.nebula.platform.gradlecompat.api.ICompatVersionsFactory
import io.nebula.platform.gradlecompat.api.IMergedManifestProcessor
import io.nebula.platform.gradlecompat.api.IVariantManager
import org.gradle.api.Project

/**
 * Created by nebula on 2021/8/12
 */
class Compat7_1 implements ICompatVersionsFactory {
    private IVariantManager mVariantManager
    private IMergedManifestProcessor mManifestProcessor

    Compat7_1(Project project) {
        mVariantManager = new VariantManagerImpl7_1(project)
        mManifestProcessor = new MergedManifestProcessorImpl7_1(project)
    }

    @Override
    IArtifactsCompat getArtifactsCompat() {
        return null
    }

    @Override
    IVariantManager getVariantManager() {
        return mVariantManager
    }

    @Override
    IMergedManifestProcessor getMergedProcessor() {
        return mManifestProcessor
    }
}