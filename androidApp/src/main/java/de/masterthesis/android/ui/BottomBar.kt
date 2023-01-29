package de.masterthesis.android.ui

import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable

@Composable
fun BottomBar() {
    BottomAppBar(
        actions = {},
        floatingActionButton = {
            FloatingActionButton(onClick = { Log.d("MyTaskTag", "Neuer Task") })
            {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Neuer Task"
                )
            }
        }
    )
}