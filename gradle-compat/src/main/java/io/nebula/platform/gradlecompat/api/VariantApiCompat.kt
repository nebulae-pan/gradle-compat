package io.nebula.platform.gradlecompat.api

import org.gradle.api.Action

/**
 * Created by nebula on 2021/8/14
 */
object VariantApiCompat : IVariantCompat {
    override fun selector(): IVariantSelectorCompat {
        return VariantSelectorCompat()
    }

    override fun onVariants(
        selector: IVariantSelectorCompat,
        action: (Action<VariantCompat>) -> Unit
    ) {
    }

}