package com.example.plantdelivery

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

object Data : ViewModel() {
    var sort by mutableStateOf("")
    val sorttype = listOf("Price ascending","Price descending","Sort:A - Z","Sort:Z - A")
    var count by mutableStateOf(0)
    var paymentmethod by mutableStateOf("Card")
    var selectdetail by  mutableStateOf("")
    var countrecent by  mutableStateOf(0)
    val recent = listOf<Int>(R.drawable.rose1,R.drawable.tulip1,R.drawable.fern1,R.drawable.lavender1,R.drawable.snake_plant1)
    data class Plant(
        val name: String,
        val category: String,
        val description: String,
        val cost: Double,
        val imageList: List<Int>
    )
    val plantList = listOf(
        Plant("Rose", "Flowering Plant", "Beautiful red roses", 10.99,listOf(R.drawable.rose1,R.drawable.rose2,R.drawable.rose3,R.drawable.rose4,R.drawable.rose5)),
        Plant("Tulip", "Flowering Plant", "Colorful tulip flowers", 8.99, listOf(R.drawable.tulip1,R.drawable.tulip,R.drawable.tulip2,R.drawable.tulip4,R.drawable.tulip5)),
        Plant("Fern", "Foliage Plant", "Lush green fern leaves", 12.99, listOf(R.drawable.fern1,R.drawable.fern2,R.drawable.fern3,R.drawable.fern4,R.drawable.fern5)),
        Plant("Lavender", "Herb", "Aromatic lavender flowers", 9.99,listOf(R.drawable.lavender1)),
        Plant("Snake Plant", "Indoor Plant", "Easy to care for snake plant", 14.99,listOf(R.drawable.snake_plant1)),
        Plant("Palm Tree", "Tree", "Tropical palm tree", 25.99,listOf(R.drawable.tulip1)),
        Plant("Succulent", "Succulent", "Assorted succulent plants", 6.99,listOf(R.drawable.tulip1)),
        Plant("Orchid", "Flowering Plant", "Elegant orchid blooms", 18.99,listOf(R.drawable.tulip1)),
        Plant("Bamboo", "Indoor Plant", "Lucky bamboo plant", 7.99,listOf(R.drawable.tulip1)),
        Plant("Cactus", "Succulent", "Low-maintenance cacti", 5.99,listOf(R.drawable.tulip1)),
        Plant("Sunflower", "Flowering Plant", "Bright sunflower blooms", 11.99,listOf(R.drawable.tulip1)),
        Plant("Bonsai", "Tree", "Miniature bonsai tree", 20.99,listOf(R.drawable.tulip1)),
        Plant("Aloe Vera", "Succulent", "Aloe vera with healing properties", 9.99,listOf(R.drawable.tulip1)),
        Plant("Pothos", "Indoor Plant", "Climbing pothos vines", 13.99,listOf(R.drawable.tulip1)),
        Plant("Lily", "Flowering Plant", "Graceful lily flowers", 10.99,listOf(R.drawable.tulip1)),
        Plant("African Violet", "Flowering Plant", "Vibrant African violet", 8.99,listOf(R.drawable.tulip1)),
        Plant("Money Plant", "Indoor Plant", "Money plant for good luck", 7.99,listOf(R.drawable.tulip1)),
        Plant("Lemon Tree", "Tree", "Lemon tree with fruit", 22.99,listOf(R.drawable.tulip1)),
        Plant("Mint", "Herb", "Fresh and fragrant mint leaves", 6.99,listOf(R.drawable.tulip1)),
        Plant("Ficus", "Indoor Plant", "Ficus with glossy leaves", 15.99,listOf(R.drawable.tulip1)),
        Plant("Daisy", "Flowering Plant", "Cheerful daisy flowers", 9.99,listOf(R.drawable.tulip1)),
        Plant("Apple Tree", "Fruit Tree", "Apple tree with delicious apples", 29.99,listOf(R.drawable.tulip1)),
        Plant("Cherry Tree", "Fruit Tree", "Cherry tree with sweet cherries", 26.99,listOf(R.drawable.tulip1)),
        Plant("Peach Tree", "Fruit Tree", "Peach tree with juicy peaches", 27.99,listOf(R.drawable.tulip1)),
        Plant("Mango Tree", "Fruit Tree", "Mango tree with sweet mangoes", 32.99,listOf(R.drawable.tulip1)),
        Plant("Lichi Tree", "Fruit Tree", "Lichi tree with luscious lychees", 34.99,listOf(R.drawable.tulip1)),
        Plant("Orange Tree", "Fruit Tree", "Orange tree with ripe oranges", 30.99,listOf(R.drawable.tulip1))
    )
}
