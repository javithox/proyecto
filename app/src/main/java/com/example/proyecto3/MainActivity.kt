package com.example.proyecto3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.proyecto3.ui.theme.Proyecto3Theme
import androidx.core.view.WindowCompat
import com.example.proyecto3.ui.screen.PantallaPrincipal


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window,false)
        setContent {
            Proyecto3Theme{
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    PantallaPrincipal(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}