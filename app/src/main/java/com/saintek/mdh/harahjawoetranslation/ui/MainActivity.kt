package com.saintek.mdh.harahjawoetranslation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.saintek.mdh.harahjawoetranslation.ui.theme.HarahJawoeTranslationTheme

class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels{
        ViewModelFactory.getInstance(this)
    }
    @OptIn(ExperimentalPermissionsApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().apply {
            setKeepOnScreenCondition{mainViewModel.isFirstTime.value}
        }

        setContent {
            HarahJawoeTranslationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HarahJawoeApplication()
                }
            }
        }
    }
}

