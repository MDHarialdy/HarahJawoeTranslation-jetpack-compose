package com.saintek.mdh.harahjawoetranslation.ui.util

import android.content.Context
import android.widget.Toast
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.saintek.mdh.harahjawoetranslation.ui.camera.NoPermissionScreen
import com.saintek.mdh.harahjawoetranslation.ui.theme.HarahJawoeTranslationTheme


fun showToast(context: Context, massage: String){
    Toast.makeText(context, massage, Toast.LENGTH_SHORT).show()
}

fun isCameraGranted(cameraPermissionGranted: Boolean): Boolean {
    return cameraPermissionGranted
}

@Composable
@Preview(showBackground = true)
fun HelperPreview(){
    HarahJawoeTranslationTheme {
        Surface {
            NoPermissionScreen({})
        }
    }
}