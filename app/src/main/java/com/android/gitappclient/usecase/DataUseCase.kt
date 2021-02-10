package com.android.gitappclient.usecase

import com.android.gitappclient.api.Result
import com.android.gitappclient.data.GitRepoModel
import com.android.gitappclient.ui.GitOwnerRepo
import javax.inject.Inject

class DataUseCase @Inject constructor( private  val gitOwnerRepo: GitOwnerRepo) {
    suspend fun getRepoList():Result<List<GitRepoModel>>{
        val data =gitOwnerRepo.getGitRepo()
        return if(!data.isNullOrEmpty()){
            Result.Success(data)

        }else{
             Result.Fail("No Data")

        }
    }
}