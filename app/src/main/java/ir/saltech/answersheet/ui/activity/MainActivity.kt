package ir.saltech.answersheet.ui.activity

import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import ir.saltech.answersheet.R
import ir.saltech.answersheet.ui.theme.AnswerSheetTheme
import ir.saltech.answersheet.ui.view.Launcher
import ir.saltech.answersheet.ui.view.LockedDirection
import ir.saltech.answersheet.ui.view.PermissionAlert
import ir.saltech.answersheet.viewmodels.MainViewModel
import kotlin.system.exitProcess

class MainActivity : ComponentActivity() {
    private val permissions = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) arrayOf(
        android.Manifest.permission.POST_NOTIFICATIONS
    ) else arrayOf(
        android.Manifest.permission.WRITE_EXTERNAL_STORAGE
    )
    private var permissionLauncher: ActivityResultLauncher<Array<String>>
    private val mainViewModel: MainViewModel by viewModels()

    init {
        permissionLauncher =
            registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
                if (it.values.all { granted -> granted }) {
                    startProgram()
                } else {
                    exitProcess(-1)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startProgram()
    }

    private fun startProgram() {
        enableEdgeToEdge()
        setContent {
            AnswerSheetTheme {
                LockedDirection {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        if (checkAppPermissions()) {
                            Launcher()
                        } else {
                            RequestPermission()
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun RequestPermission() {
        when {
            needsAppPermissionsRational() -> PermissionAlert(
                stringResource(R.string.app_permission_title),
                stringResource(R.string.app_permission_notification),
                onConfirm = {
                    requestAppPermissions()
                })

            else -> requestAppPermissions()
        }
    }

    private fun needsAppPermissionsRational(): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (permission in permissions) {
                if (shouldShowRequestPermissionRationale(permission)) return true
            }
        }
        return false
    }

    private fun checkAppPermissions(): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (permission in permissions) {
                if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) return false
            }
        }
        return true
    }

    private fun requestAppPermissions() {
        permissionLauncher.launch(permissions)
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (mainViewModel.onBackPressed()) {
            super.onBackPressed()
        }
    }
}