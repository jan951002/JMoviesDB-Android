package com.jan.jmoviesdb.ui.movies.detail

import androidx.databinding.BindingAdapter
import com.google.android.material.textview.MaterialTextView
import com.jan.jmoviesdb.R
import com.jan.jmoviesdb.data.domain.model.Movie

@BindingAdapter("originalTitle")
fun MaterialTextView.setOriginalTitle(movie: Movie?) {
    movie?.let {
        val title =
            "${context.getString(R.string.lab_original_title)}: ${it.originalTitle} (${it.originalLanguage})"
        text = title
    }
}

@BindingAdapter("title")
fun MaterialTextView.setTitle(movie: Movie?) {
    movie?.let {
        val title = "${context.getString(R.string.lab_title)}: ${it.title}"
        text = title
    }
}

@BindingAdapter("overview")
fun MaterialTextView.setOverview(movie: Movie?) {
    movie?.let { text = it.overview }
}