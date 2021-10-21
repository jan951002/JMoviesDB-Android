package com.jan.jmoviesdb.ui.main

import com.jan.jmoviesdb.R
import com.jan.jmoviesdb.base.BaseActivity
import com.jan.jmoviesdb.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun layoutRes(): Int = R.layout.activity_main
}