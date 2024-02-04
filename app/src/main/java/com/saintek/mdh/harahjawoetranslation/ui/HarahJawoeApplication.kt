package com.saintek.mdh.harahjawoetranslation.ui

import android.Manifest
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.rememberPermissionState
import com.saintek.mdh.harahjawoetranslation.ui.component.BottomBar
import com.saintek.mdh.harahjawoetranslation.ui.component.BottomNavGraph
import com.saintek.mdh.harahjawoetranslation.ui.component.NavbarItem
import com.saintek.mdh.harahjawoetranslation.ui.component.currentRoute
import com.saintek.mdh.harahjawoetranslation.ui.theme.HarahJawoeTranslationTheme

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun HarahJawoeApplication() {
    val cameraPermissionState: PermissionState = rememberPermissionState(permission = Manifest.permission.CAMERA)
    val navController = rememberNavController()
    val hideBottomBar = currentRoute(navController = navController) == NavbarItem.Camera.route && cameraPermissionState.hasPermission
    Scaffold(
        bottomBar = {
            AnimatedVisibility(
                visible  = !hideBottomBar,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                BottomBar(navController = navController)
                Log.e("MainActivity", navController.currentDestination?.route.toString())
            }
        }
    ) {
        Modifier.padding(it)
        BottomNavGraph(navController = navController)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ApplicationPreview(){
    HarahJawoeTranslationTheme {
        Surface {
            HarahJawoeApplication()
        }
    }

}