package com.saintek.mdh.harahjawoetranslation.ui.component

import com.saintek.mdh.harahjawoetranslation.R

sealed class NavbarItem(
    val route: String,
    val title: String,
    val icon: Int,
){
    object Home: NavbarItem(
        route = "home",
        title = "Home",
        icon = R.drawable.nav_home,
    )

    object History: NavbarItem(
        route = "history",
        title = "History",
        icon = R.drawable.book_outlined,
    )

    object Camera: NavbarItem(
        route = "camera",
        title = "Camera",
        icon = R.drawable.camera_icon,
    )

    object Record: NavbarItem(
        route = "record",
        title = "Record",
        icon = R.drawable.time_outlined,
    )
}