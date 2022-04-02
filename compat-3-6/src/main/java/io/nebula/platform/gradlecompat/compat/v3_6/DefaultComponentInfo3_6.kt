package io.nebula.platform.gradlecompat.compat.v3_6

import com.android.build.gradle.internal.scope.VariantScope
import io.nebula.platform.gradlecompat.api.IArtifactsCompat
import io.nebula.platform.gradlecompat.api.IComponentInfoCompat
import io.nebula.platform.gradlecompat.api.ITaskContainerCompat
import org.gradle.api.Project
import org.jetbrains.annotations.NotNull

/**
 * Created by nebula on 2021/8/12
 */
class DefaultComponentInfo3_6(
    private val project: Project,
    private val variantScope: VariantScope
) : IComponentInfoCompat {
    private val _artifacts = ArtifactCompatImpl3_6(project, variantScope.artifacts)
    private val _taskContainer = TaskContainerImpl3_6(project, variantScope.taskContainer)

    override val name: String
        get() = variantScope.fullVariantName
    override val artifacts: IArtifactsCompat
        get() = _artifacts
    override val taskContainer: ITaskContainerCompat
        get() = _taskContainer

    override fun computeTaskName(prefix: String, suffix: String): String {
        return variantScope.getTaskName(prefix, suffix)
    }
}