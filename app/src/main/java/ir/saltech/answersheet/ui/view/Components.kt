package ir.saltech.answersheet.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ir.saltech.answersheet.App
import ir.saltech.answersheet.R
import ir.saltech.answersheet.dto.ui.MainNavItem
import ir.saltech.answersheet.dto.ui.navItems
import ir.saltech.answersheet.ui.theme.Symbols
import ir.saltech.answersheet.viewmodels.MainViewModel

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

@Composable
fun TitleBar(page: App.Page, title: String, mainViewModel: MainViewModel = viewModel()) {
    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
    ) {
        if (page != App.Page.Home) {
            Spacer(modifier = Modifier.fillMaxWidth(fraction = 0.125f))
            Text(
                text = title,
                style = MaterialTheme.typography.displayLarge,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.width(16.dp))
            IconButton(modifier = Modifier.padding(top = 8.dp),
                onClick = { mainViewModel.onBackPressed() }) {
                Icon(
                    modifier = Modifier
                        .height(30.dp)
                        .width(30.dp),
                    imageVector = Icons.AutoMirrored.Rounded.ArrowForward,
                    contentDescription = null
                )
            }
        } else {
            Text(
                text = title,
                style = MaterialTheme.typography.displayLarge,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun MainBottomNav(selected: MainNavItem, onItemSelected: (MainNavItem) -> Unit) {
    NavigationBar {
        navItems.forEach { item ->
            MainBottomNavItem(item, item == selected) {
                onItemSelected(item)
            }
        }
    }
}

@Composable
fun RowScope.MainBottomNavItem(
    itemSpec: MainNavItem,
    selected: Boolean,
    enabled: Boolean = true,
    onItemSelected: () -> Unit
) {
    NavigationBarItem(
        label = {
            Text(text = itemSpec.title)
        },
        icon = {
            Icon(
                painterResource(id = itemSpec.icon),
                contentDescription = itemSpec.title
            )
        },
        enabled = enabled,
        selected = selected,
        alwaysShowLabel = true,
        onClick = {
            onItemSelected()
        }
    )
}

