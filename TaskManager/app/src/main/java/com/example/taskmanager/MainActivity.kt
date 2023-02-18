package com.example.taskmanager

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.ui.theme.TaskManagerTheme
import org.intellij.lang.annotations.JdkConstants

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TaskManagerWithImage(status = stringResource(id = R.string.task_status),
                        message = stringResource(id = R.string.congratulation))
                }
            }
        }
    }
}

@Composable
fun TaskManagerWithImage(status: String, message: String) {
    val image= painterResource(id = R.drawable.ic_task_completed)
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Image(painter = image, contentDescription = null,)
        TaskManagerText(status = status, message = message)

    }
}

@Composable
fun TaskManagerText(status: String, message: String) {
    Column{
        Text(
            text = status,
            fontWeight = FontWeight.Bold,
            modifier=Modifier.padding(top=24.dp, bottom = 8.dp),
        )
        Text(
            text = message,
            fontSize = 16.sp,
        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TaskManagerTheme {
        TaskManagerWithImage(
            status = stringResource(id = R.string.task_status),
            message = stringResource(id = R.string.congratulation)
        )
    }
}