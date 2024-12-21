package com.sai.sample.navigation.routes

import kotlinx.serialization.Serializable

sealed interface PrimaryRoutes {
    @Serializable
    data object PrimaryRoute : PrimaryRoutes
}