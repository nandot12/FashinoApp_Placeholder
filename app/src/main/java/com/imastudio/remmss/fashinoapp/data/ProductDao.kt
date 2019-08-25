package com.imastudio.remmss.fashinoapp.data

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE

@Dao
interface ProductDao{

    @Query("SELECT * from product")
    fun getAll(): List<Product>

    @Insert(onConflict = REPLACE)
    fun insert(product:Product)

    @Delete
    fun delete(product: Product)

//    @Query("UPDATE product SET name =:studentName, nim =:studentNim, gender =:studentGen WHERE id =:studentId")
//    fun update(studentId: Long, studentName:String, studentNim:String, studentGen:String)

}