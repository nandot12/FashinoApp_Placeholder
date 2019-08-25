package com.imastudio.remmss.fashinoapp.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.imastudio.remmss.fashinoapp.data.Product
import com.imastudio.remmss.fashinoapp.data.ProductDao

@Database(entities = arrayOf(Product::class), version = 1)
abstract class ProductDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao

    companion object {
        private var INSTANCE: ProductDatabase? = null

        fun getInstance(context: Context): ProductDatabase? {
            if (INSTANCE == ProductDatabase::class) {

                synchronized(ProductDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            ProductDatabase::class.java, "product.db"
                    )
                            .build()
                }
            }


            return INSTANCE


        }

        fun destroyInstance() {
            INSTANCE = null
        }

    }
}