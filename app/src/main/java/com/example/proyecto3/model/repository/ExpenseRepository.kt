package com.example.proyecto3.model.repository

import com.example.proyecto3.model.local.ExpenseDao
import com.example.proyecto3.model.local.ExpenseEntity
import kotlinx.coroutines.flow.Flow

class ExpenseRepository(private val dao: ExpenseDao){

    fun observarProducto(): Flow<List<ExpenseEntity>> = dao.observarProducto()

    suspend fun obtener(id: Int)=dao.obtenerPorId(id)

    suspend fun guardar(
        id_producto: Int?,
        nombreProducto:String,
        descripcion:String,
        fecha:String,
        monto:Double
    ){
        if(id_producto == null || id_producto==0){
            dao.insertar(
                ExpenseEntity(
                    nombreProducto = nombreProducto.trim(),
                    descripcion = descripcion.trim(),
                    fecha = fecha,
                    monto = monto
                )
            )
        }else{
            dao.actualizar(
                ExpenseEntity(
                    id_producto = id_producto,
                    nombreProducto = nombreProducto.trim(),
                    descripcion = descripcion.trim(),
                    fecha = fecha,
                    monto = monto
                )
            )
        }
    }

    suspend fun eliminar(expense: ExpenseEntity)=dao.eliminar(expense)
    suspend fun eliminarProductos()=dao.eliminarProductos()


}