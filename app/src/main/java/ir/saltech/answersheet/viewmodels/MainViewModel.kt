package ir.saltech.answersheet.viewmodels

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.saltech.answersheet.App
import ir.saltech.answersheet.ui.states.MainUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.File
import kotlin.random.Random

class MainViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    @SuppressLint("StaticFieldLeak")
    internal lateinit var context: Context

    var page: App.Page = App.Page.Home
        set(value) {
            _uiState.value = _uiState.value.copy(page = value)
        }

    fun onBackPressed(page: App.Page, onPageChanged: (App.Page) -> Unit) {
        when (page) {
            App.Page.NewExam, App.Page.ExamRoom -> onPageChanged(App.Page.Home)
            else -> Log.e("BACK_HANDLER", "Back Progress undefined")
        }
    }

    fun saveDocumentFile(bytes: ByteArray, name: String = "document${Random(32).nextInt()}"): File {
        val documentsFolder = File(context.filesDir, "documents")
        if (!documentsFolder.exists())
            documentsFolder.mkdirs()
        val document = File(documentsFolder, "$name.pdf")
        viewModelScope.launch(Dispatchers.IO) {
            document.writeBytes(bytes)
        }
        return document
    }
}
