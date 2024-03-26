package ir.saltech.answersheet.ui.test

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ir.saltech.answersheet.ui.theme.AnswerSheetTheme
import ir.saltech.answersheet.ui.view.Launcher

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AnswerSheetTheme {
        Launcher()
    }
}
