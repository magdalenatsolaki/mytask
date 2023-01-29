package de.masterthesis.android.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.input.KeyboardType
import de.masterthesis.android.viewmodel.SearchViewModel

@ExperimentalMaterial3Api
@Composable
fun SearchAppBar(viewModel: SearchViewModel) {
    var query: String by rememberSaveable { mutableStateOf("") }
    val showClearIcon by rememberSaveable { mutableStateOf(query.isEmpty()) }

    TopAppBar(
        title = {
            OutlinedTextField(
                value = query,
                onValueChange = { onQueryChanged ->
                    query = onQueryChanged
                    if (onQueryChanged.isNotEmpty()) {
                        viewModel.performQuery(onQueryChanged)
                    }
                    if (query.isEmpty()) {
                        viewModel.loadActors()
                    }
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Search,
                        tint = MaterialTheme.colorScheme.onBackground,
                        contentDescription = "Suche"
                    )
                },
                trailingIcon = {
                    if (showClearIcon) {
                        IconButton(onClick = { query = "" }) {
                            Icon(
                                imageVector = Icons.Rounded.Clear,
                                tint = MaterialTheme.colorScheme.onBackground,
                                contentDescription = "Leeren"
                            )
                        }
                    }
                },
                maxLines = 1,
                placeholder = { Text(text = "Suche") },
                textStyle = MaterialTheme.typography.labelSmall,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colorScheme.background, shape = RectangleShape)
            )
        }
    )
}