package ir.saltech.answersheet.dto.models

import java.io.File

data class Document(
    val id: String,
    val file: File,
    val pages: Int = 0,
    val currentPage: Int = 0,
    val editMode: Boolean = false,
    val nightMode: Boolean = false
)
