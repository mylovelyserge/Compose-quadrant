package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FinalScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ScreenDesign(title: String, description: String,
    background: Color, modifier: Modifier = Modifier) {
    Box(
        modifier
            .fillMaxSize()
            .background(background)) {
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(16.dp)) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = description,
                textAlign = TextAlign.Center

            )
        }
    }
}

@Composable
fun FinalScreen(modifier: Modifier = Modifier) {
    Column(modifier.fillMaxSize()) {
        Row(modifier = Modifier.weight(1f)) {
            ScreenDesign(
                title = stringResource(R.string.text_composable),
                description = stringResource(R.string.text_composable_description),
                background = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )
            ScreenDesign(
                title = stringResource(R.string.image_composable),
                description = stringResource(R.string.image_composable_description),
                background = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }
        Row(modifier = Modifier.weight(1f)) {
            ScreenDesign(
                title = stringResource(R.string.row_composable),
                description = stringResource(R.string.row_composable_description),
                background = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f)
            )
            ScreenDesign(
                title = stringResource(R.string.column_composable),
                description = stringResource(R.string.column_composable_description),
                background = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        FinalScreen()
    }
}