package ir.saltech.answersheet.ui.preview

import android.content.res.Configuration
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.saltech.answersheet.App
import ir.saltech.answersheet.ui.theme.AnswerSheetTheme
import ir.saltech.answersheet.ui.view.Launcher
import ir.saltech.answersheet.ui.view.SettingsView

@Preview(showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun LauncherPreview() {
    AnswerSheetTheme {
        Launcher()
    }
}
