package com.example.proyecto3.viewmodel


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.proyecto3.model.local.AppDataBase
import com.example.proyecto3.model.repository.ExpenseRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch


class ExpenseViewModelFactory(private val app: Application): ViewModelProvider.Factory{
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val db= AppDataBase.get(app)
        val repo = ExpenseRepository(db.expenseDao())
        return ExpenseViewModel(repo) as T
    }
}
