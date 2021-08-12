package io.nebula.platform.gradlecompat

import com.android.build.gradle.AppExtension
import org.gradle.api.Project


class GradleCompat {
    fun apply(project: Project) {

        project.extensions.getByType(AppExtension::class.java)
    }
}