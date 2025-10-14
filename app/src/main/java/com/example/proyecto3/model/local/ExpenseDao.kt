package com.example.proyecto3.model.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpenseDao {

    @Query("SELECT * FROM PRODUCTO ORDER BY FECHA DESC, id_producto DESC")
    fun observarProducto(): Flow<List<ExpenseEntity>>

    @Query("select * from producto where id_producto = :id")
    suspend fun obtenerPorId(id: Int):ExpenseEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(expense:ExpenseEntity):Long

    @Update
    suspend fun actualizar(expense:ExpenseEntity)
    @Delete
    suspend fun eliminar(expense: ExpenseEntity)

    @Query("delete from producto")
    suspend fun eliminarProductos()
}