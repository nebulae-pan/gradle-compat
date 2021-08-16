package io.nebula.platform.gradlecompat.api

import com.android.build.api.variant.ComponentIdentity
import java.util.regex.Pattern

/**
 * Created by nebula on 2021/8/15
 */
open class VariantSelectorCompat : IVariantSelectorCompat {
    override fun all(): IVariantSelectorCompat {
        return this
    }

    // By default the selector applies to all variants.
    internal open fun appliesTo(variant: ComponentIdentity): Boolean {
        return true
    }

    override fun withBuildType(buildType: String): IVariantSelectorCompat {
        return object : VariantSelectorCompat() {
            override fun appliesTo(variant: ComponentIdentity): Boolean {
                return buildType == variant.buildType && this@VariantSelectorCompat.appliesTo(
                    variant
                )
            }
        }
    }

    override fun withFlavor(flavorToDimension: Pair<String, String>): IVariantSelectorCompat {
        return object : VariantSelectorCompat() {
            override fun appliesTo(variant: ComponentIdentity): Boolean {
                return variant.productFlavors.contains(flavorToDimension) && this@VariantSelectorCompat.appliesTo(
                    variant
                )
            }
        }
    }

    override fun withName(pattern: Pattern): IVariantSelectorCompat {
        return object : VariantSelectorCompat() {
            override fun appliesTo(variant: ComponentIdentity): Boolean {
                return pattern.matcher(variant.name)
                    .matches() && this@VariantSelectorCompat.appliesTo(variant)
            }
        }
    }

    override fun withName(name: String): IVariantSelectorCompat {
        return object : VariantSelectorCompat() {
            override fun appliesTo(variant: ComponentIdentity): Boolean {
                return variant.name == name && this@VariantSelectorCompat.appliesTo(variant)
            }
        }
    }

}