package com.apptechinnovationlab.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apptechinnovationlab.lemonade.ui.theme.LemonadeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@Composable
fun ImageTextComponent(instruction: String, modifier: Modifier = Modifier) {

    var tapCount by remember { mutableStateOf(1) }

    var imageResource: Int = when(tapCount){
        1 -> R.drawable.lemon_tree
        in 2..4 -> R.drawable.lemon_squeeze
        5 -> R.drawable.lemon_drink
        6 -> R.drawable.lemon_restart
        else -> {
            tapCount = 1
            R.drawable.lemon_tree
        }
    }

    var stringResource: Int = when(tapCount){
        1 -> R.string.tap_lemon_tree
        in 2..4 -> R.string.tap_lemon_label
        5 -> R.string.glass_of_lemonade
        6 -> R.string.tap_empty_glass_label
        else -> {
            tapCount = 1
            R.string.tap_lemon_tree
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFC3ECD2)),
            onClick = { tapCount++ },
            shape = RoundedCornerShape(20.dp)
        ) {
            Image(
                imageVector = ImageVector.vectorResource(imageResource),
                contentDescription = stringResource(
                    id = R.string.lemon_tree
                )
                ,
                modifier = Modifier.padding(18.dp)
            )
        }
        Text(
            text = "Hello $instruction!",
            fontSize = 18.sp,
            modifier = Modifier.padding(top = 20.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    LemonadeTheme {
        ImageTextComponent(
            stringResource(id = R.string.tap_lemon_tree),
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(align = Alignment.Center)
        )
    }
}