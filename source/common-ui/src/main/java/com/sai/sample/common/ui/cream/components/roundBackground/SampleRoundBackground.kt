package com.sai.sample.common.ui.cream.components.roundBackground

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.sai.sample.common.ui.cream.foundation.SampleTheme
import com.sai.sample.common.ui.util.clickableSingle

@Composable
fun SampleRoundBackground(
    modifier: Modifier = Modifier,
    border: BorderStroke? = null,
    backgroundColor: Color = SampleTheme.colors.themeColors.backgroundTertiary,
    onClick: (() -> Unit)? = null,
    content: @Composable () -> Unit
) {
    Surface(
        modifier = modifier.then(
            if(onClick != null) Modifier.clickableSingle(indication = null, onClick = onClick) else Modifier
        ),
        shape = CircleShape,
        color = backgroundColor,
        border = border,
        content = content
    )
}