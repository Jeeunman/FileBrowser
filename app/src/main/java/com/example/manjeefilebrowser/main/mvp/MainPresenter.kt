package com.example.manjeefilebrowser.main.mvp

import android.content.Context

class MainPresenter(override var context: Context, override var view: MainContract.View) : MainContract.Presenter {

    private lateinit var model: MainModel

    override fun onCreate() {
        model = MainModel(this)
    }

    override fun onResume() {

    }

    override fun onPause() {

    }

}