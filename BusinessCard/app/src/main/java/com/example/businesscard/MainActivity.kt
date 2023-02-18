package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
            }
        }
    }
}

@Composable
fun BussinesCard(){
    Column(modifier= Modifier
        .fillMaxSize()
        .background(Color.DarkGray)
        .padding(80.dp) ){
        BussinesCardWithLogo()
        BussinesCardWithMoreInforamtion()
    }
}

@Composable
fun BussinesCardWithMoreInforamtion(){
    Column(
        modifier= Modifier
            .fillMaxSize()
            .padding(bottom = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ){
        Row {
            Icon(
                painterResource(id = R.drawable.ic_baseline_local_phone_24),
                contentDescription = null,
                Modifier.padding(end=10.dp)
            )
            Text(text = "+00000", color = Color.White)
        }
            Text(text = "@ferit", color= Color.White)
            Text(text= "tledencan", color= Color.White)

    }
}

@Composable
fun BussinesCardWithLogo() {
    val image = painterResource(id = R.drawable.android_logo)
    Column(
        modifier=Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Image(painter = image, contentDescription = null,modifier = Modifier.size(150.dp))
        Text(text = stringResource(R.string.full_name), color= Color.White)
        Text(text= stringResource(R.string.title), color = Color(0xFF3ddc84))
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        BussinesCard()
    }
}