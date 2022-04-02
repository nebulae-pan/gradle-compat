package io.nebula.platform.gradlecompat.api

import java.io.File

/**
 * @author xinghai.pan
 * date: 2022-03-26 23:08
 */
interface IArtifactsCompat {
    enum class CompactTypes {
        MERGED_ASSETS,
        MERGED_NATIVE_LIBS,
    }

    fun getArtifact(type: CompactTypes): File?

    fun getAllArtifact(type: CompactTypes): List<File>?
}