package io.nebula.platform.gradlecompat.api

import com.android.build.api.variant.*
import org.gradle.api.file.RegularFile
import org.gradle.api.provider.ListProperty
import org.gradle.api.provider.MapProperty
import org.gradle.api.provider.Provider
import java.io.Serializable

/**
 * Created by nebula on 2021/8/16
 */
interface VariantCompat {

    /**
     * Gets the minimum supported SDK Version for this variant.
     */
    val minSdkVersion: AndroidVersion

    /**
     * Gets the maximum supported SDK Version for this variant.
     */
    val maxSdkVersion: Int?

    /**
     * Gets the target SDK Version for this variant.
     */
    val targetSdkVersion: AndroidVersion

    /**
     * The namespace of the generated R and BuildConfig classes. Also, the namespace used to resolve
     * any relative class names that are declared in the AndroidManifest.xml.
     *
     * This value supersedes any value specified by the `package` attribute in the source
     * AndroidManifest.xml, but doing a 'get' on this property will not retrieve the value specified
     * in the AndroidManifest.xml.
     */
    val namespace: Provider<String>

    /**
     * Variant's [BuildConfigField] which will be generated in the BuildConfig class.
     */
    val buildConfigFields: MapProperty<String, BuildConfigField<out Serializable>>

    /**
     * [MapProperty] of the variant's manifest placeholders.
     *
     * Placeholders are organized with a key and a value. The value is a [String] that will be
     * used as is in the merged manifest.
     *
     * @return the [MapProperty] with keys as [String]
     */
    val manifestPlaceholders: MapProperty<String, String>

    /**
     * Variant's packagingOptions, initialized by the corresponding global DSL element.
     */
    val packaging: Packaging

    /**
     * Variant's cmake [ExternalNativeBuild], initialized by merging the product flavor values or
     * null if no cmake external build is configured for this variant.
     */
    val externalNativeBuild: ExternalNativeBuild?

    /**
     * Returns an extension object registered via the [VariantBuilder.registerExtension] API or
     * null if none were registered under the passed [type].
     *
     * @return the registered object or null.
     */
    fun <T> getExtension(type: Class<T>): T?

    /**
     * List of proguard configuration files for this variant. The list is initialized from the
     * corresponding DSL element, and cannot be queried at configuration time. At configuration time,
     * you can only add new elements to the list.
     *
     * This list will be initialized from [com.android.build.api.dsl.VariantDimension#proguardFile]
     * for non test related variants and from
     * [com.android.build.api.dsl.VariantDimension.testProguardFiles] for test related variants.
     */
    val proguardFiles: ListProperty<RegularFile>

}