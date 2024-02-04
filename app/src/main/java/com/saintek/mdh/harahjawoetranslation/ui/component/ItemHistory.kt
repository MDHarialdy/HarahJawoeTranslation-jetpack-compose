package com.saintek.mdh.harahjawoetranslation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.saintek.mdh.harahjawoetranslation.R
import com.saintek.mdh.harahjawoetranslation.ui.theme.gadugi_font
import com.saintek.mdh.harahjawoetranslation.ui.theme.transparent_black

@Composable
fun ItemHistory(
    modifier: Modifier = Modifier,
    image: Int,
    title: String,
    onClickHistory: () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentSize()
//            .padding(15.dp)
            .clickable { onClickHistory() },
        elevation = CardDefaults.cardElevation(8.dp),
        shape = RoundedCornerShape(12)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.BottomStart
        ){
            Image(
                modifier = Modifier
                    .height(170.dp)
                    .fillMaxSize(),
                painter = painterResource(id = image),
                contentDescription = "image history",
                contentScale = ContentScale.Crop
            )
            Text(
                text = title,
                fontFamily = gadugi_font,
                color = Color.White,
//                fontFamily = ,
                modifier = Modifier
                    .background(transparent_black)
                    .fillMaxWidth()
                    .padding(start = 10.dp, bottom = 5.dp, end = 5.dp),
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun Preview(){
    Surface(modifier = Modifier.fillMaxSize()) {
        ItemHistory(
            image = R.drawable.dummy_image_item_history,
            title = "Asal Mula Aksara Di Negara Republik Indonesia",
            onClickHistory = {}
        )
    }
}