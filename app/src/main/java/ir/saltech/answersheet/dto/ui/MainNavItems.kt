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

    data object Settings:
            MainNavItem(
                "تنظیمات",
                R.drawable.baseline_settings_24
            )

    data object StudyRoom:
        MainNavItem(
            "اتاق مطالعه",
            R.drawable.baseline_study_room_24
        )

    data object ExamRoom:
        MainNavItem(
            "اتاق آزمون",
            R.drawable.baseline_exam_room_24
        )

    data object Home :
        MainNavItem(
            "خانه",
            R.drawable.baseline_home_24
        )
}
