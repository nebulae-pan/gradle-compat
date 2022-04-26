package io.nebula.platform.gradlecompat.compat.v3_6

import com.android.build.gradle.AppExtension
import com.android.build.gradle.internal.scope.VariantScope
import com.android.builder.core.MergedFlavor
import io.nebula.platform.gradlecompat.api.IComponentInfoCompat
import io.nebula.platform.gradlecompat.api.IVariantCompat
import org.gradle.api.Project

/**
 * Created by nebula on 2021/8/12
 */
class VariantCompatImpl3_6(
    private val project: Project,
    private val variant: VariantScope
) : IVariantCompat {
    private val componentInfo = DefaultComponentInfo3_6(project, variant)

    override val name: String
        get() = variant.fullVariantName

    override fun getComponentInfo(): IComponentInfoCompat {
        return componentInfo
    }

    override fun getApplicationId(): String {
        return variant.variantData.applicationId
    }

    override fun setApplicationId(applicationId: String) {
        val flavor = variant.variantData.variantConfiguration.mergedFlavor as MergedFlavor
        flavor.applicationId = applicationId
    }

    override fun putManifestPlaceHolder(key: String, value: String) {
        val flavor = variant.variantData.variantConfiguration.mergedFlavor as MergedFlavor
        flavor.manifestPlaceholders[key] = value
    }

    override fun realVariant(): Any? {
        return project.extensions
            .findByType(AppExtension::class.java)?.applicationVariants?.find {
                it.name == name
            }
    }
}