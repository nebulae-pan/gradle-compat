package io.nebula.platform.gradlecompat.task

import com.android.build.gradle.internal.tasks.VariantAwareTask
import com.android.build.gradle.internal.tasks.factory.TaskCreationAction
import org.gradle.api.Task

/**
 * Created by nebula on 2021/9/12
 */
abstract class VariantTaskCreationAction<TaskT>(
) : TaskCreationAction<TaskT>() where TaskT : Task, TaskT : VariantAwareTask {
    protected fun computeTaskName(prefix: String, suffix: String = ""): String =
        TaskCompat.computeTaskName(prefix, suffix)
}
