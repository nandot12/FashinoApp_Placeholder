package com.imastudio.remmss.fashinoapp.home.produk.modelKategori

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class DataItem : Serializable {

	@field:SerializedName("kategori_id")
	val kategoriId: String? = null

	@field:SerializedName("kategori_keterangan")
	val kategoriKeterangan: String? = null

	@field:SerializedName("kategori_nama")
	val kategoriNama: String? = null

	@field:SerializedName("kategori_photo")
	val kategoriPhoto: String? = null

}