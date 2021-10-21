package com.jan.jmoviesdb.util

import android.view.LayoutInflater
import android.view.ViewGroup
import com.jan.jmoviesdb.ui.movies.list.MoviesAdapter

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T
typealias MovieClickListener = MoviesAdapter.OnItemClickListener