package com.example.ankolayout.Testing.View

import com.example.ankolayout.API.Pojo.DetailMatch.ResponseDetailMatch

interface detailMatch : View<ResponseDetailMatch> {
    fun onShowLoading()
    fun onHideLoading()
}