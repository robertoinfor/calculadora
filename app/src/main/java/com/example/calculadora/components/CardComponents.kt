package com.example.calculadora.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun DoubleCard(total: String, totaldescuento: String) {
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
        modifier = Modifier
            .size(width = 240.dp, height = 100.dp)
    ) {
        Text(text = total)
    }
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
        modifier = Modifier
            .size(width = 240.dp, height = 100.dp)
    ) {
        Text(text = totaldescuento)
    }
}

@Composable
fun Card(value: String, text: String){
        TextField(
        value = value,
        onValueChange = { value = it },
        label = { Text(text = text) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
}