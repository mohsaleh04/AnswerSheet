package ir.saltech.answersheet.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ir.saltech.answersheet.R

val Estedad = FontFamily(
    Font(R.font.estedad_black, FontWeight.Black),
    Font(R.font.estedad_black, FontWeight.Bold),
    Font(R.font.estedad_black, FontWeight.Medium),
    Font(R.font.estedad_light, FontWeight.Normal),
    Font(R.font.estedad_light, FontWeight.Light),
)

val Typography = Typography(
    headlineMedium = TextStyle(
        fontFamily = Estedad,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        lineHeight = 14.sp,
        letterSpacing = 2.sp
    ), headlineSmall = TextStyle(
        fontFamily = Estedad,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 14.sp,
        letterSpacing = 2.sp
    ), displayLarge = TextStyle(
        fontFamily = Estedad,
        fontWeight = FontWeight.Bold,
        fontSize = 36.sp,
        lineHeight = 48.sp,
        letterSpacing = 0.5.sp
    ), displayMedium = TextStyle(
        fontFamily = Estedad,
        fontWeight = FontWeight.Normal,
        fontSize = 26.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.5.sp
    ), displaySmall = TextStyle(
        fontFamily = Estedad,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.5.sp
    ), bodyLarge = TextStyle(
        fontFamily = Estedad,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ), bodyMedium = TextStyle(
        fontFamily = Estedad,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.5.sp
    ), bodySmall = TextStyle(
        fontFamily = Estedad,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.5.sp
    ), labelLarge = TextStyle(
        fontFamily = Estedad,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.5.sp
    ), labelMedium = TextStyle(
        fontFamily = Estedad,
        fontWeight = FontWeight.Light,
        fontSize = 12.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.5.sp
    ), labelSmall = TextStyle(
        fontFamily = Estedad,
        fontWeight = FontWeight.Light,
        fontSize = 10.sp,
        lineHeight = 14.sp,
        letterSpacing = 0.5.sp
    )
)

// Set of Material typography styles to start with
//val Typography = Typography(
//    bodyLarge = TextStyle(
//        fontFamily = Estedad,
//        fontWeight = FontWeight.Normal,
//        fontSize = 16.sp,
//        lineHeight = 24.sp,
//        letterSpacing = 0.5.sp
//    ),
//    titleLarge = TextStyle(
//        fontFamily = Estedad,
//        fontWeight = FontWeight.Normal,
//        fontSize = 22.sp,
//        lineHeight = 28.sp,
//        letterSpacing = 0.sp
//    ),
//    labelSmall = TextStyle(
//        fontFamily = Estedad,
//        fontWeight = FontWeight.Medium,
//        fontSize = 11.sp,
//        lineHeight = 16.sp,
//        letterSpacing = 0.5.sp
//    )
//)