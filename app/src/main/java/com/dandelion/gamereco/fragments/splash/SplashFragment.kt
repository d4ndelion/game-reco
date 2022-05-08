package com.dandelion.gamereco.fragments.splash

import androidx.fragment.app.viewModels
import com.dandelion.gamereco.R
import com.dandelion.gamereco.databinding.FragmentSplashBinding
import com.dandelion.gamereco.fragments.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : BaseFragment<SplashVM, FragmentSplashBinding>(R.layout.fragment_splash) {
    override val viewModel by viewModels<SplashVM>()
}
