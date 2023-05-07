package com.example.tsumarketapp.data
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double
)
fun parseProductsListJson(jsonString: String): List<Product> {
    return Json.decodeFromString(jsonString)
}