package com.jan.jmoviesdb.ui.movies

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.jan.jmoviesdb.domain.movie.Movie
import com.jan.jmoviesdb.usecases.movie.CheckRequireMoviesNewPageUseCase
import com.jan.jmoviesdb.usecases.movie.GetMoviesUseCase
import com.jan.jmoviesdb.usecases.movie.UpdateMovieQuantityOnShoppingCartUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MoviesViewModel(
    application: Application,
    getMoviesUseCase: GetMoviesUseCase,
    private val checkRequireMoviesNewPageUseCase: CheckRequireMoviesNewPageUseCase,
    private val updateMovieQuantityOnShoppingCartUseCase: UpdateMovieQuantityOnShoppingCartUseCase
) : AndroidViewModel(application) {

    val movies: LiveData<List<Movie>> = getMoviesUseCase.invoke().asLiveData()
    val lastVisible = MutableStateFlow(0)

    init {
        viewModelScope.launch {
            lastVisible.collect { notifyLastVisible(it) }
        }
    }

    private suspend fun notifyLastVisible(lastVisible: Int) {
        checkRequireMoviesNewPageUseCase.invoke(lastVisible)
    }

    fun updateQuantityOnShoppingCart(movieLocalId: Long, quantity: Int) {
        viewModelScope.launch {
            updateMovieQuantityOnShoppingCartUseCase.invoke(movieLocalId, quantity)
        }
    }
}