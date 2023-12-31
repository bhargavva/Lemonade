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
fun ImageTextComponent(modifier: Modifier = Modifier) {

    var tapCount by remember { mutableStateOf(0) }
    val randomNum = (2..4).random()

    var imageResource: Int
    var stringResource: Int

    when(tapCount){
        0 -> {
            imageResource = R.drawable.lemon_tree
            stringResource = R.string.Instruction_1
        }
        1 -> {
            imageResource = R.drawable.lemon_squeeze
            stringResource = R.string.Instruction_2
        }
        (2..4).random() -> {
            imageResource = R.drawable.lemon_drink
            stringResource = R.string.Instruction_3
        }
        randomNum + 1 -> {
            imageResource = R.drawable.lemon_restart
            stringResource = R.string.Instruction_4
        }
        else -> {
            tapCount = 0
            imageResource = R.drawable.lemon_tree
            stringResource = R.string.Instruction_1
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
                contentDescription = stringResource.toString(),
                modifier = Modifier.padding(18.dp)
            )
        }
        Text(
            text = stringResource(stringResource),
            fontSize = 18.sp,
            modifier = Modifier.padding(top = 20.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
        ImageTextComponent(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(align = Alignment.Center)
        )
}