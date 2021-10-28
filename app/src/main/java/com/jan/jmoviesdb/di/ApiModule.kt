package com.jan.jmoviesdb.di

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.jan.jmoviesdb.R
import com.jan.jmoviesdb.data.api.MovieDBApi
import com.jan.jmoviesdb.data.api.datasource.MovieRemoteDataSourceImpl
import com.jan.jmoviesdb.data.movie.MovieRemoteDataSource
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Module to configure api dependency injection
 * @author Jaime Trujillo
 */

val apiModule = module {

    /* Define a Singleton instance for MovieDBApi */
    single {
        createWebService<MovieDBApi>(
            createHttpClient(),
            RxJava2CallAdapterFactory.create(),
            androidContext().getString(R.string.movies_db_base_url)
        )
    }

    single {
        provideMovieRemoteDataSource(get(), androidContext().getString(R.string.movies_db_api_key))
    }
}

/* function to build our MovieRemoteDataSource */
fun provideMovieRemoteDataSource(movieDBApi: MovieDBApi, apiKey: String): MovieRemoteDataSource =
    MovieRemoteDataSourceImpl(movieDBApi, apiKey)

/* Returns a custom OkHttpClient instance with interceptor. Used for building Retrofit service */
fun createHttpClient(): OkHttpClient = OkHttpClient.Builder()
    .readTimeout(60, TimeUnit.SECONDS)
    .connectTimeout(60, TimeUnit.SECONDS)
    .build()


/* function to build our Retrofit service */
inline fun <reified T> createWebService(
    okHttpClient: OkHttpClient, factory: CallAdapter.Factory, baseUrl: String
): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .addCallAdapterFactory(factory)
        .client(okHttpClient)
        .build()
    return retrofit.create(T::class.java)
}