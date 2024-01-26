package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircleItem()

            }

        }
    }
}

@Composable
fun CircleItem() {
    var counter = remember {
        mutableStateOf(0)
    }
    var color = remember {
        mutableStateOf(Color.Blue)
    }
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.image6),
            contentDescription = "Image",
            contentScale = ContentScale.Crop,
            alpha = 0.7F
        )
        Column (modifier = Modifier, verticalArrangement = Arrangement.Center){
            Text(text = "Нажми на шарик", modifier = Modifier.padding(bottom = 15.dp),
                style = TextStyle(fontSize = 19.sp, fontWeight = FontWeight.Bold)
            )
            Box(
                modifier = Modifier
                    .size(140.dp)
                    .background(color = color.value, shape = CircleShape)
                    .clickable {
                        when (++counter.value) {
                            10 -> color.value = Color.Red
                            20 -> color.value = Color.Green
                            30 -> color.value = Color.Black
                            40 -> color.value = Color.DarkGray
                            50 -> color.value = Color.LightGray
                            60 -> color.value = Color.Magenta
                        }
                    },
                contentAlignment = Alignment.Center


            ) {
                Text(
                    text = counter.value.toString(),
                    style = TextStyle(color = Color.White, fontSize = 40.sp)
                )
            }
        }
    }
}

