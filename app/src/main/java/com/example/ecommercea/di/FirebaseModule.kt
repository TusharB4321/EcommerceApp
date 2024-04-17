package com.example.ecommerce.di

import com.example.ecommerce.data.repository.AuthRepo
import com.example.ecommerce.data.repository.AuthRepoImpl
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideAuthRepository(impl: AuthRepoImpl): AuthRepo = impl
}