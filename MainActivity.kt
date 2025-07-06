package com.example.trabalhoprogramacao

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FazerContas()
        }
    }
}

@Composable
fun FazerContas() {
    var colorBack by remember { mutableStateOf(true) }
    var clicado by remember { mutableStateOf(false) }
    var inputText1 by remember { mutableStateOf("") }
    var inputText2 by remember { mutableStateOf("") }
    var resultText by remember { mutableStateOf("") }

    val backgroundColor = if (colorBack) Color.LightGray else Color.Gray
    val corDoBotao = if (clicado) Color.Red else Color.Green

    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = backgroundColor
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Caixas de texto lado a lado
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    TextField(
                        value = inputText1,
                        onValueChange = { inputText1 = it },
                        label = { Text("Número 1") },
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 8.dp)
                    )

                    TextField(
                        value = inputText2,
                        onValueChange = { inputText2 = it },
                        label = { Text("Número 2") },
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 8.dp)
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Botão de Soma
                Button(onClick = {
                    val num1 = inputText1.toDoubleOrNull()
                    val num2 = inputText2.toDoubleOrNull()
                    resultText = if (num1 != null && num2 != null) {
                        "Soma: %.2f".format(num1 + num2)
                    } else {
                        "Os números introduzidos não são válidos"
                    }
                }) {
                    Text("Somar")
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Botão de Subtração
                Button(onClick = {
                    val num1 = inputText1.toDoubleOrNull()
                    val num2 = inputText2.toDoubleOrNull()
                    resultText = if (num1 != null && num2 != null) {
                        "Subtração: %.2f".format(num1 - num2)
                    } else {
                        "Os números introduzidos não são válidos"
                    }
                }) {
                    Text("Subtrair")
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Botão de Multiplicação
                Button(onClick = {
                    val num1 = inputText1.toDoubleOrNull()
                    val num2 = inputText2.toDoubleOrNull()
                    resultText = if (num1 != null && num2 != null) {
                        "Multiplicação: %.2f".format(num1 * num2)
                    } else {
                        "Os números introduzidos não são válidos"
                    }
                }) {
                    Text("Multiplicar")
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Botão de Divisão
                Button(onClick = {
                    val num1 = inputText1.toDoubleOrNull()
                    val num2 = inputText2.toDoubleOrNull()
                    resultText = if (num1 != null && num2 != null) {
                        if (num2 != 0.0) {
                            "Divisão: %.2f".format(num1 / num2)
                        } else {
                            "Não é possível realizar a divisão"
                        }
                    } else {
                        "Os números introduzidos não são válidos"
                    }
                }) {
                    Text("Dividir")
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Resultado
                Text(resultText)

                Spacer(modifier = Modifier.height(32.dp))

                // Botão para mudar cor de fundo
                Button(
                    onClick = {
                        colorBack = !colorBack
                        clicado = !clicado
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = corDoBotao)
                ) {
                    Text("Mudar Cor de Fundo")
                }
            }
        }
    }
}
