package com.example.proyecto3.viewmodel

import EstadoDataStore
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class EstadoViewModel(application: Application): AndroidViewModel(application) {
    // DaraStore creado con contexto de aplicacion

    private val estadoDataStore = EstadoDataStore(application)
    // Estado que representa si esta "activado" o no (observable)
    private val _activo= MutableStateFlow<Boolean?>(null)
    val activo: StateFlow<Boolean?> = _activo
    //Estado para mostrar u ocultar el mensaje animado

    private val _mostrarMensaje= MutableStateFlow(false)
    val mostrarMensaje: StateFlow<Boolean> = _mostrarMensaje

    init{
        // Al iniciar viewmodel, cargamos el estado desde dataStore
        cargarEstado()
    }

    fun cargarEstado(){
        viewModelScope.launch {
            delay(1500)
            _activo.value=estadoDataStore.obtenerResultado().first()?:false
        }
    }
    fun alternarEstado(){
        viewModelScope.launch {
            // alternamos el valor actual
            val nuevoValor=!(_activo.value?:false)
            //Guardamos en DataStore
            estadoDataStore.guardarEstado(nuevoValor)

            //actuslizamos el flujo
            _activo.value=nuevoValor

            //mostramos el mensaje visual animado
            _mostrarMensaje.value=true

            delay(2000) //ocultamos despues de 2 segundos
            _mostrarMensaje.value=false
        }
    }

}