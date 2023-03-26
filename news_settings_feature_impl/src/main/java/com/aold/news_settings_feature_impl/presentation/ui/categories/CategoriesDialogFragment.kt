package com.aold.news_settings_feature_impl.presentation.ui.categories

import android.os.Bundle
import android.view.View
import com.aold.core.core.extensions.addRadioButton
import com.aold.core.core.extensions.checkByTag
import com.aold.core.core.extensions.checkedRadioButtonTag
import com.aold.core.core.platform.dialogs.BaseDialogFragmentWithViewModel
import com.aold.news_settings_feature_api.domain.Categories
import com.aold.news_settings_feature_api.domain.convertToCategory
import com.aold.news_settings_feature_impl.databinding.CategoriesDialogFragmentBinding
import com.aold.news_settings_feature_impl.di.holder.NewsSettingsComponentHolder
import com.aold.news_settings_feature_impl.presentation.ui.settings.SettingsViewModel
import javax.inject.Inject

/**
 * @author Kirilin Yury on 26.03.2023.
 */

internal class CategoriesDialogFragment :
    BaseDialogFragmentWithViewModel<CategoriesDialogFragmentBinding, SettingsViewModel>(
        CategoriesDialogFragmentBinding::inflate
    ) {

    @Inject
    lateinit var factory: SettingsViewModel.Factory

    override fun initDI() = NewsSettingsComponentHolder.fetchComponent().inject(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) =
        with(requireViewBinding()) {
            super.onViewCreated(view, savedInstanceState)

            Categories.values().forEach {
                radioGroup.addRadioButton(it.title, it.data)
            }

            viewModel.collectSettings(viewLifecycleOwner) { settings ->
                radioGroup.checkByTag(settings.category.data)
            }

            radioGroup.setOnCheckedChangeListener { radioGroup, _ ->
                viewModel.updateSettings(radioGroup.checkedRadioButtonTag().convertToCategory())
            }

            positiveButton.setOnClickListener { dismiss() }
        }

    override fun fetchViewModelClass() = SettingsViewModel::class.java

    override fun fetchViewModelFactory() = factory
}