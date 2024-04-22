package ir.saltech.answersheet.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

object Symbols {
    object Default {
        val PermissionNeeded: ImageVector
            @Composable get() = rememberPermissionNeeded()
    }

    @Composable
    private fun rememberVisibilityOff(): ImageVector {
        return remember {
            ImageVector.Builder(
                name = "visibility_off",
                defaultWidth = 24.0.dp,
                defaultHeight = 24.0.dp,
                viewportWidth = 40.0f,
                viewportHeight = 40.0f
            ).apply {
                path(
                    fill = SolidColor(Color.Black),
                    fillAlpha = 1f,
                    stroke = null,
                    strokeAlpha = 1f,
                    strokeLineWidth = 1.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(26.25f, 22.417f)
                    lineTo(24.333f, 20.5f)
                    quadToRelative(0.875f, -2.75f, -1.145f, -4.604f)
                    quadToRelative(-2.021f, -1.854f, -4.521f, -1.063f)
                    lineToRelative(-1.917f, -1.916f)
                    quadToRelative(0.708f, -0.417f, 1.542f, -0.605f)
                    quadToRelative(0.833f, -0.187f, 1.708f, -0.187f)
                    quadToRelative(2.958f, 0f, 5f, 2.042f)
                    quadToRelative(2.042f, 2.041f, 2.042f, 5f)
                    quadToRelative(0f, 0.875f, -0.209f, 1.729f)
                    quadToRelative(-0.208f, 0.854f, -0.583f, 1.521f)
                    close()
                    moveToRelative(5.25f, 5.25f)
                    lineToRelative(-1.792f, -1.792f)
                    quadToRelative(1.875f, -1.375f, 3.313f, -3.104f)
                    quadToRelative(1.437f, -1.729f, 2.187f, -3.604f)
                    quadToRelative(-2.041f, -4.459f, -6.083f, -7.042f)
                    reflectiveQuadToRelative(-8.833f, -2.583f)
                    quadToRelative(-1.542f, 0f, -3.209f, 0.271f)
                    quadToRelative(-1.666f, 0.27f, -2.708f, 0.729f)
                    lineToRelative(-2.042f, -2.084f)
                    quadToRelative(1.5f, -0.666f, 3.625f, -1.125f)
                    quadToRelative(2.125f, -0.458f, 4.167f, -0.458f)
                    quadToRelative(5.625f, 0f, 10.271f, 3.021f)
                    quadToRelative(4.646f, 3.021f, 7.104f, 8.062f)
                    quadToRelative(0.125f, 0.25f, 0.188f, 0.563f)
                    quadToRelative(0.062f, 0.312f, 0.062f, 0.646f)
                    quadToRelative(0f, 0.333f, -0.062f, 0.666f)
                    quadToRelative(-0.063f, 0.334f, -0.188f, 0.542f)
                    quadToRelative(-1.042f, 2.208f, -2.562f, 4.021f)
                    quadToRelative(-1.521f, 1.812f, -3.438f, 3.271f)
                    close()
                    moveToRelative(1.083f, 8.458f)
                    lineToRelative(-5.916f, -5.833f)
                    quadToRelative(-1.417f, 0.541f, -3.146f, 0.854f)
                    quadToRelative(-1.729f, 0.312f, -3.521f, 0.312f)
                    quadToRelative(-5.708f, 0f, -10.375f, -3.02f)
                    quadToRelative(-4.667f, -3.021f, -7.125f, -8.063f)
                    quadToRelative(-0.125f, -0.292f, -0.167f, -0.583f)
                    quadToRelative(-0.041f, -0.292f, -0.041f, -0.625f)
                    quadToRelative(0f, -0.334f, 0.062f, -0.667f)
                    quadToRelative(0.063f, -0.333f, 0.146f, -0.583f)
                    quadToRelative(0.917f, -1.792f, 2.188f, -3.479f)
                    quadToRelative(1.27f, -1.688f, 2.937f, -3.146f)
                    lineTo(3.583f, 7.167f)
                    quadToRelative(-0.416f, -0.375f, -0.416f, -0.917f)
                    reflectiveQuadToRelative(0.416f, -0.917f)
                    quadToRelative(0.375f, -0.375f, 0.917f, -0.375f)
                    reflectiveQuadToRelative(0.958f, 0.375f)
                    lineToRelative(29f, 29f)
                    quadToRelative(0.334f, 0.375f, 0.334f, 0.875f)
                    reflectiveQuadToRelative(-0.375f, 0.917f)
                    quadToRelative(-0.375f, 0.417f, -0.917f, 0.417f)
                    reflectiveQuadToRelative(-0.917f, -0.417f)
                    close()
                    moveToRelative(-23.125f, -23f)
                    quadToRelative(-1.416f, 1.083f, -2.729f, 2.771f)
                    quadToRelative(-1.312f, 1.687f, -1.979f, 3.271f)
                    quadToRelative(2.083f, 4.458f, 6.188f, 7.041f)
                    quadToRelative(4.104f, 2.584f, 9.27f, 2.584f)
                    quadToRelative(1.25f, 0f, 2.459f, -0.146f)
                    quadToRelative(1.208f, -0.146f, 1.875f, -0.438f)
                    lineToRelative(-2.334f, -2.333f)
                    quadToRelative(-0.458f, 0.167f, -1.062f, 0.25f)
                    quadToRelative(-0.604f, 0.083f, -1.146f, 0.083f)
                    quadToRelative(-2.917f, 0f, -4.979f, -2.041f)
                    quadToRelative(-2.063f, -2.042f, -2.063f, -5f)
                    quadToRelative(0f, -0.584f, 0.084f, -1.146f)
                    quadToRelative(0.083f, -0.563f, 0.25f, -1.063f)
                    close()
                    moveToRelative(12.625f, 5.333f)
                    close()
                    moveTo(17.042f, 21f)
                    close()
                }
            }.build()
        }
    }

    @Composable
    private fun rememberVisibility(): ImageVector {
        return remember {
            ImageVector.Builder(
                name = "visibility",
                defaultWidth = 24.0.dp,
                defaultHeight = 24.0.dp,
                viewportWidth = 40.0f,
                viewportHeight = 40.0f
            ).apply {
                path(
                    fill = SolidColor(Color.Black),
                    fillAlpha = 1f,
                    stroke = null,
                    strokeAlpha = 1f,
                    strokeLineWidth = 1.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(20f, 26.208f)
                    quadToRelative(2.958f, 0f, 5f, -2.041f)
                    quadToRelative(2.042f, -2.042f, 2.042f, -5f)
                    quadToRelative(0f, -2.959f, -2.042f, -5f)
                    quadToRelative(-2.042f, -2.042f, -5f, -2.042f)
                    reflectiveQuadToRelative(-5f, 2.042f)
                    quadToRelative(-2.042f, 2.041f, -2.042f, 5f)
                    quadToRelative(0f, 2.958f, 2.042f, 5f)
                    quadToRelative(2.042f, 2.041f, 5f, 2.041f)
                    close()
                    moveToRelative(0f, -2.916f)
                    quadToRelative(-1.708f, 0f, -2.917f, -1.209f)
                    quadToRelative(-1.208f, -1.208f, -1.208f, -2.916f)
                    quadToRelative(0f, -1.709f, 1.208f, -2.917f)
                    quadToRelative(1.209f, -1.208f, 2.917f, -1.208f)
                    quadToRelative(1.708f, 0f, 2.917f, 1.208f)
                    quadToRelative(1.208f, 1.208f, 1.208f, 2.917f)
                    quadToRelative(0f, 1.708f, -1.208f, 2.916f)
                    quadToRelative(-1.209f, 1.209f, -2.917f, 1.209f)
                    close()
                    moveToRelative(0f, 8.75f)
                    quadToRelative(-5.792f, 0f, -10.562f, -3.146f)
                    quadToRelative(-4.771f, -3.146f, -7.396f, -8.271f)
                    quadToRelative(-0.167f, -0.292f, -0.23f, -0.687f)
                    quadToRelative(-0.062f, -0.396f, -0.062f, -0.771f)
                    reflectiveQuadToRelative(0.062f, -0.771f)
                    quadToRelative(0.063f, -0.396f, 0.23f, -0.688f)
                    quadToRelative(2.625f, -5.125f, 7.396f, -8.27f)
                    quadTo(14.208f, 6.292f, 20f, 6.292f)
                    reflectiveQuadToRelative(10.562f, 3.146f)
                    quadToRelative(4.771f, 3.145f, 7.396f, 8.27f)
                    quadToRelative(0.167f, 0.292f, 0.25f, 0.688f)
                    quadToRelative(0.084f, 0.396f, 0.084f, 0.771f)
                    reflectiveQuadToRelative(-0.084f, 0.771f)
                    quadToRelative(-0.083f, 0.395f, -0.25f, 0.687f)
                    quadToRelative(-2.625f, 5.125f, -7.396f, 8.271f)
                    quadToRelative(-4.77f, 3.146f, -10.562f, 3.146f)
                    close()
                    moveToRelative(0f, -12.875f)
                    close()
                    moveToRelative(0f, 9.625f)
                    quadToRelative(4.875f, 0f, 8.958f, -2.625f)
                    quadToRelative(4.084f, -2.625f, 6.209f, -7f)
                    quadToRelative(-2.125f, -4.375f, -6.209f, -7f)
                    quadTo(24.875f, 9.542f, 20f, 9.542f)
                    reflectiveQuadToRelative(-8.958f, 2.625f)
                    quadToRelative(-4.084f, 2.625f, -6.25f, 7f)
                    quadToRelative(2.166f, 4.375f, 6.25f, 7f)
                    quadToRelative(4.083f, 2.625f, 8.958f, 2.625f)
                    close()
                }
            }.build()
        }
    }

    @Composable
    private fun rememberChartData(): ImageVector {
        return remember {
            ImageVector.Builder(
                name = "chart_data",
                defaultWidth = 40.0.dp,
                defaultHeight = 40.0.dp,
                viewportWidth = 40.0f,
                viewportHeight = 40.0f
            ).apply {
                path(
                    fill = SolidColor(Color.Black),
                    fillAlpha = 1f,
                    stroke = null,
                    strokeAlpha = 1f,
                    strokeLineWidth = 1.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(17.417f, 21.125f)
                    lineToRelative(2.416f, 2.417f)
                    quadToRelative(0.375f, 0.375f, 0.917f, 0.375f)
                    reflectiveQuadToRelative(0.917f, -0.375f)
                    lineToRelative(5.375f, -5.334f)
                    verticalLineToRelative(1.834f)
                    quadToRelative(0f, 0.541f, 0.375f, 0.896f)
                    quadToRelative(0.375f, 0.354f, 0.916f, 0.354f)
                    quadToRelative(0.542f, 0f, 0.938f, -0.375f)
                    quadToRelative(0.396f, -0.375f, 0.396f, -0.917f)
                    verticalLineToRelative(-5f)
                    quadToRelative(0f, -0.542f, -0.396f, -0.937f)
                    quadToRelative(-0.396f, -0.396f, -0.938f, -0.396f)
                    horizontalLineToRelative(-5.041f)
                    quadToRelative(-0.542f, 0f, -0.896f, 0.396f)
                    quadToRelative(-0.354f, 0.395f, -0.354f, 0.937f)
                    quadToRelative(0f, 0.583f, 0.375f, 0.938f)
                    quadToRelative(0.375f, 0.354f, 0.916f, 0.354f)
                    horizontalLineToRelative(1.792f)
                    lineTo(20.75f, 20.75f)
                    lineToRelative(-2.417f, -2.417f)
                    quadToRelative(-0.375f, -0.375f, -0.916f, -0.375f)
                    quadToRelative(-0.542f, 0f, -0.917f, 0.375f)
                    lineToRelative(-5.083f, 5.084f)
                    quadToRelative(-0.375f, 0.375f, -0.375f, 0.937f)
                    quadToRelative(0f, 0.563f, 0.375f, 0.896f)
                    quadToRelative(0.375f, 0.417f, 0.916f, 0.417f)
                    quadToRelative(0.542f, 0f, 0.917f, -0.417f)
                    close()
                    moveTo(7.875f, 34.75f)
                    quadToRelative(-1.042f, 0f, -1.833f, -0.792f)
                    quadToRelative(-0.792f, -0.791f, -0.792f, -1.833f)
                    verticalLineTo(7.875f)
                    quadToRelative(0f, -1.042f, 0.792f, -1.833f)
                    quadToRelative(0.791f, -0.792f, 1.833f, -0.792f)
                    horizontalLineToRelative(24.25f)
                    quadToRelative(1.042f, 0f, 1.833f, 0.792f)
                    quadToRelative(0.792f, 0.791f, 0.792f, 1.833f)
                    verticalLineToRelative(24.25f)
                    quadToRelative(0f, 1.042f, -0.792f, 1.833f)
                    quadToRelative(-0.791f, 0.792f, -1.833f, 0.792f)
                    close()
                    moveToRelative(0f, -2.625f)
                    horizontalLineToRelative(24.25f)
                    verticalLineTo(7.875f)
                    horizontalLineTo(7.875f)
                    verticalLineToRelative(24.25f)
                    close()
                    moveToRelative(0f, -24.25f)
                    verticalLineToRelative(24.25f)
                    verticalLineToRelative(-24.25f)
                    close()
                }
            }.build()
        }
    }

    @Composable
    private fun rememberSettingsAccountBox(): ImageVector {
        return remember {
            ImageVector.Builder(
                name = "settings_account_box",
                defaultWidth = 40.0.dp,
                defaultHeight = 40.0.dp,
                viewportWidth = 40.0f,
                viewportHeight = 40.0f
            ).apply {
                path(
                    fill = SolidColor(Color.Black),
                    fillAlpha = 1f,
                    stroke = null,
                    strokeAlpha = 1f,
                    strokeLineWidth = 1.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(20f, 17.5f)
                    close()
                    moveTo(7.875f, 33.083f)
                    quadToRelative(-1.042f, 0f, -1.833f, -0.791f)
                    quadToRelative(-0.792f, -0.792f, -0.792f, -1.834f)
                    verticalLineTo(6.208f)
                    quadToRelative(0f, -1.041f, 0.792f, -1.833f)
                    quadToRelative(0.791f, -0.792f, 1.833f, -0.792f)
                    horizontalLineToRelative(24.25f)
                    quadToRelative(1.042f, 0f, 1.833f, 0.792f)
                    quadToRelative(0.792f, 0.792f, 0.792f, 1.833f)
                    verticalLineToRelative(10.917f)
                    quadToRelative(-0.625f, -0.333f, -1.271f, -0.521f)
                    quadToRelative(-0.646f, -0.187f, -1.354f, -0.312f)
                    verticalLineTo(6.208f)
                    horizontalLineTo(7.875f)
                    verticalLineToRelative(22.625f)
                    quadToRelative(2.375f, -2.25f, 5.458f, -3.604f)
                    quadToRelative(3.084f, -1.354f, 6.584f, -1.396f)
                    quadToRelative(-0.167f, 0.625f, -0.271f, 1.292f)
                    quadToRelative(-0.104f, 0.667f, -0.104f, 1.333f)
                    quadToRelative(-2.5f, 0.084f, -4.834f, 0.98f)
                    quadToRelative(-2.333f, 0.895f, -4.333f, 2.604f)
                    verticalLineToRelative(0.416f)
                    horizontalLineToRelative(9.833f)
                    quadToRelative(0.25f, 0.709f, 0.584f, 1.375f)
                    quadToRelative(0.333f, 0.667f, 0.791f, 1.25f)
                    close()
                    moveToRelative(12.167f, -12.416f)
                    quadToRelative(0.416f, 0f, 0.791f, -0.042f)
                    quadToRelative(0.375f, -0.042f, 0.792f, -0.167f)
                    quadToRelative(0.667f, -0.958f, 1.583f, -1.77f)
                    quadToRelative(0.917f, -0.813f, 2f, -1.355f)
                    quadToRelative(0.25f, -0.5f, 0.375f, -1.104f)
                    quadToRelative(0.125f, -0.604f, 0.125f, -1.229f)
                    quadToRelative(0f, -2.375f, -1.646f, -4.021f)
                    quadToRelative(-1.645f, -1.646f, -4.02f, -1.646f)
                    quadToRelative(-2.375f, 0f, -4.021f, 1.646f)
                    reflectiveQuadTo(14.375f, 15f)
                    quadToRelative(0f, 2.375f, 1.646f, 4.021f)
                    reflectiveQuadToRelative(4.021f, 1.646f)
                    close()
                    moveToRelative(0f, -2.625f)
                    quadToRelative(-1.25f, 0f, -2.125f, -0.896f)
                    reflectiveQuadTo(17.042f, 15f)
                    quadToRelative(0f, -1.25f, 0.875f, -2.146f)
                    quadToRelative(0.875f, -0.896f, 2.125f, -0.896f)
                    reflectiveQuadToRelative(2.146f, 0.896f)
                    quadToRelative(0.895f, 0.896f, 0.895f, 2.146f)
                    reflectiveQuadToRelative(-0.895f, 2.146f)
                    quadToRelative(-0.896f, 0.896f, -2.146f, 0.896f)
                    close()
                    moveToRelative(8.833f, 16.791f)
                    lineToRelative(-0.25f, -2.083f)
                    quadToRelative(-0.75f, -0.25f, -1.5f, -0.646f)
                    reflectiveQuadToRelative(-1.25f, -0.937f)
                    lineTo(23.958f, 32f)
                    lineToRelative(-1.5f, -2.333f)
                    lineToRelative(1.709f, -1.334f)
                    quadToRelative(-0.209f, -0.833f, -0.209f, -1.541f)
                    quadToRelative(0f, -0.709f, 0.209f, -1.542f)
                    lineToRelative(-1.709f, -1.333f)
                    lineToRelative(1.5f, -2.375f)
                    lineToRelative(1.917f, 0.833f)
                    quadToRelative(0.5f, -0.5f, 1.25f, -0.896f)
                    reflectiveQuadToRelative(1.5f, -0.646f)
                    lineToRelative(0.25f, -2.125f)
                    horizontalLineTo(31.5f)
                    lineToRelative(0.292f, 2.125f)
                    quadToRelative(0.75f, 0.25f, 1.5f, 0.667f)
                    quadToRelative(0.75f, 0.417f, 1.25f, 0.875f)
                    lineToRelative(1.916f, -0.833f)
                    lineToRelative(1.5f, 2.375f)
                    lineToRelative(-1.708f, 1.333f)
                    quadToRelative(0.208f, 0.833f, 0.208f, 1.542f)
                    quadToRelative(0f, 0.708f, -0.208f, 1.541f)
                    lineToRelative(1.708f, 1.334f)
                    lineToRelative(-1.5f, 2.333f)
                    lineToRelative(-1.916f, -0.833f)
                    quadToRelative(-0.5f, 0.541f, -1.25f, 0.937f)
                    reflectiveQuadToRelative(-1.5f, 0.646f)
                    lineToRelative(-0.292f, 2.083f)
                    close()
                    moveToRelative(1.333f, -4.125f)
                    quadToRelative(1.667f, 0f, 2.792f, -1.125f)
                    quadToRelative(1.125f, -1.125f, 1.125f, -2.791f)
                    quadToRelative(0f, -1.709f, -1.125f, -2.834f)
                    reflectiveQuadToRelative(-2.792f, -1.125f)
                    quadToRelative(-1.708f, 0f, -2.833f, 1.125f)
                    quadToRelative(-1.125f, 1.125f, -1.125f, 2.834f)
                    quadToRelative(0f, 1.666f, 1.125f, 2.791f)
                    reflectiveQuadToRelative(2.833f, 1.125f)
                    close()
                }
            }.build()
        }
    }

    @Composable
    private fun rememberLogout(): ImageVector {
        return remember {
            ImageVector.Builder(
                name = "logout",
                defaultWidth = 40.0.dp,
                defaultHeight = 40.0.dp,
                viewportWidth = 40.0f,
                viewportHeight = 40.0f
            ).apply {
                path(
                    fill = SolidColor(Color.Black),
                    fillAlpha = 1f,
                    stroke = null,
                    strokeAlpha = 1f,
                    strokeLineWidth = 1.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(26.417f, 26.5f)
                    quadToRelative(-0.375f, -0.417f, -0.375f, -0.958f)
                    quadToRelative(0f, -0.542f, 0.375f, -0.917f)
                    lineToRelative(3.25f, -3.25f)
                    horizontalLineTo(16.833f)
                    quadToRelative(-0.541f, 0f, -0.937f, -0.375f)
                    reflectiveQuadToRelative(-0.396f, -0.917f)
                    quadToRelative(0f, -0.583f, 0.396f, -0.958f)
                    reflectiveQuadToRelative(0.937f, -0.375f)
                    horizontalLineToRelative(12.792f)
                    lineToRelative(-3.292f, -3.292f)
                    quadToRelative(-0.375f, -0.333f, -0.354f, -0.875f)
                    quadToRelative(0.021f, -0.541f, 0.396f, -0.958f)
                    quadToRelative(0.375f, -0.375f, 0.937f, -0.375f)
                    quadToRelative(0.563f, 0f, 0.98f, 0.375f)
                    lineToRelative(5.5f, 5.542f)
                    quadToRelative(0.208f, 0.208f, 0.312f, 0.437f)
                    quadToRelative(0.104f, 0.229f, 0.104f, 0.479f)
                    quadToRelative(0f, 0.292f, -0.104f, 0.5f)
                    quadToRelative(-0.104f, 0.209f, -0.312f, 0.417f)
                    lineToRelative(-5.5f, 5.542f)
                    quadToRelative(-0.375f, 0.375f, -0.917f, 0.354f)
                    quadToRelative(-0.542f, -0.021f, -0.958f, -0.396f)
                    close()
                    moveToRelative(-18.5f, 8.375f)
                    quadToRelative(-1.084f, 0f, -1.855f, -0.792f)
                    quadToRelative(-0.77f, -0.791f, -0.77f, -1.875f)
                    verticalLineTo(7.917f)
                    quadToRelative(0f, -1.084f, 0.77f, -1.854f)
                    quadToRelative(0.771f, -0.771f, 1.855f, -0.771f)
                    horizontalLineToRelative(10.541f)
                    quadToRelative(0.542f, 0f, 0.938f, 0.375f)
                    quadToRelative(0.396f, 0.375f, 0.396f, 0.916f)
                    quadToRelative(0f, 0.584f, -0.396f, 0.959f)
                    reflectiveQuadToRelative(-0.938f, 0.375f)
                    horizontalLineTo(7.917f)
                    verticalLineToRelative(24.291f)
                    horizontalLineToRelative(10.541f)
                    quadToRelative(0.542f, 0f, 0.938f, 0.396f)
                    quadToRelative(0.396f, 0.396f, 0.396f, 0.938f)
                    quadToRelative(0f, 0.541f, -0.396f, 0.937f)
                    reflectiveQuadToRelative(-0.938f, 0.396f)
                    close()
                }
            }.build()
        }
    }

    @Composable
    private fun rememberKey(): ImageVector {
        return remember {
            ImageVector.Builder(
                name = "key",
                defaultWidth = 40.0.dp,
                defaultHeight = 40.0.dp,
                viewportWidth = 40.0f,
                viewportHeight = 40.0f
            ).apply {
                path(
                    fill = SolidColor(Color.Black),
                    fillAlpha = 1f,
                    stroke = null,
                    strokeAlpha = 1f,
                    strokeLineWidth = 1.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(11.75f, 22.875f)
                    quadToRelative(-1.167f, 0f, -2.021f, -0.854f)
                    quadToRelative(-0.854f, -0.854f, -0.854f, -2.021f)
                    quadToRelative(0f, -1.167f, 0.854f, -2.021f)
                    quadToRelative(0.854f, -0.854f, 2.021f, -0.854f)
                    quadToRelative(1.167f, 0f, 2.021f, 0.854f)
                    quadToRelative(0.854f, 0.854f, 0.854f, 2.021f)
                    quadToRelative(0f, 1.167f, -0.854f, 2.021f)
                    quadToRelative(-0.854f, 0.854f, -2.021f, 0.854f)
                    close()
                    moveToRelative(0f, 6.917f)
                    quadToRelative(-4.083f, 0f, -6.938f, -2.854f)
                    quadTo(1.958f, 24.083f, 1.958f, 20f)
                    reflectiveQuadToRelative(2.854f, -6.937f)
                    quadToRelative(2.855f, -2.855f, 6.938f, -2.855f)
                    quadToRelative(2.917f, 0f, 5.125f, 1.375f)
                    reflectiveQuadToRelative(3.5f, 4.042f)
                    horizontalLineToRelative(14.292f)
                    quadToRelative(0.208f, 0f, 0.458f, 0.104f)
                    reflectiveQuadToRelative(0.417f, 0.313f)
                    lineToRelative(3.333f, 3.291f)
                    quadToRelative(0.208f, 0.209f, 0.292f, 0.438f)
                    quadToRelative(0.083f, 0.229f, 0.083f, 0.521f)
                    quadToRelative(0f, 0.25f, -0.104f, 0.479f)
                    quadToRelative(-0.104f, 0.229f, -0.313f, 0.437f)
                    lineToRelative(-5.166f, 4.875f)
                    quadToRelative(-0.167f, 0.167f, -0.375f, 0.25f)
                    quadToRelative(-0.209f, 0.084f, -0.459f, 0.084f)
                    quadToRelative(-0.208f, 0.041f, -0.416f, -0.021f)
                    quadToRelative(-0.209f, -0.063f, -0.417f, -0.188f)
                    lineToRelative(-2.708f, -2f)
                    lineToRelative(-2.75f, 2.042f)
                    quadToRelative(-0.209f, 0.167f, -0.396f, 0.208f)
                    quadToRelative(-0.188f, 0.042f, -0.396f, 0.042f)
                    quadToRelative(-0.208f, 0f, -0.417f, -0.062f)
                    quadToRelative(-0.208f, -0.063f, -0.375f, -0.188f)
                    lineTo(22.5f, 24.375f)
                    horizontalLineToRelative(-2.125f)
                    quadToRelative(-1.125f, 2.417f, -3.333f, 3.917f)
                    quadToRelative(-2.209f, 1.5f, -5.292f, 1.5f)
                    close()
                    moveToRelative(0f, -2.625f)
                    quadToRelative(2.375f, 0f, 4.312f, -1.521f)
                    quadToRelative(1.938f, -1.521f, 2.521f, -3.938f)
                    horizontalLineToRelative(4.834f)
                    lineToRelative(2.333f, 1.834f)
                    quadToRelative(-0.042f, 0f, 0f, 0f)
                    horizontalLineToRelative(0.021f)
                    horizontalLineToRelative(-0.021f)
                    lineToRelative(3.583f, -2.584f)
                    lineToRelative(3.292f, 2.459f)
                    horizontalLineToRelative(-0.021f)
                    horizontalLineToRelative(0.021f)
                    lineToRelative(3.417f, -3.209f)
                    quadToRelative(-0.042f, 0f, -0.021f, 0.021f)
                    reflectiveQuadToRelative(0.021f, -0.021f)
                    lineToRelative(-1.959f, -1.916f)
                    verticalLineToRelative(-0.021f)
                    verticalLineToRelative(0.021f)
                    horizontalLineToRelative(-15.5f)
                    quadToRelative(-0.541f, -2.292f, -2.458f, -3.875f)
                    quadToRelative(-1.917f, -1.584f, -4.375f, -1.584f)
                    quadToRelative(-3f, 0f, -5.083f, 2.084f)
                    quadTo(4.583f, 17f, 4.583f, 20f)
                    reflectiveQuadToRelative(2.084f, 5.083f)
                    quadToRelative(2.083f, 2.084f, 5.083f, 2.084f)
                    close()
                }
            }.build()
        }
    }

    @Composable
    private fun rememberWarning(): ImageVector {
        return remember {
            ImageVector.Builder(
                name = "warning",
                defaultWidth = 40.0.dp,
                defaultHeight = 40.0.dp,
                viewportWidth = 40.0f,
                viewportHeight = 40.0f
            ).apply {
                path(
                    fill = SolidColor(Color.Black),
                    fillAlpha = 1f,
                    stroke = null,
                    strokeAlpha = 1f,
                    strokeLineWidth = 1.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(4.292f, 34.75f)
                    quadToRelative(-0.75f, 0f, -1.125f, -0.646f)
                    reflectiveQuadToRelative(0f, -1.312f)
                    lineTo(18.875f, 5.667f)
                    quadToRelative(0.375f, -0.625f, 1.125f, -0.625f)
                    reflectiveQuadToRelative(1.125f, 0.625f)
                    lineToRelative(15.708f, 27.125f)
                    quadToRelative(0.375f, 0.666f, 0f, 1.312f)
                    reflectiveQuadToRelative(-1.125f, 0.646f)
                    close()
                    moveToRelative(15.833f, -18.333f)
                    quadToRelative(-0.542f, 0f, -0.937f, 0.395f)
                    quadToRelative(-0.396f, 0.396f, -0.396f, 0.896f)
                    verticalLineTo(24f)
                    quadToRelative(0f, 0.583f, 0.396f, 0.958f)
                    quadToRelative(0.395f, 0.375f, 0.937f, 0.375f)
                    reflectiveQuadToRelative(0.937f, -0.375f)
                    quadToRelative(0.396f, -0.375f, 0.396f, -0.958f)
                    verticalLineToRelative(-6.292f)
                    quadToRelative(0f, -0.5f, -0.396f, -0.896f)
                    quadToRelative(-0.395f, -0.395f, -0.937f, -0.395f)
                    close()
                    moveToRelative(0f, 13.541f)
                    quadToRelative(0.542f, 0f, 0.937f, -0.396f)
                    quadToRelative(0.396f, -0.395f, 0.396f, -0.937f)
                    quadToRelative(0f, -0.583f, -0.396f, -0.958f)
                    quadToRelative(-0.395f, -0.375f, -0.937f, -0.375f)
                    quadToRelative(-0.583f, 0f, -0.958f, 0.375f)
                    reflectiveQuadToRelative(-0.375f, 0.958f)
                    quadToRelative(0f, 0.542f, 0.375f, 0.937f)
                    quadToRelative(0.375f, 0.396f, 0.958f, 0.396f)
                    close()
                }
            }.build()
        }
    }

    @Composable
    private fun rememberAverage(): ImageVector {
        return remember {
            ImageVector.Builder(
                name = "Average",
                defaultWidth = 40.0.dp,
                defaultHeight = 40.0.dp,
                viewportWidth = 512.0f,
                viewportHeight = 512.0f
            ).apply {
                path(
                    fill = SolidColor(Color(0xFF000000)),
                    stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 4.0f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(45.1f, 1.4f)
                    curveToRelative(-8.7f, 4.8f, -5.0f, 18.6f, 4.9f, 18.6f)
                    curveToRelative(5.1f, -0.0f, 10.0f, -4.9f, 10.0f, -9.9f)
                    curveToRelative(0.0f, -7.5f, -8.3f, -12.4f, -14.9f, -8.7f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF000000)),
                    stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 4.0f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(45.1f, 46.4f)
                    curveToRelative(-4.6f, 2.5f, -5.0f, 4.8f, -5.1f, 25.8f)
                    lineToRelative(0.0f, 19.8f)
                    lineToRelative(-16.0f, -0.0f)
                    curveToRelative(-17.4f, -0.0f, -20.3f, 0.7f, -22.6f, 5.1f)
                    curveToRelative(-1.8f, 3.5f, -1.8f, 6.3f, 0.0f, 9.8f)
                    curveToRelative(2.3f, 4.4f, 5.2f, 5.1f, 22.6f, 5.1f)
                    lineToRelative(16.0f, -0.0f)
                    lineToRelative(0.0f, 20.0f)
                    lineToRelative(0.0f, 20.0f)
                    lineToRelative(-7.5f, -0.0f)
                    curveToRelative(-11.3f, -0.0f, -15.5f, 2.8f, -15.5f, 10.4f)
                    curveToRelative(0.0f, 2.2f, 0.9f, 4.5f, 2.4f, 6.3f)
                    curveToRelative(2.3f, 2.6f, 3.0f, 2.8f, 11.5f, 3.1f)
                    lineToRelative(9.1f, 0.4f)
                    lineToRelative(0.0f, 19.9f)
                    lineToRelative(0.0f, 19.9f)
                    lineToRelative(-7.5f, -0.0f)
                    curveToRelative(-11.3f, -0.0f, -15.5f, 2.8f, -15.5f, 10.4f)
                    curveToRelative(0.0f, 2.2f, 0.9f, 4.5f, 2.4f, 6.3f)
                    curveToRelative(2.3f, 2.6f, 3.0f, 2.8f, 11.5f, 3.1f)
                    lineToRelative(9.1f, 0.4f)
                    lineToRelative(0.0f, 19.9f)
                    lineToRelative(0.0f, 19.9f)
                    lineToRelative(-16.0f, -0.0f)
                    curveToRelative(-17.4f, -0.0f, -20.3f, 0.7f, -22.6f, 5.1f)
                    curveToRelative(-1.8f, 3.5f, -1.8f, 6.3f, 0.0f, 9.8f)
                    curveToRelative(2.3f, 4.4f, 5.2f, 5.1f, 22.6f, 5.1f)
                    lineToRelative(16.0f, -0.0f)
                    lineToRelative(0.0f, 20.0f)
                    lineToRelative(0.0f, 20.0f)
                    lineToRelative(-7.5f, -0.0f)
                    curveToRelative(-11.3f, -0.0f, -15.5f, 2.8f, -15.5f, 10.4f)
                    curveToRelative(0.0f, 2.2f, 0.9f, 4.5f, 2.4f, 6.3f)
                    curveToRelative(2.3f, 2.6f, 3.0f, 2.8f, 11.5f, 3.1f)
                    lineToRelative(9.1f, 0.4f)
                    lineToRelative(0.0f, 19.9f)
                    lineToRelative(0.0f, 19.9f)
                    lineToRelative(-7.5f, -0.0f)
                    curveToRelative(-11.3f, -0.0f, -15.5f, 2.8f, -15.5f, 10.4f)
                    curveToRelative(0.0f, 2.2f, 0.9f, 4.5f, 2.4f, 6.3f)
                    curveToRelative(2.3f, 2.6f, 3.0f, 2.8f, 11.5f, 3.1f)
                    lineToRelative(9.1f, 0.4f)
                    lineToRelative(0.0f, 19.9f)
                    lineToRelative(0.0f, 19.9f)
                    lineToRelative(-16.0f, -0.0f)
                    curveToRelative(-17.6f, -0.0f, -20.6f, 0.7f, -22.8f, 5.5f)
                    curveToRelative(-1.5f, 3.3f, -1.5f, 5.7f, 0.0f, 9.0f)
                    curveToRelative(2.2f, 4.8f, 5.2f, 5.5f, 22.8f, 5.5f)
                    lineToRelative(16.0f, -0.0f)
                    lineToRelative(0.0f, 16.0f)
                    curveToRelative(0.0f, 17.4f, 0.7f, 20.3f, 5.1f, 22.6f)
                    curveToRelative(3.5f, 1.8f, 6.3f, 1.8f, 9.8f, -0.0f)
                    curveToRelative(4.4f, -2.3f, 5.1f, -5.2f, 5.1f, -22.6f)
                    lineToRelative(0.0f, -16.0f)
                    lineToRelative(19.9f, -0.0f)
                    lineToRelative(19.9f, -0.0f)
                    lineToRelative(0.4f, 9.1f)
                    curveToRelative(0.3f, 8.5f, 0.5f, 9.2f, 3.1f, 11.5f)
                    curveToRelative(1.8f, 1.5f, 4.1f, 2.4f, 6.3f, 2.4f)
                    curveToRelative(7.6f, -0.0f, 10.4f, -4.2f, 10.4f, -15.5f)
                    lineToRelative(0.0f, -7.5f)
                    lineToRelative(19.9f, -0.0f)
                    lineToRelative(19.9f, -0.0f)
                    lineToRelative(0.4f, 9.1f)
                    curveToRelative(0.3f, 8.5f, 0.5f, 9.2f, 3.1f, 11.5f)
                    curveToRelative(1.8f, 1.5f, 4.1f, 2.4f, 6.3f, 2.4f)
                    curveToRelative(7.6f, -0.0f, 10.4f, -4.2f, 10.4f, -15.5f)
                    lineToRelative(0.0f, -7.5f)
                    lineToRelative(20.0f, -0.0f)
                    lineToRelative(20.0f, -0.0f)
                    lineToRelative(0.0f, 16.0f)
                    curveToRelative(0.0f, 17.4f, 0.7f, 20.3f, 5.1f, 22.6f)
                    curveToRelative(3.5f, 1.8f, 6.3f, 1.8f, 9.8f, -0.0f)
                    curveToRelative(4.4f, -2.3f, 5.1f, -5.2f, 5.1f, -22.6f)
                    lineToRelative(0.0f, -16.0f)
                    lineToRelative(19.9f, -0.0f)
                    lineToRelative(19.9f, -0.0f)
                    lineToRelative(0.4f, 9.1f)
                    curveToRelative(0.3f, 8.5f, 0.5f, 9.2f, 3.1f, 11.5f)
                    curveToRelative(3.8f, 3.3f, 9.6f, 3.3f, 13.4f, -0.0f)
                    curveToRelative(2.6f, -2.3f, 2.8f, -3.0f, 3.1f, -11.5f)
                    lineToRelative(0.4f, -9.1f)
                    lineToRelative(19.8f, -0.0f)
                    lineToRelative(19.8f, -0.0f)
                    lineToRelative(0.4f, 9.1f)
                    curveToRelative(0.3f, 8.5f, 0.5f, 9.2f, 3.1f, 11.5f)
                    curveToRelative(3.8f, 3.3f, 9.6f, 3.3f, 13.4f, -0.0f)
                    curveToRelative(2.6f, -2.3f, 2.8f, -3.0f, 3.1f, -11.5f)
                    lineToRelative(0.4f, -9.1f)
                    lineToRelative(19.9f, -0.0f)
                    lineToRelative(19.9f, -0.0f)
                    lineToRelative(0.0f, 16.0f)
                    curveToRelative(0.0f, 17.4f, 0.7f, 20.3f, 5.1f, 22.6f)
                    curveToRelative(3.5f, 1.8f, 6.3f, 1.8f, 9.8f, -0.0f)
                    curveToRelative(4.4f, -2.3f, 5.1f, -5.2f, 5.1f, -22.6f)
                    lineToRelative(0.0f, -16.0f)
                    lineToRelative(42.0f, -0.0f)
                    curveToRelative(45.7f, -0.0f, 46.3f, -0.1f, 48.8f, -5.5f)
                    curveToRelative(2.4f, -5.1f, 0.4f, -11.2f, -4.3f, -13.3f)
                    curveToRelative(-2.0f, -0.9f, -54.6f, -1.2f, -224.5f, -1.2f)
                    lineToRelative(-222.0f, -0.0f)
                    lineToRelative(0.0f, -199.5f)
                    curveToRelative(0.0f, -152.5f, -0.3f, -200.0f, -1.2f, -202.0f)
                    curveToRelative(-2.2f, -4.8f, -8.8f, -6.8f, -13.7f, -4.1f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF000000)),
                    stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 4.0f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(279.0f, 63.6f)
                    curveToRelative(-20.0f, 5.3f, -32.8f, 27.9f, -27.6f, 48.4f)
                    curveToRelative(1.7f, 6.7f, 5.8f, 13.9f, 10.0f, 17.9f)
                    lineToRelative(2.5f, 2.3f)
                    lineToRelative(-20.0f, 39.9f)
                    curveToRelative(-19.7f, 39.4f, -19.9f, 39.9f, -23.0f, 39.9f)
                    curveToRelative(-6.1f, -0.0f, -10.9f, 4.5f, -10.9f, 10.3f)
                    curveToRelative(0.0f, 1.2f, 1.0f, 3.8f, 2.1f, 5.7f)
                    lineToRelative(2.1f, 3.5f)
                    lineToRelative(-17.7f, 35.5f)
                    lineToRelative(-17.7f, 35.5f)
                    lineToRelative(-9.2f, -0.0f)
                    curveToRelative(-8.1f, -0.0f, -9.8f, 0.4f, -15.6f, 3.1f)
                    curveToRelative(-9.5f, 4.6f, -15.3f, 10.1f, -19.7f, 19.2f)
                    curveToRelative(-3.6f, 7.2f, -3.8f, 8.1f, -3.8f, 17.2f)
                    curveToRelative(0.0f, 9.1f, 0.2f, 10.0f, 3.7f, 17.2f)
                    curveToRelative(4.5f, 9.0f, 10.3f, 14.8f, 19.3f, 19.0f)
                    curveToRelative(19.7f, 9.2f, 43.3f, 0.6f, 52.2f, -18.9f)
                    curveToRelative(7.0f, -15.2f, 4.8f, -31.7f, -5.7f, -43.5f)
                    lineToRelative(-3.8f, -4.3f)
                    lineToRelative(19.9f, -39.7f)
                    curveToRelative(19.7f, -39.3f, 19.9f, -39.8f, 23.0f, -39.8f)
                    curveToRelative(6.1f, -0.0f, 10.9f, -4.5f, 10.9f, -10.3f)
                    curveToRelative(0.0f, -1.2f, -1.0f, -3.8f, -2.1f, -5.7f)
                    lineToRelative(-2.1f, -3.5f)
                    lineToRelative(17.7f, -35.5f)
                    lineToRelative(17.7f, -35.5f)
                    lineToRelative(8.8f, -0.0f)
                    lineToRelative(8.8f, -0.0f)
                    lineToRelative(17.7f, 35.5f)
                    lineToRelative(17.7f, 35.5f)
                    lineToRelative(-2.1f, 3.5f)
                    curveToRelative(-2.5f, 4.1f, -2.6f, 7.0f, -0.7f, 10.9f)
                    curveToRelative(1.7f, 3.1f, 5.4f, 5.1f, 9.6f, 5.1f)
                    curveToRelative(2.9f, -0.0f, 3.4f, 0.9f, 22.9f, 39.8f)
                    lineToRelative(19.9f, 39.7f)
                    lineToRelative(-3.8f, 4.3f)
                    curveToRelative(-10.5f, 11.8f, -12.7f, 28.3f, -5.7f, 43.6f)
                    curveToRelative(8.9f, 19.4f, 32.6f, 27.9f, 52.2f, 18.8f)
                    curveToRelative(9.0f, -4.2f, 14.8f, -10.0f, 19.3f, -19.0f)
                    curveToRelative(3.5f, -7.2f, 3.7f, -8.1f, 3.7f, -17.1f)
                    curveToRelative(0.0f, -8.7f, -0.3f, -10.2f, -3.2f, -16.3f)
                    curveToRelative(-4.4f, -9.3f, -10.0f, -15.1f, -19.1f, -19.6f)
                    curveToRelative(-7.1f, -3.5f, -8.2f, -3.7f, -16.8f, -3.7f)
                    lineToRelative(-9.2f, -0.0f)
                    lineToRelative(-17.7f, -35.5f)
                    lineToRelative(-17.7f, -35.5f)
                    lineToRelative(2.1f, -3.5f)
                    curveToRelative(1.1f, -1.9f, 2.1f, -4.5f, 2.1f, -5.7f)
                    curveToRelative(0.0f, -5.8f, -4.8f, -10.3f, -10.9f, -10.3f)
                    curveToRelative(-3.1f, -0.0f, -3.3f, -0.5f, -23.0f, -39.9f)
                    lineToRelative(-20.0f, -39.9f)
                    lineToRelative(2.5f, -2.3f)
                    curveToRelative(7.4f, -6.9f, 12.1f, -19.8f, 11.1f, -30.5f)
                    curveToRelative(-2.4f, -25.9f, -25.9f, -42.4f, -50.7f, -35.8f)
                    close()
                    moveTo(301.0f, 85.4f)
                    curveToRelative(5.9f, 3.9f, 8.5f, 8.9f, 8.5f, 16.6f)
                    curveToRelative(0.0f, 7.8f, -2.6f, 12.7f, -8.8f, 16.8f)
                    curveToRelative(-5.6f, 3.7f, -15.3f, 3.9f, -21.0f, 0.3f)
                    curveToRelative(-7.6f, -4.7f, -11.1f, -14.0f, -8.8f, -22.9f)
                    curveToRelative(1.4f, -5.1f, 7.5f, -11.7f, 12.3f, -13.1f)
                    curveToRelative(5.3f, -1.6f, 13.5f, -0.6f, 17.8f, 2.3f)
                    close()
                    moveTo(176.4f, 323.2f)
                    curveToRelative(15.4f, 4.7f, 18.1f, 26.5f, 4.3f, 35.6f)
                    curveToRelative(-5.6f, 3.7f, -15.3f, 3.9f, -21.0f, 0.3f)
                    curveToRelative(-10.9f, -6.7f, -12.8f, -22.0f, -3.9f, -30.9f)
                    curveToRelative(5.7f, -5.7f, 12.6f, -7.4f, 20.6f, -5.0f)
                    close()
                    moveTo(419.6f, 324.7f)
                    curveToRelative(2.2f, 1.1f, 5.3f, 3.9f, 6.9f, 6.2f)
                    curveToRelative(2.6f, 3.7f, 3.0f, 5.1f, 3.0f, 11.1f)
                    curveToRelative(0.0f, 6.0f, -0.4f, 7.4f, -3.0f, 11.1f)
                    curveToRelative(-1.6f, 2.3f, -5.0f, 5.3f, -7.5f, 6.7f)
                    curveToRelative(-3.8f, 2.0f, -5.5f, 2.3f, -10.4f, 1.9f)
                    curveToRelative(-13.0f, -1.1f, -21.1f, -12.8f, -17.6f, -25.4f)
                    curveToRelative(1.6f, -5.5f, 7.0f, -11.4f, 12.0f, -13.0f)
                    curveToRelative(4.8f, -1.6f, 12.0f, -1.0f, 16.6f, 1.4f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF000000)),
                    stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 4.0f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(95.1f, 213.4f)
                    curveToRelative(-4.7f, 2.6f, -6.3f, 8.4f, -3.7f, 13.5f)
                    curveToRelative(2.2f, 4.2f, 5.5f, 5.1f, 18.6f, 5.1f)
                    curveToRelative(13.1f, -0.0f, 16.4f, -0.9f, 18.6f, -5.1f)
                    curveToRelative(2.7f, -5.2f, 0.8f, -11.5f, -4.1f, -13.7f)
                    curveToRelative(-3.7f, -1.7f, -26.3f, -1.5f, -29.4f, 0.2f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF000000)),
                    stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 4.0f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(155.1f, 213.4f)
                    curveToRelative(-4.7f, 2.6f, -6.3f, 8.4f, -3.7f, 13.5f)
                    curveToRelative(2.2f, 4.2f, 5.5f, 5.1f, 18.6f, 5.1f)
                    curveToRelative(13.1f, -0.0f, 16.4f, -0.9f, 18.6f, -5.1f)
                    curveToRelative(2.7f, -5.2f, 0.8f, -11.5f, -4.1f, -13.7f)
                    curveToRelative(-3.7f, -1.7f, -26.3f, -1.5f, -29.4f, 0.2f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF000000)),
                    stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 4.0f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(275.1f, 213.4f)
                    curveToRelative(-4.7f, 2.6f, -6.3f, 8.4f, -3.7f, 13.5f)
                    curveToRelative(2.2f, 4.2f, 5.5f, 5.1f, 18.6f, 5.1f)
                    curveToRelative(13.1f, -0.0f, 16.4f, -0.9f, 18.6f, -5.1f)
                    curveToRelative(2.7f, -5.2f, 0.8f, -11.5f, -4.1f, -13.7f)
                    curveToRelative(-3.7f, -1.7f, -26.3f, -1.5f, -29.4f, 0.2f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF000000)),
                    stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 4.0f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(395.1f, 213.4f)
                    curveToRelative(-4.7f, 2.6f, -6.3f, 8.4f, -3.7f, 13.5f)
                    curveToRelative(2.2f, 4.2f, 5.5f, 5.1f, 18.6f, 5.1f)
                    curveToRelative(13.1f, -0.0f, 16.4f, -0.9f, 18.6f, -5.1f)
                    curveToRelative(2.7f, -5.2f, 0.8f, -11.5f, -4.1f, -13.7f)
                    curveToRelative(-3.7f, -1.7f, -26.3f, -1.5f, -29.4f, 0.2f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF000000)),
                    stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 4.0f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(455.1f, 213.4f)
                    curveToRelative(-4.7f, 2.6f, -6.3f, 8.4f, -3.7f, 13.5f)
                    curveToRelative(2.2f, 4.2f, 5.5f, 5.1f, 18.6f, 5.1f)
                    curveToRelative(13.1f, -0.0f, 16.4f, -0.9f, 18.6f, -5.1f)
                    curveToRelative(2.7f, -5.2f, 0.8f, -11.5f, -4.1f, -13.7f)
                    curveToRelative(-3.7f, -1.7f, -26.3f, -1.5f, -29.4f, 0.2f)
                    close()
                }
            }.build()
        }
    }

    @Composable
    private fun rememberRates(): ImageVector {
        return remember {
            ImageVector.Builder(
                name = "candlestick_chart",
                defaultWidth = 40.0.dp,
                defaultHeight = 40.0.dp,
                viewportWidth = 40.0f,
                viewportHeight = 40.0f
            ).apply {
                path(
                    fill = SolidColor(Color.Black),
                    fillAlpha = 1f,
                    stroke = null,
                    strokeAlpha = 1f,
                    strokeLineWidth = 1.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(13.042f, 33.25f)
                    quadToRelative(-0.542f, 0f, -0.917f, -0.375f)
                    reflectiveQuadToRelative(-0.375f, -0.917f)
                    verticalLineToRelative(-2.333f)
                    horizontalLineTo(9.708f)
                    quadToRelative(-0.541f, 0f, -0.916f, -0.354f)
                    reflectiveQuadToRelative(-0.375f, -0.938f)
                    verticalLineTo(11.625f)
                    quadToRelative(0f, -0.542f, 0.375f, -0.917f)
                    reflectiveQuadToRelative(0.916f, -0.375f)
                    horizontalLineToRelative(2.042f)
                    verticalLineTo(8.042f)
                    quadToRelative(0f, -0.542f, 0.375f, -0.938f)
                    quadToRelative(0.375f, -0.396f, 0.917f, -0.396f)
                    quadToRelative(0.583f, 0f, 0.958f, 0.396f)
                    reflectiveQuadToRelative(0.375f, 0.938f)
                    verticalLineToRelative(2.291f)
                    horizontalLineToRelative(2.042f)
                    quadToRelative(0.541f, 0f, 0.916f, 0.375f)
                    reflectiveQuadToRelative(0.375f, 0.917f)
                    verticalLineToRelative(16.708f)
                    quadToRelative(0f, 0.584f, -0.375f, 0.938f)
                    reflectiveQuadToRelative(-0.916f, 0.354f)
                    horizontalLineToRelative(-2.042f)
                    verticalLineToRelative(2.333f)
                    quadToRelative(0f, 0.542f, -0.375f, 0.917f)
                    reflectiveQuadToRelative(-0.958f, 0.375f)
                    close()
                    moveToRelative(-2f, -6.25f)
                    horizontalLineToRelative(4.041f)
                    verticalLineTo(12.958f)
                    horizontalLineToRelative(-4.041f)
                    close()
                    moveToRelative(15.916f, 6.25f)
                    quadToRelative(-0.583f, 0f, -0.958f, -0.375f)
                    reflectiveQuadToRelative(-0.375f, -0.917f)
                    verticalLineToRelative(-7.333f)
                    horizontalLineToRelative(-2f)
                    quadToRelative(-0.583f, 0f, -0.958f, -0.354f)
                    reflectiveQuadToRelative(-0.375f, -0.938f)
                    verticalLineToRelative(-8.375f)
                    quadToRelative(0f, -0.541f, 0.375f, -0.916f)
                    reflectiveQuadToRelative(0.958f, -0.375f)
                    horizontalLineToRelative(2f)
                    verticalLineTo(8.042f)
                    quadToRelative(0f, -0.542f, 0.375f, -0.938f)
                    quadToRelative(0.375f, -0.396f, 0.958f, -0.396f)
                    quadToRelative(0.542f, 0f, 0.938f, 0.396f)
                    quadToRelative(0.396f, 0.396f, 0.396f, 0.938f)
                    verticalLineToRelative(5.625f)
                    horizontalLineToRelative(2f)
                    quadToRelative(0.541f, 0f, 0.937f, 0.375f)
                    reflectiveQuadToRelative(0.396f, 0.916f)
                    verticalLineToRelative(8.375f)
                    quadToRelative(0f, 0.584f, -0.396f, 0.938f)
                    reflectiveQuadToRelative(-0.937f, 0.354f)
                    horizontalLineToRelative(-2f)
                    verticalLineToRelative(7.333f)
                    quadToRelative(0f, 0.542f, -0.396f, 0.917f)
                    reflectiveQuadToRelative(-0.938f, 0.375f)
                    close()
                    moveToRelative(-2f, -11.25f)
                    horizontalLineToRelative(4f)
                    verticalLineToRelative(-5.708f)
                    horizontalLineToRelative(-4f)
                    close()
                    moveToRelative(-11.916f, -2f)
                    close()
                    moveToRelative(13.916f, -0.833f)
                    close()
                }
            }.build()
        }
    }

    @Composable
    private fun rememberIndexesTable(): ImageVector {
        return remember {
            ImageVector.Builder(
                name = "stacked_line_chart",
                defaultWidth = 40.0.dp,
                defaultHeight = 40.0.dp,
                viewportWidth = 40.0f,
                viewportHeight = 40.0f
            ).apply {
                path(
                    fill = SolidColor(Color.Black),
                    fillAlpha = 1f,
                    stroke = null,
                    strokeAlpha = 1f,
                    strokeLineWidth = 1.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(16.125f, 25.75f)
                    lineToRelative(-9.292f, 9.333f)
                    quadToRelative(-0.416f, 0.417f, -1f, 0.417f)
                    quadToRelative(-0.583f, 0f, -1f, -0.417f)
                    quadToRelative(-0.416f, -0.416f, -0.416f, -1f)
                    quadToRelative(0f, -0.583f, 0.416f, -1f)
                    lineToRelative(10.375f, -10.416f)
                    quadToRelative(0.417f, -0.375f, 0.938f, -0.375f)
                    quadToRelative(0.521f, 0f, 0.896f, 0.375f)
                    lineToRelative(5.666f, 5.708f)
                    lineToRelative(11.25f, -12.583f)
                    quadToRelative(0.334f, -0.417f, 0.896f, -0.438f)
                    quadToRelative(0.563f, -0.021f, 0.938f, 0.354f)
                    reflectiveQuadToRelative(0.396f, 0.896f)
                    quadToRelative(0.02f, 0.521f, -0.355f, 0.896f)
                    lineTo(23.625f, 31.292f)
                    quadToRelative(-0.333f, 0.458f, -0.917f, 0.479f)
                    quadToRelative(-0.583f, 0.021f, -1f, -0.396f)
                    close()
                    moveToRelative(0f, -10.792f)
                    lineTo(6.833f, 24.25f)
                    quadToRelative(-0.416f, 0.417f, -1f, 0.417f)
                    quadToRelative(-0.583f, 0f, -1f, -0.417f)
                    quadToRelative(-0.416f, -0.417f, -0.416f, -0.979f)
                    quadToRelative(0f, -0.563f, 0.416f, -1.021f)
                    lineToRelative(10.375f, -10.375f)
                    quadToRelative(0.417f, -0.375f, 0.938f, -0.375f)
                    quadToRelative(0.521f, 0f, 0.896f, 0.375f)
                    lineToRelative(5.666f, 5.667f)
                    lineTo(33.958f, 5f)
                    quadToRelative(0.334f, -0.417f, 0.896f, -0.458f)
                    quadToRelative(0.563f, -0.042f, 0.938f, 0.375f)
                    quadToRelative(0.375f, 0.375f, 0.396f, 0.896f)
                    quadToRelative(0.02f, 0.52f, -0.355f, 0.895f)
                    lineTo(23.625f, 20.5f)
                    quadToRelative(-0.333f, 0.417f, -0.917f, 0.438f)
                    quadToRelative(-0.583f, 0.02f, -1f, -0.396f)
                    close()
                }
            }.build()
        }
    }

    @Composable
    private fun rememberDelete(): ImageVector {
        return remember {
            ImageVector.Builder(
                name = "delete",
                defaultWidth = 40.0.dp,
                defaultHeight = 40.0.dp,
                viewportWidth = 40.0f,
                viewportHeight = 40.0f
            ).apply {
                path(
                    fill = SolidColor(Color.Black),
                    fillAlpha = 1f,
                    stroke = null,
                    strokeAlpha = 1f,
                    strokeLineWidth = 1.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(11.208f, 34.708f)
                    quadToRelative(-1.041f, 0f, -1.833f, -0.77f)
                    quadToRelative(-0.792f, -0.771f, -0.792f, -1.855f)
                    verticalLineTo(9.25f)
                    horizontalLineTo(8.25f)
                    quadToRelative(-0.583f, 0f, -0.958f, -0.396f)
                    reflectiveQuadToRelative(-0.375f, -0.937f)
                    quadToRelative(0f, -0.542f, 0.375f, -0.917f)
                    reflectiveQuadToRelative(0.958f, -0.375f)
                    horizontalLineToRelative(6.458f)
                    quadToRelative(0f, -0.583f, 0.375f, -0.958f)
                    reflectiveQuadToRelative(0.959f, -0.375f)
                    horizontalLineTo(24f)
                    quadToRelative(0.583f, 0f, 0.938f, 0.375f)
                    quadToRelative(0.354f, 0.375f, 0.354f, 0.958f)
                    horizontalLineToRelative(6.5f)
                    quadToRelative(0.541f, 0f, 0.937f, 0.375f)
                    reflectiveQuadToRelative(0.396f, 0.917f)
                    quadToRelative(0f, 0.583f, -0.396f, 0.958f)
                    reflectiveQuadToRelative(-0.937f, 0.375f)
                    horizontalLineToRelative(-0.334f)
                    verticalLineToRelative(22.833f)
                    quadToRelative(0f, 1.084f, -0.791f, 1.855f)
                    quadToRelative(-0.792f, 0.77f, -1.875f, 0.77f)
                    close()
                    moveToRelative(0f, -25.458f)
                    verticalLineToRelative(22.833f)
                    horizontalLineToRelative(17.584f)
                    verticalLineTo(9.25f)
                    close()
                    moveToRelative(4.125f, 18.042f)
                    quadToRelative(0f, 0.583f, 0.396f, 0.958f)
                    reflectiveQuadToRelative(0.938f, 0.375f)
                    quadToRelative(0.541f, 0f, 0.916f, -0.375f)
                    reflectiveQuadToRelative(0.375f, -0.958f)
                    verticalLineTo(14f)
                    quadToRelative(0f, -0.542f, -0.375f, -0.937f)
                    quadToRelative(-0.375f, -0.396f, -0.916f, -0.396f)
                    quadToRelative(-0.584f, 0f, -0.959f, 0.396f)
                    quadToRelative(-0.375f, 0.395f, -0.375f, 0.937f)
                    close()
                    moveToRelative(6.709f, 0f)
                    quadToRelative(0f, 0.583f, 0.396f, 0.958f)
                    quadToRelative(0.395f, 0.375f, 0.937f, 0.375f)
                    reflectiveQuadToRelative(0.937f, -0.375f)
                    quadToRelative(0.396f, -0.375f, 0.396f, -0.958f)
                    verticalLineTo(14f)
                    quadToRelative(0f, -0.542f, -0.396f, -0.937f)
                    quadToRelative(-0.395f, -0.396f, -0.937f, -0.396f)
                    reflectiveQuadToRelative(-0.937f, 0.396f)
                    quadToRelative(-0.396f, 0.395f, -0.396f, 0.937f)
                    close()
                    moveTo(11.208f, 9.25f)
                    verticalLineToRelative(22.833f)
                    verticalLineTo(9.25f)
                    close()
                }
            }.build()
        }
    }

    @Composable
    private fun rememberDateRange(): ImageVector {
        return remember {
            ImageVector.Builder(
                name = "DateRangeFill0Wght400Grad0Opsz24",
                defaultWidth = 40.0.dp,
                defaultHeight = 40.0.dp,
                viewportWidth = 960.0f,
                viewportHeight = 960.0f
            ).apply {
                path(
                    fill = SolidColor(Color(0xFF000000)),
                    stroke = null,
                    strokeLineWidth = 0.0f,
                    strokeLineCap = Butt,
                    strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(320.0f, 560.0f)
                    quadToRelative(-17.0f, 0.0f, -28.5f, -11.5f)
                    reflectiveQuadTo(280.0f, 520.0f)
                    quadToRelative(0.0f, -17.0f, 11.5f, -28.5f)
                    reflectiveQuadTo(320.0f, 480.0f)
                    quadToRelative(17.0f, 0.0f, 28.5f, 11.5f)
                    reflectiveQuadTo(360.0f, 520.0f)
                    quadToRelative(0.0f, 17.0f, -11.5f, 28.5f)
                    reflectiveQuadTo(320.0f, 560.0f)
                    close()
                    moveTo(480.0f, 560.0f)
                    quadToRelative(-17.0f, 0.0f, -28.5f, -11.5f)
                    reflectiveQuadTo(440.0f, 520.0f)
                    quadToRelative(0.0f, -17.0f, 11.5f, -28.5f)
                    reflectiveQuadTo(480.0f, 480.0f)
                    quadToRelative(17.0f, 0.0f, 28.5f, 11.5f)
                    reflectiveQuadTo(520.0f, 520.0f)
                    quadToRelative(0.0f, 17.0f, -11.5f, 28.5f)
                    reflectiveQuadTo(480.0f, 560.0f)
                    close()
                    moveTo(640.0f, 560.0f)
                    quadToRelative(-17.0f, 0.0f, -28.5f, -11.5f)
                    reflectiveQuadTo(600.0f, 520.0f)
                    quadToRelative(0.0f, -17.0f, 11.5f, -28.5f)
                    reflectiveQuadTo(640.0f, 480.0f)
                    quadToRelative(17.0f, 0.0f, 28.5f, 11.5f)
                    reflectiveQuadTo(680.0f, 520.0f)
                    quadToRelative(0.0f, 17.0f, -11.5f, 28.5f)
                    reflectiveQuadTo(640.0f, 560.0f)
                    close()
                    moveTo(200.0f, 880.0f)
                    quadToRelative(-33.0f, 0.0f, -56.5f, -23.5f)
                    reflectiveQuadTo(120.0f, 800.0f)
                    verticalLineToRelative(-560.0f)
                    quadToRelative(0.0f, -33.0f, 23.5f, -56.5f)
                    reflectiveQuadTo(200.0f, 160.0f)
                    horizontalLineToRelative(40.0f)
                    verticalLineToRelative(-40.0f)
                    quadToRelative(0.0f, -17.0f, 11.5f, -28.5f)
                    reflectiveQuadTo(280.0f, 80.0f)
                    quadToRelative(17.0f, 0.0f, 28.5f, 11.5f)
                    reflectiveQuadTo(320.0f, 120.0f)
                    verticalLineToRelative(40.0f)
                    horizontalLineToRelative(320.0f)
                    verticalLineToRelative(-40.0f)
                    quadToRelative(0.0f, -17.0f, 11.5f, -28.5f)
                    reflectiveQuadTo(680.0f, 80.0f)
                    quadToRelative(17.0f, 0.0f, 28.5f, 11.5f)
                    reflectiveQuadTo(720.0f, 120.0f)
                    verticalLineToRelative(40.0f)
                    horizontalLineToRelative(40.0f)
                    quadToRelative(33.0f, 0.0f, 56.5f, 23.5f)
                    reflectiveQuadTo(840.0f, 240.0f)
                    verticalLineToRelative(560.0f)
                    quadToRelative(0.0f, 33.0f, -23.5f, 56.5f)
                    reflectiveQuadTo(760.0f, 880.0f)
                    lineTo(200.0f, 880.0f)
                    close()
                    moveTo(200.0f, 800.0f)
                    horizontalLineToRelative(560.0f)
                    verticalLineToRelative(-400.0f)
                    lineTo(200.0f, 400.0f)
                    verticalLineToRelative(400.0f)
                    close()
                    moveTo(200.0f, 320.0f)
                    horizontalLineToRelative(560.0f)
                    verticalLineToRelative(-80.0f)
                    lineTo(200.0f, 240.0f)
                    verticalLineToRelative(80.0f)
                    close()
                    moveTo(200.0f, 320.0f)
                    verticalLineToRelative(-80.0f)
                    verticalLineToRelative(80.0f)
                    close()
                }
            }.build()
        }
    }

    @Composable
    private fun rememberTrendingUp(): ImageVector {
        return remember {
            ImageVector.Builder(
                name = "TrendingUpFill0Wght400Grad0Opsz24",
                defaultWidth = 40.0.dp,
                defaultHeight = 40.0.dp,
                viewportWidth = 960.0f,
                viewportHeight = 960.0f
            ).apply {
                path(
                    fill = SolidColor(Color(0xFF000000)),
                    stroke = null,
                    strokeLineWidth = 0.0f,
                    strokeLineCap = Butt,
                    strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(108.0f, 705.0f)
                    quadToRelative(-12.0f, -12.0f, -11.5f, -28.5f)
                    reflectiveQuadTo(108.0f, 649.0f)
                    lineToRelative(211.0f, -214.0f)
                    quadToRelative(23.0f, -23.0f, 57.0f, -23.0f)
                    reflectiveQuadToRelative(57.0f, 23.0f)
                    lineToRelative(103.0f, 104.0f)
                    lineToRelative(208.0f, -206.0f)
                    horizontalLineToRelative(-64.0f)
                    quadToRelative(-17.0f, 0.0f, -28.5f, -11.5f)
                    reflectiveQuadTo(640.0f, 293.0f)
                    quadToRelative(0.0f, -17.0f, 11.5f, -28.5f)
                    reflectiveQuadTo(680.0f, 253.0f)
                    horizontalLineToRelative(160.0f)
                    quadToRelative(17.0f, 0.0f, 28.5f, 11.5f)
                    reflectiveQuadTo(880.0f, 293.0f)
                    verticalLineToRelative(160.0f)
                    quadToRelative(0.0f, 17.0f, -11.5f, 28.5f)
                    reflectiveQuadTo(840.0f, 493.0f)
                    quadToRelative(-17.0f, 0.0f, -28.5f, -11.5f)
                    reflectiveQuadTo(800.0f, 453.0f)
                    verticalLineToRelative(-64.0f)
                    lineTo(593.0f, 596.0f)
                    quadToRelative(-23.0f, 23.0f, -57.0f, 23.0f)
                    reflectiveQuadToRelative(-57.0f, -23.0f)
                    lineTo(376.0f, 493.0f)
                    lineTo(164.0f, 705.0f)
                    quadToRelative(-11.0f, 11.0f, -28.0f, 11.0f)
                    reflectiveQuadToRelative(-28.0f, -11.0f)
                    close()
                }
            }.build()
        }
    }

    @Composable
    private fun rememberCalendarMonth(): ImageVector {
        return remember {
            ImageVector.Builder(
                name = "CalendarMonthFill0Wght400Grad0Opsz24",
                defaultWidth = 24.0.dp,
                defaultHeight = 24.0.dp,
                viewportWidth = 960.0f,
                viewportHeight = 960.0f
            ).apply {
                path(
                    fill = SolidColor(Color(0xFF000000)),
                    stroke = null,
                    strokeLineWidth = 0.0f,
                    strokeLineCap = Butt,
                    strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(200.0f, 880.0f)
                    quadToRelative(-33.0f, 0.0f, -56.5f, -23.5f)
                    reflectiveQuadTo(120.0f, 800.0f)
                    verticalLineToRelative(-560.0f)
                    quadToRelative(0.0f, -33.0f, 23.5f, -56.5f)
                    reflectiveQuadTo(200.0f, 160.0f)
                    horizontalLineToRelative(40.0f)
                    verticalLineToRelative(-40.0f)
                    quadToRelative(0.0f, -17.0f, 11.5f, -28.5f)
                    reflectiveQuadTo(280.0f, 80.0f)
                    quadToRelative(17.0f, 0.0f, 28.5f, 11.5f)
                    reflectiveQuadTo(320.0f, 120.0f)
                    verticalLineToRelative(40.0f)
                    horizontalLineToRelative(320.0f)
                    verticalLineToRelative(-40.0f)
                    quadToRelative(0.0f, -17.0f, 11.5f, -28.5f)
                    reflectiveQuadTo(680.0f, 80.0f)
                    quadToRelative(17.0f, 0.0f, 28.5f, 11.5f)
                    reflectiveQuadTo(720.0f, 120.0f)
                    verticalLineToRelative(40.0f)
                    horizontalLineToRelative(40.0f)
                    quadToRelative(33.0f, 0.0f, 56.5f, 23.5f)
                    reflectiveQuadTo(840.0f, 240.0f)
                    verticalLineToRelative(560.0f)
                    quadToRelative(0.0f, 33.0f, -23.5f, 56.5f)
                    reflectiveQuadTo(760.0f, 880.0f)
                    lineTo(200.0f, 880.0f)
                    close()
                    moveTo(200.0f, 800.0f)
                    horizontalLineToRelative(560.0f)
                    verticalLineToRelative(-400.0f)
                    lineTo(200.0f, 400.0f)
                    verticalLineToRelative(400.0f)
                    close()
                    moveTo(200.0f, 320.0f)
                    horizontalLineToRelative(560.0f)
                    verticalLineToRelative(-80.0f)
                    lineTo(200.0f, 240.0f)
                    verticalLineToRelative(80.0f)
                    close()
                    moveTo(200.0f, 320.0f)
                    verticalLineToRelative(-80.0f)
                    verticalLineToRelative(80.0f)
                    close()
                    moveTo(480.0f, 560.0f)
                    quadToRelative(-17.0f, 0.0f, -28.5f, -11.5f)
                    reflectiveQuadTo(440.0f, 520.0f)
                    quadToRelative(0.0f, -17.0f, 11.5f, -28.5f)
                    reflectiveQuadTo(480.0f, 480.0f)
                    quadToRelative(17.0f, 0.0f, 28.5f, 11.5f)
                    reflectiveQuadTo(520.0f, 520.0f)
                    quadToRelative(0.0f, 17.0f, -11.5f, 28.5f)
                    reflectiveQuadTo(480.0f, 560.0f)
                    close()
                    moveTo(320.0f, 560.0f)
                    quadToRelative(-17.0f, 0.0f, -28.5f, -11.5f)
                    reflectiveQuadTo(280.0f, 520.0f)
                    quadToRelative(0.0f, -17.0f, 11.5f, -28.5f)
                    reflectiveQuadTo(320.0f, 480.0f)
                    quadToRelative(17.0f, 0.0f, 28.5f, 11.5f)
                    reflectiveQuadTo(360.0f, 520.0f)
                    quadToRelative(0.0f, 17.0f, -11.5f, 28.5f)
                    reflectiveQuadTo(320.0f, 560.0f)
                    close()
                    moveTo(640.0f, 560.0f)
                    quadToRelative(-17.0f, 0.0f, -28.5f, -11.5f)
                    reflectiveQuadTo(600.0f, 520.0f)
                    quadToRelative(0.0f, -17.0f, 11.5f, -28.5f)
                    reflectiveQuadTo(640.0f, 480.0f)
                    quadToRelative(17.0f, 0.0f, 28.5f, 11.5f)
                    reflectiveQuadTo(680.0f, 520.0f)
                    quadToRelative(0.0f, 17.0f, -11.5f, 28.5f)
                    reflectiveQuadTo(640.0f, 560.0f)
                    close()
                    moveTo(480.0f, 720.0f)
                    quadToRelative(-17.0f, 0.0f, -28.5f, -11.5f)
                    reflectiveQuadTo(440.0f, 680.0f)
                    quadToRelative(0.0f, -17.0f, 11.5f, -28.5f)
                    reflectiveQuadTo(480.0f, 640.0f)
                    quadToRelative(17.0f, 0.0f, 28.5f, 11.5f)
                    reflectiveQuadTo(520.0f, 680.0f)
                    quadToRelative(0.0f, 17.0f, -11.5f, 28.5f)
                    reflectiveQuadTo(480.0f, 720.0f)
                    close()
                    moveTo(320.0f, 720.0f)
                    quadToRelative(-17.0f, 0.0f, -28.5f, -11.5f)
                    reflectiveQuadTo(280.0f, 680.0f)
                    quadToRelative(0.0f, -17.0f, 11.5f, -28.5f)
                    reflectiveQuadTo(320.0f, 640.0f)
                    quadToRelative(17.0f, 0.0f, 28.5f, 11.5f)
                    reflectiveQuadTo(360.0f, 680.0f)
                    quadToRelative(0.0f, 17.0f, -11.5f, 28.5f)
                    reflectiveQuadTo(320.0f, 720.0f)
                    close()
                    moveTo(640.0f, 720.0f)
                    quadToRelative(-17.0f, 0.0f, -28.5f, -11.5f)
                    reflectiveQuadTo(600.0f, 680.0f)
                    quadToRelative(0.0f, -17.0f, 11.5f, -28.5f)
                    reflectiveQuadTo(640.0f, 640.0f)
                    quadToRelative(17.0f, 0.0f, 28.5f, 11.5f)
                    reflectiveQuadTo(680.0f, 680.0f)
                    quadToRelative(0.0f, 17.0f, -11.5f, 28.5f)
                    reflectiveQuadTo(640.0f, 720.0f)
                    close()
                }
            }.build()
        }
    }

    @Composable
    private fun rememberPayments(): ImageVector {
        return remember {
            ImageVector.Builder(
                name = "PaymentsFill0Wght400Grad0Opsz24",
                defaultWidth = 40.0.dp,
                defaultHeight = 40.0.dp,
                viewportWidth = 960.0f,
                viewportHeight = 960.0f
            ).apply {
                path(
                    fill = SolidColor(Color(0xFF000000)),
                    stroke = null,
                    strokeLineWidth = 0.0f,
                    strokeLineCap = Butt,
                    strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(560.0f, 520.0f)
                    quadToRelative(-50.0f, 0.0f, -85.0f, -35.0f)
                    reflectiveQuadToRelative(-35.0f, -85.0f)
                    quadToRelative(0.0f, -50.0f, 35.0f, -85.0f)
                    reflectiveQuadToRelative(85.0f, -35.0f)
                    quadToRelative(50.0f, 0.0f, 85.0f, 35.0f)
                    reflectiveQuadToRelative(35.0f, 85.0f)
                    quadToRelative(0.0f, 50.0f, -35.0f, 85.0f)
                    reflectiveQuadToRelative(-85.0f, 35.0f)
                    close()
                    moveTo(280.0f, 640.0f)
                    quadToRelative(-33.0f, 0.0f, -56.5f, -23.5f)
                    reflectiveQuadTo(200.0f, 560.0f)
                    verticalLineToRelative(-320.0f)
                    quadToRelative(0.0f, -33.0f, 23.5f, -56.5f)
                    reflectiveQuadTo(280.0f, 160.0f)
                    horizontalLineToRelative(560.0f)
                    quadToRelative(33.0f, 0.0f, 56.5f, 23.5f)
                    reflectiveQuadTo(920.0f, 240.0f)
                    verticalLineToRelative(320.0f)
                    quadToRelative(0.0f, 33.0f, -23.5f, 56.5f)
                    reflectiveQuadTo(840.0f, 640.0f)
                    lineTo(280.0f, 640.0f)
                    close()
                    moveTo(360.0f, 560.0f)
                    horizontalLineToRelative(400.0f)
                    quadToRelative(0.0f, -33.0f, 23.5f, -56.5f)
                    reflectiveQuadTo(840.0f, 480.0f)
                    verticalLineToRelative(-160.0f)
                    quadToRelative(-33.0f, 0.0f, -56.5f, -23.5f)
                    reflectiveQuadTo(760.0f, 240.0f)
                    lineTo(360.0f, 240.0f)
                    quadToRelative(0.0f, 33.0f, -23.5f, 56.5f)
                    reflectiveQuadTo(280.0f, 320.0f)
                    verticalLineToRelative(160.0f)
                    quadToRelative(33.0f, 0.0f, 56.5f, 23.5f)
                    reflectiveQuadTo(360.0f, 560.0f)
                    close()
                    moveTo(760.0f, 800.0f)
                    lineTo(120.0f, 800.0f)
                    quadToRelative(-33.0f, 0.0f, -56.5f, -23.5f)
                    reflectiveQuadTo(40.0f, 720.0f)
                    verticalLineToRelative(-400.0f)
                    quadToRelative(0.0f, -17.0f, 11.5f, -28.5f)
                    reflectiveQuadTo(80.0f, 280.0f)
                    quadToRelative(17.0f, 0.0f, 28.5f, 11.5f)
                    reflectiveQuadTo(120.0f, 320.0f)
                    verticalLineToRelative(400.0f)
                    horizontalLineToRelative(640.0f)
                    quadToRelative(17.0f, 0.0f, 28.5f, 11.5f)
                    reflectiveQuadTo(800.0f, 760.0f)
                    quadToRelative(0.0f, 17.0f, -11.5f, 28.5f)
                    reflectiveQuadTo(760.0f, 800.0f)
                    close()
                    moveTo(280.0f, 560.0f)
                    verticalLineToRelative(-320.0f)
                    verticalLineToRelative(320.0f)
                    close()
                }
            }.build()
        }
    }

    @Composable
    private fun rememberChart(): ImageVector {
        return remember {
            ImageVector.Builder(
                name = "InsertChartFill0Wght400Grad0Opsz24",
                defaultWidth = 24.0.dp,
                defaultHeight = 24.0.dp,
                viewportWidth = 960.0f,
                viewportHeight = 960.0f
            ).apply {
                path(
                    fill = SolidColor(Color(0xFF000000)),
                    stroke = null,
                    strokeLineWidth = 0.0f,
                    strokeLineCap = Butt,
                    strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(280.0f, 680.0f)
                    horizontalLineToRelative(80.0f)
                    verticalLineToRelative(-280.0f)
                    horizontalLineToRelative(-80.0f)
                    verticalLineToRelative(280.0f)
                    close()
                    moveTo(440.0f, 680.0f)
                    horizontalLineToRelative(80.0f)
                    verticalLineToRelative(-400.0f)
                    horizontalLineToRelative(-80.0f)
                    verticalLineToRelative(400.0f)
                    close()
                    moveTo(600.0f, 680.0f)
                    horizontalLineToRelative(80.0f)
                    verticalLineToRelative(-160.0f)
                    horizontalLineToRelative(-80.0f)
                    verticalLineToRelative(160.0f)
                    close()
                    moveTo(200.0f, 840.0f)
                    quadToRelative(-33.0f, 0.0f, -56.5f, -23.5f)
                    reflectiveQuadTo(120.0f, 760.0f)
                    verticalLineToRelative(-560.0f)
                    quadToRelative(0.0f, -33.0f, 23.5f, -56.5f)
                    reflectiveQuadTo(200.0f, 120.0f)
                    horizontalLineToRelative(560.0f)
                    quadToRelative(33.0f, 0.0f, 56.5f, 23.5f)
                    reflectiveQuadTo(840.0f, 200.0f)
                    verticalLineToRelative(560.0f)
                    quadToRelative(0.0f, 33.0f, -23.5f, 56.5f)
                    reflectiveQuadTo(760.0f, 840.0f)
                    lineTo(200.0f, 840.0f)
                    close()
                    moveTo(200.0f, 760.0f)
                    horizontalLineToRelative(560.0f)
                    verticalLineToRelative(-560.0f)
                    lineTo(200.0f, 200.0f)
                    verticalLineToRelative(560.0f)
                    close()
                    moveTo(200.0f, 200.0f)
                    verticalLineToRelative(560.0f)
                    verticalLineToRelative(-560.0f)
                    close()
                }
            }.build()
        }
    }


    @Composable
    private fun rememberPermissionNeeded(): ImageVector {
        return remember {
            ImageVector.Builder(
                name = "gpp_maybe",
                defaultWidth = 40.0.dp,
                defaultHeight = 40.0.dp,
                viewportWidth = 40.0f,
                viewportHeight = 40.0f
            ).apply {
                path(
                    fill = SolidColor(Color.Black),
                    fillAlpha = 1f,
                    stroke = null,
                    strokeAlpha = 1f,
                    strokeLineWidth = 1.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(20f, 20.5f)
                    quadToRelative(0.583f, 0f, 1f, -0.396f)
                    quadToRelative(0.417f, -0.396f, 0.417f, -0.979f)
                    verticalLineTo(13.25f)
                    quadToRelative(0f, -0.542f, -0.417f, -0.937f)
                    quadToRelative(-0.417f, -0.396f, -1f, -0.396f)
                    reflectiveQuadToRelative(-0.979f, 0.396f)
                    quadToRelative(-0.396f, 0.395f, -0.396f, 0.937f)
                    verticalLineToRelative(5.875f)
                    quadToRelative(0f, 0.583f, 0.396f, 0.979f)
                    reflectiveQuadTo(20f, 20.5f)
                    close()
                    moveToRelative(0f, 5.792f)
                    quadToRelative(0.667f, 0f, 1.125f, -0.438f)
                    quadToRelative(0.458f, -0.437f, 0.458f, -1.146f)
                    quadToRelative(0f, -0.666f, -0.437f, -1.125f)
                    quadToRelative(-0.438f, -0.458f, -1.146f, -0.458f)
                    quadToRelative(-0.667f, 0f, -1.125f, 0.458f)
                    quadToRelative(-0.458f, 0.459f, -0.458f, 1.125f)
                    quadToRelative(0f, 0.667f, 0.437f, 1.125f)
                    quadToRelative(0.438f, 0.459f, 1.146f, 0.459f)
                    close()
                    moveToRelative(0f, 10.25f)
                    quadToRelative(-0.208f, 0f, -0.396f, -0.042f)
                    quadToRelative(-0.187f, -0.042f, -0.312f, -0.083f)
                    quadToRelative(-5.584f, -1.667f, -9.125f, -6.813f)
                    quadToRelative(-3.542f, -5.146f, -3.542f, -11.312f)
                    verticalLineToRelative(-7.875f)
                    quadToRelative(0f, -0.959f, 0.542f, -1.75f)
                    quadToRelative(0.541f, -0.792f, 1.416f, -1.125f)
                    lineToRelative(10.375f, -3.875f)
                    quadTo(19.458f, 3.5f, 20f, 3.5f)
                    reflectiveQuadToRelative(1.083f, 0.167f)
                    lineToRelative(10.334f, 3.875f)
                    quadToRelative(0.875f, 0.333f, 1.416f, 1.125f)
                    quadToRelative(0.542f, 0.791f, 0.542f, 1.75f)
                    verticalLineToRelative(7.875f)
                    quadToRelative(0f, 6.166f, -3.542f, 11.312f)
                    quadToRelative(-3.541f, 5.146f, -9.125f, 6.813f)
                    quadToRelative(0.042f, 0f, -0.708f, 0.125f)
                    close()
                    moveToRelative(0f, -3f)
                    quadToRelative(4.542f, -1.584f, 7.438f, -5.792f)
                    quadToRelative(2.895f, -4.208f, 2.895f, -9.458f)
                    verticalLineToRelative(-7.875f)
                    lineTo(20f, 6.5f)
                    lineTo(9.667f, 10.417f)
                    verticalLineToRelative(7.875f)
                    quadToRelative(0f, 5.25f, 2.895f, 9.458f)
                    quadToRelative(2.896f, 4.208f, 7.438f, 5.792f)
                    close()
                    moveTo(20f, 20f)
                    close()
                }
            }.build()
        }
    }
}