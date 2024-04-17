package com.example.ecommerce.data.source.remote


import com.example.ecommerce.common.Constants.Endpoint.ADD_TO_CART
import com.example.ecommerce.common.Constants.Endpoint.CLEAR_CART
import com.example.ecommerce.common.Constants.Endpoint.DELETE_FROM_CART
import com.example.ecommerce.common.Constants.Endpoint.GET_ALL_PRODUCTS
import com.example.ecommerce.common.Constants.Endpoint.GET_CART_PRODUCTS
import com.example.ecommerce.common.Constants.Endpoint.GET_PRODUCT_DETAIL
import com.example.ecommerce.common.Constants.Endpoint.GET_SALE_PRODUCTS
import com.example.ecommerce.common.Constants.Endpoint.SEARCH_PRODUCT
import com.example.ecommerce.data.model.request.AddToCartRequest
import com.example.ecommerce.data.model.request.ClearCartRequest
import com.example.ecommerce.data.model.request.DeleteFromCartRequest
import com.example.ecommerce.data.model.response.CRUDResponse
import com.example.ecommerce.data.model.response.GetCartProductsResponse
import com.example.ecommerce.data.model.response.GetProductDetailResponse
import com.example.ecommerce.data.model.response.GetProductResponse
import com.example.ecommerce.data.model.response.GetSaleProductResponse
import com.example.ecommerce.data.model.response.GetSearchProductResponse
import com.example.ecommercea.common.Constants.Endpoint.GET_ALL_PRODUCTS
import com.example.ecommercea.data.model.request.AddToCartRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query


interface ProductService {

    @Headers("store:food")
    @GET(GET_ALL_PRODUCTS)
    suspend fun getAllProducts(): GetProductResponse

    @Headers("store:food")
    @GET(GET_PRODUCT_DETAIL)
    suspend fun getProductDetail(
        @Query("id") id: Int
    ): GetProductDetailResponse

    @Headers("store:food")
    @GET(GET_SALE_PRODUCTS)
    suspend fun getSaleProducts(): GetSaleProductResponse

    @Headers("store:food")
    @GET(SEARCH_PRODUCT)
    suspend fun getSearchProduct(
        @Query("query") query: String
    ): GetSearchProductResponse

    @Headers("store:food")
    @POST(ADD_TO_CART)
    suspend fun addToCart(
        @Body addToCartRequest: AddToCartRequest
    ): CRUDResponse

    @Headers("store:food")
    @GET(GET_CART_PRODUCTS)
    suspend fun getCartProducts(
        @Query("userId") userId: String
    ): GetCartProductsResponse

    @Headers("store:food")
    @POST(DELETE_FROM_CART)
    suspend fun deleteFromCart(
        @Body deleteFromCartRequest: DeleteFromCartRequest
    ): CRUDResponse

    @Headers("store:food")
    @POST(CLEAR_CART)
    suspend fun clearCart(
        @Body clearCartRequest: ClearCartRequest
    ) : CRUDResponse

}