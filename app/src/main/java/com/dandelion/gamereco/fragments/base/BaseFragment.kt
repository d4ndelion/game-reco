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

    lateinit var binding: BINDING
        private set
    abstract val viewModel: VIEWMODEL

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, layout, container, false)
        binding.lifecycleOwner = this
        viewModel.screenFlow observe {
            navigateToScreen(it)
        }
        return binding.root
    }

    infix fun <T> Flow<T>.observe(consumer: (T) -> Unit) {
        lifecycleScope.launchWhenStarted {
            this@observe.collect {
                consumer(it)
            }
        }
    }

    private fun navigateToScreen(screen: SCREENS) {
        if (activity is MainActivity) {
            (activity as MainActivity).navigateToScreen(screen)
        }
    }
}
