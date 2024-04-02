package ir.saltech.answersheet.ui.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Create
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import ir.saltech.answersheet.App
import ir.saltech.answersheet.R
import ir.saltech.answersheet.dto.models.User
import ir.saltech.answersheet.dto.ui.MainNavItem
import ir.saltech.answersheet.dto.ui.examTypesItems
import ir.saltech.answersheet.viewmodels.MainViewModel


@Composable
fun Launcher(mainViewModel: MainViewModel = viewModel()) {
    mainViewModel.context = LocalContext.current
    val tradeUiState by mainViewModel.uiState.collectAsState()
    mainViewModel.setupBackStrategy(tradeUiState.page) { mainViewModel.page = it }
    AnimatedVisibility(visible = tradeUiState.page == App.Page.Home) {
        MainView(tradeUiState.page) { p ->
            mainViewModel.page = p
        }
    }
    AnimatedVisibility(visible = tradeUiState.page == App.Page.NewExam) {
        Scaffold (modifier = Modifier.fillMaxSize()) {
            NewExamPage(it)
        }
    }
}

@Composable
fun MainView(
    page: App.Page,
    user: User? = null,
    onPageChanged: (App.Page) -> Unit
) {
    var selectedMainPage: MainNavItem by remember { mutableStateOf(MainNavItem.ExamRoom) }
    Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = {
        MainBottomNav(selected = selectedMainPage) {
            selectedMainPage = it
        }
    }) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            AnimatedVisibility(
                modifier = Modifier.fillMaxSize(),
                visible = selectedMainPage == MainNavItem.ExamRoom,
                enter = slideInHorizontally(initialOffsetX = { x -> x }),
                exit = slideOutHorizontally(targetOffsetX = { x -> -x })
            ) {
                ExamsNavView(it, page, onPageChanged)
            }
            AnimatedVisibility(
                modifier = Modifier.fillMaxSize(),
                visible = selectedMainPage == MainNavItem.StudyRoom,
                enter = slideInHorizontally(initialOffsetX = { x -> x }),
                exit = slideOutHorizontally(targetOffsetX = { x -> -x })
            ) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(
                        "در دست ساخت ...", style = MaterialTheme.typography.displayMedium.copy(
                            textDirection = TextDirection.Rtl,
                            color = MaterialTheme.colorScheme.secondary
                        )
                    )
                }
            }
            AnimatedVisibility(
                modifier = Modifier.fillMaxSize(),
                visible = selectedMainPage == MainNavItem.Settings,
                enter = slideInHorizontally(initialOffsetX = { x -> x }),
                exit = slideOutHorizontally(targetOffsetX = { x -> -x })
            ) {
                SettingsView(it, user, page, onPageChanged)
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SettingsView(
    padding: PaddingValues, user: User?, page: App.Page, onPageChanged: (App.Page) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(padding)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        LockedDirection(LayoutDirection.Rtl) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                if (user != null) {
                    Row(
                        modifier = Modifier.padding(8.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            modifier = Modifier
                                .padding(top = 3.dp, start = 16.dp)
                                .width(60.dp),
                            painter = painterResource(id = R.drawable.account_profile),
                            contentDescription = "Profile Image"
                        )
                        Column(
                            modifier = Modifier
                                .padding(3.dp)
                                .weight(1f),
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                modifier = Modifier
                                    .padding(vertical = 4.dp, horizontal = 8.dp)
                                    .basicMarquee(),
                                text = "محمد صالح مسعودی مقدم",
                                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp),
                                maxLines = 1
                            )
                            Text(
                                modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
                                text = "09138549727",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.secondary
                            )
                        }
                        IconButton(modifier = Modifier
                            .padding(16.dp)
                            .weight(0.3f),
                            onClick = { /* TODO */ }) {
                            Icon(
                                imageVector = Icons.Outlined.Create,
                                contentDescription = "Edit User"
                            )
                        }
                    }
                } else {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 24.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Button(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Outlined.AccountCircle,
                                contentDescription = "Login"
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(text = "ورود به حساب کاربری")
                        }
                    }
                }
            }
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
                    .background(MaterialTheme.colorScheme.surfaceContainer)
            )
            SettingsOption(icon = R.drawable.bookmarks, title = "بوکمارک ها") {

            }
            SettingsOption(
                icon = R.drawable.exam_names, title = "نام آزمون ها", showDivider = false
            ) {

            }
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
                    .background(MaterialTheme.colorScheme.surfaceContainer)
            )
            SettingsOption(
                icon = R.drawable.settings_notifications, title = "اعلان های شروع آزمون"
            ) {

            }
            SettingsOption(icon = R.drawable.settings_wallpaper, title = "پس زمینه صفحه آزمون") {

            }
            SettingsOption(
                icon = R.drawable.settings_effects,
                title = "جلوه های ویژه آزمون",
                showDivider = false
            ) {

            }
            Spacer(modifier = Modifier.padding(top = 6.dp))
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
                    .background(MaterialTheme.colorScheme.surfaceContainer)
            )
            SettingsOption(icon = R.drawable.settings_backup, title = "پشتیبان گیری آزمون") {

            }
            SettingsOption(icon = R.drawable.donate_us, title = "حمایت از ما") {

            }
            SettingsOption(icon = R.drawable.settings_about, title = "درباره ما") {

            }
            SettingsOption(
                icon = R.drawable.settings_help,
                title = "پشتیبانی و سؤالات متداول",
                showDivider = false
            ) {

            }
        }
    }
}

@Composable
fun ExamsNavView(padding: PaddingValues, page: App.Page, onPageChanged: (App.Page) -> Unit) {
    Column(
        modifier = Modifier
            .padding(padding)
            .scrollable(rememberScrollState(), Orientation.Vertical)
    ) {
        TitleBar(modifier = Modifier.padding(16.dp), title = "آزمون ها")

        LazyVerticalStaggeredGrid(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, start = 16.dp, end = 16.dp, bottom = 4.dp),
            columns = StaggeredGridCells.Adaptive(150.dp)
        ) {
            item {
                FilledTonalButton(
                    modifier = Modifier.padding(4.dp),
                    onClick = { onPageChanged(App.Page.NewExam) },
                    colors = ButtonColors(
                        MaterialTheme.colorScheme.tertiaryContainer,
                        MaterialTheme.colorScheme.onTertiaryContainer,
                        MaterialTheme.colorScheme.secondaryContainer,
                        MaterialTheme.colorScheme.onSecondaryContainer
                    )
                ) {
                    Text("آزمون جدید", style = MaterialTheme.typography.bodyMedium)
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.exam_new),
                        contentDescription = "New Exam"
                    )
                }
            }
            item {
                FilledTonalButton(
                    modifier = Modifier.padding(4.dp),
                    onClick = { /*TODO*/ },
                    colors = ButtonColors(
                        MaterialTheme.colorScheme.primaryContainer,
                        MaterialTheme.colorScheme.onPrimaryContainer,
                        MaterialTheme.colorScheme.secondaryContainer,
                        MaterialTheme.colorScheme.onSecondaryContainer
                    )
                ) {
                    Text("جستــجـو", style = MaterialTheme.typography.bodyMedium)
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.exam_search),
                        contentDescription = "Search Exam"
                    )
                }
            }
            item {
                FilledTonalButton(
                    modifier = Modifier.padding(4.dp),
                    enabled = false,
                    onClick = { /*TODO*/ },
                    colors = ButtonColors(
                        MaterialTheme.colorScheme.primaryContainer,
                        MaterialTheme.colorScheme.onPrimaryContainer,
                        MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.4f),
                        MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.4f)
                    )
                ) {
                    Text("آزمون آنلاین", style = MaterialTheme.typography.bodyMedium)
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.exam_online),
                        contentDescription = "Online Exam"
                    )
                }
            }
            item {
                FilledTonalButton(
                    modifier = Modifier.padding(4.dp),
                    onClick = { /*TODO*/ },
                    colors = ButtonColors(
                        colorResource(R.color.favorite_container),
                        colorResource(
                            id = R.color.favorite_on_container
                        ),
                        MaterialTheme.colorScheme.secondaryContainer,
                        MaterialTheme.colorScheme.onSecondaryContainer
                    )
                ) {
                    Text("پسندیده ها", style = MaterialTheme.typography.bodyMedium)
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.exam_favorite),
                        contentDescription = "Favorite Exams"
                    )
                }
            }
        }
        LazyVerticalGrid(
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp)
                .wrapContentHeight(align = Alignment.CenterVertically)
                .fillMaxWidth(),
            columns = GridCells.Adaptive(150.dp),
            horizontalArrangement = Arrangement.Center,
            contentPadding = PaddingValues(
                start = 12.dp, top = 16.dp, end = 12.dp, bottom = 16.dp
            )
        ) {
            items(examTypesItems) { item ->
                ExamNavCard(examTypeItem = item) {
                    /* TODO */
                }
            }
        }
    }
}




