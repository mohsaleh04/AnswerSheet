package ir.saltech.answersheet.dto.models

import ir.saltech.answersheet.App
import java.util.Date

data class Exams(
    val list: MutableList<Exam> = mutableListOf()
)

data class Exam(
    val id: Long,
    val name: ExamName,
    val description: String? = null,
    val document: Document? = null,
    val status: App.ExamStatus = App.ExamStatus.Draft,
    val questions: Questions? = null,
    val time: ExamTime? = null,
    val features: List<App.ExamFeature>? = null,
    val correctionMode: App.ExamCorrectionMode = App.ExamCorrectionMode.None,
    val collapsableViews: MutableList<App.CollapsableView> = mutableListOf(), // if a view collapsing wanted, that item will be added to this list
    /** This is the same when, when scheduled or started **/
    val whenn: ExamWhen? = null,
    val average: ExamAverage? = null,
    val score: Double? = null,
    val stoppedManually: Boolean = false,
    val timeChanged: Boolean = false,
    val isFavorite: Boolean = false,
    val isLoading: Boolean = false,
)

data class ExamTime(
    val left: Long,
    val whole: Long
)

data class ExamName(
    val name: String,
    val scores: MutableList<Double> = mutableListOf(),
    val examDates: MutableList<String> = mutableListOf(),
)

data class ExamWhen(
    val scheduled: Date? = null,
    val started: Date? = null
)

data class ExamAverage(
    val chronoTimeSpent: Long? = null,
    val score: Double? = null
)

data class ExamChronometer(
    val threshold: Long? = null,
    val timeSpent: Long? = null,
    val reset: Boolean = false,
)

// VALUES & VARIABLES

val testExamNames = listOf(
    ExamName("علوم"),
    ExamName("ریاضی"),
    ExamName("ریاضی2"),
    ExamName("ریاضی3"),
    ExamName("ریاضی4"),
)
