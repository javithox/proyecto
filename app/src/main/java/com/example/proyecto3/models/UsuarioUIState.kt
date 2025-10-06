package com.example.proyecto3.models

data class UsuarioUIState(
    val nombre:String="",
    val correo:String="",
    val clave:String="",
    val direccion:String="",
    val aceptarterminos:Boolean=false,
    val errores:UsuarioErrores=UsuarioErrores()

)
data class UsuarioErrores(
    val nombre:String?=null,
    val correo:String?=null,
    val clave:String?=null,
    val direccion:String?=null
)