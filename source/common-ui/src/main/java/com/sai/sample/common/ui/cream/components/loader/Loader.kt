package com.sai.sample.common.ui.cream.components.loader

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sai.sample.common.ui.R
import com.sai.sample.common.ui.cream.foundation.SampleShapes
import com.sai.sample.common.ui.cream.foundation.SampleTheme

@Composable
fun Loader(
    modifier: Modifier = Modifier,
    text: String? = null
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = SampleTheme.colors.themeColors.backgroundScrim)
            .pointerInput(Unit) {}
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LottieLoadingView(
                resId = R.raw.cream_loading,
                modifier = modifier
                    .size(188.dp)
                    .background(
                        color = SampleTheme.colors.themeColors.backgroundSecondary,
                        shape = SampleShapes.small
                    )
            )
            if (text != null) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = text)
            }
        }
    }
}

@Preview
@Composable
fun LoaderPreview() {
    Loader()
}
