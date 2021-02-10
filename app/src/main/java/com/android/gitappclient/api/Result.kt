package com.android.gitappclient.api

 sealed class Result< out T> {

     data class Success<out T>(val data :T?=null): Result<T>()
     data class Loading(val nothing :Nothing?=null): Result<Nothing>()
     data class Fail(val msg :String?=null): Result<Nothing>()
     data class Exception(val msg :String?=null): Result<Nothing>()


 }