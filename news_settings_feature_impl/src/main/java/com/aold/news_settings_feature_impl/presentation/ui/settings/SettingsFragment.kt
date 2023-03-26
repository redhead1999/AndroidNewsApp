package com.aold.news_settings_feature_impl.presentation.ui.settings

import android.os.Bundle
import com.aold.core.core.platform.fragments.BaseFragmentWithViewModel
import com.aold.news_settings_feature_impl.databinding.SettingsFragmentBinding
import com.aold.news_settings_feature_impl.di.holder.NewsSettingsComponentHolder
import javax.inject.Inject

/**
 * @author Kirilin Yury on 03.03.2023.
 */

internal class SettingsFragment :
    BaseFragmentWithViewModel<SettingsFragmentBinding, SettingsViewModel>(
        SettingsFragmentBinding::inflate
    ) {

    @Inject
    lateinit var factory: SettingsViewModel.Factory

    override fun initDI() = NewsSettingsComponentHolder.fetchComponent().inject(this)

    override fun initData(savedInstanceState: Bundle?) {
        super.initData(savedInstanceState)

        viewModel.collectState(viewLifecycleOwner) { state -> state.apply(requireViewBinding()) }

        viewModel.collectSettings(viewLifecycleOwner) { settings ->
            with(requireViewBinding()) {
                categoryTitle.setText(settings.category.title)
                countryTitle.setText(settings.country.title)
                languageTitle.setText(settings.language.title)
            }
        }

        viewModel.init(savedInstanceState == null)
    }

    override fun initView(savedInstanceState: Bundle?) = with(requireViewBinding()) {
        super.initView(savedInstanceState)

        categoryLayout.setOnClickListener { viewModel.pressCategorySettingsItem() }

        languageLayout.setOnClickListener { viewModel.pressLanguageSettingsItem() }

        countryLayout.setOnClickListener { viewModel.pressCountrySettingsItem() }
    }

    override fun fetchViewModelClass() = SettingsViewModel::class.java

    override fun fetchViewModelFactory() = factory
}