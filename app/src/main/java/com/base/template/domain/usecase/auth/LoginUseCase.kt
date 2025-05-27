package com.base.template.domain.usecase.auth

import com.base.template.domain.repository.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: AuthRepository
) {
/*    suspend operator fun invoke(username: String, password: String): User {
        return repository.login(username, password)
    }*/
}