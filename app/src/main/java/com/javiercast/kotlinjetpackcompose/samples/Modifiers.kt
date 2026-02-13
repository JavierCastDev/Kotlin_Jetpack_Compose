package com.javiercast.kotlinjetpackcompose.samples

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


//We can create a preview of our components, using the @Preview annotation and calling the function.
@Preview
@Composable

//The fun is commonly named like the original function, appending 'Preview' to the end of the function name.
fun MyModifierPreview() {
    MyModifier()
}

@Composable

fun MyModifier() {
    Text(
        "I've modified this text", modifier = Modifier
            .clip(RoundedCornerShape(25.dp)) //This modifier clips the content to a specific shape, like rounded corners or a circle.
            .background(Color.Green) //We set the background of the text as green
            .animateContentSize() //This modifier animates the layout size changes. It's placed here to ensure smooth transitions whenever the internal content size updates.
            .padding(15.dp) //We set the padding at all sides to 15 dp
            .blur(1.dp) //We set a blur effect to the text
            .clickable {} //Adding this modifier, we can make something happen when the text is clicked.
    )
}

/**
 * IMPORTANT: Modifier order is sequential (top-to-bottom).
 * Each function wraps the previous result, creating a "chain" of transformations.
 * * Examples of how order changes the result:
 * 1. clip() before background(): The background is cut into the shape (rounded corners).
 * If reversed, the background remains a sharp rectangle and the clipping is invisible.
 * 2. padding() location: Padding before background() adds space OUTSIDE the color.
 * Padding after background() (like here) adds space INSIDE, acting as internal margins.
 */
