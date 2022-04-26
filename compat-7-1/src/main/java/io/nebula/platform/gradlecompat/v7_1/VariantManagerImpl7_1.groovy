package io.nebula.platform.gradlecompat.v7_1

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

import java.lang.reflect.Field

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
        def androidComponents = mProject.androidComponents
        def field = (Field) androidComponents.class.superclass.superclass.superclass.getDeclaredField("variantApiOperations")
        field.setAccessible(true)
        def variantApiOperations = field.get(androidComponents)
        println variantApiOperations.variantBuilderOperations.hashCode()
        if (variantApiOperations.variantBuilderOperations.actionsExecuted.get()) {
            return
        }
        mProject.androidComponents.beforeVariants(mProject.androidComponents.selector().all()) {
            action.invoke(new ComponentBuilderCompatImpl7_1(mProject, it))
        }
    }

    @Override
    void onVariants(@NotNull IVariantSelectorCompat selector, @NotNull Function1<? super IVariantCompat, Unit> action) {
        def androidComponents = mProject.androidComponents
        def field = (Field) androidComponents.class.superclass.superclass.superclass.getDeclaredField("variantApiOperations")
        field.setAccessible(true)
        def variantApiOperations = field.get(androidComponents)
        if (variantApiOperations.variantOperations.actionsExecuted.get()) {
            return
        }
        androidComponents.onVariants(androidComponents.selector().all()) {
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