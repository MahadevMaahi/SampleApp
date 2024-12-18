package com.sample.primary.internal.di.hilt.modules

import com.google.gson.GsonBuilder
import com.sai.sample.primary.BuildConfig
import com.sample.primary.internal.data.remote.api.PrimaryApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

//@Module
//@InstallIn(SingletonComponent::class)
internal object PrimaryProviderModule {

//    @Provides
//    @Singleton
    fun providePrimaryApi() = Retrofit.Builder()
        .baseUrl(BuildConfig.PRIMARY_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(PrimaryApi::class.java)
}