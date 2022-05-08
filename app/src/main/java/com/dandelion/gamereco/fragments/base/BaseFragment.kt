package com.dandelion.gamereco.fragments.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.dandelion.MainActivity
import com.dandelion.gamereco.utils.navigation.SCREENS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

abstract class BaseFragment<VIEWMODEL : BaseViewModel, BINDING : ViewDataBinding>(@LayoutRes val layout: Int) : Fragment() {

    var binding: BINDING? = null
        private set

    abstract val viewModel: VIEWMODEL

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: BINDING = DataBindingUtil.inflate(inflater, layout, container, false)
        this.binding = binding
        this.binding?.lifecycleOwner = this.viewLifecycleOwner
        viewModel.screenFlow observe {
            navigateToScreen(it)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    infix fun <T> Flow<T>.observe(consumer: (T) -> Unit) {
        lifecycleScope.launchWhenStarted {
            this@observe.collect {
                consumer(it)
            }
        }
    }

    fun setToolbarVisibility(isVisible: Boolean) {
        if (activity is MainActivity) {
            (activity as MainActivity).setToolbarVisibility(isVisible)
        }
    }

    private fun navigateToScreen(screen: SCREENS) {
        if (activity is MainActivity) {
            (activity as MainActivity).navigateToScreen(screen)
        }
    }
}
