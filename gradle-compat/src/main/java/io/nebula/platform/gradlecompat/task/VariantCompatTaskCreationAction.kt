package io.nebula.platform.gradlecompat.task

import com.android.build.gradle.internal.tasks.VariantAwareTask
import com.android.build.gradle.internal.tasks.factory.TaskCreationAction
import io.nebula.platform.gradlecompat.api.IComponentInfoCompat
import org.gradle.api.Task

/**
 * Created by nebula on 2021/9/12
 */
abstract class VariantCompatTaskCreationAction<TaskT>(
    protected val componentVariant: IComponentInfoCompat
) : TaskCreationAction<TaskT>() where TaskT : Task, TaskT : VariantAwareTask {
    protected fun computeTaskName(prefix: String, suffix: String = ""): String =
        componentVariant.computeTaskName(prefix, suffix)

    override fun configure(task: TaskT) {
        task.variantName = componentVariant.name
    }
}
