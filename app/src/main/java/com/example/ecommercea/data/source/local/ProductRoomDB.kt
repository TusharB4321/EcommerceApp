package com.example.ecommercea.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ecommercea.data.model.ProductEntity
import com.example.taptaze.data.model.ProductEntity

@Database(entities = [ProductEntity::class], version = 1)
abstract class ProductRoomDB : RoomDatabase() {
    abstract fun productDao(): ProductDao
}