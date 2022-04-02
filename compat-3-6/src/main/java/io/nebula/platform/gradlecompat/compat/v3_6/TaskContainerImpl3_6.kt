package io.nebula.platform.gradlecompat.compat.v3_6

import com.android.build.gradle.internal.scope.MutableTaskContainer
import com.android.build.gradle.internal.scope.TaskContainer
import io.nebula.platform.gradlecompat.api.ITaskContainerCompat
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.tasks.TaskProvider

/**
 * Created by nebula on 2021/8/12
 */
class TaskContainerImpl3_6(private val project: Project, private val taskContainer: TaskContainer) :
    ITaskContainerCompat {

    override val mergeAssetsTask: Task
        get() = taskContainer.mergeAssetsTask.get()
    override val compressAssetsTask: Task?
        get() = null
    override val packageAndroidTask: Task?
        get() = taskContainer.packageAndroidTask?.get()
    override val bundleTask: Task?
        get() = (taskContainer as MutableTaskContainer).bundleTask?.get()
    override val assembleTask: Task?
        get() = taskContainer.assembleTask.get()
}