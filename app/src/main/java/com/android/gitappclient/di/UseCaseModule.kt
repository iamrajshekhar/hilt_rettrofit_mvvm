package com.android.gitappclient.di

import com.android.gitappclient.ui.GitOwnerRepo
import com.android.gitappclient.usecase.DataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@InstallIn(ActivityRetainedComponent::class)
@Module
object UseCaseModule {
    @Provides
    fun provideUseCase(gitOwnerRepo: GitOwnerRepo)=DataUseCase(gitOwnerRepo)
}