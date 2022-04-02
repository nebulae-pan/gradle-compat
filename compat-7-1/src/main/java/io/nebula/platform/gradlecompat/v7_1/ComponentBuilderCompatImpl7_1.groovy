package io.nebula.platform.gradlecompat.v7_1

import com.android.build.api.variant.impl.VariantBuilderImpl
import io.nebula.platform.gradlecompat.api.IComponentBuilder
import org.gradle.api.Project
import org.jetbrains.annotations.NotNull

/**
 * Created by nebula on 2021/8/12
 */
class ComponentBuilderCompatImpl7_1 implements IComponentBuilder {
    private Project mProject
    private VariantBuilderImpl mVariantBuilder

    ComponentBuilderCompatImpl7_1(Project project, VariantBuilderImpl variantBuilder) {
        mProject = project
        mVariantBuilder = variantBuilder
    }

    @Override
    String getName() {
        return mVariantBuilder.name
    }

    @Override
    String getApplicationId() {
        return mVariantBuilder.variantDslInfo.mergedFlavor.applicationId
    }

    @Override
    void setApplicationId(@NotNull String applicationId) {
        mVariantBuilder.variantDslInfo.mergedFlavor.applicationId = applicationId
    }
}