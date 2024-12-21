package com.sai.sample.core.di

interface AppDependencyProvider {
    fun <T> getAppLevelDependency(): T
}