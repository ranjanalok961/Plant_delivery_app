package com.example.plantdelivery.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.plantdelivery.Data

@Preview
@Composable
fun Cart(function: () -> Unit) {
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
            Text(text = "My Cart",
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
        Column (
            Modifier.fillMaxHeight(0.85f)
        ){
            LazyVerticalGrid(
                columns = GridCells.Fixed(1),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                content = {
                    items(Data.plantList){ item->
                        Card (
                            modifier = Modifier
                                .fillMaxWidth(0.9f)
                                .height(120.dp)
                        ){
                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(10.dp)
                            ) {
                                Image(painter = painterResource(id = item.imageList.get(0)), contentDescription = "",
                                    modifier = Modifier.size(width = 100.dp, height = 100.dp)
                                )
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(start = 10.dp)
                                ) {
                                    Text(text = item.name,
                                        style = TextStyle(
                                            fontSize = 20.sp
                                        )
                                    )
                                    Text(text = item.description,
                                        style = TextStyle(
                                            fontSize = 20.sp
                                        )
                                    )
                                    Row (
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(top = 5.dp),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ){
                                        Column {
                                            Row (
                                                Modifier.padding(5.dp),
                                            ){
                                                IconButton(onClick = { /*TODO*/ },
                                                    Modifier
                                                        .background(Color.Green)
                                                        .size(25.dp, 25.dp),
                                                ) {
                                                    Text(text = "-",
                                                        style = TextStyle(
                                                            fontSize = 17.sp,
                                                            textAlign = TextAlign.Center,
                                                            fontWeight = FontWeight.Bold
                                                        )
                                                    )
                                                }
                                                Text(text = "${1}",
                                                    Modifier
                                                        .background(Color.White)
                                                        .size(25.dp, 25.dp),
                                                    style = TextStyle(
                                                        fontSize = 17.sp,
                                                        textAlign = TextAlign.Center,
                                                        fontWeight = FontWeight.Bold
                                                    )
                                                )
                                                IconButton(onClick = { /*TODO*/ },
                                                    Modifier
                                                        .background(Color.Green)
                                                        .size(25.dp, 25.dp),
                                                ) {
                                                    Text(text = "+",
                                                        style = TextStyle(
                                                            fontSize = 17.sp,
                                                            textAlign = TextAlign.Center,
                                                            fontWeight = FontWeight.Bold
                                                        )
                                                    )
                                                }
                                            }
                                        }
                                        Text(text = "${item.cost}",
                                            style = TextStyle(
                                                fontSize = 20.sp
                                            )
                                        )
                                    }
                                }
                            }

                        }
                    }
                })
        }
        Row(
            Modifier
                .fillMaxWidth(0.8f)
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Total",
                style = TextStyle(
                    fontSize = 17.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                ))
            Text(text = "${300}",
                style = TextStyle(
                    fontSize = 17.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                ))

        }
        Button(onClick = { function() },
            Modifier
                .fillMaxWidth(0.85f),
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
            Text(text = "CheckOut",
                style = TextStyle(
                    fontSize = 17.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                ))
        }
    }
}