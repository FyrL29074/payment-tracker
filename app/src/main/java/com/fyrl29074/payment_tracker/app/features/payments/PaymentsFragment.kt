package com.fyrl29074.payment_tracker.app.features.payments

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.fyrl29074.payment_tracker.R
import com.fyrl29074.payment_tracker.app.base.BaseFragment
import com.fyrl29074.payment_tracker.app.State
import com.fyrl29074.payment_tracker.databinding.FragmentPaymentsBinding
import com.fyrl29074.payment_tracker.domain.model.Payment
import com.fyrl29074.payment_tracker.utils.Const
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class PaymentsFragment : BaseFragment<FragmentPaymentsBinding>() {
    override val inflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPaymentsBinding
        get() = FragmentPaymentsBinding::inflate

    private val viewModel: PaymentsViewModel by viewModel()

    private val paymentAdapter = PaymentAdapter()

    override fun initUI() {
        binding.apply {
            logout.setOnClickListener {
                viewModel.logout()
            }
            payments.adapter = paymentAdapter
        }
    }

    override fun initState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.state.collect { state ->
                when (state) {
                    State.Waiting -> {
                        viewModel.getPayments()
                    }

                    State.Loading -> {
                        binding.progressBar.isVisible = true
                    }

                    is State.Loaded<*> -> {
                        if (state.data is List<*>
                            && state.data.all { payment -> payment is Payment }
                        ) {
                            val payments = state.data as List<Payment>
                            paymentAdapter.setData(payments)
                        }

                        binding.progressBar.isVisible = false
                    }

                    is State.Error -> {
                        Toast.makeText(
                            requireContext(),
                            state.message,
                            Toast.LENGTH_SHORT
                        ).show()
                        binding.progressBar.isVisible = false
                    }

                    State.TokenError -> {
                        findNavController().navigate(R.id.login_fragment)
                        Toast.makeText(
                            requireContext(),
                            Const.INVALID_TOKEN_ERROR,
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    State.Success -> {
                        findNavController().navigate(R.id.login_fragment)
                        Toast.makeText(
                            requireContext(),
                            Const.LOGOUT_SUCCESS,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }
}