package com.jan.jmoviesdb.ui.movies

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jan.jmoviesdb.base.BaseFragment
import com.jan.jmoviesdb.databinding.FragmentMoviesBinding
import org.koin.android.viewmodel.ext.android.viewModel

class MoviesFragment : BaseFragment<FragmentMoviesBinding>(FragmentMoviesBinding::inflate) {

    private val moviesViewModel: MoviesViewModel by viewModel()
    private lateinit var moviesAdapter: MoviesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        moviesAdapter = MoviesAdapter()
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
}