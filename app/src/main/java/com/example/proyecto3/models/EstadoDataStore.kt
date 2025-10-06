package com.example.proyecto3.models

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore("preferencias-usuario")

class EstadoDataStore (private val context: Context){
    //Clave usada para guardar el estado

    private val ESTADO_ACTIVADO= booleanPreferencesKey("Modo-activado")

    //Funcion para guardar el estado en dataStore
    suspend fun guardarEstado(valor: Boolean){
        context.dataStore.edit { preferencias ->
            preferencias[ESTADO_ACTIVADO]=valor
        }
    }

    //Funcion para obtener el estado como Flow (reactivo)

    fun obtenerEstado(): Flow<Boolean?>{
        return context.dataStore.data.map { preferencias ->
            preferencias[ESTADO_ACTIVADO]
        }
    }
}