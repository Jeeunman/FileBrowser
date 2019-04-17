package com.example.manjeefilebrowser.main.mvp

import android.view.View
import basemvp.BaseModel
import basemvp.BasePresenter
import basemvp.BaseView

interface MainContract {

    interface Presenter : BasePresenter<View> {

    }

    interface Model : BaseModel<Presenter> {

    }

    interface View : BaseView<Presenter> {
        fun initView()
        fun showHeaderBtn()
        fun hideHeaderBtn()
    }
}