package com.aold.core.core.platform.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.viewbinding.ViewBinding
import com.aold.core.R
import com.google.android.material.transition.MaterialFadeThrough

/**
 * @author {Kirilin Yury} on 26.02.2023.
 */

abstract class BaseDialogFragment<VB : ViewBinding>(
    private val bindingInflater: DialogBindingInflater<VB>
) : DialogFragment() {

    private var viewBinding: VB? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        initDI()
        super.onCreate(savedInstanceState)

        enterTransition = MaterialFadeThrough()
        returnTransition = MaterialFadeThrough()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = bindingInflater.invoke(layoutInflater, container, false)
        initWindowBackground()
        return requireViewBinding().root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

    open fun initWindowBackground() {
        dialog?.window?.setBackgroundDrawableResource(com.aold.core_ui.R.drawable.alert_dialog_container)
    }

    open fun initDI() {}

    protected fun requireViewBinding() = checkNotNull(viewBinding) { "ViewBinding is nullable" }
}

typealias DialogBindingInflater<VB> = (LayoutInflater, ViewGroup?, Boolean) -> VB