package io.nebula.platform.gradlecompat.api

interface ICompatVersionsFactory {
    fun getArtifactsCompat(): IArtifactsCompat

    fun getVariantManager(): IVariantManager

    fun getMergedProcessor(): IMergedManifestProcessor
}