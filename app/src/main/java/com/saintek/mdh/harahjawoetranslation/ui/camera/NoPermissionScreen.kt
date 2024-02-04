package com.saintek.mdh.harahjawoetranslation.ui.camera

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saintek.mdh.harahjawoetranslation.R
import com.saintek.mdh.harahjawoetranslation.ui.theme.HarahJawoeTranslationTheme
import com.saintek.mdh.harahjawoetranslation.ui.theme.light_gray
import com.saintek.mdh.harahjawoetranslation.ui.theme.istok_web_bold
import com.saintek.mdh.harahjawoetranslation.ui.theme.light_red

@Composable
fun NoPermissionScreen(
    onRequestPermission: () -> Unit
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.background_camera),
                contentScale = ContentScale.Crop
            )
    ){
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, end = 20.dp, top = 150.dp, bottom = 150.dp),
            shape = RoundedCornerShape(7),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ){

                Image(
                    modifier = Modifier
                        .size(270.dp),
                    painter = painterResource(id = R.drawable.image_no_permission_screen_center),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = "Welcome To Proreader",
                    fontFamily = istok_web_bold,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )

                Text(
                    modifier = Modifier
                        .padding(top = 2.dp, start = 5.dp, end = 5.dp),
                    text = "Please give access to your Camera for use this feature",
                    textAlign = TextAlign.Center,
                    color = light_gray
                )

                Button(
                    modifier = Modifier
                        .padding(top = 50.dp, bottom = 7.dp, start = 5.dp, end = 5.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(30),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = light_red
                    ),
                    onClick = onRequestPermission,
                ) {
                    Icon(
                        modifier = Modifier
                            .padding(end = 10.dp, top = 7.dp, bottom = 7.dp)
                            .size(30.dp),
                        painter = painterResource(id = R.drawable.camera_icon),
                        contentDescription = "Camera Icon"
                    )
                    Text(
                        fontSize = 18.sp,
                        text = "Grant Permission"
                    )
                }

            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun NoPermissonScreenPreview(){
    HarahJawoeTranslationTheme {
        Surface {
           NoPermissionScreen({})
//       BottomContent({},{})
        }
    }
}