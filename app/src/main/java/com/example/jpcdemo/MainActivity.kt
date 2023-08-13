package com.example.jpcdemo

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jpcdemo.ui.theme.JPCDemoTheme

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JPCDemoTheme {
                Scaffold(
                    topBar = {
                        colorResource(id = R.color.teal_700)
                        TopAppBar(
                            title = {
                            Text(text = "Demo App")
                        },navigationIcon = {
                            IconButton(onClick = { }) {
                                Icon(Icons.Filled.Menu,contentDescription = "menu")
                            }

                        },actions = {
                                IconButton(onClick = { }) {
                                    Icon(Icons.Filled.Notifications,contentDescription = "noti")
                                }
                                IconButton(onClick = { }) {
                                    Icon(Icons.Filled.Search,contentDescription = "search")
                                }
                            })
                    },
                    floatingActionButton = {
                        FloatingActionButton(onClick = { }) {
                            IconButton(onClick = { }) {
                                Icon(Icons.Filled.Add,contentDescription = "Add")
                            }
                        }
                    }) {
                   Greeting(name = "Android")
                    ShowSwitch()
                }
                // A surface container using the 'background' color from the theme
//                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
//                    Greeting("Android")
//                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
    )
}

@Composable
fun ShowSwitch(){
    val isChecked = remember {
        mutableStateOf(true)

    }
    Switch(checked = isChecked.value,
        onCheckedChange = {
            isChecked.value=it
        },
        modifier = Modifier.run {
            size(20.dp)
            padding(100.dp)
        })
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JPCDemoTheme {
        Greeting("Android")
    }
}