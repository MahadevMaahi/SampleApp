package com.sai.sample.core.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.transform

inline fun <reified T, R> T.resultOf(block: T.() -> R): Result<R> {
    return try {
        Result.success(block())
    } catch (e: Exception) {
        Result.failure(e)
    }
}

fun countDownTimer(totalSeconds: Int, timeDelayMills: Long = 1000L) =
    (totalSeconds - 1 downTo 0).asFlow()
        .onEach { delay(timeDelayMills) }
        .onStart { emit(totalSeconds) }
        .conflate()
        .transform { emit(it) }
