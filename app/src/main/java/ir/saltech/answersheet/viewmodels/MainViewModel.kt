package ir.saltech.answersheet.viewmodels

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.ViewModel
import ir.saltech.answersheet.App
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    @SuppressLint("StaticFieldLeak")
    internal lateinit var context: Context

    lateinit var backPressedListener: OnBackPressedListener

    var page: App.Page = App.Page.Home
        set(value) {
            _uiState.value = _uiState.value.copy(page = value)
        }


    interface OnBackPressedListener {
        fun onBackPressed(): Boolean
    }

    fun onBackPressed(): Boolean {
        return if (this::backPressedListener.isInitialized) {
            backPressedListener.onBackPressed()
        } else {
            false
        }
    }

    fun setupBackStrategy(page: App.Page, onPageChanged: (App.Page) -> Unit) {
        backPressedListener = object : OnBackPressedListener {
            override fun onBackPressed(): Boolean {
                return when(page) {
                    App.Page.Home -> true
                }
            }
        }
    }

}
