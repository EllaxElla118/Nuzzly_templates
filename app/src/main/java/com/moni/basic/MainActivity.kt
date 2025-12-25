package com.moni.basic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.moni.basic.ui.theme.BasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BasicTheme {
                HelloButtonApp()
            }
        }
    }
}

@Composable
fun HelloButtonApp() {
    // State to track current color
    var currentColor by remember { mutableStateOf(Color.Blue) }
    
    // List of colors to cycle through
    val colors = listOf(
        Color.Blue,
        Color.Red,
        Color.Green,
        Color.Magenta,
        Color.Cyan,
        Color.Yellow
    )
    
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    // Change to next color
                    val currentIndex = colors.indexOf(currentColor)
                    val nextIndex = (currentIndex + 1) % colors.size
                    currentColor = colors[nextIndex]
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = currentColor
                ),
                modifier = Modifier
                    .padding(16.dp)
                    .height(80.dp)
                    .width(200.dp)
            ) {
                Text(
                    text = "Hello",
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.White
                )
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Text(
                text = "Click the button to change color!",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}