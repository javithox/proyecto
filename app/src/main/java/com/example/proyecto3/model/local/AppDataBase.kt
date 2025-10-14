package com.example.proyecto3.model.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ExpenseEntity::class], version = 1, exportSchema = false)
abstract class AppDataBase:RoomDatabase(){
    abstract fun expenseDao():ExpenseDao

    companion object{
        @Volatile private var INSTANCE: AppDataBase?=null

        fun get(context: Context): AppDataBase =
            INSTANCE?:synchronized(this){
                INSTANCE?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "Productos.db"
                ).build().also { INSTANCE = it }
            }
    }

}