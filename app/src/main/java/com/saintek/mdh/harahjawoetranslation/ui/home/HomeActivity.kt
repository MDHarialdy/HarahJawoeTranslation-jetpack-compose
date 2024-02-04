package com.saintek.mdh.harahjawoetranslation.ui.home

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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
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
import com.saintek.mdh.harahjawoetranslation.data.dummydata.HistoryObjectInit
import com.saintek.mdh.harahjawoetranslation.ui.component.ItemCamera
import com.saintek.mdh.harahjawoetranslation.ui.component.ItemHistory
import com.saintek.mdh.harahjawoetranslation.ui.theme.Light_yellow
import com.saintek.mdh.harahjawoetranslation.ui.theme.dm_serif_display
import com.saintek.mdh.harahjawoetranslation.ui.theme.duru_sans

@Composable
fun HomeActivity(){
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
                        painter = painterResource(id = R.drawable.cloud_home),
                        contentDescription = "image cloud",
                        contentScale = ContentScale.Crop
                    )

                    Row(
                        verticalAlignment = Alignment.Bottom
                    ) {

                        //text
                        Column(
                            modifier = Modifier
                                .padding(bottom = 10.dp, start = 25.dp)
                        ) {
                            Text(
                                fontFamily = dm_serif_display,
                                style = MaterialTheme.typography.headlineLarge,
                                text = "Mari \nlestarikan \nAksara",
                            )

                            Text(
                                fontFamily = duru_sans,
                                style = MaterialTheme.typography.titleSmall,
                                text = "Dengan Mempelajarinya",
                            )
                        }

                        //person Image
                        Image(
                            modifier = Modifier
                                .padding(top = 40.dp, end = 15.dp)
                                .fillMaxHeight(),
                            painter = painterResource(id = R.drawable.male_home_icon),
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
                    .fillMaxSize()
            ) {

//                Text(
//                    modifier = Modifier
//                        .padding(start = 15.dp, top = 10.dp),
//                    fontFamily = gadugi_font,
//                    fontWeight = FontWeight.Bold,
//                    style = MaterialTheme.typography.titleLarge,
//                    text = "Sejarah Harah Jawoe"
//                )
                
                LazyVerticalGrid(
                    modifier = Modifier
                        .padding(top = 10.dp),
                    columns = GridCells.Fixed(2),
//                    contentPadding = PaddingValues(2.dp)
                ){
                    item { ItemCamera() }
                    item { ItemCamera() }
                }

                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                ){
                    items(HistoryObjectInit.history, key = {it.id}){ history ->
                        ItemHistory(
                            modifier = Modifier
                                .padding(start = 14.dp),
                            image = history.image,
                            title = history.title,
                            onClickHistory = {}
                        )
                    }
                }

//                Row(
//                    modifier = Modifier
//                        .padding(10.dp)
//                ) {
//                    ItemCamera()
//                    ItemHistory(image = R.drawable.dummy_image_item_history, title = "apapun") {
//
//                    }
//                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun Preview(){
    Surface(modifier = Modifier.fillMaxSize()) {
        HomeActivity()
    }
}