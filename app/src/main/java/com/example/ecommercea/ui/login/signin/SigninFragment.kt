package com.example.ecommercea.ui.login.signin

import android.os.Bundle
import android.system.Os.bind
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.ecommercea.common.viewBinding
import com.example.ecommerceapp.R
import com.example.ecommerce.common.invisible
import com.example.ecommerce.common.isValidEmail
import com.example.ecommerce.common.isValidPassword
import com.example.ecommerce.common.visible
import com.example.ecommerce.databinding.FragmentSigninBinding
import com.example.ecommerce.ui.login.AuthState
import com.example.ecommerce.ui.login.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.text.Typography.dagger

@AndroidEntryPoint
class SigninFragment : Fragment(R.layout.fragment_signin) {

    private val binding by viewBinding(FragmentSigninBinding::bind)
    private val viewModel by viewModels<AuthViewModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()

        with(binding) {
            button.setOnClickListener {
                if (checkInfos(etEmail.text.toString(), etPassword.text.toString())) {
                    viewModel.signin(etEmail.text.toString(), etPassword.text.toString())
                }
            }
            tvGoToSignup.setOnClickListener {
                findNavController().navigate(SigninFragmentDirections.signinToSignup())
            }
        }
    }

    private fun observeData() = with(binding) {

        viewModel.authState.observe(viewLifecycleOwner) { state ->

            when (state) {
                AuthState.Loading -> {
                    binding.progressBar.visible()
                }

                is AuthState.Data -> {
                    binding.progressBar.invisible()
                    findNavController().navigate(SigninFragmentDirections.signinToHome())
                }

                is AuthState.Error -> {
                    binding.progressBar.invisible()
                    Toast.makeText(
                        requireContext(),
                        state.throwable.message.orEmpty(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        }
    }

    private fun checkInfos(email: String, password: String): Boolean {

        val checkInfos = when {
            email.isValidEmail(email).not() -> false
            password.isValidPassword(password).not() -> false
            else -> true
        }
        return checkInfos
    }


}