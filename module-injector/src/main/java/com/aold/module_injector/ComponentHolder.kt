package com.aold.module_injector

/**
 * @author {Kirilin Yury} on 27.02.2023.
 */

interface ComponentHolder<A : BaseFeatureApi, D : BaseFeatureDependencies> {

    fun initComponent(dependencies: D)

    fun fetchApi(): A

    fun reset()
}
