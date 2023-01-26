package de.masterthesis.android.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import de.masterthesis.android.logic.SearchViewModel
import de.masterthesis.android.ui.overview.OverviewTaskList

@Composable
fun Content(innerPadding: PaddingValues, viewModel: SearchViewModel) {
    OverviewTaskList(
        Modifier
            .fillMaxHeight(),
        innerPadding,
        viewModel
    )
}