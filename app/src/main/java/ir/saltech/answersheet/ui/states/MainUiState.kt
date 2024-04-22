package ir.saltech.answersheet.ui.states

import ir.saltech.answersheet.App
import ir.saltech.answersheet.dto.models.Exam
import ir.saltech.answersheet.dto.models.Exams

data class MainUiState(
    val page: App.Page = App.Page.Home,
    val exams: Exams? = null,
    val currentExam: Exam? = null
)
