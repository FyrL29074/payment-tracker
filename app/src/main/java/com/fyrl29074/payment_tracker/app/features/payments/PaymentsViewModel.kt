package com.fyrl29074.payment_tracker.app.features.payments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fyrl29074.payment_tracker.app.State
import com.fyrl29074.payment_tracker.domain.usecase.GetPaymentsUseCase
import com.fyrl29074.payment_tracker.domain.usecase.LogoutUseCase
import com.fyrl29074.payment_tracker.utils.Const
import com.fyrl29074.payment_tracker.utils.CustomException.InvalidTokenException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PaymentsViewModel(
    private val getPaymentsUseCase: GetPaymentsUseCase,
    private val logoutUseCase: LogoutUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow<State>(State.Waiting)
    val state = _state.asStateFlow()

    fun getPayments() {
        viewModelScope.launch {
            _state.value = State.Loading
            try {
                val payments = getPaymentsUseCase.execute()
                _state.value = State.Loaded(payments)
            } catch (e: InvalidTokenException) {
                _state.value = State.TokenError
            } catch (e: Exception) {
                _state.value = State.Error(e.message ?: Const.UNKNOWN_ERROR)
            }
        }
    }

    fun logout() {
        _state.value = State.Loading
        logoutUseCase.execute()
        _state.value = State.Success
    }
}