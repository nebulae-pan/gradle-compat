package io.nebula.platform.gradlecompat.api

import org.gradle.api.Action

/**
 * Created by nebula on 2021/8/15
 */
interface IVariantCompat {
    fun selector(): IVariantSelectorCompat

    fun onVariants(
        selector: IVariantSelectorCompat,
        action: (Action<VariantCompat>) -> Unit
    )
}