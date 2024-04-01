package ir.saltech.answersheet.dto.ui

import ir.saltech.answersheet.R

val navItems = listOf(
    MainNavItem.Settings,
    MainNavItem.StudyRoom,
    MainNavItem.ExamRoom
)

sealed class MainNavItem(
    var title: String,
    var icon: Int,
) {

    data object Settings :
        MainNavItem(
            "تنظیمات",
            R.drawable.settings
        )

    data object StudyRoom :
        MainNavItem(
            "اتاق مطالعه",
            R.drawable.room_study
        )

    data object ExamRoom :
        MainNavItem(
            "اتاق آزمون",
            R.drawable.room_exam
        )

    data object Home :
        MainNavItem(
            "خانه",
            R.drawable.home
        )
}
