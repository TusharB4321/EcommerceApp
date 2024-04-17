package com.example.ecommerce.di

import com.example.ecommerce.data.repository.ProductRepository
import com.example.ecommerce.data.source.local.ProductDao
import com.example.ecommerce.data.source.remote.ProductService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesProductRepository(
        productService: ProductService,
        productDao: ProductDao
    ): ProductRepository =
        ProductRepository(productService, productDao)


}