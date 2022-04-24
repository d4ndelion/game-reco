package com.dandelion.gamereco.fragments.main

import androidx.fragment.app.viewModels
import com.dandelion.gamereco.R
import com.dandelion.gamereco.databinding.FragmentMainBinding
import com.dandelion.gamereco.fragments.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<MainVM, FragmentMainBinding>(R.layout.fragment_main) {
    override val viewModel by viewModels<MainVM>()
}
