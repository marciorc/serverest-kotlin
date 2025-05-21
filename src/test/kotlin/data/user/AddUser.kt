package data.user

data class AddUser(
    var nome: String,
    var email: String,
    val password: String,
    val administrador: String
)