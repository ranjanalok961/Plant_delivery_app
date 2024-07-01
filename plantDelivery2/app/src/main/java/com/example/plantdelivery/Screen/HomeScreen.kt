package com.example.plantdelivery.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.plantdelivery.Data

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(function: () -> Unit, function1: () -> Unit) {
    var sort by remember { mutableStateOf("") }
    var showMenu by remember { mutableStateOf(false) }
    var data  = listOf<Data.Plant>()
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(0.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TopAppBar(function1)
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f)
                .paint(
                    painter = painterResource(id = Data.recent[Data.countrecent]),
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
                IconButton(onClick = {
                    if (Data.countrecent==0){
                        Data.countrecent = Data.recent.size - 1
                    }else{
                        Data.countrecent--
                    }
                }) {
                    Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "left")
                }
                IconButton(onClick = {
                    if (Data.countrecent==Data.recent.size - 1){
                        Data.countrecent = 0
                    }else{
                        Data.countrecent++
                    }
                }) {
                    Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "Right")
                }
            }
        }

        Row (
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .padding(5.dp)
                .height(120.dp)
        ){
            Column (
                modifier = Modifier.fillMaxWidth()
            ){
                Row (
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Column {
                        Text(text = "Category",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Column {
                        IconButton(onClick = { showMenu = !showMenu }) {
                            Icon(Icons.Default.MoreVert, "")
                        }
                        DropdownMenu(
                            expanded = showMenu,
                            onDismissRequest = { showMenu = false }
                        ){
                            Data.sorttype.forEach {category ->
                                if (category == "All"){

                                }else{
                                    DropdownMenuItem(text= { Text(text = category) },onClick = {
                                        sort = category
                                    }
                                    )
                                }
                            }
                        }
                    }

                }
                LazyHorizontalGrid(
                    rows = GridCells.Fixed(1),
                    modifier = Modifier.padding(5.dp),
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    content = {
                        items(
                            Data.plantList.map { it.category }.distinct()
                        ){item->
                            Box (
                                modifier = Modifier
                                    .defaultMinSize(minWidth = 80.dp)
                                    .height(50.dp)// Adjust the size as needed
                                    .clip(
                                        RoundedCornerShape(10)
                                    )
                                    .background(Color.LightGray)
                                    .padding(3.dp),
                                contentAlignment = Alignment.Center
                            ){
                                Text(text = item,
                                    style = TextStyle(
                                        fontSize = 20.sp
                                    )
                                    )
                            }
                            Spacer(modifier = Modifier.size(10.dp))
                        }
                    }
                )
            }
        }
        Column (
            modifier = Modifier.padding(10.dp)
        ){
            LazyVerticalGrid(
                columns = GridCells.Fixed(1),
                verticalArrangement = Arrangement.spacedBy(30.dp),
                content = {
                    if(sort == "Sort:A - Z"){
                        data = Data.plantList.sortedBy { it.name }
                    }else if(sort == "Sort:Z - A"){
                        data = Data.plantList.sortedByDescending { it.name }
                    }else if(sort == "Price ascending"){
                        data = Data.plantList.sortedBy { it.cost }
                    }else if(sort == "Price descending"){
                        data = Data.plantList.sortedByDescending { it.cost }
                    }else{
                        data = Data.plantList
                    }
                items(data){ item->
                    Card(onClick = {
                                   Data.selectdetail = item.name
                                    Data.count = 0
                        function()
                    },
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .height(120.dp),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 20.dp
                        )
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
//                                    Column {
//                                        Row (
//                                            Modifier.padding(5.dp),
//                                        ){
//                                            IconButton(onClick = { /*TODO*/ },
//                                                Modifier.background(Color.Green)
//                                                .size(25.dp, 25.dp),
//                                                ) {
//                                                Text(text = "-",
//                                                    style = TextStyle(
//                                                        fontSize = 17.sp,
//                                                        textAlign = TextAlign.Center,
//                                                        fontWeight = FontWeight.Bold
//                                                    )
//                                                )
//                                            }
//                                            Text(text = "${1}",
//                                                Modifier
//                                                    .background(Color.White)
//                                                    .size(25.dp, 25.dp),
//                                                style = TextStyle(
//                                                    fontSize = 17.sp,
//                                                    textAlign = TextAlign.Center,
//                                                    fontWeight = FontWeight.Bold
//                                                )
//                                            )
//                                            IconButton(onClick = { /*TODO*/ },
//                                                Modifier.background(Color.Green)
//                                                    .size(25.dp, 25.dp),
//                                            ) {
//                                                Text(text = "+",
//                                                    style = TextStyle(
//                                                        fontSize = 17.sp,
//                                                        textAlign = TextAlign.Center,
//                                                        fontWeight = FontWeight.Bold
//                                                    )
//                                                )
//                                            }
//                                        }
//                                    }
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
    }
}