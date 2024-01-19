package com.saintek.mdh.harahjawoetranslation.ui.onBoarding

import androidx.annotation.FloatRange
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.saintek.mdh.harahjawoetranslation.R
import androidx.annotation.IntRange as IntRange

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingActivity() {
    val items = ArrayList<OnBoardingData>()

    items.add(
            OnBoardingData(
                R.raw.animasi1,
                "Title 1",
                "Lorem Ipsum Dolor sir amet, ini adalah deskripsi"
            )
        )

    items.add(
        OnBoardingData(
            R.drawable.ic_launcher_background,
            "Title 2",
            "Lorem Ipsum Dolor sir amet, ini adalah deskripsi"
        )
    )
    items.add(
        OnBoardingData(
            R.raw.animasi1,
            "Title 3",
            "Lorem Ipsum Dolor sir amet, ini adalah deskripsi"
        )
    )

    val pagerState = rememberPagerState(
        pageCount = items.size,
        initialOffscreenLimit = 2,
        initialPage = 0,
        infiniteLoop = false
    )

    OnBoardingPager(
        items = items,
        pagerState = pagerState,
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxWidth()
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingPager(
    items: List<OnBoardingData>,
    pagerState: PagerState,
    modifier: Modifier = Modifier
){
    Box(modifier = modifier){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HorizontalPager(state = pagerState) {page ->
                Column(
                    modifier = Modifier
                        .padding(top = 60.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    LoaderIntro(
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(400.dp)
                            .align(alignment = Alignment.CenterHorizontally),
                        image = items[page].image
                    )

                    Text(
                        text = items[page].title,
                        modifier = Modifier
                            .padding(top = 20.dp),
                        color = Color.Black,
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Text(
                        text = items[page].description,
                        modifier = Modifier
                            .padding(
                                top = 30.dp,
                                start = 20.dp,
                                end = 20.dp
                            ),
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center
                    )
                }
            }
            PagerIndicator(size = items.size, currentPage = pagerState.currentPage)
        }
        Box(modifier = Modifier.align(Alignment.BottomCenter)) {
            BottomSection(pagerState.currentPage)
        }

    }
}

@ExperimentalPagerApi
@Composable
fun rememberPagerState(
    @IntRange(from = 0) pageCount: Int,
    @IntRange(from = 0) initialPage: Int = 0,
    @FloatRange(from = 0.0, to = 1.0) initialPageOffset: Float = 0f,
    @IntRange(from = 1) initialOffscreenLimit: Int = 1,
    infiniteLoop: Boolean = false
) = rememberSaveable(
    saver = PagerState.Saver
) {
    PagerState(
        pageCount = pageCount,
        currentPage = initialPage,
        currentPageOffset = initialPageOffset,
        offscreenLimit = initialOffscreenLimit,
        infiniteLoop = infiniteLoop
    )
}

@Composable
fun PagerIndicator(
    size: Int,
    currentPage: Int
){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(top = 60.dp)
    ){
        repeat(size){
            Indicator(isSelected = it == currentPage)
        }
    }
}

@Composable
fun Indicator(isSelected: Boolean){
    val width = animateDpAsState(targetValue = if (isSelected) 25.dp else 10.dp)
    Box(
        modifier = Modifier
            .padding(1.dp)
            .height(10.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(if (isSelected) Color.Red else Color.Gray)
    )

}

@Composable
fun BottomSection(currentPager: Int) {
    Row(
        modifier = Modifier
            .padding(bottom = 20.dp)
            .fillMaxWidth(),
        horizontalArrangement = if (currentPager != 2) Arrangement.SpaceBetween else Arrangement.Center
    ) {
        if (currentPager == 2) {
            OutlinedButton(
                onClick = { },
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .padding(bottom = 20.dp)
            ) {
                Text(
                    text = "Get Started",
                    modifier = Modifier
                        .padding(vertical = 8.dp, horizontal = 40.dp),
                    color = Color.Gray
                )
            }
        } else {
            SkipNextButton(text = "Skip", modifier = Modifier.padding(start = 20.dp))
            SkipNextButton(text = "Next", modifier = Modifier.padding(end = 20.dp))
        }
    }
}

@Composable
fun SkipNextButton(text: String, modifier: Modifier) {
    Text(
        text = text,
        color = Color.Black,
        modifier = modifier,
        fontSize = 18.sp,
        style = MaterialTheme.typography.bodyLarge,
        fontWeight = FontWeight.Medium
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun Preview(){
    Surface(modifier = Modifier.fillMaxSize()) {
        OnBoardingActivity()
    }
}
