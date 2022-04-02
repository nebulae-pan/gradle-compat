package io.nebula.platform.gradlecompat.api

/**
 * @author xinghai.pan
 * date: 2022-03-27 00:36
 */
interface IVariantManager {
    fun selector(): IVariantSelectorCompat

    fun beforeVariants(
        selector: IVariantSelectorCompat = selector().all(),
        action: (IComponentBuilder) -> Unit
    )

    fun onVariants(
        selector: IVariantSelectorCompat = selector().all(),
        action: (IVariantCompat) -> Unit
    )

    fun variantsAfterEvaluate(): List<IVariantCompat>
}