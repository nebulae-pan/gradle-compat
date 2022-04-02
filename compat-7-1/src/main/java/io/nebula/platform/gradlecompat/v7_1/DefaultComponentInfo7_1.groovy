package io.nebula.platform.gradlecompat.v7_1

import com.android.build.api.variant.impl.ApplicationVariantImpl
import io.nebula.platform.gradlecompat.api.IArtifactsCompat
import io.nebula.platform.gradlecompat.api.IComponentInfoCompat
import io.nebula.platform.gradlecompat.api.ITaskContainerCompat
import org.gradle.api.Project
import org.jetbrains.annotations.NotNull

/**
 * Created by nebula on 2021/8/12
 */
class DefaultComponentInfo7_1 implements IComponentInfoCompat {
    private Project mProject
    private ApplicationVariantImpl mVariant
    private IArtifactsCompat mArtifacts
    private ITaskContainerCompat mTaskContainer

    DefaultComponentInfo7_1(Project project, ApplicationVariantImpl variant) {
        mProject = project
        mVariant = variant
        mArtifacts = new ArtifactCompatImpl7_1(project, variant.artifacts)
        mTaskContainer = new TaskContainerImpl7_1(project, variant, variant.taskContainer)
    }

    @Override
    String getName() {
        return mVariant.name
    }

    @Override
    IArtifactsCompat getArtifacts() {
        return mArtifacts
    }

    @Override
    ITaskContainerCompat getTaskContainer() {
        return mTaskContainer
    }

    @Override
    String computeTaskName(@NotNull String prefix, @NotNull String suffix) {
        return mVariant.computeTaskName(prefix, suffix)
    }
}