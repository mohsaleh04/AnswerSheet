package ir.saltech.answersheet.dto.ui

import ir.saltech.answersheet.R

val examTypesItems = listOf(
    ExamTypesItem.Started,
    ExamTypesItem.Suspended,
    ExamTypesItem.Finished,
    ExamTypesItem.Correcting,
    ExamTypesItem.Creating,
    ExamTypesItem.Scheduled
)

sealed class ExamTypesItem(
    var title: String,
    var icon: Int
) {
    data object Started :
        ExamTypesItem(
            title = "در انتظار اتمام",
            icon = R.drawable.exam_started
        )

    data object Suspended :
        ExamTypesItem(
            title = "مـعـلـق شـده",
            icon = R.drawable.exam_suspended
        )

    data object Finished :
        ExamTypesItem(
            title = "پـایــان یـافـتـه",
            icon = R.drawable.exam_finished
        )

    data object Creating :
        ExamTypesItem(
            title = "در دست ساخت",
            icon = R.drawable.exam_creating
        )

    data object Correcting :
        ExamTypesItem(
            title = "تصـحیح نـشده",
            icon = R.drawable.exam_correcting
        )

    data object Scheduled :
        ExamTypesItem(
            title = "زمان بندی شده",
            icon = R.drawable.exam_scheduled
        )

    data object Favorite :
        ExamTypesItem(
            title = "مورد علاقه",
            icon = R.drawable.exam_favorite
        )
}