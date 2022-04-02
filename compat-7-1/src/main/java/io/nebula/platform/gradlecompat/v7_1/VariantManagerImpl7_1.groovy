package io.nebula.platform.gradlecompat.v7_1

import com.android.build.api.variant.AndroidComponentsExtension
import com.android.build.gradle.AppExtension
import io.nebula.platform.gradlecompat.api.IComponentBuilder
import io.nebula.platform.gradlecompat.api.IVariantCompat
import io.nebula.platform.gradlecompat.api.IVariantManager
import io.nebula.platform.gradlecompat.api.IVariantSelectorCompat
import io.nebula.platform.gradlecompat.api.VariantSelectorCompat
import kotlin.Unit
import kotlin.jvm.functions.Function1
import org.gradle.api.Project
import org.jetbrains.annotations.NotNull

/**
 * Created by nebula on 2021/8/12
 */
class VariantManagerImpl7_1 implements IVariantManager {
    private Project mProject

    VariantManagerImpl7_1(Project project) {
        mProject = project
    }

    @Override
    IVariantSelectorCompat selector() {
        return new VariantSelectorCompat()
    }

    @Override
    void beforeVariants(@NotNull IVariantSelectorCompat selector, @NotNull Function1<? super IComponentBuilder, Unit> action) {
        def androidComponent = mProject.getExtensions().findByType(AndroidComponentsExtension)
        androidComponent.beforeVariants(androidComponent.selector().all()) {
            action.invoke(new ComponentBuilderCompatImpl7_1(mProject, it))
        }
    }

    @Override
    void onVariants(@NotNull IVariantSelectorCompat selector, @NotNull Function1<? super IVariantCompat, Unit> action) {
        mProject.androidComponents.onVariants(mProject.androidComponents.selector().all()) {
            action.invoke(new VariantCompatImpl7_1(mProject, it))
        }
    }

    @Override
    List<IVariantCompat> variantsAfterEvaluate() {
        return mProject.getExtensions().findByType(AppExtension).applicationVariants.collect {
            new VariantCompatImpl7_1(mProject, it)
        }
    }

}