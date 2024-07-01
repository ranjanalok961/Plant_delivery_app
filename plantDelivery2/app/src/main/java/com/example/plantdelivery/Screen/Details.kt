package com.example.plantdelivery.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
fun Details(navigate:()-> Unit) {
    val dataind  = (Data.plantList.filter { it.name == Data.selectdetail }).get(0)

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TopAppBar(navigate)
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f)
                .paint(
                    painter = painterResource(id = dataind.imageList[0]),
                    contentScale = ContentScale.FillBounds
                ),
            verticalArrangement = Arrangement.Center,
        ){
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ){
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "left")
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "Right")
                }
            }
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Column {
                Text(text = dataind.name,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(text = dataind.description,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
            IconButton(onClick = { /*TODO*/ },
//                colors =
                ) {
                Icon(imageVector = Icons.Default.Favorite, contentDescription = "Right",

                    )
            }
        }
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = "Quantity",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                )
            ElevatedButton(onClick = { /*TODO*/ },
                ) {
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){
                    IconButton(onClick = { Data.count-- }) {
                        Text(text = "-",
                            style = TextStyle(
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                    Text(text = "${Data.count}",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        )
                    IconButton(onClick = { Data.count++ }) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = "Right")
                    }

                }
            }
        }
        Column (
            modifier = Modifier.fillMaxWidth(0.9f)
        ){
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text = "Cost : ",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    ))
                ElevatedButton(onClick = { /*TODO*/ }) {
                    Text(text = "Add to cart",
                        style = TextStyle(
                            fontSize = 17.sp,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold
                        ))
                }
                ElevatedButton(onClick = { /*TODO*/ }) {
                    Text(text = "Buy Now",
                        style = TextStyle(
                            fontSize = 17.sp,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold
                        ))
                }
            }
        }
    }
}