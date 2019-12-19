package com.example.myshop

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*

@Entity
data class ProductItem(@PrimaryKey(autoGenerate = true) var id:Int=0, var name:String, var cost:Int, var desc:String) {
}

//create Database Access Object
@Dao
interface ProductItemsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertProduct(contacts: ProductItem)

    @Query("SELECT * FROM ProductItem WHERE id LIKE:id")
    fun getProductId(id:Int): LiveData<ProductItem>

    @Query("SELECT * FROM ProductItem ")
    fun getAllProducts(): LiveData<List<ProductItem>>

    @Query("DELETE FROM ProductItem WHERE id LIKE:id")
    fun deleteProduct(id:Int)
}

//create database
@Database(entities = [ProductItem::class],
    version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun productsDao(): ProductItemsDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance
            ?: synchronized(LOCK) {
                instance
                    ?: buildDatabase(context).also { instance = it }
            }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
            AppDatabase::class.java, "myshop.db")
            .build()
    }
}

//dependencies
/*
apply plugin: 'kotlin-kapt'
* //room
    implementation "androidx.room:room-runtime:2.1.0-alpha01"
    annotationProcessor 'androidx.room:room-compiler:2.0.0'
    kapt 'androidx.room:room-compiler:2.0.0'
    *

*
*
* */