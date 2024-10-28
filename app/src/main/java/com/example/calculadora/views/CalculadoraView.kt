package com.example.calculadora.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculadora.viewModels.CalculadoraViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculadoraView(viewModel: CalculadoraViewModel) {
    var totdesc = viewModel.totdesc.value.toString()
    if (totdesc == "0.0"){totdesc = ""}
    var showAlert by remember {
        mutableStateOf(false)
    }
    var precio by remember {
        mutableStateOf(value = "")
    }
    var descuento by remember {
        mutableStateOf(value = "")
    }
    var total by remember {
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
            ) {
                UpText(name = "Total: \n $total€")
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                        .width(10.dp)
                )
                UpText(name = "Descuento: \n $totdesc€")
            }
            TextField(
                value = precio,
                onValueChange = { precio = it },
                label = { Text(text = "Precio") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                value = descuento,
                onValueChange = { descuento = it },
                label = { Text(text = "Descuento %") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedButton(
                onClick = {
                    totdesc = viewModel.generarTotal(precio, descuento)
                    total = (precio.toDouble() - totdesc.toDouble()).toString()
                }, Modifier
                    .align(Alignment.CenterHorizontally),
                    colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Blue,
                )
            ) {
                Text(text = "Generar descuento")
            }
            OutlinedButton(
                onClick = {
                    precio = ""
                    totdesc = ""
                    total = ""
                    descuento = ""
                }, Modifier.align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Red
                )
            ) {
                Text(text = "Limpiar")
            }
        }

        if (showAlert){
            Alert(title = "Alerta", message = "Escriba precio y descuento", confirmText = "Aceptar", onConfirmClick = { showAlert = false }) {
                
            }
        }
    }
}

@Composable
fun Alert(
    title: String,
    message: String,
    confirmText: String,
    onConfirmClick: () -> Unit,
    onDismissClick: () -> Unit
) {
    AlertDialog(
        title = {Text(text = title)},
        text = {Text(text = message)},
        onDismissRequest = { onDismissClick },
        confirmButton = { Button(onClick = { onConfirmClick }) {
        Text(text = confirmText)
    } })
}

@Composable
fun UpText(name: String) {
    Text(
        text = "$name\n", fontSize = 22.sp, modifier = Modifier
            .background(color = Color.Gray, shape = CircleShape)
            .padding(horizontal = 20.dp, vertical = 10.dp)
    )
}

@Composable
fun TitleBar(name: String) {
    Text(text = name, fontSize = 25.sp, fontWeight = FontWeight.Bold, color = Color.White)
}





