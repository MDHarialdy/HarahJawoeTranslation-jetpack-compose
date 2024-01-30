package com.saintek.mdh.harahjawoetranslation.ui.camera

import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.LinearLayout
import androidx.camera.view.LifecycleCameraController
import androidx.camera.view.PreviewView
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.rememberPermissionState
import com.saintek.mdh.harahjawoetranslation.R
import com.saintek.mdh.harahjawoetranslation.ui.theme.HarahJawoeTranslationTheme
import com.saintek.mdh.harahjawoetranslation.ui.util.isCameraGranted

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun CameraActivity(){

    val cameraPermissionState: PermissionState
    = rememberPermissionState(permission = android.Manifest.permission.CAMERA)
    isCameraGranted(cameraPermissionState.hasPermission)
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
        CameraScreen()
    } else {
        NoPermissionScreen(onRequestPermission = onRequestPermission)
    }
}


@Composable
fun CameraScreen(){
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val cameraController = remember { LifecycleCameraController(context) }
    Scaffold(
        modifier = Modifier
            .wrapContentSize(),
        bottomBar = { BottomContent({}, {}) },
        floatingActionButtonPosition = FabPosition.Center
    ) { paddingValues ->
        AndroidView(
            modifier = Modifier.padding(paddingValues),
            factory = {context ->
            PreviewView(context).apply {
                layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
                setBackgroundColor(0xFF000000.toInt())
                scaleType = PreviewView.ScaleType.FILL_START
            }.also { previewView ->
                previewView.controller = cameraController
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
                painter = painterResource(id = R.drawable.camera_icon),
                contentDescription = "Camera Icon"
            )
            Text(text = "Grant Permission")
        }
    }
}

@Composable
fun BottomContent(
    galleryOnclickAction: () -> Unit,
    tutorialOnClickAction: () -> Unit
) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize()
        .background(Color.White)
    ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 12.dp, top = 8.dp, bottom = 15.dp, end = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    OutlinedButton(
                        modifier = Modifier,
                        onClick = galleryOnclickAction,
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(25.dp)
                                .padding(end = 2.dp),
                            imageVector = ImageVector.vectorResource(R.drawable.baseline_image_24),
                            contentDescription = "icon",
                        )
//                        Text(
//                            text = "Gallery"
//                        )
                    }

                    Button(
                        modifier = Modifier
                            .size(60.dp),
                        onClick = {},
                        border = BorderStroke(10.dp, Color.LightGray)
                    ){}

                    OutlinedButton(
                        modifier = Modifier,
                        onClick = tutorialOnClickAction,
                    ) {
                        Icon( painter = painterResource(id = R.drawable.baseline_cameraswitch_24) , contentDescription = "Flip Camera")
                    }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HelperPreview(){
    HarahJawoeTranslationTheme {
        Surface {
            CameraScreen()
//       BottomContent({},{})
        }
    }
}
