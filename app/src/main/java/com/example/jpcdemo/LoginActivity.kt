package com.example.jpcdemo

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jpcdemo.ui.theme.JPCDemoTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JPCDemoTheme {
                Surface (color = MaterialTheme.colorScheme.background){
                    LoginScreen()

                }

            }
        }
    }
    private fun logged(username:String,password:String){
        if(username=="jks" && password=="12345"){
            Toast.makeText(this,"logged!",Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@LoginActivity,RecyclerviewActivity::class.java))
        }else{
            Toast.makeText(this,"wrong Credential!",Toast.LENGTH_SHORT).show()
        }

    }
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun LoginScreen(){
        val userName= remember {
            mutableStateOf("")
        }
        val password= remember {
            mutableStateOf("")
        }

        Column (modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
            verticalArrangement = Arrangement.Center){
            Text(
                text = "Hello Again!",
                fontSize = 20.sp,
                fontFamily = FontFamily.Monospace,
                color = Color.Blue,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = "Welcome",
                fontSize = 20.sp,
                fontFamily = FontFamily.Monospace,
                color = Color.Blue,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = "Back",
                fontSize = 20.sp,
                fontFamily = FontFamily.Monospace,
                color = Color.Blue,
                fontWeight = FontWeight.Bold,
            )
            OutlinedTextField(
                value = userName.value,
                onValueChange = {
                    userName.value = it
                }, leadingIcon = {
                    Icon(Icons.Default.Person , contentDescription ="Person" )
                }, label = {
                    Text(text = "Username")
                }, placeholder = {
                    Text(text = "Enter User Name")
                }, modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = password.value,
                onValueChange = {
                    password.value = it
                }, leadingIcon = {
                    Icon(Icons.Default.Info , contentDescription ="Person" )
                }, label = {
                    Text(text = "Password")
                }, placeholder = {
                    Text(text = "Enter User Password")
                },modifier = Modifier.fillMaxWidth()
            )
            
            OutlinedButton(onClick = {logged(userName.value,password.value) },modifier = Modifier.fillMaxWidth()) {
                Text(text = "Login")

            }
        }
    }
//    @Composable
//    fun MyContent(){
//        val mContext = LocalContext.current
//        mContext.startActivity(Intent(mContext,RecyclerviewActivity::class.java))
//    }
//    @Preview(showBackground = true)
//    @Composable
//    fun DefaultPreview(){
//
//    }
}