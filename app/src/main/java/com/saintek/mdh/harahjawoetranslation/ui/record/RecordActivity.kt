package com.saintek.mdh.harahjawoetranslation.ui.record

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun RecordActivity(){
    Text(
        text = "This Is Record",
        modifier = Modifier
            .fillMaxSize(),
        textAlign = TextAlign.Center
    )
}