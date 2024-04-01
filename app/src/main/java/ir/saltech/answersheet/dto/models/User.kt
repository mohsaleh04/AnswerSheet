package ir.saltech.answersheet.dto.models

data class User(
    val id: String,
    val fullName: String,
    val userName: String,
    val phoneNumber: String,
    val age: Int,
    val email: String,
)