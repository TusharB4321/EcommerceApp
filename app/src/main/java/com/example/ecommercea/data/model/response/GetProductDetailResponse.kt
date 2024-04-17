package com.example.ecommerce.data.model.response


import com.example.ecommerce.data.model.Product

data class GetProductDetailResponse(
    val message: String?,
    val product: Product,
    val status: Int?
)