package com.example.proyecto3.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.proyecto3.viewmodel.ExpenseViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormScreen(
    vm: ExpenseViewModel,
    onBack:()-> Unit,
    onSaved:()-> Unit
){
    val form by vm.form.collectAsState()
}