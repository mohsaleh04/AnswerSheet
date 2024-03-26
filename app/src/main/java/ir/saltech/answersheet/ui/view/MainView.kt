package ir.saltech.answersheet.ui.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ir.saltech.answersheet.App
import ir.saltech.answersheet.R
import ir.saltech.answersheet.viewmodels.MainViewModel


@Composable
fun Launcher(modifier: Modifier = Modifier, mainViewModel: MainViewModel = viewModel()) {
    mainViewModel.context = LocalContext.current
    val tradeUiState by mainViewModel.uiState.collectAsState()
    setupBackFunction(tradeUiState.page, mainViewModel) {
        mainViewModel.page = it
    }
    Box(modifier = modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.fillMaxHeight(fraction = 0.2f))
            TitleBar(tradeUiState.page, stringResource(id = R.string.app_name))
            Spacer(modifier = Modifier.height(16.dp))
            PagesView(tradeUiState.page, mainViewModel) { p ->
//                if (u != null) {
//                    user = u
//                    mainViewModel.saveUser(u)
//                }
                mainViewModel.page = p
            }
        }
    }
}

@Composable
fun PagesView(
    page: App.Page,
    mainViewModel: MainViewModel,
    onPageChanged: (App.Page) -> Unit
) {
    MainUiPages(
        page = page,
        mainViewModel = mainViewModel,
        onPageChanged = onPageChanged
    )
}

@Composable
fun MainUiPages(
    page: App.Page,
    mainViewModel: MainViewModel,
    onPageChanged: (App.Page) -> Unit
) {
//    AnimatedVisibility(visible = page == App.Page.Login || user.accessToken == null) {
//        LoginLayout(mainViewModel = mainViewModel, user = user) {
//            onPageChanged(App.Page.Menu, it)
//        }
//    }
}


fun setupBackFunction(
    page: App.Page, mainViewModel: MainViewModel, onPageChanged: (App.Page) -> Unit
) {
    mainViewModel.backPressedListener = object : MainViewModel.OnBackPressedListener {
        override fun onBackPressed(): Boolean {
//            if (page == App.Page.Menu ||
//                page == App.Page.Login
//            ) {
//                return true
//            } else {
//                when (page) {
//                    App.Page.AccountSettings, App.Page.ShowReports, App.Page.ResetPassword, App.Page.Logout -> {
//                        mainViewModel.reportChart = null
//                        onPageChanged(App.Page.Menu)
//                    }
//
//                    App.Page.EditIndexes, App.Page.EditAverage, App.Page.DeleteIndex -> {
//                        onPageChanged(App.Page.AccountSettings)
//                    }
//
//                    App.Page.TrendingUp, App.Page.DateRange, App.Page.Chart -> {
//                        onPageChanged(App.Page.ShowReports)
//                    }
//
//                    else -> TODO()
//                }
//                return false
//            }
            return true
        }
    }
}

