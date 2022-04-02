package io.nebula.platform.gradlecompat.api

/**
 * @author xinghai.pan
 * date: 2022-03-30 20:56
 */
interface IComponentBuilder {
    val name: String
    val applicationId: String
    fun setApplicationId(applicationId: String)
}