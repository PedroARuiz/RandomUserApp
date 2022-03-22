package org.edrodev.randomuserapp.userDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import org.edrodev.randomuserapp.domain.user.useCase.FindUserUseCase

class UserDetailViewModel(
    private val userEmail: String,
    private val findUser: FindUserUseCase,
) : ViewModel() {

    val user = findUser(userEmail).stateIn(viewModelScope, SharingStarted.Lazily, null)

}