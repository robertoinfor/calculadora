package com.example.calculadora.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculadoraView() {
    var precio by remember {
        mutableStateOf(value = "")
    }
    var descuento by remember {
        mutableStateOf(value = "")
    }
    var total by remember {
        mutableStateOf(value = "")
    }
    var totdesc by remember {
        mutableStateOf(value = "")
    }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { TitleBar(name = "App descuentos") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Blue
                )
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        ) {
            Row(
                modifier = Modifier
                    .wrapContentSize(Alignment.Center)
                    .padding(vertical = 10.dp)
                    .align(Alignment.CenterHorizontally)
                    .wrapContentSize()
            ) {
                UpText(name = "Total \n $total")
                Spacer(modifier = Modifier.padding(10.dp))
                UpText(name = "Descuento \n $totdesc")
            }
            TextField(
                value = precio,
                onValueChange = { precio = it },
                label = { Text(text = "Precio") })

            TextField(
                value = descuento,
                onValueChange = { descuento = it },
                label = { Text(text = "Descuento %") })

            Button(onClick = {
                total =
                    (precio.toDouble() - (precio.toDouble() * descuento.toDouble()/100)).toString()
                totdesc = (precio.toDouble() * descuento.toDouble()/100).toString()
            }) {
                Text(text = "Generar descuento")
            }
            Button(onClick = { precio = ""
                totdesc = ""
                total = ""
                descuento = ""
            }) {
                Text(text = "Limpiar")
            }
        }
    }
}


@Composable
fun UpText(name: String) {
    Text(
        text = "$name\n", modifier = Modifier
            .background(color = Color.Gray, shape = CircleShape)
            .padding(horizontal = 40.dp)
    )
}

@Composable
fun TitleBar(name: String) {
    Text(text = name, fontSize = 25.sp, fontWeight = FontWeight.Bold, color = Color.White)
}





