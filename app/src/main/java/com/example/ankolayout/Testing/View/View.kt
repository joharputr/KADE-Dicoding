package com.example.ankolayout.Testing.View

interface View<T> {

    fun onDataLoaded(data: T?)
    fun onDataError()
}