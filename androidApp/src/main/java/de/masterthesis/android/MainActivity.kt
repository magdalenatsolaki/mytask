package de.masterthesis.android

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import de.masterthesis.android.bars.BottomBar
import de.masterthesis.android.bars.TopBar

class MainActivity : AppCompatActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint(
        "UnusedMaterialScaffoldPaddingParameter",
        "UnusedMaterial3ScaffoldPaddingParameter"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Scaffold(
                    topBar = { TopBar() },
                    content = {
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxHeight()
                        ) {
                            itemsIndexed(items = listItems, itemContent = { index, item ->
                                var checkedState by remember { mutableStateOf(item.erledigt) }

                                val background: Color =
                                    if ((index % 2) == 0) Color.Green else Color.Red
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .requiredHeight(ButtonDefaults.MinHeight * 2)
                                        .padding(16.dp)
                                        .background(background)

                                ) {
                                    Checkbox(
                                        checked = checkedState,
                                        onCheckedChange = { checkedState = !checkedState }
                                    )
                                    Spacer(Modifier.size(6.dp))
                                    Text(
                                        textAlign = TextAlign.Center,
                                        text = item.kurzbeschreibung
                                    )
                                    Spacer(Modifier.size(6.dp))
                                    Icon(Icons.Rounded.Edit, contentDescription = null)
                                }
                            })
                        }
                    },
                    //bottomBar = { NavigationBar() },
                    bottomBar = {
                        BottomBar()
                    },
                )

            }
        }
    }
}


