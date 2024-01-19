package com.saintek.mdh.harahjawoetranslation.ui.component

import com.saintek.mdh.harahjawoetranslation.R

sealed class NavbarItem(
    val route: String,
    val title: String,
    val icon: Int,
    val iconFocused: Int,
){
    object Home: NavbarItem(
        route = "home",
        title = "Home",
        icon = R.drawable.nav_home,
        iconFocused = R.drawable.nav_home_filled
    )

    object History: NavbarItem(
        route = "history",
        title = "History",
        icon = R.drawable.book_outlined,
        iconFocused = R.drawable.book_filled
    )

    object Camera: NavbarItem(
        route = "camera",
        title = "Camera",
        icon = R.drawable.camera_outlined,
        iconFocused = R.drawable.camera_filled
    )

    object Record: NavbarItem(
        route = "record",
        title = "Record",
        icon = R.drawable.time_outlined,
        iconFocused = R.drawable.time_filled
    )
}