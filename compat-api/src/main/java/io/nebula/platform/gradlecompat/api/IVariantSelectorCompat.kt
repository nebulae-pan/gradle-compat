package io.nebula.platform.gradlecompat.api

import java.util.regex.Pattern

/**
 * Created by nebula on 2021/8/15
 */
interface IVariantSelectorCompat {
    fun all(): IVariantSelectorCompat

    fun withName(pattern: Pattern): IVariantSelectorCompat

    fun withName(name: String): IVariantSelectorCompat
}