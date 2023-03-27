package com.aold.news_settings_feature_impl.presentation.ui.languages

import android.os.Bundle
import android.view.View
import com.aold.core.core.extensions.addRadioButton
import com.aold.core.core.extensions.checkByTag
import com.aold.core.core.extensions.checkedRadioButtonTag
import com.aold.core.core.platform.dialogs.BaseDialogFragmentWithViewModel
import com.aold.news_settings_feature_api.domain.Languages
import com.aold.news_settings_feature_api.domain.convertToLanguage
import com.aold.news_settings_feature_impl.databinding.LanguagesDialogFragmentBinding
import com.aold.news_settings_feature_impl.di.holder.NewsSettingsComponentHolder
import com.aold.news_settings_feature_impl.presentation.ui.settings.SettingsViewModel
import javax.inject.Inject

/**
 * @author Kirilin Yury on 26.03.2023.
 */

internal class LanguagesDialogFragment :
    BaseDialogFragmentWithViewModel<LanguagesDialogFragmentBinding, SettingsViewModel>(
        LanguagesDialogFragmentBinding::inflate
    ) {

    @Inject
    lateinit var factory: SettingsViewModel.Factory

    override fun initDI() = NewsSettingsComponentHolder.fetchComponent().inject(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) =
        with(requireViewBinding()) {
            super.onViewCreated(view, savedInstanceState)

            Languages.values().forEach { radioGroup.addRadioButton(it.title, it.data) }

            viewModel.collectSettings(viewLifecycleOwner) { settings ->
                radioGroup.checkByTag(settings.language.data)
            }

            radioGroup.setOnCheckedChangeListener { radioGroup, _ ->
                viewModel.updateSettings(
                    languages = radioGroup.checkedRadioButtonTag().convertToLanguage()
                )
            }

            positiveButton.setOnClickListener { dismiss() }
        }

    override fun fetchViewModelClass() = SettingsViewModel::class.java

    override fun fetchViewModelFactory() = factory
}