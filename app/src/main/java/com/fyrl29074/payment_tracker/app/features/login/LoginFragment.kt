package com.fyrl29074.payment_tracker.app.features.login

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.fyrl29074.payment_tracker.R
import com.fyrl29074.payment_tracker.app.base.BaseFragment
import com.fyrl29074.payment_tracker.app.State
import com.fyrl29074.payment_tracker.databinding.FragmentLoginBinding
import com.fyrl29074.payment_tracker.utils.Const
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : BaseFragment<FragmentLoginBinding>() {

    override val inflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentLoginBinding
        get() = FragmentLoginBinding::inflate

    private val viewModel: LoginViewModel by viewModel()

    override fun initUI() {
        binding.apply {
            btnLogin.setOnClickListener {
                val login = etLogin.text.toString()
                val password = etPassword.text.toString()
                viewModel.login(login, password)
            }
        }
    }

    override fun initState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.state.collect { state ->
                when (state) {
                    State.Loading -> {
                        disableUI()
                    }

                    is State.Success -> {
                        findNavController().navigate(R.id.to_payments)
                    }

                    is State.Error -> {
                        Toast.makeText(
                            requireContext(),
                            state.message,
                            Toast.LENGTH_SHORT
                        ).show()

                        enableUI()
                    }

                    else -> {
                        Toast.makeText(
                            requireContext(),
                            Const.UNKNOWN_STATE_ERROR,
                            Toast.LENGTH_SHORT
                        ).show()

                        enableUI()
                    }
                }
            }
        }
    }

    private fun enableUI() {
        binding.apply {
            btnLogin.isEnabled = true
            etLogin.isEnabled = true
            etPassword.isEnabled = true
            progressBar.isVisible = false
        }
    }

    private fun disableUI() {
        binding.apply {
            btnLogin.isEnabled = false
            etLogin.isEnabled = false
            etPassword.isEnabled = false
            progressBar.isVisible = true
        }
    }
}