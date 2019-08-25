package com.imastudio.remmss.fashinoapp.home.produk.modelProduk

import com.google.gson.annotations.SerializedName

data class ResponseProduk(

	@field:SerializedName("pesan")
	val pesan: String? = null,

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("sukses")
	val sukses: Boolean? = null
)