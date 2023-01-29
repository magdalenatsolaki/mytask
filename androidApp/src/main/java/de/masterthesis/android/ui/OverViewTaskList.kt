@file:OptIn(ExperimentalMaterial3Api::class)

package de.masterthesis.android.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import de.masterthesis.android.R
import de.masterthesis.android.viewmodel.SearchViewModel

@ExperimentalMaterial3Api
@Composable
fun OverviewTaskList(modifier: Modifier, innerPadding: PaddingValues, viewModel: SearchViewModel) {
    val taskList = viewModel.list.observeAsState().value
    LazyColumn(
        modifier = modifier,
        contentPadding = innerPadding
    ) {
        if (!taskList.isNullOrEmpty()) {
            items(taskList) { task ->
                ListItem(
                    headlineText = { Text(task.kurzbeschreibung) },
                    leadingContent = {
                        IconButton(onClick = { }) {
                            Icon(
                                painterResource(id = R.drawable.baseline_check_box_outline_blank_24),
                                contentDescription = "Aufgabe erledigen",
                            )
                        }
                    },
                    trailingContent = {
                        Icon(
                            painterResource(id = R.drawable.baseline_more_horiz_24),
                            contentDescription = "More",
                        )
                    },
                )
                Divider()
            }
        }
    }
}