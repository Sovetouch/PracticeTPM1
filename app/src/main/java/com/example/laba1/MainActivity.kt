package com.example.laba1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.laba1.ui.theme.Laba1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laba1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    InputScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputScreen() {
    var arraySize by remember { mutableStateOf("15") }
    var result by remember { mutableStateOf("") }
    val arrayProcessor = remember { ArrayProcessor() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "1. В списке найдите индекс первого отрицательного и последнего положительного элементов.",
            modifier = Modifier.padding(top = 16.dp),
            style = MaterialTheme.typography.bodyLarge
        )

        OutlinedTextField(
            value = arraySize,
            onValueChange = { arraySize = it },
            label = { Text("Введите количество элементов для списка") },
            modifier = Modifier.width(300.dp)
        )

        Button(
            onClick = {
                val size = arraySize.toIntOrNull() ?: 15
                val array = arrayProcessor.generateRandomArray(size)
                result = arrayProcessor.findFirstNegativeAndLastPositive(array)
            },
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            Text("Сгенерировать и найти")
        }

        if (result.isNotEmpty()) {
            Text(
                text = "$result",
                modifier = Modifier.padding(top = 16.dp),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}