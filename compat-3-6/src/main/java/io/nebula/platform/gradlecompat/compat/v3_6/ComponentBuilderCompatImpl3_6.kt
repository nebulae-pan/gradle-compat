package io.nebula.platform.gradlecompat.compat.v3_6

import com.android.build.gradle.internal.scope.VariantScope
import com.android.builder.core.MergedFlavor
import io.nebula.platform.gradlecompat.api.IComponentBuilder
import org.gradle.api.Project

/**
 * Created by nebula on 2021/8/12
 */
class ComponentBuilderCompatImpl3_6(
    private val project: Project,
    private val variantScope: VariantScope
) : IComponentBuilder {

    override val name: String
        get() = variantScope.fullVariantName
    override val applicationId: String
        get() = variantScope.variantData.applicationId

    override fun setApplicationId(applicationId: String) {
        val flavor = variantScope.variantData.variantConfiguration.mergedFlavor as MergedFlavor
        flavor.applicationId = applicationId
    }
}