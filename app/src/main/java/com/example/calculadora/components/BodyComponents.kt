package com.example.calculadora.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TitleBar(name: String) {
    Text(text = name, fontSize = 25.sp, fontWeight = FontWeight.Bold, color = Color.White)
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