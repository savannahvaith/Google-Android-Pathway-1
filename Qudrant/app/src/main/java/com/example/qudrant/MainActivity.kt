package com.example.qudrant

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.qudrant.ui.theme.QudrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QudrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Quadrant("Android", "Something else")
                }
            }
        }
    }
}

@Composable
fun Quadrant(heading: String, body: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = heading,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )
        Text(
            text = body,
            textAlign = TextAlign.Justify,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun QadrantPreview() {
    QudrantTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(modifier = Modifier.weight(1f)) {
                Quadrant(
                    heading = stringResource(R.string.text_composable),
                    body = stringResource(id = R.string.text_body),
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp)
                        .wrapContentWidth(Alignment.Start)
                        .background(color = Color(0xFFEADDFF))
                )
                Quadrant(
                    heading = stringResource(R.string.image_composable),
                    body = stringResource(id = R.string.image_body),
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp)
                        .wrapContentWidth(Alignment.End)
                        .background(color = Color(0xFFD0BCFF))
                )
            }
            Row(modifier = Modifier.weight(1f)) {
                Quadrant(
                    stringResource(R.string.row_composoble),
                    stringResource(id = R.string.row_body),
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp)
                        .wrapContentWidth(Alignment.Start)
                        .background(color = Color(0xFFB69DF8))
                )
                Quadrant(
                    stringResource(R.string.column_composoble),
                    stringResource(id = R.string.column_body),
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp)
                        .wrapContentWidth(Alignment.Start)
                        .background(color = Color(0xFFF6EDFF))
                )
            }
        }
    }
}

// Solution Code: https://github.com/google-developer-training/basic-android-kotlin-compose-training-practice-problems/blob/main/Unit%201/Pathway%203/ComposeQuadrant/app/src/main/java/com/example/composequadrant/MainActivity.kt
