package com.lamda.moviedetails.data.model

sealed class ResultSet<out T> {
    object Loading: ResultSet<Nothing>()
    data class Success<out T>(val data:T?) : ResultSet<T>()
    data class Error(val error: Exception?, val errorMsg: String?, val code: Int?): ResultSet<Nothing>()
}