package io.nebula.platform.gradlecompat.v7_1

import com.android.build.api.variant.impl.ApplicationVariantImpl
import com.android.build.gradle.internal.scope.TaskContainer
import io.nebula.platform.gradlecompat.api.ITaskContainerCompat
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.tasks.TaskProvider

/**
 * Created by nebula on 2021/8/12
 */
class TaskContainerImpl7_1 implements ITaskContainerCompat {
    private Project mProject
    private TaskContainer mTaskContainer
    private ApplicationVariantImpl mVariant

    TaskContainerImpl7_1(Project project, ApplicationVariantImpl variant, TaskContainer taskContainer) {
        mProject = project
        mTaskContainer = taskContainer
        mVariant = variant
    }

    @Override
    Task getMergeAssetsTask() {
        return getTaskByProvider(mTaskContainer.mergeAssetsTask)
    }

    @Override
    Task getPackageAndroidTask() {
        return getTaskByProvider(mTaskContainer.packageAndroidTask)
    }

    @Override
    Task getBundleTask() {
        return getTaskByProvider(mTaskContainer.bundleLibraryTask)
    }

    @Override
    Task getAssembleTask() {
        return getTaskByProvider(mTaskContainer.assembleTask)
    }

    private static Task getTaskByProvider(TaskProvider<Task> provider) {
        if (provider == null) {
            return null
        }
        return provider.get()
    }

    @Override
    Task getCompressAssetsTask() {
        return getTaskByProvider(mProject.tasks.named(mVariant.computeTaskName("compress", "Assets")))
    }
}