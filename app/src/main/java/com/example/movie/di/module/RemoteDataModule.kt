package com.example.movie.di.module

import com.example.movie.di.scope.RemoteDataScope
import com.example.movie.remote_data_source.MovieApi
import com.example.movie.remote_data_source.RemoteDataSource
import com.example.movie.remote_data_source.RemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class RemoteDataModule {

    companion object {
        private val API_URL = "https://api.themoviedb.org/3/"
    }

    @Provides
    @RemoteDataScope
    fun provideOkHttpClient(): OkHttpClient {
        var httpClient=OkHttpClient.Builder()
            .connectionPool(ConnectionPool(5, 30, TimeUnit.SECONDS))
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)

        return httpClient.build()
    }

    @Provides
    @RemoteDataScope
    fun provideRetrofitBuilder(client: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    }

    @Provides
    @RemoteDataScope
    fun provideRetrofit(builder: Retrofit.Builder): Retrofit {
        return builder.baseUrl(API_URL).build()
    }

    @Provides
    @RemoteDataScope
    fun provideApiService(retrofit: Retrofit): MovieApi {
        return retrofit.create<MovieApi>(
            MovieApi::class.java)
    }


    @Provides
    @RemoteDataScope
    fun providesFeedRemoteDataSource(apiService: MovieApi): RemoteDataSource {
        return RemoteDataSourceImpl(apiService)
    }
}