package com.example.ankolayout.Testing.View

import com.example.ankolayout.API.Pojo.Match.ResponseSearchMatch

interface Search : View<ResponseSearchMatch> {
    fun onShowLoading()
    fun onHideLoading()
}

