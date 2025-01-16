package com.sai.sample.common.ui.cream.foundation

import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

object SampleColors {
    val themeColors = ThemeColors(
        brandPrimary = Color(0xFFD2BFF4),
        brandSecondary = Color(0xFF8653E3),
        brandTertiary = Color(0xFFAF89F4),
        backgroundPrimary = Color(0xFF0C0120),
        backgroundSecondary = Color(0xFF272036),
        backgroundTertiary = Color(0xFF443B59),
        backgroundDisabled = Color(0xFF332B84),
        textPrimary = Color(0xFFFAFAFA),
        textSecondary = Color(0xFFE9E9E9),
        textTertiary = Color(0xFF878787),
        textDisabled = Color(0xFFFAFAFA).copy(alpha = 0.2F),
        textPlaceholder = Color(0xFF8173A0),
        textLink = Color(0xFFAF89F4),
        statusSuccess = Color(0xFF75F9AA),
        statusError = Color(0xFFF8316D),
        statusAlert = Color(0xFFFFD500),
        statusInformation = Color(0xFF4CC9F0)
    )

    val materialDarkColorTheme = darkColorScheme(
        primary = themeColors.brandPrimary,
        secondary = themeColors.brandSecondary,
        tertiary = themeColors.brandTertiary,
        primaryContainer = themeColors.backgroundPrimary,
        secondaryContainer = themeColors.backgroundSecondary,
        tertiaryContainer = themeColors.backgroundTertiary,
        surface = themeColors.backgroundSecondary,
        error = themeColors.statusError,
        onPrimary = themeColors.textPrimary,
        onSecondary = themeColors.textSecondary,
        onTertiary = themeColors.textTertiary,
        onError = themeColors.textPrimary
    )
}

@Immutable
data class ThemeColors(
    val brandPrimary: Color,
    val brandSecondary: Color,
    val brandTertiary: Color,
    val backgroundPrimary: Color,
    val backgroundSecondary: Color,
    val backgroundTertiary: Color,
    val backgroundDisabled: Color,
    val textPrimary: Color,
    val textSecondary: Color,
    val textTertiary: Color,
    val textDisabled: Color,
    val textPlaceholder: Color,
    val textLink: Color,
    val statusSuccess: Color,
    val statusError: Color,
    val statusAlert: Color,
    val statusInformation: Color
)