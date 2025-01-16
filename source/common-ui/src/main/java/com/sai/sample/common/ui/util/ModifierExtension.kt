package com.sai.sample.common.ui.util

import androidx.compose.foundation.Indication
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.platform.debugInspectorInfo
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

private val LocalClickTimeSlotInterval = compositionLocalOf { ClickTimeInterval.DEFAULT }

@Composable
fun ProvideClickTimeInterval(value: ClickTimeInterval, content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalClickTimeSlotInterval provides value, content = content)
}

fun Modifier.clickableSingle(onClick: () -> Unit) = this.then(Modifier.clickableSingle(null, onClick))

fun Modifier.clickableSingle(indication: Indication?, onClick: () -> Unit) = this.composed(
    inspectorInfo = debugInspectorInfo {
        name = "clickable"
        properties["indication"] = indication
        properties["onClick"] = onClick
    }
) {
    val clickDelay = LocalClickTimeSlotInterval.current.delay.toLong()
    val callback by rememberUpdatedState(onClick)
    val scope = rememberCoroutineScope()
    val flow = remember { MutableSharedFlow<Unit>(replay = 0, extraBufferCapacity = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST) }
    LaunchedEffect(Unit) {
        scope.launch {
            flow.throttleFirst(clickDelay).collectLatest {
                callback()
            }
        }
    }
    Modifier.clickable(
        enabled = true,
        onClickLabel = null,
        role = null,
        indication = indication ?: LocalIndication.current,
        interactionSource = remember { MutableInteractionSource() },
        onClick = { scope.launch { flow.emit(Unit) } }
    )
}

@Composable
fun rememberSingleClickable(onClick: () -> Unit): () -> Unit {
    val clickDelay = LocalClickTimeSlotInterval.current.delay.toLong()
    val scope = rememberCoroutineScope()
    val flow = remember { MutableSharedFlow<Unit>(replay = 0, extraBufferCapacity = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST) }
    LaunchedEffect(Unit) {
        scope.launch {
            flow.throttleFirst(clickDelay).collectLatest {
                onClick()
            }
        }
    }
    return { scope.launch { flow.emit(Unit) } }
}

enum class ClickTimeInterval(internal val delay: Int) {
    NONE(0),
    SHORT(300),
    MEDIUM(500),
    DEFAULT(750),
    LONG(1000)
}