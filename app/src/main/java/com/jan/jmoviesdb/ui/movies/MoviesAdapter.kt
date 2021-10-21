package com.jan.jmoviesdb.ui.movies

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jan.jmoviesdb.R
import com.jan.jmoviesdb.data.domain.model.Movie
import com.jan.jmoviesdb.databinding.ItemMovieViewBinding
import com.jan.jmoviesdb.util.MovieClickListener
import com.jan.jmoviesdb.util.Utils.basicDiffUtil
import com.jan.jmoviesdb.util.Utils.inflate
import com.jan.jmoviesdb.util.Utils.loadUrl

class MoviesAdapter(private val listener: MovieClickListener) :

    ListAdapter<Movie, MoviesAdapter.ViewHolder>(basicDiffUtil<Movie>(
        areContentsTheSame = { oldItem, newItem -> oldItem.id == newItem.id },
        areItemsTheSame = { oldItem, newItem -> oldItem == newItem }
    )) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = parent.inflate(ItemMovieViewBinding::inflate)
        return ViewHolder(binding, parent.context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemMovieViewBinding,
        private val context: Context
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            binding.movie = movie
            binding.movieImage.loadUrl("${context.getString(R.string.movies_db_base_url_img)}${movie.posterPath}")
            binding.counterView.updateCountAddListener { listener.onAddMovie(movie) }
            binding.counterView.updateCountRemoveListener { listener.onRemoveMovie(movie) }
        }
    }

    interface OnItemClickListener {
        fun onAddMovie(movie: Movie)
        fun onRemoveMovie(movie: Movie)
    }
}
