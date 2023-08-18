package com.example.composebasics

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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composebasics.ui.theme.ComposeBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TutorialContent()
                }
            }
        }
    }
}

@Composable
fun TutorialInfo(heading: String, intro: String, body: String, modifier : Modifier = Modifier){
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = heading,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.Start),
            fontSize = 24.sp,
        )
        Text(
            text = intro,
            modifier = Modifier
                .padding(start = 16.dp)
                .padding(end = 16.dp)
                .align(alignment = Alignment.CenterHorizontally),
            textAlign = TextAlign.Justify
        )
        Text(
            text = body,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally),
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun TutorialContent(modifier: Modifier = Modifier) {
    Column (modifier = Modifier){
        val image = painterResource(R.drawable.bg_compose_background)
        Image(
            painter = image,
            contentDescription = null,
        )
        TutorialInfo(
            heading = stringResource(R.string.heading),
            intro = stringResource(R.string.intro),
            body = stringResource(R.string.body),
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp))
    }

}

@Preview(showBackground = true)
@Composable
fun JetpackTutorialPreview() {
    ComposeBasicsTheme {
        TutorialContent()
    }
}

// TODO: Check naming conventions of composable function
//  solution code: https://github.com/google-developer-training/basic-android-kotlin-compose-training-practice-problems/blob/main/Unit%201/Pathway%203/ComposeArticle/app/src/main/java/com/example/composearticle/MainActivity.kt
