package com.saintek.mdh.harahjawoetranslation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.saintek.mdh.harahjawoetranslation.ui.component.BottomNavigation
import com.saintek.mdh.harahjawoetranslation.ui.home.HomeActivity
import com.saintek.mdh.harahjawoetranslation.ui.onBoarding.OnBoardingActivity
import com.saintek.mdh.harahjawoetranslation.ui.theme.HarahJawoeTranslationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HarahJawoeTranslationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BottomNavigation()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HarahJawoeTranslationTheme {
        BottomNavigation()
    }
}