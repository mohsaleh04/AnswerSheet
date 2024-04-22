package ir.saltech.answersheet

import android.content.Context
import androidx.datastore.preferences.core.stringPreferencesKey
import ir.saltech.answersheet.dto.models.Exam
import ir.saltech.answersheet.dto.models.Exams
import ir.saltech.answersheet.utils.dataStore
import ir.saltech.answersheet.utils.fromJson
import ir.saltech.answersheet.utils.get
import ir.saltech.answersheet.utils.set
import ir.saltech.answersheet.utils.toJson

object App {

    object Key {
        val Exams = stringPreferencesKey("exams")
        val Bookmarks = stringPreferencesKey("bookmarks")
        val ExamNames = stringPreferencesKey("examNames")
    }

    enum class Page {
        Home, NewExam, ExamRoom
    }

    enum class ExamCorrectionMode {
        None, Manual, ByKeys
    }

    enum class ExamStatus {
        Started,
        Suspended,
        Finished,
        Correcting,
        Scheduled,
        Draft // Draft is Creating
    }

    enum class ExamFeature {
        Correction,
        Timing,
        Categorization,
        CategoryTiming,
        CategoryCorrection,
        Chronometer,
        ChronometerThreshold
    }

    enum class CollapsableView { // Exam Room Collapsable View
        AnswerSheet,
        ExamDocument,
        Header
    }

    fun getExams(context: Context): Exams {
        return fromJson<Exams>(context.dataStore[Key.Exams] ?: "") ?: Exams()
    }

    fun setExams(context: Context, exams: Exams) {
        context.dataStore[Key.Exams] = toJson(exams) ?: ""
    }

}