package ir.saltech.answersheet.dto.models

import java.io.File

data class Document(
    val id: String,
    val file: File,
    val nightMode: Boolean = false
    )
