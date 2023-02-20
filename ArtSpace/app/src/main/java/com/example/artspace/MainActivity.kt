package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Magenta
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    var artSelector by remember{
        mutableStateOf(1)
    }
    Column() {
        ImageAndDescription(selector = artSelector)

        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Spacer(modifier = Modifier.height(32.dp))
            Button(onClick = {if(artSelector==2) artSelector -= 1}) {
                Text(text = stringResource(id = R.string.back), modifier = Modifier.padding(8.dp))
            }
            Spacer(modifier = Modifier.width(64.dp))
            Button(onClick = {if(artSelector==1) artSelector += 1}) {
                Text(text = stringResource(id = R.string.next), modifier = Modifier.padding(8.dp))
            }
        }
    }

}

@Composable
fun ImageAndDescription(selector: Int) {
    val imagePainter = when(selector) {
        1 -> painterResource(id = R.drawable.dog)
        else -> painterResource(id = R.drawable.flowers)
    }
    val imageDescription = when(selector) {
        1 -> stringResource(id = R.string.dog)
        else -> stringResource(id = R.string.flowers)
    }
    val title = when(selector) {
        1-> stringResource(id = R.string.title1)
        else -> stringResource(id = R.string.title2)
    }
    val description = when(selector) {
        1 -> stringResource(id = R.string.description1)
        else -> stringResource(id = R.string.description2)
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Spacer(modifier = Modifier.height(24.dp))
        Image(
            painter = imagePainter,
            contentDescription = imageDescription,
            modifier = Modifier.border(3.dp, Black)
        )
        Spacer(modifier = Modifier.height(24.dp))
       Box(modifier = Modifier
           .border(3.dp, LightGray)
           .padding(10.dp)
           .fillMaxWidth()
           .height(100.dp)
       ) {

           Text(
               text = title,
               modifier = Modifier.padding(bottom = 16.dp).align(Alignment.Center),
               fontSize = 24.sp,
               fontWeight = FontWeight.Bold
           )
           Text(
               text = description,
               modifier = Modifier.padding(top=24.dp,bottom = 8.dp).align(Alignment.BottomCenter),
           )
       }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}