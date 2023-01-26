package de.masterthesis.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import de.masterthesis.android.logic.SearchViewModel
import de.masterthesis.android.ui.Content
import de.masterthesis.android.ui.bars.BottomBar
import de.masterthesis.android.ui.bars.SearchAppBar

class MainActivity : AppCompatActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val viewModel: SearchViewModel = viewModel()
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                SearchAppBar(viewModel)
                            }
                        )
                    },
                    content = { innerPadding ->
                        Content(innerPadding, viewModel)
                    },
                    bottomBar = {
                        BottomBar()
                    },
                )

            }
        }
    }
}
