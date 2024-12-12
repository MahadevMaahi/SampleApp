package com.sai.primary.internal.di.modules

import com.google.gson.GsonBuilder
import com.sai.sample.primary.BuildConfig
import com.sai.primary.internal.data.remote.api.PrimaryApi
import com.sai.primary.internal.data.repo.PrimaryRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object PrimaryModule {

    @Provides
    @Singleton
    fun providePrimaryApi(): PrimaryApi {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.PRIMARY_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(PrimaryApi::class.java)
    }
}