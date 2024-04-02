package ir.saltech.answersheet.ui.view

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import ir.saltech.answersheet.R
import ir.saltech.answersheet.dto.ui.Digit
import ir.saltech.answersheet.dto.ui.ExamTypesItem
import ir.saltech.answersheet.dto.ui.MainNavItem
import ir.saltech.answersheet.dto.ui.compareTo
import ir.saltech.answersheet.dto.ui.navItems
import ir.saltech.answersheet.ui.states.PickerState
import ir.saltech.answersheet.ui.states.rememberPickerState
import ir.saltech.answersheet.ui.theme.Symbols
import ir.saltech.answersheet.utils.fadingEdge
import ir.saltech.answersheet.utils.pixelsToDp
import ir.saltech.answersheet.viewmodels.MainViewModel
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Picker(
    modifier: Modifier = Modifier,
    items: List<String>,
    state: PickerState = rememberPickerState(),
    startIndex: Int = 0,
    visibleItemsCount: Int = 3,
    textModifier: Modifier = Modifier,
    textStyle: TextStyle = LocalTextStyle.current,
) {

    val visibleItemsMiddle = visibleItemsCount / 2
    val listScrollCount = Integer.MAX_VALUE
    val listScrollMiddle = listScrollCount / 2
    val listStartIndex =
        listScrollMiddle - listScrollMiddle % items.size - visibleItemsMiddle + startIndex

    fun getItem(index: Int) = items[index % items.size]

    val listState = rememberLazyListState(initialFirstVisibleItemIndex = listStartIndex)
    val flingBehavior = rememberSnapFlingBehavior(lazyListState = listState)

    val itemHeightPixels = remember { mutableIntStateOf(0) }
    val itemHeightDp = pixelsToDp(itemHeightPixels.intValue)

    val fadingEdgeGradient = remember {
        Brush.verticalGradient(
            0f to Color.Transparent,
            0.5f to Color.Black,
            1f to Color.Transparent
        )
    }

    LaunchedEffect(listState) {
        snapshotFlow { listState.firstVisibleItemIndex }
            .map { index -> getItem(index + visibleItemsMiddle) }
            .distinctUntilChanged()
            .collect { item -> state.selectedItem = item }
    }

    Box(modifier = modifier) {
        LazyColumn(
            state = listState,
            flingBehavior = flingBehavior,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .height(itemHeightDp * visibleItemsCount)
                .fadingEdge(fadingEdgeGradient)
        ) {
            items(listScrollCount) { index ->
                Text(
                    text = getItem(index),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = textStyle,
                    modifier = Modifier
                        .onSizeChanged { size -> itemHeightPixels.intValue = size.height }
                        .then(textModifier)
                )
            }
        }
    }

}

/**
 * Animated Count is an Animated Compose Block that can count with animate your number with update
 */
@Composable
fun AnimatedCount(number: Int, content: @Composable (Digit) -> Unit) {
    Row(
        modifier = Modifier
            .animateContentSize()
            .padding(horizontal = 32.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        number.toString()
            .mapIndexed { index, c -> Digit(c, number, index) }
            .forEach { digit ->
                AnimatedContent(
                    targetState = digit,
                    transitionSpec = {
                        if (targetState > initialState) {
                            slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Up) { -it } togetherWith slideOutOfContainer(
                                AnimatedContentTransitionScope.SlideDirection.Down
                            ) { it }
                        } else {
                            slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Up) { it } togetherWith slideOutOfContainer(
                                AnimatedContentTransitionScope.SlideDirection.Down
                            ) { -it }
                        }
                    }, label = ""
                ) { digit2 ->
                    content(digit2)
                }
            }
    }
}

/**
 * Animated Number is an Animated Compose Block that can count with animate from 0 to your number
 * @param number Number that must be counted until that
 */
@Composable
fun AnimatedNumber(number: Int, content: @Composable (Int) -> Unit) {
    var numbers by remember { mutableIntStateOf(0) }
    val counter by animateIntAsState(
        targetValue = numbers,
        animationSpec = tween(
            durationMillis = 1250,
            easing = FastOutSlowInEasing
        ),
        label = "AnimatedNumber"
    )
    LaunchedEffect(Unit) { numbers = number }
    content(counter)
}

@Composable
fun LockedDirection(
    direction: LayoutDirection = LayoutDirection.Ltr, content: @Composable () -> Unit
) {
    CompositionLocalProvider(LocalLayoutDirection provides direction) {
        content()
    }
}

@Composable
fun MaterialAlertDialog(
    icon: ImageVector,
    title: String,
    message: String,
    confirmText: String,
    dismissText: String? = null,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
) {
    var dismiss by remember { mutableStateOf(false) }
    if (!dismiss) {
        AlertDialog(icon = {
            Icon(
                imageVector = icon, contentDescription = null
            )
        }, onDismissRequest = {
            dismiss = true
            onDismiss()
        }, title = {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall.copy(textDirection = TextDirection.ContentOrRtl)
            )
        }, text = {
            Text(
                text = message, style = MaterialTheme.typography.bodyLarge.copy(
                    textDirection = TextDirection.ContentOrRtl, textAlign = TextAlign.Justify
                )
            )
        }, confirmButton = {
            TextButton(onClick = onConfirm) {
                Text(text = confirmText)
            }
        }, dismissButton = {
            if (dismissText != null) {
                TextButton(onClick = { dismiss = true; onDismiss() }) {
                    Text(text = dismissText)
                }
            }
        })
    }
}


@Composable
fun PermissionAlert(
    title: String, text: String, onConfirm: () -> Unit, dismissible: Boolean = false
) {
    var dismiss by remember { mutableStateOf(false) }
    if (!dismiss) {
        AlertDialog(icon = {
            Icon(
                imageVector = Symbols.Default.PermissionNeeded,
                contentDescription = "Permission Needed Icon"
            )
        }, onDismissRequest = {
            dismiss = dismissible
        }, title = {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall.copy(textDirection = TextDirection.ContentOrRtl)
            )
        }, text = {
            Text(
                text = text, style = MaterialTheme.typography.bodyLarge.copy(
                    textDirection = TextDirection.ContentOrRtl, textAlign = TextAlign.Justify
                )
            )
        }, confirmButton = {
            TextButton(onClick = onConfirm) {
                Text(text = stringResource(R.string.ok_done))
            }
        })
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TitleBar(
    modifier: Modifier = Modifier,
    title: String,
    showBack: Boolean = false,
    mainViewModel: MainViewModel = viewModel()
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (showBack) {
            Spacer(modifier = Modifier.fillMaxWidth(fraction = 0.1f))
        }
        Text(
            modifier = Modifier
                .width(185.dp)
                .basicMarquee(),
            text = title,
            style = MaterialTheme.typography.displayMedium,
            textAlign = TextAlign.Center,
            maxLines = 1
        )
        if (showBack) {
            IconButton(
                modifier = Modifier
                    .width(35.dp)
                    .height(35.dp)
                    .padding(top = 3.dp, end = 5.dp),
                onClick = { mainViewModel.onBackPressed() }) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_back),
                    contentDescription = null
                )
            }
        }
    }
}

@Composable
fun MainBottomNav(selected: MainNavItem, onItemSelected: (MainNavItem) -> Unit) {
    NavigationBar(
        modifier = Modifier.clip(
            MaterialTheme.shapes.large.copy(
                topStart = CornerSize(20.dp),
                topEnd = CornerSize(20.dp),
                bottomEnd = CornerSize(0),
                bottomStart = CornerSize(0)
            )
        )
    ) {
        navItems.forEach { item ->
            MainBottomNavItem(item, item == selected) {
                onItemSelected(item)
            }
        }
    }
}

@Composable
fun RowScope.MainBottomNavItem(
    itemSpec: MainNavItem, selected: Boolean, enabled: Boolean = true, onItemSelected: () -> Unit
) {
    NavigationBarItem(label = {
        Text(text = itemSpec.title)
    }, icon = {
        Icon(
            painterResource(id = itemSpec.icon), contentDescription = itemSpec.title
        )
    }, enabled = enabled, selected = selected, alwaysShowLabel = true, onClick = {
        onItemSelected()
    })
}

@Composable
fun ExamNavCard(examTypeItem: ExamTypesItem, onClick: () -> Unit) {
    ElevatedCard(
        modifier = Modifier
            .padding(13.dp)
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.large),
        elevation = CardDefaults.elevatedCardElevation(4.dp, 8.dp, 4.dp, 6.dp),
        onClick = onClick
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 13.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                modifier = if (examTypeItem in arrayOf(
                        ExamTypesItem.Started, ExamTypesItem.Suspended
                    )
                ) Modifier.scale(1.35f) else Modifier,
                painter = painterResource(id = examTypeItem.icon),
                contentDescription = null
            )
            Spacer(
                modifier = if (examTypeItem in arrayOf(
                        ExamTypesItem.Started, ExamTypesItem.Suspended
                    )
                ) Modifier.height(6.dp) else Modifier.height(12.dp)
            )
            Text(
                text = examTypeItem.title,
                style = LocalTextStyle.current.copy(textAlign = TextAlign.Center)
            )
        }
    }
}

@Composable
fun SettingsOption(icon: Int, title: String, showDivider: Boolean = true, onClick: () -> Unit) {
    Row(modifier = Modifier
        .padding(top = 3.dp)
        .clickable { onClick() }) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .width(35.dp)
                    .height(35.dp),
                painter = painterResource(id = icon),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = title, style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp))
        }
    }
    if (showDivider) {
        HorizontalDivider(modifier = Modifier.padding(vertical = 3.dp, horizontal = 24.dp))
    }
}
