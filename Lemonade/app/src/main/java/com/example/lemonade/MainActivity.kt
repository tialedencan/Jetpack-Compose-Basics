package com.example.lemonade

import android.graphics.ColorSpace
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LemonadeApp(modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(align = Alignment.Center)
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun LemonadeApp(modifier: Modifier = Modifier) {

    var currentStep by remember{
        mutableStateOf(1)
    }
    var numberOfSqueezes by remember {
        mutableStateOf(1)
    }
    var squeezesCounter = 0

        val imageResource = when(currentStep){
            1 -> painterResource(id = R.drawable.lemon_tree)
            2 -> painterResource(id = R.drawable.lemon_squeeze)
            3 -> painterResource(id = R.drawable.lemon_drink)
            else -> painterResource(id = R.drawable.lemon_restart)
        }

        val imageDescription = when(currentStep){
            1 -> stringResource(id =R.string.lemon_tree_content_description)
            2 -> stringResource(id =R.string.lemon_content_description)
            3 -> stringResource(id =R.string.lemonade_content_description)
            else -> stringResource(id =R.string.glass_content_description)
        }

        val textDescription = when(currentStep){
            1 -> stringResource(id =R.string.lemon_tree_description)
            2 -> stringResource(id =R.string.lemon_description)
            3 -> stringResource(id =R.string.lemonade_description)
            else -> stringResource(id =R.string.glass_description)
        }

        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = textDescription, fontSize = 18.sp)
            Image(
                painter = imageResource,
                contentDescription = imageDescription,
                modifier=Modifier
                    .padding(top=16.dp)
                    .border(2.dp, Color(105, 205, 216, 255))
                    .clickable {
                        if(currentStep==4){
                            currentStep = 1
                        } else if( currentStep == 2){
                            if(numberOfSqueezes == 1) {
                                numberOfSqueezes = (2..4).random()
                            }
                            if(squeezesCounter < numberOfSqueezes-1) {
                                currentStep = 2
                                squeezesCounter++
                            } else {
                                currentStep = 3
                                numberOfSqueezes = 1
                                squeezesCounter = 0
                            }
                        } else {
                            currentStep++
                        }

                    },
            )

        }
    }
