package com.jan.jmoviesdb.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.jan.jmoviesdb.data.domain.repository.MovieRepository

class MainViewModel(application: Application, movieRepository: MovieRepository) :
    AndroidViewModel(application) {

}