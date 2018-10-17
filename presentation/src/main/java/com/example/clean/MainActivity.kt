package com.example.clean

import android.os.Bundle
import com.example.clean.base.BaseActivity
import com.example.clean.ui.main.MainFragment

class MainActivity : BaseActivity() {
    override fun firstFragment() = MainFragment.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, firstFragment())
                    .commitNow()
        }
    }
}
