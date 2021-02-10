package com.android.gitappclient.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.android.gitappclient.api.Result
import com.android.gitappclient.data.GitRepoModel
import com.android.gitappclient.usecase.DataUseCase
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.flow

class GitApiVm @ViewModelInject constructor(private  val dataUseCase: DataUseCase): ViewModel() {
    fun getRepositoriesList(): LiveData<Result<List<GitRepoModel>>> {
        return flow{
            emit(Result.Loading())
            try {
                emit(dataUseCase.getRepoList())
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Result.Exception())
            }
        }.asLiveData(IO)
    }

}