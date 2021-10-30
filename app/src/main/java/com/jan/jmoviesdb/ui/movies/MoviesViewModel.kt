package com.jan.jmoviesdb.ui.movies

import androidx.lifecycle.*
import com.jan.jmoviesdb.domain.movie.Movie
import com.jan.jmoviesdb.usecases.movie.CheckRequireMoviesNewPageUseCase
import com.jan.jmoviesdb.usecases.movie.GetMoviesUseCase
import com.jan.jmoviesdb.usecases.movie.UpdateMovieQuantityOnShoppingCartUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val checkRequireMoviesNewPageUseCase: CheckRequireMoviesNewPageUseCase,
    getMoviesUseCase: GetMoviesUseCase,
    private val updateMovieQuantityOnShoppingCartUseCase: UpdateMovieQuantityOnShoppingCartUseCase
) : ViewModel() {

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