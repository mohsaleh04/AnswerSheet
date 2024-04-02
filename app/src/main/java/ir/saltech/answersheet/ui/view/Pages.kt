package ir.saltech.answersheet.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.saltech.answersheet.ui.theme.AnswerSheetTheme
import kotlinx.coroutines.delay

@Composable
fun NewExamPage(padding: PaddingValues = PaddingValues(0.dp)) {
    LockedDirection {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            TitleBar(modifier = Modifier.padding(vertical = 16.dp), title = "آزمون جدید", showBack = true)
            Picker(items = (1..10).toStringList())
            AnimatedNumber(number = 123292) {
                Text(text = "$it")
            }
            var count by remember {
                mutableIntStateOf(0)
            }
            LaunchedEffect(count) {
                delay(1000)
                count++
            }
            AnimatedCount(number = count) {
                Text(text = "${it.digitChar}")
            }
        }
    }
}

private fun IntRange.toStringList(): List<String> =
    this.map { it.toString() }

@Preview(showBackground = true)
@Composable
fun NewExamPagePreview() {
    AnswerSheetTheme {
        NewExamPage()
    }
}
