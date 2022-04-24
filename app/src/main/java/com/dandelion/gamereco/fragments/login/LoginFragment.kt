package com.dandelion.gamereco.fragments.login

import androidx.fragment.app.viewModels
import com.dandelion.gamereco.R
import com.dandelion.gamereco.databinding.FragmentLoginBinding
import com.dandelion.gamereco.fragments.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<LoginVM, FragmentLoginBinding>(R.layout.fragment_login) {

    override val viewModel by viewModels<LoginVM>()

}
