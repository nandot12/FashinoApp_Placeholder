package com.imastudio.remmss.fashinoapp.home.produk.modelProduk

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class DataItem : Serializable {

    @field:SerializedName("produk_toko")
    val produkToko: String? = null

    @field:SerializedName("produk_kategori")
    val produkKategori: String? = null

    @field:SerializedName("produk_harga")
    val produkHarga: String? = null

    @field:SerializedName("produk_nama")
    val produkNama: String? = null

    @field:SerializedName("produk_stok")
    val produkStok: String? = null

    @field:SerializedName("produk_id")
    val produkId: String? = null

    @field:SerializedName("produk_ratting")
    val produkRatting: String? = null

    @field:SerializedName("produk_desc")
    val produkDesc: String? = null

    @field:SerializedName("produk_status")
    val produkStatus: String? = null

    @field:SerializedName("produk_photo")
    val produkPhoto: String? = null
}