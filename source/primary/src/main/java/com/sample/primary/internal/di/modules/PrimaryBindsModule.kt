package com.sample.primary.internal.di.modules

import com.sample.primary.internal.data.repo.PrimaryRepositoryImpl
import com.sample.primary.internal.domain.repo.PrimaryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class PrimaryBindsModule {

    @Binds
    @Singleton
    abstract fun bindPrimaryRepository(impl: PrimaryRepositoryImpl): PrimaryRepository
}