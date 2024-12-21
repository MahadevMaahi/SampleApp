package com.sample.primary.internal.di.dagger.modules

import com.sample.primary.internal.data.repo.PrimaryRepositoryImpl
import com.sample.primary.internal.domain.repo.PrimaryRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
internal abstract class PrimaryBindModule {

    @Binds
    @Singleton
    abstract fun bindPrimaryRepository(impl: PrimaryRepositoryImpl): PrimaryRepository
}