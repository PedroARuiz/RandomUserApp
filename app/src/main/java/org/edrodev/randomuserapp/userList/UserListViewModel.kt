package org.edrodev.randomuserapp.userList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.edrodev.randomuserapp.domain.user.model.User
import org.edrodev.randomuserapp.domain.user.useCase.DeleteUserUseCase
import org.edrodev.randomuserapp.domain.user.useCase.FetchUsersUseCase
import org.edrodev.randomuserapp.domain.user.useCase.FindUsersUseCase

class UserListViewModel(
    private val findUsers: FindUsersUseCase,
    private val fetchUsers: FetchUsersUseCase,
    private val deleteUser: DeleteUserUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(State())
    val state = _state.asStateFlow()

    init {
        state
        .map { it.filter }.distinctUntilChanged()
        .flatMapLatest {
            findUsers(it)
        }.onEach {
            _state.value = state.value.copy(users = it)
        }.launchIn(viewModelScope)
    }

    fun loadUsers() {
        viewModelScope.launch {
            _state.value = state.value.copy(isFetchingUsers = true)
            fetchUsers().fold(
                ifLeft = { _state.value = state.value.copy(error = it) },
                ifRight = {},
            )
            _state.value = state.value.copy(isFetchingUsers = false)
        }
    }

    fun removeUser(user: User) {
        viewModelScope.launch {
            deleteUser(user)
        }
    }

    fun filter(text: String) {
        _state.value = state.value.copy(filter = text)
    }

    data class State(
        val users: List<User> = emptyList(),
        val isFetchingUsers: Boolean = false,
        val error: Throwable? = null,
        val filter: String = "",
    )
}