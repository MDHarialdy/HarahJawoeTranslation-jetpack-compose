package com.saintek.mdh.harahjawoetranslation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.saintek.mdh.harahjawoetranslation.R
import com.saintek.mdh.harahjawoetranslation.ui.theme.gadugi_font


@Composable
fun ItemCamera(
    modifier: Modifier = Modifier
) {
    BoxWithConstraints() {
        val constraints = this
        val cardSize = minOf(constraints.maxWidth, constraints.maxHeight)
        Card(
            modifier = Modifier
                .size(cardSize)
                .padding(15.dp),
            shape = RoundedCornerShape(20),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Box(
                modifier = Modifier.size(cardSize),
                contentAlignment = Alignment.BottomCenter
            ) {
                Image(
                    painter = painterResource(id = R.drawable.image_harah_jawoe),
                    contentDescription = "Translate with camera",
                    contentScale = ContentScale.Crop
                )
                Text(
                    modifier = Modifier
                        .padding(bottom = 10.dp, start = 10.dp, end = 10.dp, ),
                    fontFamily = gadugi_font,
                    color = Color.White,
                    text = "Translate With Camera",
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

//@Composable
//fun ItemCamera(
//    modifier: Modifier = Modifier
//){
//    Card(
//        modifier = Modifier
//            .padding(15.dp),
//        elevation = CardDefaults.cardElevation(15.dp)
//    ){
//        Box(
//            modifier = modifier
//                .width(100.dp),
//            contentAlignment = Alignment.BottomCenter
//        ) {
//            Image(
//                painter = painterResource(id = R.drawable.camera_icon_vector),
//                contentDescription = "Translate with camera",
//                contentScale = ContentScale.Crop
//            )
//            Text(
//                modifier = Modifier
//                    .padding(bottom = 10.dp),
//                fontFamily = gadugi_font,
//                text = "Translate With Camera"
//            )
//        }
//    }
//}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun Preview(){
    ItemCamera()
}