package com.example.calculadora.viewModels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.lifecycle.ViewModel

class CalculadoraViewModel: ViewModel() {
    private val _totdesc = mutableDoubleStateOf(0.0)
    var totdesc: MutableState<Double> = _totdesc

    fun generarTotal(precio: String, descuento: String) : String {
        _totdesc.doubleValue = (precio.toDouble() * descuento.toDouble() / 100)
        return totdesc.value.toString()
    }
}