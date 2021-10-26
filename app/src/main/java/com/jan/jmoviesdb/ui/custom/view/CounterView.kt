package com.jan.jmoviesdb.ui.custom.view

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.view.setPadding
import androidx.databinding.BindingAdapter
import com.google.android.material.textview.MaterialTextView
import com.jan.jmoviesdb.R

class CounterView(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    var mCountAddListener: () -> Unit = {}
    var mCountRemoveListener: () -> Unit = {}

    var count = 0

    init {
        /*
        val attributes = context.obtainStyledAttributes(
            attrs, R.styleable.CounterView, 0, 0
        )
        val count = attributes.getInt(R.styleable.CounterView_initial_count, 0)
        attributes.recycle()
        */
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.view_counter, this, true)

        orientation = HORIZONTAL
        gravity = Gravity.CENTER_VERTICAL
        weightSum = 3f
        setPadding(resources.getDimensionPixelSize(R.dimen.minimum_margin_vertical))

        (getChildAt(0) as ImageView).setOnClickListener { mCountRemoveListener() }
        (getChildAt(2) as ImageView).setOnClickListener { mCountAddListener() }
    }

    fun updateCountAddListener(countAddListener: () -> Unit) {
        mCountAddListener = countAddListener
    }

    fun updateCountRemoveListener(countRemoveListener: () -> Unit) {
        mCountRemoveListener = countRemoveListener
    }
}