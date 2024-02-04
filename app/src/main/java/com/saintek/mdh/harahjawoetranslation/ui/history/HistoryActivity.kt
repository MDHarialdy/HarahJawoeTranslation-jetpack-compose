package com.saintek.mdh.harahjawoetranslation.ui.history

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.unit.sp
import com.saintek.mdh.harahjawoetranslation.R
import com.saintek.mdh.harahjawoetranslation.data.dummydata.HistoryObjectInit
import com.saintek.mdh.harahjawoetranslation.ui.component.ItemHistory
import com.saintek.mdh.harahjawoetranslation.ui.theme.HarahJawoeTranslationTheme
import com.saintek.mdh.harahjawoetranslation.ui.theme.Light_yellow
import com.saintek.mdh.harahjawoetranslation.ui.theme.dm_serif_display
import com.saintek.mdh.harahjawoetranslation.ui.theme.gray_transparent

@Composable
fun HistoryActivity(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Light_yellow)
    ) {

        //background
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(270.dp),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.BottomEnd
            ){

                //cloud
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 10.dp),
                    painter = painterResource(id = R.drawable.cloud_history),
                    contentDescription = "image cloud",
                    contentScale = ContentScale.Crop
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.Bottom
                ) {

                    Text(
                        modifier = Modifier
                            .padding(start = 20.dp),
                        fontFamily = dm_serif_display,
                        fontSize = 48.sp,
                        text = "History",
                    )

                    //person Image
                    Image(
                        modifier = Modifier
                            .padding(top = 40.dp, end = 15.dp)
                            .fillMaxHeight(),
                        painter = painterResource(id = R.drawable.female_history_icon),
                        contentDescription = "Home",
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }

        //main
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            shape = RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(10.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Button(
                    onClick = {},
                    modifier = Modifier
                        .padding(top = 10.dp, bottom = 10.dp)
                        .height(10.dp)
                        .width(130.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = gray_transparent
                    )
                ) {
                    
                }

                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()

                ){
                    items(HistoryObjectInit.history, key = {it.id}){ history ->
                        ItemHistory(
                            modifier = Modifier
                                .padding(bottom = 14.dp, start = 17.dp, end = 17.dp),
                            image = history.image,
                            title = history.title,
                            onClickHistory = {}
                        )
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun HistoryPreview(){
    HarahJawoeTranslationTheme {
        Surface {
            HistoryActivity()
        }
    }
}