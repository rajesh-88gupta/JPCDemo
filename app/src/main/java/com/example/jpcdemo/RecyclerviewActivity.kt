package com.example.jpcdemo

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jpcdemo.ui.theme.JPCDemoTheme
import com.example.jpcdemo.utils.User
import com.example.jpcdemo.utils.dummyData

@OptIn(ExperimentalMaterial3Api::class)
class RecyclerviewActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JPCDemoTheme {
                Scaffold(topBar = {
                    colorResource(id = R.color.teal_700)
                    TopAppBar(
                        title = {
                            Text(text = "Demo App")
                        },
                        navigationIcon = {
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
                },) {
                    Surface(
                        color = MaterialTheme.colorScheme.background) {
                        Recyclerview(users = dummyData())
                    }
                }

            }
        }
    }

    @Composable
    fun EachRow(user: User) {
        Card(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(CornerSize(10.dp)),
            elevation =  CardDefaults.cardElevation(
                defaultElevation = 5.dp
            )
        ) {
            Row(modifier = Modifier.padding(5.dp)) {
                Image(painter = painterResource(id =R.drawable.ic_launcher_background), contentDescription = "Image",
                    modifier = Modifier
                        .padding(8.dp)
                        .size(80.dp)
                        .align(Alignment.CenterVertically)
                        .clip(
                            RoundedCornerShape(CornerSize(10.dp))
                        )
                )
                Text(text = user.description, modifier = Modifier.padding(8.dp))

            }
        }
    }
    @Composable
    fun Recyclerview(users:List<User>){
        LazyColumn(modifier = Modifier.padding(top = 60.dp)
            ){
            items(users){
                EachRow(user = it)

            }
        }
    }

}