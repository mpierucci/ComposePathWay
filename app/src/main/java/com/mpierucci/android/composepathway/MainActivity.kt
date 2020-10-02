package com.mpierucci.android.composepathway

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.mpierucci.android.composepathway.ui.ComposePathWayTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewStory()
        }
    }
}

@Composable
fun NewStory() {
    val image = imageResource(id = R.drawable.header)
    Column(modifier = Modifier.padding(8.dp)) {
        val imageModifier = Modifier.preferredHeight(180.dp)
            .fillMaxWidth()
        Image(image, modifier = imageModifier)
        Spacer(modifier = Modifier.preferredHeight(16.dp))
        Text("A what a wonderful day")
        Text("To learn compose")
        Text("Following the path way")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePathWayTheme {
        NewStory()
    }
}