package io.nebula.platform.gradlecompat.task

import com.android.build.gradle.internal.tasks.factory.PreConfigAction
import com.android.build.gradle.internal.tasks.factory.TaskConfigAction
import com.android.build.gradle.internal.tasks.factory.TaskInformation
import com.android.build.gradle.internal.tasks.factory.TaskProviderCallback
import org.gradle.api.Task
import org.gradle.api.tasks.TaskProvider

/**
 * Created by nebula on 2021/9/12
 */
abstract class TaskCreationAction<TaskT : Task> : TaskInformation<TaskT>, PreConfigAction,
    TaskConfigAction<TaskT>, TaskProviderCallback<TaskT> {

    override fun preConfigure(taskName: String) {
        // default does nothing
    }

    override fun handleProvider(taskProvider: TaskProvider<TaskT>) {
        // default does nothing
    }
}