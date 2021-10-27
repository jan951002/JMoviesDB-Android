package com.jan.jmoviesdb.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.jan.jmoviesdb.R
import es.dmoral.toasty.Toasty

object Utils {

    fun Context.isOnline(): Boolean {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork ?: return false
        val networkCapabilities =
            connectivityManager.getNetworkCapabilities(network) ?: return false

        return when {
            networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }

    fun Context.showMessage(type: ToastyType, message: String) {
        when (type) {
            ToastyType.SUCCESS -> Toasty.success(this, message, Toast.LENGTH_LONG, true).show()
            ToastyType.ERROR -> Toasty.error(this, message, Toast.LENGTH_LONG, true).show()
            ToastyType.WARNING -> Toasty.warning(this, message, Toast.LENGTH_LONG, true).show()
            ToastyType.INFO -> Toasty.info(this, message, Toast.LENGTH_LONG, true).show()
        }
    }

    fun ImageView.loadUrl(urlString: String) {
        Glide.with(context)
            .load(urlString)
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .centerCrop()
            .placeholder(R.drawable.ic_place_holder)
            .into(this)
    }

    inline fun <T> basicDiffUtil(
        crossinline areContentsTheSame: (T, T) -> Boolean,
        crossinline areItemsTheSame: (T, T) -> Boolean
    ): DiffUtil.ItemCallback<T> = object : DiffUtil.ItemCallback<T>() {

        override fun areItemsTheSame(oldItem: T, newItem: T) = areItemsTheSame(oldItem, newItem)

        override fun areContentsTheSame(oldItem: T, newItem: T) =
            areContentsTheSame(oldItem, newItem)
    }

    fun <Binding : ViewBinding> ViewGroup.inflate(inflate: Inflate<Binding>): Binding {
        val layoutInflater = LayoutInflater.from(context)
        return inflate(layoutInflater, this, false)
    }
}