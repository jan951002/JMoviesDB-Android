package com.jan.jmoviesdb.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.widget.Toast
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
}