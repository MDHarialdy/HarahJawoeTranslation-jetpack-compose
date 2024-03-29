package com.saintek.mdh.harahjawoetranslation.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.saintek.mdh.harahjawoetranslation.ui.camera.CameraActivity
import com.saintek.mdh.harahjawoetranslation.ui.history.HistoryActivity
import com.saintek.mdh.harahjawoetranslation.ui.home.HomeActivity
import com.saintek.mdh.harahjawoetranslation.ui.record.RecordActivity
import com.saintek.mdh.harahjawoetranslation.ui.theme.Brown
import com.saintek.mdh.harahjawoetranslation.ui.theme.Light_yellow


@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        NavbarItem.Home,
        NavbarItem.Camera,
        NavbarItem.History,
        NavbarItem.Record
    )

    val navStackBackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navStackBackEntry?.destination

    Card(
        shape = RoundedCornerShape(topEnd = 0.dp, topStart = 0.dp),
        colors = CardDefaults.cardColors(Brown),
        modifier = Modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            screens.forEach { screens ->
                AddItem(
                    screen = screens,
                    destination = currentDestination,
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}

@Composable
fun BottomNavGraph(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = NavbarItem.Home.route
    ){
        composable(route = NavbarItem.Home.route){
            HomeActivity()
        }
        composable(route = NavbarItem.History.route){
            HistoryActivity()
        }
        composable(route = NavbarItem.Record.route){
            RecordActivity()
        }
        composable(route = NavbarItem.Camera.route){
            CameraActivity()
        }
    }
}

@Composable
fun AddItem(
    screen: NavbarItem,
    destination: NavDestination?,
    navController: NavHostController
){
    val selected = destination?.hierarchy?.any{ it.route == screen.route} == true

    val background =
        if (selected) Color.White.copy(alpha = 0.9f) else Color.Transparent

    val iconColor = if (selected) Light_yellow else Color.White

    Box(
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp, top = 11.dp, bottom = 8.dp)
            .height(50.dp)
            .clip(CircleShape)
//            .background(background)
            .clickable(onClick = {
                navController.navigate(screen.route) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
            })
    ){
        Row(
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp, top = 8.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                modifier = Modifier
                    .size(50.dp),
                painter = painterResource(screen.icon),
                contentDescription = "icon",
                tint = iconColor
            )
//            AnimatedVisibility(visible = selected) {
//                Text(
//                    text = screen.title,
//                    color = contentColor
//                )
//            }
        }
    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun Preview(){
    Surface(modifier = Modifier.fillMaxSize()) {
//        BottomNavigation()
    }
}
