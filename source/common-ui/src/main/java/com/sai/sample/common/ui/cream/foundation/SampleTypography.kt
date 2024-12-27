package com.sai.sample.common.ui.cream.foundation

import androidx.compose.material3.Typography
import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Immutable
class SampleTypography private constructor(
    val display1: TextStyle,
    val display2: TextStyle,
    val display3: TextStyle,
    val display4: TextStyle,
    val display5: TextStyle,
    val heading1: TextStyle,
    val heading2: TextStyle,
    val heading3: TextStyle,
    val heading4: TextStyle,
    val heading5: TextStyle,
    val body1: TextStyle,
    val body2: TextStyle,
    val body3: TextStyle,
    val callOut1: TextStyle,
    val callOut2: TextStyle,
    val callOut3: TextStyle,
    val metadata1: TextStyle,
    val metadata1SemiBold: TextStyle,
    val metadata1Bold: TextStyle,
    val metadata2: TextStyle,
    val metadata2SemiBold: TextStyle
) {

    constructor(
        defaultFontFamily: FontFamily = DEFAULT_FONT_FAMILY,
        display1: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 80.sp,
            lineHeight = 88.sp
        ),
        display2: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 72.sp,
            lineHeight = 80.sp
        ),
        display3: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 64.sp,
            lineHeight = 72.sp
        ),
        display4: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 56.sp,
            lineHeight = 64.sp
        ),
        display5: TextStyle = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 48.sp,
            lineHeight = 56.sp
        ),
        heading1: TextStyle = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 40.sp,
            lineHeight = 44.sp
        ),
        heading2: TextStyle = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 32.sp,
            lineHeight = 40.sp
        ),
        heading3: TextStyle = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp,
            lineHeight = 32.sp
        ),
        heading4: TextStyle = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            lineHeight = 28.sp
        ),
        heading5: TextStyle = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            lineHeight = 24.sp
        ),
        body1: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp,
            lineHeight = 20.sp
        ),
        body2: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = 24.sp
        ),
        body3: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = 20.sp
        ),
        callOut1: TextStyle = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            lineHeight = 24.sp
        ),
        callOut2: TextStyle = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            lineHeight = 20.sp
        ),
        callOut3: TextStyle = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            lineHeight = 20.sp
        ),
        metaData1: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            lineHeight = 16.sp
        ),
        metaData1SemiBold: TextStyle = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp,
            lineHeight = 16.sp
        ),
        metaData1Bold: TextStyle = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            lineHeight = 18.sp
        ),
        metaData2: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 10.sp,
            lineHeight = 12.sp
        ),
        metaData2SemiBold: TextStyle = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 10.sp,
            lineHeight = 12.sp
        )
    ) : this(
        display1 = display1.withDefaultFontFamily(defaultFontFamily),
        display2 = display2.withDefaultFontFamily(defaultFontFamily),
        display3 = display3.withDefaultFontFamily(defaultFontFamily),
        display4 = display4.withDefaultFontFamily(defaultFontFamily),
        display5 = display5.withDefaultFontFamily(defaultFontFamily),
        heading1 = heading1.withDefaultFontFamily(defaultFontFamily),
        heading2 = heading2.withDefaultFontFamily(defaultFontFamily),
        heading3 = heading3.withDefaultFontFamily(defaultFontFamily),
        heading4 = heading4.withDefaultFontFamily(defaultFontFamily),
        heading5 = heading5.withDefaultFontFamily(defaultFontFamily),
        body1 = body1.withDefaultFontFamily(defaultFontFamily),
        body2 = body2.withDefaultFontFamily(defaultFontFamily),
        body3 = body3.withDefaultFontFamily(defaultFontFamily),
        callOut1 = callOut1.withDefaultFontFamily(defaultFontFamily),
        callOut2 = callOut2.withDefaultFontFamily(defaultFontFamily),
        callOut3 = callOut3.withDefaultFontFamily(defaultFontFamily),
        metadata1 = metaData1.withDefaultFontFamily(defaultFontFamily),
        metadata1SemiBold = metaData1SemiBold.withDefaultFontFamily(defaultFontFamily),
        metadata1Bold = metaData1Bold.withDefaultFontFamily(defaultFontFamily),
        metadata2 = metaData2.withDefaultFontFamily(defaultFontFamily),
        metadata2SemiBold = metaData2SemiBold.withDefaultFontFamily(defaultFontFamily)
    )

    val materialTypography: Typography
        get() = Typography(
            displayLarge = display1,
            displayMedium = display4,
            displaySmall = display5,
            headlineLarge = heading3,
            headlineMedium = heading4,
            headlineSmall = heading5,
            titleLarge = heading1,
            titleMedium = heading2,
            titleSmall = heading3,
            bodyLarge = body1,
            bodyMedium = body2,
            bodySmall = body3,
            labelLarge = display1,
            labelMedium = display2,
            labelSmall = display4
        )

    companion object {
        private val DEFAULT_FONT_FAMILY = FontFamily.Default
    }
}

private fun TextStyle.withDefaultFontFamily(default: FontFamily): TextStyle {
    return if (fontFamily != null) this else copy(fontFamily = default)
}