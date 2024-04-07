package ir.saltech.answersheet.dto.models

data class ExamName(
    val name: String,
    val scores: MutableList<Double> = mutableListOf(),
    val examDates: MutableList<String> = mutableListOf(),
)

val testExamNames = listOf(
    ExamName("علوم"),
    ExamName("ریاضی"),
    ExamName("ریاضی2"),
    ExamName("ریاضی3"),
    ExamName("ریاضی4"),
)