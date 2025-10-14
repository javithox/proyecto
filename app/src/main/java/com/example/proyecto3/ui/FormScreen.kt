package com.example.proyecto3.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormScreen(
    vm:ExpenseViewModel,
    onBack:()-> Unit,
    onSaved:()-> Unit
){
    val form by vm.form.collectAsState()
}