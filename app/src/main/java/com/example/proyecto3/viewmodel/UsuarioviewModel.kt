package com.example.proyecto3.viewmodel

import androidx.lifecycle.ViewModel
import com.example.proyecto3.models.UsuarioErrores
import com.example.proyecto3.models.UsuarioUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update


class UsuarioviewModel : ViewModel() {

    private val estado = MutableStateFlow(UsuarioUIState())

    val Estado: StateFlow<UsuarioUIState> = estado

    //actualiza el campo nombre
    fun onNombreChange(valor:String){
        estado.update { it.copy(nombre = valor, errores = it.errores.copy(nombre = null)) }
    }
    //actualiza el campo correo
    fun onCorreoChange(valor: String){
        estado.update { it.copy(correo = valor, errores = it.errores.copy(correo = null)) }
    }
    //actualiza el campo clave
    fun onClaveChange(valor: String){
        estado.update { it.copy(clave = valor, errores = it.errores.copy(clave = null)) }
    }
    //actualiza el campo direccion
    fun onDireccionChange(valor: String){
        estado.update { it.copy(direccion = valor, errores = it.errores.copy(direccion = null)) }
    }
    //actualiza el chechbox de aceptacion
    fun onAceptarTerminosChange(valor: Boolean){
        estado.update { it.copy(aceptarterminos = valor) }
    }

    //validacion total del formulario
    fun validarFormulario():Boolean{
        val estadoActual=estado.value
        val errores = UsuarioErrores(
            nombre = if(estadoActual.nombre.isBlank()) "Campo obligatorio" else null,
            correo = if(!estadoActual.correo.contains("@"))"Correo invalido" else null,
            clave = if(estadoActual.clave.length<6)"debe tener al menos 6 caracteres" else null,
            direccion = if(estadoActual.direccion.isBlank())"Campo obligatorio" else null
        )

        val hayErrores=listOfNotNull(
            errores.nombre,
            errores.correo,
            errores.clave,
            errores.direccion
        ).isNotEmpty()
        estado.update { it.copy(errores = errores) }
        return !hayErrores
    }
}
