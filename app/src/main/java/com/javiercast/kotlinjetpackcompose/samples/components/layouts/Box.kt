package com.javiercast.kotlinjetpackcompose.samples.components.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun MyBox() {
    /* We apply fillMaxSize so the component occupies the entire screen.
       We also use contentAlignment to ensure that its children are
       centered both vertically and horizontally.
    */
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        // Nested Box created inside the parent Box.
        Box(
            /* We set the background to red and enable vertical scrolling.
               This allows us to scroll through the content if it exceeds
                the parent's available height.
            */
            modifier = Modifier
                .background(Color.Red)
                .verticalScroll(rememberScrollState())
        ) {
            // A simple Text component placed inside the child Box.
            Text("Contenido de mi box")
        }
    }
}