package io.nebula.platform.gradlecompat.api

/**
 * @author xinghai.pan
 * date: 2022-03-27 00:25
 */
interface IVariantCompat {
    val name: String
    fun getComponentInfo(): IComponentInfoCompat
    fun getApplicationId(): String
    fun setApplicationId(applicationId: String)
    fun putManifestPlaceHolder(key: String, value: String)
    fun realVariant(): Any?
}