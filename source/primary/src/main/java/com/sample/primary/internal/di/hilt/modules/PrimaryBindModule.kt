package com.sample.primary.internal.di.hilt.modules

import com.sample.primary.internal.data.repo.PrimaryRepositoryImpl
import com.sample.primary.internal.domain.repo.PrimaryRepository

//@Module
//@InstallIn(SingletonComponent::class)
internal abstract class PrimaryBindModule {

//    @Binds
//    @Singleton
    abstract fun bindPrimaryRepository(impl: PrimaryRepositoryImpl): PrimaryRepository
}