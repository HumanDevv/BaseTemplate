package com.base.template.data.remote.repository

import com.base.template.data.remote.api.AuthApi
import com.base.template.domain.repository.AuthRepository

class AuthRepositoryImpl(
    private val api: AuthApi,
) : AuthRepository {
/*
    override suspend fun login(request: LoginRequest): AuthResponse {
        val response = api.login(request)
        return response
    }

    override suspend fun signup(request: SignupRequest): AuthResponse {
        val response = api.signup(request)
        return response
    }*/
}
