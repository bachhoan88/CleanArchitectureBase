package com.example.clean.base

import androidx.appcompat.app.AppCompatActivity
import com.example.clean.R

abstract class BaseActivity : AppCompatActivity() {
    abstract fun firstFragment(): BaseFragment<*, *>

    override fun onBackPressed() {
        ((supportFragmentManager.findFragmentById(R.id.container)) as BaseFragment<*, *>).onBackPressed()
        super.onBackPressed()
    }
}