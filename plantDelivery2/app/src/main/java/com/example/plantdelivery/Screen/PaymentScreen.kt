package com.example.plantdelivery.Screen

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.plantdelivery.Data
import com.example.plantdelivery.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PaymentScreen() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "")
            }
            Text(text = "Payment",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(Color.Black)
        ){

        }
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,

            ){
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.LocationOn, contentDescription = "")
            }
            Text(text = "Your Shipping Address",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(text = "Chnage",
                Modifier
                    .fillMaxWidth()
                    .padding(end = 10.dp),
                style = TextStyle(
                    fontSize = 15.sp,
                    color = Color.Blue,
                    textAlign = TextAlign.Right
                )
            )
        }
        Text(text = "Select your payment method",
            Modifier
                .fillMaxWidth(0.9f),
            style = TextStyle(
                fontSize = 15.sp,
                color = Color.Black,
            )
            )
        Row (
            Modifier
                .fillMaxWidth(0.9f),
        ){
            OutlinedButton(onClick = { Data.paymentmethod="Card" },
                Modifier
                    .fillMaxWidth(0.33f)
                    .height(80.dp)
                    .paint(
                        painter = painterResource(id = R.drawable.dc2),
                        contentScale = ContentScale.FillBounds
                    ),
                shape = CircleShape,
                border= if(Data.paymentmethod == "Card"){
                    BorderStroke(2.dp, Color.Green)
                }else{
                    BorderStroke(1.dp, Color.LightGray)
                }
                ) {
                
            }
            OutlinedButton(onClick = { Data.paymentmethod = "paytm" },
                Modifier
                    .fillMaxWidth(0.5f)
                    .height(80.dp)
                    .paint(
                        painter = painterResource(id = R.drawable.paytm),
                        contentScale = ContentScale.FillBounds
                    ),
                shape = CircleShape,
                border= if(Data.paymentmethod == "paytm"){
                    BorderStroke(2.dp, Color.Green)
                }else{
                    BorderStroke(1.dp, Color.LightGray)
                }
            ) {

            }
            OutlinedButton(onClick = { Data.paymentmethod = "upi" },
                Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .paint(
                        painter = painterResource(id = R.drawable.upi),
                        contentScale = ContentScale.FillBounds
                    ),
                shape = CircleShape,
                border= if(Data.paymentmethod == "upi"){
                    BorderStroke(2.dp, Color.Green)
                }else{
                    BorderStroke(1.dp, Color.LightGray)
                }
            ) {

            }
        }
        if(Data.paymentmethod=="Card"){
            var text by remember { mutableStateOf("") }
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Card Number") },
                modifier = Modifier.fillMaxWidth(0.9f)
            )
            val text1 by remember { mutableStateOf("") }
            OutlinedTextField(
                value = text1,
                onValueChange = { text = it },
                label = { Text("Cardholder Name") },
                modifier = Modifier.fillMaxWidth(0.9f)
            )
            Row (
                modifier = Modifier.fillMaxWidth(0.9f),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                val text2 by remember { mutableStateOf("") }
                OutlinedTextField(
                    value = text2,
                    onValueChange = { text = it },
                    label = { Text("Expiry Date") },
                    modifier = Modifier.fillMaxWidth(0.45f)
                )
                val text3 by remember { mutableStateOf("") }
                OutlinedTextField(
                    value = text3,
                    onValueChange = { text = it },
                    label = { Text("CVV") },
                    modifier = Modifier.fillMaxWidth(0.9f)
                )
            }
        }else if(Data.paymentmethod == "paytm"){
            var text by remember { mutableStateOf("") }
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Enter Your number") },
                modifier = Modifier.fillMaxWidth(0.9f)
            )
        }else if(Data.paymentmethod == "upi"){
            var text by remember { mutableStateOf("") }
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Enter your upi") },
                modifier = Modifier.fillMaxWidth(0.9f)
            )
        }
        Row (modifier = Modifier.fillMaxWidth().height(50.dp)){

        }
        val context = LocalContext.current
        Button(onClick = {

        },
            Modifier
                .fillMaxWidth(0.9f),
            colors =  ButtonDefaults.outlinedButtonColors(
                containerColor = Color.Green,
                contentColor = Color.White
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 20.dp,
                pressedElevation = 5.dp,
                disabledElevation = 0.dp,
                hoveredElevation = 30.dp
            )
        ) {
            Text(text = "Confirm and Pay",
                style = TextStyle(
                    fontSize = 17.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                ))
        }
    }
}