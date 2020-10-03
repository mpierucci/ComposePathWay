package com.mpierucci.android.composepathway.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview

@Composable
internal fun NewStory() {
    val image = imageResource(id = com.mpierucci.android.composepathway.R.drawable.header)

    ComposePathWayTheme() {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            val imageModifier = Modifier
                .preferredHeight(180.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(4.dp))
            Image(image, modifier = imageModifier, contentScale = ContentScale.Crop)
            Spacer(modifier = Modifier.preferredHeight(16.dp))
            Text(
                "A day wandering through the sandhills " +
                        "in Shark Fin Cove, and a few of the " +
                        "sights I saw", style = typography.h6,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text("To learn compose", style = typography.body2)
            Text("Following the path way", style = typography.body2)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewStoryPreview() {
    NewStory()
}