package com.jan.jmoviesdb.ui.movies

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.jan.jmoviesdb.data.domain.model.Movie
import com.jan.jmoviesdb.data.domain.repository.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MoviesViewModel(application: Application, private val movieRepository: MovieRepository) :
    AndroidViewModel(application) {

    val movies: LiveData<List<Movie>> =
        movieRepository.getMovies().asLiveData()
    val lastVisible = MutableStateFlow(0)

    init {
        viewModelScope.launch {
            lastVisible.collect { notifyLastVisible(it) }
        }
    }

    private suspend fun notifyLastVisible(lastVisible: Int) {
        movieRepository.checkRequireNewPage(lastVisible)
    }

    fun updateQuantityOnShoppingCart(movieLocalId: Long, quantity: Int) {
        viewModelScope.launch {
            movieRepository.updateQuantityOnShoppingCart(movieLocalId, quantity)
        }
    }
}