package com.example.plantdelivery.Screen


import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.plantdelivery.R
import com.example.plantdelivery.SharedPrefenceHelper

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navigate: () -> Unit, navigate1: () -> Unit) {
    val context = LocalContext.current
    val sharedPreferencesHelper = SharedPrefenceHelper(context)
    var email by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .paint(
                painter = painterResource(id = R.drawable.plantback2),
                contentScale = ContentScale.Crop
            ),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Row (
            modifier = Modifier.fillMaxWidth()
                .height(50.dp)
        ){

        }
        Text(text = "Plant Delivery App",
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(
                fontSize = 50.sp,
                color = Color.Green,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Cursive
            )
            )
        Row (
            modifier = Modifier.fillMaxWidth()
                .height(100.dp)
        ){

        }
        OutlinedTextField(
            leadingIcon =  {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Email Icon"
                )
            },
            value = email,
            onValueChange = { email = it },
            placeholder = { Text(text = "Enter your e-mail") },
            modifier = Modifier
                .padding(0.dp)
                .background(Color.LightGray)
                .fillMaxWidth(0.8f),
            textStyle = TextStyle(
                fontSize = 18.sp
            )
        )
        //pass
        Row (
            Modifier
                .fillMaxWidth()
                .height(10.dp)
        ){

        }
        val passwordVisible by rememberSaveable { mutableStateOf(false) }
        OutlinedTextField(
            leadingIcon =  {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Email Icon"
                )
            },
            value = pass,
            onValueChange = { pass = it },
            placeholder = { Text(text = "Enter your password") },
            modifier = Modifier
                .padding(0.dp)
                .background(Color.LightGray)
                .fillMaxWidth(0.8f),
            textStyle = TextStyle(
                fontSize = 18.sp
            ),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        )
        Row (
            Modifier
                .fillMaxWidth()
                .height(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
        }
        OutlinedIconButton(onClick = {
            if(email==""){
                Toast.makeText(context, "Enter Your email first!", Toast.LENGTH_SHORT).show()
            }else{
                val userInfo = sharedPreferencesHelper.getUserInfo(email)
                if(userInfo != null){
                    if(pass == userInfo.password){
                        navigate()
                    }
                }else
                {
                    Toast.makeText(context, "User not found", Toast.LENGTH_SHORT).show()
                }
            }


        },
            modifier = Modifier
                .fillMaxWidth(0.8f),
            colors =  IconButtonDefaults.filledIconButtonColors(
                containerColor = Color.LightGray,
                contentColor = Color.White
            )

        ) {
            Text(text = "Login",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                ))
        }
        Row (
            Modifier
                .fillMaxWidth()
                .height(80.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Row (
                Modifier
                    .fillMaxWidth(0.8f)
                    .height(2.dp)
                    .background(Color.Black)
            ){

            }
        }
        OutlinedIconButton(onClick = {
                                 navigate1()
        },
            modifier = Modifier
                .fillMaxWidth(0.8f),
            colors =  IconButtonDefaults.filledIconButtonColors(
                containerColor = Color.LightGray,
                contentColor = Color.White
            )
        ) {
            Text(text = "Register",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                ))
        }
    }
}