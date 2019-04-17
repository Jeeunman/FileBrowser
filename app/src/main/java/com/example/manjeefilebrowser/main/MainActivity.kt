package com.example.manjeefilebrowser.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import com.example.manjeefilebrowser.R
import com.example.manjeefilebrowser.main.mvp.MainContract
import com.example.manjeefilebrowser.main.mvp.MainPresenter
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), MainContract.View, NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: com.example.manjeefilebrowser.databinding.ActivityMainBinding

    override var presenter: MainContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        presenter = MainPresenter(this, this)
        presenter?.onCreate()
//        setContentView(R.layout.activity_main)
//
//        naviButton.setOnClickListener {
//            if(navigationLayout.isDrawerOpen(GravityCompat.START)) {
//                navigationLayout.closeDrawers()
//            } else {
//                navigationLayout.openDrawer(GravityCompat.START)
//            }
//        }
    }

    override fun onResume() {
        super.onResume()
        presenter?.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter?.onPause()
    }

    override fun initView() {
        binding.naviButton.setOnClickListener(::onClickDrawer)
    }

    override fun showHeaderBtn() {
        binding.searchBtn.visibility = View.VISIBLE
        binding.favoriteBtn.visibility = View.VISIBLE
    }

    override fun hideHeaderBtn() {
        binding.searchBtn.visibility = View.INVISIBLE
        binding.favoriteBtn.visibility = View.INVISIBLE
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        return true
    }

    private fun onClickDrawer() {
        if(binding.navigationLayout.isDrawerOpen(GravityCompat.START)) {
            binding.navigationLayout.closeDrawers()
        } else {
            binding.navigationLayout.openDrawer(GravityCompat.START)
        }
    }
}