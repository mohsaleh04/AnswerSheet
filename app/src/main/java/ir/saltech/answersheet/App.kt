package ir.saltech.answersheet

import android.content.Context
import androidx.datastore.preferences.core.stringPreferencesKey
import ir.saltech.answersheet.utils.dataStore
import ir.saltech.answersheet.utils.fromJson
import ir.saltech.answersheet.utils.get
import ir.saltech.answersheet.utils.set
import ir.saltech.answersheet.utils.toJson

object App {

    object Key {
    }

    enum class Page {
        Home, NewExam
    }

    enum class ExamCorrectionMode {
        None, Manual, ByKeys
    }

//    fun getUserProfile(context: Context): User {
//        return fromJson<User>(context.dataStore[Key.UserProfile] ?: "") ?: User()
//    }
//
//    fun setUserProfile(context: Context, user: User) {
//        context.dataStore[Key.UserProfile] = toJson(user) ?: ""
//    }

}