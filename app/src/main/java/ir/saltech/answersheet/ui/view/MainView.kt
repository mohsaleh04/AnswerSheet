package ir.saltech.answersheet.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import ir.saltech.answersheet.App
import ir.saltech.answersheet.dto.ui.MainNavItem
import ir.saltech.answersheet.viewmodels.MainViewModel


@Composable
fun Launcher(mainViewModel: MainViewModel = viewModel()) {
    mainViewModel.context = LocalContext.current
    val tradeUiState by mainViewModel.uiState.collectAsState()
    mainViewModel.setupBackStrategy(tradeUiState.page) { mainViewModel.page = it }
    MainView(tradeUiState.page) { p ->
        mainViewModel.page = p
    }
}

@Composable
fun MainView(
    page: App.Page,
    mainViewModel: MainViewModel = viewModel(),
    onPageChanged: (App.Page) -> Unit
) {
    var selectedMainPage: MainNavItem by remember { mutableStateOf(MainNavItem.ExamRoom) }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            MainBottomNav(selected = selectedMainPage) {
                selectedMainPage = it
            }
        }
    ) {
        Box(modifier = Modifier.padding(it).fillMaxSize().background(MaterialTheme.colorScheme.primary)) {
        }
    }
}
