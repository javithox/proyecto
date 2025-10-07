package com.example.proyecto3.ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.proyecto3.viewmodel.EstadoViewModel

@Composable
fun PantallaPrincipal(modifier: Modifier= Modifier, viewModel: EstadoViewModel= viewModel()) {
    //usa el modifier en el contenedor principal
    val estado=viewModel.activo.collectAsState()
    val mostrarMensaje =viewModel.mostrarMensaje.collectAsState()

    if(estado.value==null){
        Box(
            modifier=modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            CircularProgressIndicator()
        }

    }else{
        val estadoActivo =estado.value!!
        val colorAnimado by animateColorAsState(
            targetValue = if (estadoActivo) Color(0xff4caf50) else Color(0xffb0bec5),
            animationSpec = tween(durationMillis = 500), label = ""
        )

        val textoBoton by remember(estadoActivo) {
            derivedStateOf { if (estadoActivo) "Desactivar" else "Activar" }
        }

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Button(
                onClick = {viewModel.alternarEstado() },
                colors = ButtonDefaults.buttonColors(containerColor = colorAnimado),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            ) {
                Text(textoBoton, style = MaterialTheme.typography.titleLarge)
            }

            Spacer(modifier=Modifier.height(24.dp))

            AnimatedVisibility(visible = mostrarMensaje.value) {
                Text(
                    text = "¡Estado gusardado exitosamente!",
                    color = Color(0xff4caf50),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}