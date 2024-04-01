package ir.saltech.answersheet.ui.view

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.saltech.answersheet.App
import ir.saltech.answersheet.ui.theme.AnswerSheetTheme

@Composable
fun NewExamPage(padding: PaddingValues = PaddingValues(0.dp)) {
    LockedDirection {
        Column (
            modifier = Modifier.fillMaxSize().padding(padding)
        ) {
            TitleBar(modifier = Modifier.padding(top = 16.dp), title = "آزمون جدید", showBack = true)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewExamPagePreview() {
    AnswerSheetTheme {
        NewExamPage()
    }
}
