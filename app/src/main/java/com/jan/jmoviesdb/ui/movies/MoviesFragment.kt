package com.jan.jmoviesdb.ui.movies

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jan.jmoviesdb.baseui.BaseFragment
import com.jan.jmoviesdb.databinding.FragmentMoviesBinding
import com.jan.jmoviesdb.domain.movie.Movie
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesFragment : BaseFragment<FragmentMoviesBinding>(FragmentMoviesBinding::inflate),
    MovieClickListener {

    private val moviesViewModel: MoviesViewModel by viewModels()
    private lateinit var moviesAdapter: MoviesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        moviesAdapter = MoviesAdapter(this)
        binding.moviesRecycler.adapter = moviesAdapter
        observableViewModel()
        configScroll()
    }

    private fun observableViewModel() {
        moviesViewModel.movies.observe(viewLifecycleOwner, { movies ->
            movies?.let { moviesAdapter.submitList(movies) }
        })
    }

    private fun configScroll() {
        val layoutManager = binding.moviesRecycler.layoutManager as GridLayoutManager
        binding.moviesRecycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                moviesViewModel.lastVisible.value = layoutManager.findLastVisibleItemPosition()
            }
        })
    }

    override fun onAddMovie(movie: Movie) {
        val count = movie.countOnCart++
        moviesViewModel.updateQuantityOnShoppingCart(movie.localId, count)
    }

    override fun onRemoveMovie(movie: Movie) {
        val count = movie.countOnCart--
        moviesViewModel.updateQuantityOnShoppingCart(movie.localId, count)
    }
}