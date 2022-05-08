package com.dandelion.gamereco.fragments.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.dandelion.gamereco.R
import com.dandelion.gamereco.databinding.FragmentLoginBinding
import com.dandelion.gamereco.fragments.base.BaseFragment
import com.dandelion.gamereco.utils.observe
import com.dandelion.gamereco.utils.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<LoginVM, FragmentLoginBinding>(R.layout.fragment_login) {

    override val viewModel by viewModels<LoginVM>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.vm = viewModel
        observe(viewModel.error, ::showToast)
    }
}
