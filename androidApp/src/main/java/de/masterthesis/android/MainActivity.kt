package de.masterthesis.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import de.masterthesis.android.ui.OverviewTaskList
import de.masterthesis.android.ui.BottomBar
import de.masterthesis.android.ui.SearchAppBar
import de.masterthesis.android.viewmodel.SearchViewModel

@ExperimentalMaterial3Api
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val viewModel: SearchViewModel = viewModel()
                Scaffold(
                    topBar = { SearchAppBar(viewModel) },
                    bottomBar = { BottomBar() },
                ) { innerPadding ->
                    OverviewTaskList(
                        Modifier.fillMaxHeight(),
                        innerPadding,
                        viewModel
                    )
                }

            }
        }
    }
}
