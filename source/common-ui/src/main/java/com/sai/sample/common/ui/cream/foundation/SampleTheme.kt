package com.sai.sample.common.ui.cream.foundation

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

object SampleTheme {
    val colors: SampleColors = SampleColors
    val shapes: SampleShapes = SampleShapes
    val typography: SampleTypography = SampleTypography()
}

@Composable
fun SampleTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> SampleTheme.colors.materialDarkColorTheme
        else -> SampleTheme.colors.materialDarkColorTheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        shapes = SampleTheme.shapes.materialShapes,
        typography = SampleTheme.typography.materialTypography,
        content = content
    )
}
