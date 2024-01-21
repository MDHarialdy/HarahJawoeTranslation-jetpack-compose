package com.saintek.mdh.harahjawoetranslation.ui.camera

import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.LinearLayout
import androidx.camera.view.LifecycleCameraController
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.rememberPermissionState
import com.saintek.mdh.harahjawoetranslation.R
import com.saintek.mdh.harahjawoetranslation.ui.theme.HarahJawoeTranslationTheme

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun CameraActivity(){

    val cameraPermissionState: PermissionState
    = rememberPermissionState(permission = android.Manifest.permission.CAMERA)

    CheckPermissionCamera(
        hasPermission = cameraPermissionState.hasPermission,
        onRequestPermission = cameraPermissionState::launchPermissionRequest
    )
}

@Composable
fun CheckPermissionCamera(
    hasPermission: Boolean,
    onRequestPermission: () -> Unit
){
    if (hasPermission){
        //TODO
    } else {
        NoPermissionScreen(onRequestPermission = onRequestPermission)
    }
}


@Composable
fun CameraScreen(){
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val cameraController = remember { LifecycleCameraController(context) }
    Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
        AndroidView(
            modifier = Modifier.padding(paddingValues),
            factory = {context ->
            PreviewView(context).apply {
                layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
                setBackgroundColor(0xFF000000.toInt())
                scaleType = PreviewView.ScaleType.FILL_START
            }.also {PreviewView ->
                PreviewView.controller = cameraController
                cameraController.bindToLifecycle(lifecycleOwner)
            }
        })
    }
}

@Composable
fun NoPermissionScreen(
    onRequestPermission: () -> Unit
){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(text = "Please Grant the Permission to Use Camera")
        Button(
            modifier = Modifier
                .padding(top = 10.dp),
            onClick = onRequestPermission,
        ) {
            Icon(
                modifier = Modifier
                    .padding(end = 5.dp)
                    .size(30.dp),
                painter = painterResource(id = R.drawable.camera_filled),
                contentDescription = "Camera Icon"
            )
            Text(text = "Grant Permission")
        }
    }
}
@Composable
@Preview(showBackground = true)
fun HelperPreview(){
    HarahJawoeTranslationTheme {
        Surface {
            CheckPermissionCamera(
                hasPermission = true,
                onRequestPermission = {}
            )
        }
    }
}
