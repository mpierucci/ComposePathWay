package com.mpierucci.android.composepathway

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionReference
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.mpierucci.android.composepathway.ui.ComposePathWayTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppContainer {
                MainScreenContent()
            }
        }
    }
}

/*
We can encapsulate shared styles and configuration
with container functions
 */
@Composable
fun MyAppContainer(
    content: @Composable () -> Unit
) {
    ComposePathWayTheme {
        Surface(color = Color.Yellow) {
            content()
        }
    }
}

@Composable
private fun Greetings(name: String) {
    Text(
        "Holi $name",
        modifier = Modifier.padding(24.dp),
        style = MaterialTheme.typography.h1
    )
}

@Composable
private fun MainScreenContent(names:List<String> = listOf("Marco","Flor","Axel")) {
    val count = remember { mutableStateOf(0) }
    Column(modifier = Modifier.fillMaxHeight()) {
        Column(modifier = Modifier.weight(1f)) {
            names.forEach {name ->
                Greetings(name)
                Divider(color = Color.Black)
            }

        }
        Counter(
            count = count.value,
            updateCount = {count.value ++}
        )
    }
}

@Composable
fun Counter(count: Int, updateCount: (Int) -> Unit) {
    Button(
        onClick = {updateCount(count+1)},
        backgroundColor = if (count > 5) Color.Green else Color.White
    ) {
        Text("I´ve been clicked $count times")

    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MyAppContainer { MainScreenContent() }
}



