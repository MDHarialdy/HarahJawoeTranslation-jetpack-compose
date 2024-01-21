package com.saintek.mdh.harahjawoetranslation.ui.util

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.saintek.mdh.harahjawoetranslation.ui.camera.NoPermissionScreen
import com.saintek.mdh.harahjawoetranslation.ui.theme.HarahJawoeTranslationTheme

@Composable
@Preview(showBackground = true)
fun HelperPreview(){
    HarahJawoeTranslationTheme {
        Surface {
            NoPermissionScreen({})
        }
    }
}