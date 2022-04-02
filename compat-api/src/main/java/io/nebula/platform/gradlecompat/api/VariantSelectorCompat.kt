package io.nebula.platform.gradlecompat.api

import java.util.regex.Pattern

/**
 * Created by nebula on 2021/8/15
 */
open class VariantSelectorCompat : IVariantSelectorCompat {
    override fun all(): IVariantSelectorCompat {
        return this
    }

    // By default the selector applies to all variants.
    internal open fun appliesTo(variant: IComponentInfoCompat): Boolean {
        return true
    }

    override fun withName(pattern: Pattern): IVariantSelectorCompat {
        return object : VariantSelectorCompat() {
            override fun appliesTo(variant: IComponentInfoCompat): Boolean {
                return pattern.matcher(variant.name)
                    .matches() && this@VariantSelectorCompat.appliesTo(variant)
            }
        }
    }

    override fun withName(name: String): IVariantSelectorCompat {
        return object : VariantSelectorCompat() {
            override fun appliesTo(variant: IComponentInfoCompat): Boolean {
                return variant.name == name && this@VariantSelectorCompat.appliesTo(variant)
            }
        }
    }

}