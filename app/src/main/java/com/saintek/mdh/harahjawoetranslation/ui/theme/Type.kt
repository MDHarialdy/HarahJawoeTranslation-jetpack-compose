package com.saintek.mdh.harahjawoetranslation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.saintek.mdh.harahjawoetranslation.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

val dm_serif_display = FontFamily(
    Font(R.font.dm_serif_display)
)

val duru_sans = FontFamily(
    Font(R.font.duru_sans)
)

val gadugi_font = FontFamily(
    Font(R.font.gadugi_font)
)

val istok_web = FontFamily(
    Font(R.font.istok_web_font)
)

val istok_web_bold = FontFamily(
    Font(R.font.istok_web_bold)
)