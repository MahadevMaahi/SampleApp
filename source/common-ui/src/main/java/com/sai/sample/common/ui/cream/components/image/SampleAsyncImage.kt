package com.sai.sample.common.ui.cream.components.image

import androidx.compose.foundation.layout.requiredSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.request.ImageRequest
import coil.request.NullRequestDataException
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.placeholder.material.shimmer
import com.sai.sample.common.ui.cream.components.roundBackground.SampleRoundBackground
import com.sai.sample.common.ui.cream.foundation.SampleTheme

private const val FILE_TYPE_JSON = ".json"

@Composable
fun SampleAsyncImage(
    model: Any?,
    modifier: Modifier = Modifier,
    placeholder: Painter? = null,
    error: Painter? = null,
    fallback: Painter? = error,
    transform:(AsyncImagePainter.State) -> AsyncImagePainter.State = transformOf(placeholder, error, fallback),
    onState: ((AsyncImagePainter.State) -> Unit)? = null,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
    filterQuality: FilterQuality = DrawScope.DefaultFilterQuality,
    placeholderColor: Color = Color.Unspecified,
    placeHolderOnLoading: Boolean = true,
    contentDescription: String? = null,
    iterations: Int = 2
) {
    val state = remember {
        mutableStateOf<AsyncImagePainter.State>(AsyncImagePainter.State.Empty)
    }

    val showPlaceHolderLoading = remember(placeHolderOnLoading, state.value) {
        placeHolderOnLoading && state.value is AsyncImagePainter.State.Loading
    }

    if (model is ImageRequest && model.data is String && model.data.toString().endsWith(FILE_TYPE_JSON)) {
        val composition by rememberLottieComposition(LottieCompositionSpec.Url(model.data.toString()))
        LottieAnimation(
            modifier = modifier,
            iterations = iterations,
            composition = composition,
            alignment = alignment,
            contentScale = contentScale
        )
    } else {
        AsyncImage(
            model = model,
            contentDescription = contentDescription,
            modifier = modifier.placeholder(
                color = placeholderColor,
                visible = showPlaceHolderLoading,
                highlight = PlaceholderHighlight.shimmer()
            ),
            transform = transform,
            onState = {
                state.value = it
                onState?.invoke(it)
            },
            alignment = alignment,
            contentScale = contentScale,
            alpha = alpha,
            colorFilter = colorFilter,
            filterQuality = filterQuality
        )
    }
}

@Stable
private fun transformOf(
    placeholder: Painter?,
    error: Painter?,
    fallback: Painter?
): (AsyncImagePainter.State) -> AsyncImagePainter.State {
    return if(placeholder != null || error != null || fallback != null) {
        { state ->
            when(state) {
                is AsyncImagePainter.State.Loading -> {
                    if (placeholder != null) state.copy(painter = placeholder) else state
                }

                is AsyncImagePainter.State.Error -> if (state.result.throwable is NullRequestDataException) {
                    if (fallback != null) state.copy(painter = fallback) else state
                } else {
                    if (error != null) state.copy(painter = error) else state
                }
                else -> state
            }
        }
    } else {
        AsyncImagePainter.DefaultTransform
    }
}

@Composable
fun RoundUrlImageIcon(
    iconUrl: String,
    bgColor: Color = SampleTheme.colors.themeColors.backgroundPrimary,
    bgSize: Dp = 40.dp,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    crossFadeEnabled: Boolean = true,
    contentScale: ContentScale = ContentScale.Crop
) {
    SampleRoundBackground(
        modifier = Modifier.requiredSize(bgSize),
        backgroundColor = bgColor
    ) {
        SampleAsyncImage(
            modifier = modifier,
            model = ImageRequest.Builder(LocalContext.current)
                .data(iconUrl)
                .crossfade(crossFadeEnabled)
                .build(),
            contentDescription = contentDescription,
            contentScale = contentScale
        )
    }
}
