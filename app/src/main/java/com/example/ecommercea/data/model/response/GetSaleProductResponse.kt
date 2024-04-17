package com.example.ecommerce.data.model.response


import com.example.ecommerce.data.model.Product

data class GetSaleProductResponse(
    val message: String?,
    val products: List<Product>?,
    val status: Int?
)