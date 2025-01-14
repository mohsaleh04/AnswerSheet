package ir.saltech.answersheet.utils

import android.content.Context
import android.net.Uri
import android.provider.DocumentsContract
import android.provider.MediaStore
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import com.google.gson.Gson
import com.valentinilk.shimmer.shimmer
import java.util.GregorianCalendar
import kotlin.math.pow


operator fun Int.div(dp: Dp): Float {
    return this / dp.value
}

operator fun Float.minus(dp: Dp): Float {
    return this - dp.value
}

infix operator fun Long.div(l: Long): Float {
    return (this.toDouble() / l.toDouble()).toFloat()
}

inline fun <reified T> fromJson(json: String): T? {
    return Gson().fromJson(json, T::class.java)
}

inline fun <reified T> toJson(t: T): String? {
    return Gson().toJson(t)
}

fun String.asToken(): String {
    return "bearer $this"
}

fun GregorianCalendar.toStringDate(splitter: String = "/"): String {
    return "${get(GregorianCalendar.YEAR)}$splitter${(get(GregorianCalendar.MONTH) + 1).twoDigits()}$splitter${
        get(
            GregorianCalendar.DAY_OF_MONTH
        ).twoDigits()
    }"
}

fun Int.twoDigits(): String {
    return if (this >= 10) {
        "$this"
    } else {
        "0$this"
    }
}

fun <X, Y> Map<X, Y>.getKey(value: Y): X? {
    for ((key, value1) in this) {
        Log.d("TAG", "Value search $value || $value1 || $key")
        if (value1 == value) {
            Log.i("TAG", "Value found! $value || $value1 || $key")
            return key
        }
    }
    return null
}

fun Float.toDp(density: Density): Dp {
    return with(density) { this@toDp.toDp() }
}

infix fun Int.atLeast(i: Int): Boolean {
    return this >= i
}

fun Modifier.fadingEdge(brush: Brush) = this
    .graphicsLayer(compositingStrategy = CompositingStrategy.Offscreen)
    .drawWithContent {
        drawContent()
        drawRect(brush = brush, blendMode = BlendMode.DstIn)
    }

@Composable
fun pixelsToDp(pixels: Int) = with(LocalDensity.current) { pixels.toDp() }

fun checkExamTimeValidation(hour: Int, minute: Int): Boolean {
    return hour in 1..5 || minute in 5..<60
}

fun IntRange.toStringList(): List<String> =
    this.map { it.toString() }

infix fun Int.pow(times: Int): Int {
    return this.toDouble().pow(times.toDouble()).toInt()
}

fun Modifier.shimmerLoader(load: Boolean): Modifier =
    if (load) this.shimmer() else this

