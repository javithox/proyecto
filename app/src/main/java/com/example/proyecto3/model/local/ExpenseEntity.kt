package com.example.proyecto3.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "producto")
data class ExpenseEntity(
    @PrimaryKey(true)
    val id_producto:Int=0,
    val nombreProducto:String,
    val descripcion:String,
    val fecha:String,
    val monto:Double

)