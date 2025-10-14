package com.example.proyecto3.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyecto3.model.local.ExpenseEntity
import com.example.proyecto3.model.repository.ExpenseRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn

data class FormState(
    val id_producto:Int?=null,
    val nombreProducto:String="",
    val descripcion:String="",
    val fecha:String="",
    val monto:String="",
    val errors:String?=null
)

class ExpenseViewModel(private val repo: ExpenseRepository): ViewModel(){

    val producto: StateFlow<List<ExpenseEntity>> =
        repo.observarProducto().stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = emptyList()
        )

    private val _form=MutableStateFlow(FormState())

    val form: StateFlow<FormState> = _form.asStateFlow()

    fun cargarParaEditar(expense: ExpenseEntity){
        _form.value= FormState(
            id_producto = expense.id_producto,
            nombreProducto = expense.nombreProducto,
            descripcion = expense.descripcion,
            fecha = expense.fecha,
            monto = expense.monto.toString()
        )
    }
}