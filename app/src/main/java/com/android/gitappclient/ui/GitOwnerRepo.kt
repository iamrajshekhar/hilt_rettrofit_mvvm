package com.android.gitappclient.ui

import com.android.gitappclient.api.ApiService
import javax.inject.Inject

class GitOwnerRepo @Inject constructor(private  val apiService: ApiService) {
   suspend fun getGitRepo()= apiService.getRepository()
}