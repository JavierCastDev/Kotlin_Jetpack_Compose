package com.javiercast.kotlinjetpackcompose.samples.components.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable

fun MyBoxPractice() {

    //I created this state variable to hold the initial background color of the child box.
    val colorBlack = remember { mutableStateOf(Color.Black) }

    Box(
        /*We use fillMaxSize to occupy the entire screen,
        set the background color to green, and center the content.
         */
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green), contentAlignment = Alignment.Center
    ) {
        Box(
            //Here I used the clip modifier to shape the box into a circle.
            modifier = Modifier
                .clip(CircleShape)
                .background(colorBlack.value)
                .size(150.dp)
                /*Using the clickable modifier, I update the background color
                to blue when the box is pressed.
                 */
                .clickable(onClick = { colorBlack.value = Color.Blue }),
            contentAlignment = Alignment.Center
        ) {
            //We set the text color to white and define a custom font size.
            Text("Hola", modifier = Modifier, color = Color.White, fontSize = 35.sp)
        }
    }
}

/* * NOTE ON TEXT SCALING:
 * We use 'sp' (Scale-independent Pixels) for font sizes instead of 'dp'.
 * While 'dp' scales based on screen density, 'sp' also scales based on the
 * user's preferred font size in their system settings. This ensures the
 * application remains accessible for users who need larger text.
 */