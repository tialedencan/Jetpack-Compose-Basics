package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ComposeArticleWithImage(
                        title= stringResource(id = R.string.article_title),
                        sectionText1 = stringResource(id = R.string.section_text_1),
                        sectionText2 = stringResource(id = R.string.section_text_2)
                    )
                }
            }
        }
    }
}

@Composable
fun ComposeArticleWithImage(title: String, sectionText1: String,sectionText2: String) {
    val image= painterResource(id = R.drawable.bg_compose_background)
    Column {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
        ComposeArticleText(title = title, sectionText1 = sectionText1, sectionText2 = sectionText2)
    }
}

@Composable
fun ComposeArticleText(title: String, sectionText1: String, sectionText2: String) {
   Column{
       Text(
           text = title,
           fontSize = 24.sp,
           modifier = Modifier
               .fillMaxWidth()
               .wrapContentWidth(align = Alignment.Start)
               .padding(26.dp)
       )
       Text(
           text = sectionText1,
           modifier = Modifier
               .fillMaxWidth()
               .padding(start = 16.dp, end = 16.dp),
           textAlign = TextAlign.Justify
       )
       Text(
           text = sectionText2,
           modifier = Modifier
               .fillMaxWidth()
               .padding(16.dp),
           textAlign = TextAlign.Justify)
   }
}


@Preview(showBackground = true)
@Composable
fun ComposeArticlePreview() {
    ComposeArticleTheme {
       ComposeArticleWithImage(
           title= stringResource(id = R.string.article_title),
           sectionText1 = stringResource(id = R.string.section_text_1),
           sectionText2 = stringResource(id = R.string.section_text_2)
       )
    }
}