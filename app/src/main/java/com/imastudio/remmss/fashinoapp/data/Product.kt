package com.imastudio.remmss.fashinoapp.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "product")
class Product {
    @ColumnInfo(name = "name")
    var name: String = ""
    @ColumnInfo(name = "harga")
    var harga: String = ""
    @ColumnInfo(name = "stok")
    var stok: String = ""
    @ColumnInfo(name = "categori")
    var categori: String = ""
    @ColumnInfo(name = "ratting")
    var ratting: String = ""
    @ColumnInfo(name = "desc")
    var desc: String = ""
    @ColumnInfo(name = "photo")
    var photo: String = ""
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id:Long = 0
}