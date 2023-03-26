package com.aold.news_settings_feature_impl.presentation.ui.countries

import android.os.Bundle
import android.view.View
import com.aold.core.core.extensions.addRadioButton
import com.aold.core.core.extensions.checkByTag
import com.aold.core.core.extensions.checkedRadioButtonTag
import com.aold.core.core.platform.dialogs.BaseDialogFragmentWithViewModel
import com.aold.news_settings_feature_api.domain.Countries
import com.aold.news_settings_feature_api.domain.convertToCountry
import com.aold.news_settings_feature_impl.databinding.CountriesDialogFragmentBinding
import com.aold.news_settings_feature_impl.di.holder.NewsSettingsComponentHolder
import com.aold.news_settings_feature_impl.presentation.ui.settings.SettingsViewModel
import javax.inject.Inject

/**
 * @author Kirilin Yury on 26.03.2023.
 */

internal class CountriesDialogFragment :
    BaseDialogFragmentWithViewModel<CountriesDialogFragmentBinding, SettingsViewModel>(
        CountriesDialogFragmentBinding::inflate
    ) {

    @Inject
    lateinit var factory: SettingsViewModel.Factory

    override fun initDI() = NewsSettingsComponentHolder.fetchComponent().inject(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) =
        with(requireViewBinding()) {
            super.onViewCreated(view, savedInstanceState)

            Countries.values().forEach { radioGroup.addRadioButton(it.title, it.data) }

            viewModel.collectSettings(viewLifecycleOwner) { settings ->
                radioGroup.checkByTag(settings.country.data)
            }

            radioGroup.setOnCheckedChangeListener { radioGroup, _ ->
                viewModel.updateSettings(
                    countries = radioGroup.checkedRadioButtonTag().convertToCountry()
                )
            }

            positiveButton.setOnClickListener { dismiss() }
        }

    override fun fetchViewModelClass() = SettingsViewModel::class.java

    override fun fetchViewModelFactory() = factory
}