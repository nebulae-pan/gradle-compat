package io.nebula.platform.gradlecompat.api

import org.gradle.api.Task

/**
 * @author xinghai.pan
 * date: 2022-03-26 23:04
 */
interface ITaskContainerCompat {
    val mergeAssetsTask: Task

    val compressAssetsTask: Task?

    val packageAndroidTask: Task?

    val bundleTask: Task?

    val assembleTask: Task?
}