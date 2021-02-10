package com.android.gitappclient.di

import com.android.gitappclient.api.ApiService
import com.android.gitappclient.ui.GitOwnerRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.components.FragmentComponent

@InstallIn(ActivityRetainedComponent::class)
@Module
object RepositoryModule {
    @Provides
    fun provideDateToRepo(apiService: ApiService)=GitOwnerRepo(apiService)
}