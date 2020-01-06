package com.example.ankolayout.Testing.View

import com.example.ankolayout.API.Pojo.Match.ResponseMatch

interface Match : View<ResponseMatch> {
    fun onShowLoading()
    fun onHideLoading()
}

