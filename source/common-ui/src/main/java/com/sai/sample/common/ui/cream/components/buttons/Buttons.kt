package com.sai.sample.common.ui.cream.components.buttons

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.sai.sample.common.ui.cream.foundation.SampleTheme
import com.sai.sample.common.ui.util.throttleFirst
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

@Composable
fun SamplePrimaryButton(
    modifier: Modifier = Modifier,
    buttonText: String,
    buttonSize: ButtonSize,
    enabled: Boolean = true,
    onButtonClick: () -> Unit
) {
    SampleButton(
        modifier = modifier,
        buttonText = buttonText,
        backgroundColor = SampleTheme.colors.themeColors.brandPrimary,
        disabledBackgroundColor = SampleTheme.colors.themeColors.backgroundDisabled,
        enabled = enabled,
        buttonSize = buttonSize,
        onButtonClick = onButtonClick
    )
}

@Composable
fun SampleSmallPrimaryButton(
    modifier: Modifier = Modifier,
    buttonText: String,
    enabled: Boolean = true,
    onButtonClick: () -> Unit
) {
    SamplePrimaryButton(
        modifier = modifier,
        buttonText = buttonText,
        enabled = enabled,
        buttonSize = ButtonSize.SMALL,
        onButtonClick = onButtonClick
    )
}

@Composable
fun SampleLargePrimaryButton(
    modifier: Modifier = Modifier,
    buttonText: String,
    enabled: Boolean = true,
    onButtonClick: () -> Unit
) {
    SamplePrimaryButton(
        modifier = modifier,
        buttonText = buttonText,
        enabled = enabled,
        buttonSize = ButtonSize.LARGE,
        onButtonClick = onButtonClick
    )
}

@Composable
fun SampleSecondaryButton(
    modifier: Modifier = Modifier,
    buttonText: String,
    buttonSize: ButtonSize,
    buttonTextColor: Color = SampleTheme.colors.themeColors.textPrimary,
    borderColorEnable: Color = SampleTheme.colors.themeColors.textPrimary,
    borderColorDisable: Color = SampleTheme.colors.themeColors.textDisabled,
    backgroundColor: Color = Color.Transparent,
    enabled: Boolean = true,
    onButtonClick: () -> Unit
) {
    SampleButton(
        modifier = modifier
            .border(
                width = 1.dp,
                color = if(enabled) borderColorEnable else borderColorDisable,
                shape = CircleShape
            ),
        buttonText = buttonText,
        buttonTextColor = buttonTextColor,
        backgroundColor = backgroundColor,
        enabled = enabled,
        buttonSize = buttonSize,
        onButtonClick = onButtonClick
    )
}

@Composable
fun SampleSmallSecondaryButton(
    modifier: Modifier = Modifier,
    buttonText: String,
    enabled: Boolean = true,
    buttonTextColor: Color = SampleTheme.colors.themeColors.textPrimary,
    borderColorEnable: Color = SampleTheme.colors.themeColors.textPrimary,
    onButtonClick: () -> Unit
) {
    SampleSecondaryButton(
        modifier = modifier,
        buttonText = buttonText,
        buttonSize = ButtonSize.SMALL,
        enabled = enabled,
        buttonTextColor = buttonTextColor,
        borderColorEnable = borderColorEnable,
        onButtonClick = onButtonClick
    )
}

@Composable
fun SampleLargeSecondaryButton(
    modifier: Modifier = Modifier,
    buttonText: String,
    enabled: Boolean = true,
    backgroundColor: Color = Color.Transparent,
    borderColorDisable: Color = SampleTheme.colors.themeColors.textDisabled,
    borderColorEnable: Color = SampleTheme.colors.themeColors.textPrimary,
    onButtonClick: () -> Unit
) {
    SampleSecondaryButton(
        modifier = modifier,
        buttonText = buttonText,
        buttonSize = ButtonSize.LARGE,
        enabled = enabled,
        backgroundColor = backgroundColor,
        borderColorEnable = borderColorEnable,
        borderColorDisable = borderColorDisable,
        onButtonClick = onButtonClick
    )
}

@Composable
private fun SampleButton(
    buttonText: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier,
    buttonTextColor: Color = SampleTheme.colors.themeColors.textPrimary,
    disabledTextColor: Color = SampleTheme.colors.themeColors.textDisabled,
    disabledBackgroundColor: Color = backgroundColor,
    buttonSize: ButtonSize = ButtonSize.LARGE,
    enabled: Boolean = true,
    onButtonClick: () -> Unit
) {
    val scope = rememberCoroutineScope()
    val flow = MutableSharedFlow<Unit>()

    LaunchedEffect(flow) {
        flow.throttleFirst(300).collect { onButtonClick() }
    }

    Button(
        modifier = modifier
            .requiredHeight(buttonSize.size),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            disabledContentColor = disabledBackgroundColor,
            contentColor = buttonTextColor,
            disabledContainerColor = disabledTextColor
        ),
        contentPadding = PaddingValues(vertical = 0.dp, horizontal = 16.dp),
        shape = CircleShape,
        onClick = { scope.launch { flow.emit(Unit) } },
        elevation = null
    ) {
        Text(
            style = buttonSize.textStyle,
            text = buttonText,
            color = if (enabled) buttonTextColor else disabledTextColor,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

enum class ButtonSize(
    val size: Dp,
    val textStyle: TextStyle
) {
    SMALL(32.dp, SampleTheme.typography.callOut3),
    MEDIUM(40.dp, SampleTheme.typography.callOut3),
    LARGE(56.dp, SampleTheme.typography.callOut2)
}