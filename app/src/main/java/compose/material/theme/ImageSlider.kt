package compose.material.theme

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Scale
import kotlin.math.absoluteValue

@Preview
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CarouselCard() {
    val pagerState = rememberPagerState(initialPage = 1)
    val sliderList = listOf(
        "https://www.ecashmeup.com/?guid=baeb294bc65b809b3e2a7f61bec0088c",
        "https://www.ecashmeup.com/assets/img/slideshow/GoalBanner.jpg",
        "https://www.ecashmeup.com/assets/img/slideshow/loanbanner2.jpg",
        "https://www.ecashmeup.com/assets/img/slideshow/Public_Private_Banner.jpg",
        "https://www.ecashmeup.com/assets/img/slideshow/insuranceonboarding.jpg",
        "https://www.ecashmeup.com/assets/img/slideshow/DebiCheckVP1.jpg"
    )

    Column {
        HorizontalPager(
            pageCount = sliderList.size,
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 10.dp),
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth()
                .padding(top = 20.dp)
        ) { page ->
            Card(
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier
                    .graphicsLayer {
                        val pageOffset = (
                                (pagerState.currentPage - page) + pagerState
                                    .currentPageOffsetFraction
                                ).absoluteValue
                        lerp(
                            start = 0.5f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        )
                                .also { scale ->
                                scaleX = scale
                                scaleY = scale
                            }
                    }
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(sliderList[page])
                        .crossfade(true)
                        .scale(Scale.FILL)
                        .build(),
                    contentDescription = null,
                    placeholder = painterResource(id = R.drawable.ic_placeholder_image),
//                    error = painterResource(id = R.drawable.ic_error_image_generic)
                )

            }

        }

    }
}
