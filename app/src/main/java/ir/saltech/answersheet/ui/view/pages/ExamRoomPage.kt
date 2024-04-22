package ir.saltech.answersheet.ui.view.pages

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ir.saltech.answersheet.App
import ir.saltech.answersheet.R
import ir.saltech.answersheet.ui.theme.AnswerSheetTheme
import ir.saltech.answersheet.ui.view.LockedDirection
import ir.saltech.answersheet.viewmodels.MainViewModel

@Composable
fun ExamRoomPage(mainViewModel: MainViewModel = viewModel()) {
    val answerSheetState by mainViewModel.uiState.collectAsState()
    val scope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }
    Scaffold (
        modifier = Modifier.fillMaxSize(),
        snackbarHost = {
            SnackbarHost(hostState = snackBarHostState)
        },
    ) { padding ->
        Box (modifier = Modifier.padding(padding)) {
            Column (modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = Modifier.height(13.dp))
                Row (modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        /* TODO */
                    }, horizontalArrangement = Arrangement.Center) {
                    Card(modifier = Modifier
                        .width(125.dp)
                        .height(5.dp)) {

                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row (modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp, start = 24.dp, end = 24.dp, top = 5.dp)) {
                    Icon(painter = painterResource(id = R.drawable.finish_exam), contentDescription = "action button")
                    Text(modifier = Modifier.weight(1f), text = "آزمون عربی", textAlign = TextAlign.Center)
                    Icon(painter = painterResource(id = R.drawable.more_items), contentDescription = "show options")
                }
                LockedDirection (LayoutDirection.Rtl) {
                    Text(modifier = Modifier.padding(bottom = 8.dp), text = "آزمون خود را ویرایش کنید.", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.secondary)
                }
                Text(modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState()), text = "saved exams: ${App.getExams(context = LocalContext.current)}\n\nState saved exams: ${answerSheetState.exams}\n\nViewModel saved exams: ${mainViewModel.exams}")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ExamRoomPreview() {
    AnswerSheetTheme {
        ExamRoomPage()
    }
}
