package io.nebula.platform.gradlecompat.api

/**
 * @author xinghai.pan
 * date: 2022-03-25 23:34
 */
interface IComponentInfoCompat {
    val name: String
    val artifacts: IArtifactsCompat
    val taskContainer: ITaskContainerCompat

    fun computeTaskName(prefix: String, suffix: String): String
}