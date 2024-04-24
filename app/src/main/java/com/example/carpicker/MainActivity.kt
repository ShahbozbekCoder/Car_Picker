package com.example.carpicker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.carpicker.ui.theme.CarPickerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarPickerTheme {
                CarPicker()
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun CarPicker() {
    CarImageAndButton(
        Modifier
            .fillMaxSize()
            .wrapContentSize(align = Alignment.Center)
    )
}

@Composable
fun CarImageAndButton(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
    val carImage = when (result) {
        1 -> R.drawable.image1
        2 -> R.drawable.image2
        3 -> R.drawable.image3
        4 -> R.drawable.image4
        5 -> R.drawable.image5
        6 -> R.drawable.image6
        7 -> R.drawable.image7
        8 -> R.drawable.image8
        9 -> R.drawable.image9
        10 -> R.drawable.image10
        11 -> R.drawable.image11
        12 -> R.drawable.image12
        13 -> R.drawable.image13
        else -> R.drawable.image1
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = carImage),
            contentDescription = null
        )
        Button(onClick = {
            //mashina rasmi almashsin
            result++
            if (result >13) {
                result = 1
            }
        }) {
            Text(text = "Keyingi mashina")
        }
    }
}