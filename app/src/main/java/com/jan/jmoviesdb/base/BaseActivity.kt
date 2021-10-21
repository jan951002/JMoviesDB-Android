package com.jan.jmoviesdb.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.viewbinding.ViewBinding
import com.jan.jmoviesdb.util.Inflate

/**
 * Base activity class
 * @author Jaime Trujillo
 */

abstract class BaseActivity<Binding : ViewBinding>(private val inflate: Inflate<Binding>) :
    AppCompatActivity() {

    private lateinit var _binding: Binding
    protected val binding get() = _binding

    @LayoutRes
    protected abstract fun layoutRes(): Int

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, layoutRes())
    }
}