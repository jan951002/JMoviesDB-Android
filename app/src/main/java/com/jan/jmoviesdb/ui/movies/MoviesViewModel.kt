package com.jan.jmoviesdb.ui.movies

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.jan.jmoviesdb.data.domain.model.Movie
import com.jan.jmoviesdb.data.domain.repository.MovieRepository
import kotlinx.coroutines.launch

class MoviesViewModel(application: Application, private val movieRepository: MovieRepository) :
    AndroidViewModel(application) {

    val movies: LiveData<List<Movie>> = movieRepository.getMovies().asLiveData()

    init {
        notifyLastVisible(0)
    }

    fun notifyLastVisible(lastVisible: Int) {
        viewModelScope.launch { movieRepository.checkRequireNewPage(lastVisible) }
    }
}