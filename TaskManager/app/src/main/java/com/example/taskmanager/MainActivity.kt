package com.example.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TaskCompletedScreen(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}

@Composable
fun TaskCompletedScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        // Solution recommended to add horizontal alignment here too to avoid duplication L57/63
    ) {
        val image = painterResource(id = R.drawable.ic_task_completed)
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally),
        )
        TaskMessage(
            stringResource(R.string.all_tasks_completed),
            stringResource(R.string.compliment),
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally),
        )
    }
}

@Composable
fun TaskMessage(heading: String, body: String, modifier: Modifier = Modifier) {
    // No need for another column here
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = heading,
            modifier = modifier
                .padding(
                    top = 24.dp,
                    bottom = 8.dp
                ),
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = body,
            fontSize = 16.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TaskManagerPreview() {
    TaskManagerTheme {
        // Move fill() to column modifier.
        TaskCompletedScreen(modifier = Modifier.fillMaxSize())
    }
}


// Solution Code: https://github.com/google-developer-training/basic-android-kotlin-compose-training-practice-problems/blob/main/Unit%201/Pathway%203/TaskCompleted/app/src/main/java/com/example/taskcompleted/MainActivity.kt