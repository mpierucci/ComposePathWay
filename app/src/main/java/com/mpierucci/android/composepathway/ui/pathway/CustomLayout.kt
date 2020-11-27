package com.mpierucci.android.composepathway.ui.pathway

import androidx.compose.foundation.Text
import androidx.compose.foundation.text.FirstBaseline
import androidx.compose.runtime.Composable
import androidx.compose.ui.AlignmentLine
import androidx.compose.ui.Layout
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview

/**
 * Layout modifier to place x  padding between the component and the first baseline.
 */
/*
 * This approach works if you want to controll how a single composable gets measured and laid
 */
fun Modifier.firstBaselineToTop(
    firstBaselineTopTop: Dp
) = Modifier.layout { measurable, constraints ->
    // first we measure the composable we are modifying
    val placeable = measurable.measure(constraints)

    // we first check that the composable has a first baseline
    check(placeable[FirstBaseline] != AlignmentLine.Unspecified) {
        "Composable does not have a first baseline"
    }

    val firstBaseline = placeable[FirstBaseline]

    val placeableY = firstBaselineTopTop.toIntPx() - firstBaseline
    val height = placeable.height + placeableY

    /*
    width would be the measured with of the composable
    hight would be it height plus the difference between the supplied padding and the first baseline
     */
    layout(placeable.width, height) {
        // we need to place the comñposable on the screen or it wont be visible
        placeable.placeRelative(0, placeableY)

    }
}

@Preview
@Composable
fun previewLayoutModifier() {
    Text(text = "Hola", modifier = Modifier.firstBaselineToTop(45.dp))
}



/**
 *
 */
@Composable
fun IncrementalTabbedLayout(
    modifier: Modifier = Modifier,
    tab : Dp = 20.dp,
    children: @Composable () -> Unit
){
    Layout(
        modifier = modifier,
        children = children
    ) { measurables, constraints ->
        // Don't constrain child views further, measure them with given constraints
        // List of measured children
        val placeables = measurables.map { measurable ->
            // Measure each children
            measurable.measure(constraints)
        }

        // Track the y co-ord we have placed children up to
        var yPosition = 0

        var tabValue = 0

        // Set the size of the layout as big as it can
        layout(constraints.maxWidth, constraints.maxHeight) {
            // Place children in the parent layout
            placeables.forEach { placeable ->
                // Position item on the screen
                placeable.placeRelative(x = tabValue, y = yPosition)

                // Record the y co-ord placed up to
                yPosition += placeable.height

                tabValue += tab.toIntPx()

            }
        }
    }
}

@Preview
@Composable
fun TabbedColumnPreview(){
    IncrementalTabbedLayout {
        Text("This is")
        Text("Quite a nice")
        Text("Tabbed view")
    }
}