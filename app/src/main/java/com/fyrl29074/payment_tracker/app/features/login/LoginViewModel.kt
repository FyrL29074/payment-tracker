package com.fyrl29074.payment_tracker.app.features.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fyrl29074.payment_tracker.app.State
import com.fyrl29074.payment_tracker.domain.usecase.LoginUseCase
import com.fyrl29074.payment_tracker.utils.Const
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow<State>(State.Waiting)
    val state = _state.asStateFlow()

    fun login(login: String, password: String) {
        viewModelScope.launch {
            _state.value = State.Loading
            try {
                loginUseCase.execute(login, password)
                _state.value = State.Success
            } catch (e: Exception) {
                _state.value = State.Error(e.message ?: Const.UNKNOWN_ERROR)
            }
        }
    }
}