package com.saintek.mdh.harahjawoetranslation.ui.onBoarding

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

data class OnBoardingData(
    val image: Int,
    val title: String,
    val description: String
)

@Composable
fun LoaderIntro(modifier: Modifier, image: Int){
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(image))
    val progress by  animateLottieCompositionAsState(composition)
    LottieAnimation(
        composition = composition,
//        progress = { progress })
        iterations = LottieConstants.IterateForever,
        modifier = modifier
    )
}
