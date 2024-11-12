package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val destination = intent.getStringExtra("destination") ?: "main"

        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    when (destination) {
                        "main" -> MainView(modifier = Modifier.padding(innerPadding))
                        "second" -> SecondView(modifier = Modifier.padding(innerPadding))
                        else -> MainView(modifier = Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }
}

@Composable
fun MainView(modifier: Modifier = Modifier) {
    Text(
        text = "Bienvenido a la Página Principal",
        modifier = modifier
    )
}

@Composable
fun SecondView(modifier: Modifier = Modifier) {
    Text(
        text = "Bienvenido a la Segunda Vista",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun MainViewPreview() {
    MyApplicationTheme {
        MainView()
    }
}

@Preview(showBackground = true)
@Composable
fun SecondViewPreview() {
    MyApplicationTheme {
        SecondView()
    }
}
