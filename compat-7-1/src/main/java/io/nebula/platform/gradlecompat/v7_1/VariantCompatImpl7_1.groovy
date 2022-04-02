package io.nebula.platform.gradlecompat.v7_1

import com.android.build.api.variant.impl.ApplicationVariantImpl
import com.android.build.gradle.AppExtension
import io.nebula.platform.gradlecompat.api.IComponentInfoCompat
import io.nebula.platform.gradlecompat.api.IVariantCompat
import org.gradle.api.Project
import org.jetbrains.annotations.NotNull

/**
 * Created by nebula on 2021/8/12
 */
class VariantCompatImpl7_1 implements IVariantCompat {
    private Project mProject
    private ApplicationVariantImpl mVariant
    private IComponentInfoCompat componentInfo

    VariantCompatImpl7_1(Project project, ApplicationVariantImpl variant) {
        mProject = project
        mVariant = variant
        componentInfo = new DefaultComponentInfo7_1(project, variant)
    }

    @Override
    String getName() {
        return mVariant.name
    }

    @Override
    IComponentInfoCompat getComponentInfo() {
        return componentInfo
    }

    @Override
    String getApplicationId() {
        return mVariant.variantDslInfo.mergedFlavor.applicationId
    }

    @Override
    void setApplicationId(@NotNull String applicationId) {
        mVariant.variantDslInfo.mergedFlavor.applicationId = applicationId
    }

    @Override
    Object realVariant() {
        return mProject.getExtensions().findByType(AppExtension).applicationVariants.find {
            it.name == getName()
        }
    }
}