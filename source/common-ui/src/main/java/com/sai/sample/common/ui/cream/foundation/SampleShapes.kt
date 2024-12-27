package com.sai.sample.common.ui.cream.foundation

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

object SampleShapes {
    val xSmall = RoundedCornerShape(8.dp)
    val small = RoundedCornerShape(12.dp)
    val large = RoundedCornerShape(24.dp)
    val maxium = RoundedCornerShape(percent = 100)

    val materialShapes = Shapes(
        small = xSmall,
        medium = small,
        large = large,
        extraLarge = maxium
    )
}