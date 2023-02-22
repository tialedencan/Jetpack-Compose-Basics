package com.example.courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.courses.data.DataSource
import com.example.courses.model.Topic
import com.example.courses.ui.theme.CoursesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesApp()
        }
    }
}

@Composable
fun CoursesApp() {
    CoursesTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            CoursesGrid(topics =  DataSource.topics)
        }
    }
}

@Composable
fun CourseCard(topic: Topic){
    Card(modifier = Modifier.padding(8.dp), elevation = 4.dp) {
        Row{
            Image(
                painter = painterResource(id = topic.imageResourceId),
                contentDescription = stringResource(id = topic.stringResourceId),
                modifier = Modifier
                    .height(64.dp)
                    .width(64.dp)
                    .align(Alignment.CenterVertically)
            )
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = stringResource(id = topic.stringResourceId), modifier = Modifier.padding(bottom = 8.dp), style = MaterialTheme.typography.h6)

                Row() {
                    Image(painter = painterResource(id = R.drawable.topics), contentDescription = "dots")
                    Text(text = topic.number.toString(), modifier = Modifier.padding(start = 8.dp))
                }
            }
        }

    }
}


@Composable
fun CoursesGrid(topics: List<Topic>){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        items(topics){topic ->
            CourseCard(topic = topic)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopicCardPreview() {
    CoursesTheme {
        CourseCard(topic = Topic(R.string.architecture,58,R.drawable.architecture))
    }
}