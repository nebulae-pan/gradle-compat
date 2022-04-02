package io.nebula.platform.gradlecompat

import com.android.Version
import io.nebula.platform.gradlecompat.api.ICompatVersionsFactory
import io.nebula.platform.gradlecompat.compat.v3_6.Compat3_6
import io.nebula.platform.gradlecompat.v7_1.Compat7_1
import org.gradle.api.Project

/**
 * @author xinghai.pan
 * date: 2022-04-01 12:15
 */
fun constructVersionsImpl(project: Project): ICompatVersionsFactory {
    return when (val version = Version.ANDROID_GRADLE_PLUGIN_VERSION) {
        "3.6.4" ->
            Compat3_6(project)
        "7.1.2" ->
            Compat7_1(project)
        else ->
            throw  RuntimeException("didn't support version: $version")
    }
}

class CompatCore(private val project: Project) :
    ICompatVersionsFactory by constructVersionsImpl(project)