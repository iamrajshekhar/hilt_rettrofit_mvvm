package com.android.gitappclient.api

import com.android.gitappclient.data.GitRepoModel
import com.android.gitappclient.utility.AppConstant
import retrofit2.http.GET
import retrofit2.http.POST
import java.util.concurrent.Flow

interface ApiService {

    @GET(AppConstant.URL_REPOSITORIES)
    suspend fun getRepository(): List<GitRepoModel>

}