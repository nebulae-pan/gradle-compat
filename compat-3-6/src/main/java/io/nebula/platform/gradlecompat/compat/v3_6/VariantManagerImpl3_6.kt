package io.nebula.platform.gradlecompat.compat.v3_6


import com.android.build.gradle.internal.plugins.AppPlugin
import io.nebula.platform.gradlecompat.api.*
import org.gradle.api.Project

/**
 * Created by nebula on 2021/8/12
 */
open class VariantManagerImpl3_6(private val project: Project) : IVariantManager {

    @Override
    override fun selector(): IVariantSelectorCompat {
        return VariantSelectorCompat()
    }

    override fun beforeVariants(
        selector: IVariantSelectorCompat,
        action: (IComponentBuilder) -> Unit
    ) {
        project.afterEvaluate {
            project.plugins.getPlugin(AppPlugin::class.java).variantManager.variantScopes.forEach {
                action.invoke(ComponentBuilderCompatImpl3_6(project, it))
            }
        }
    }

    override fun onVariants(selector: IVariantSelectorCompat, action: (IVariantCompat) -> Unit) {
        project.afterEvaluate {
            project.plugins.getPlugin(AppPlugin::class.java).variantManager.variantScopes.forEach {
                action.invoke(VariantCompatImpl3_6(project, it))
            }
        }
    }

    override fun variantsAfterEvaluate(): List<IVariantCompat> {
        return emptyList()
    }
}