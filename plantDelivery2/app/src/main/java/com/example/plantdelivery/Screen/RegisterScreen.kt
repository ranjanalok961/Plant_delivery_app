package com.example.plantdelivery.Screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.plantdelivery.R
import com.example.plantdelivery.SharedPrefenceHelper
import com.example.plantdelivery.User

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun RegisterScreen(function: () -> Unit) {
    val context = LocalContext.current
    val sharedPreferencesHelper = SharedPrefenceHelper(context)

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }
    var cpass by remember { mutableStateOf("") }
    val onSaveClick: () -> Unit = {
        val userInfo = User(name,email,phone,pass)
        sharedPreferencesHelper.saveUserInfo(userInfo)
        Toast.makeText(context, "User information saved", Toast.LENGTH_SHORT).show()
    }
    Box (
        Modifier
            .fillMaxSize()
            .padding(0.dp)
            .paint(
                painter = painterResource(id = R.drawable.stacked_waves_haikei),
                contentScale = ContentScale.Crop
            )
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 100.dp)
            ) {

            }

            OutlinedTextField(
                leadingIcon =  {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Email Icon"
                    )
                },
                value = name,
                onValueChange = { name = it },
                placeholder = { Text(text = "Enter your Name") },
                modifier = Modifier
                    .padding(0.dp)
                    .background(Color.LightGray)
                    .fillMaxWidth(0.8f),
                textStyle = TextStyle(
                    fontSize = 18.sp
                )
            )
            //Enter email
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

            //phone
            OutlinedTextField(
                leadingIcon =  {
                    Icon(
                        imageVector = Icons.Default.Phone,
                        contentDescription = "Email Icon"
                    )
                },
                value = phone,
                onValueChange = { phone = it },
                placeholder = { Text(text = "Enter your Phone Number") },
                modifier = Modifier
                    .padding(0.dp)
                    .background(Color.LightGray)
                    .fillMaxWidth(0.8f),
                textStyle = TextStyle(
                    fontSize = 18.sp
                )
            )

            //pass
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

            val cpasswordVisible by rememberSaveable { mutableStateOf(false) }
            OutlinedTextField(
                leadingIcon =  {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Email Icon"
                    )
                },
                value = cpass,
                onValueChange = { cpass = it },
                placeholder = { Text(text = "Enter Confirm Password") },
                modifier = Modifier
                    .padding(0.dp)
                    .background(Color.LightGray)
                    .fillMaxWidth(0.8f),
                textStyle = TextStyle(
                    fontSize = 18.sp
                ),
                visualTransformation = if (cpasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            )
            Row (
                Modifier
                    .fillMaxWidth()
                    .height(50.dp),
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
                onSaveClick()
                if(name==""){
                    Toast.makeText(context,"Please Enter Name First",Toast.LENGTH_SHORT).show()
                }else if (email==""){
                    Toast.makeText(context,"Please Enter Name First",Toast.LENGTH_SHORT).show()
                }else if(phone.isEmpty()){
                    Toast.makeText(context,"Please Enter Name First",Toast.LENGTH_SHORT).show()
                }else if(pass.isEmpty()){
                    Toast.makeText(context,"Please Enter Name First",Toast.LENGTH_SHORT).show()
                }else if(cpass.isEmpty()){
                    Toast.makeText(context,"Please Enter Name First",Toast.LENGTH_SHORT).show()
                }else if (email.isNotEmpty() && pass.isNotEmpty()){
                    onSaveClick()
                }
            },
                Modifier.fillMaxWidth(0.8f)) {
                Text(text = "Sign Up",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    ))
            }
            OutlinedIconButton(onClick = { function() },
                Modifier.fillMaxWidth(0.8f)) {
                Text(text = "Log In",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                )
            }

        }
    }
}