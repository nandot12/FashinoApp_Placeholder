package com.imastudio.remmss.fashinoapp.home.produk.modelKategori

import com.google.gson.annotations.SerializedName

data class ResponseKategori(

	@field:SerializedName("pesan")
	val pesan: String? = null,

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("sukses")
	val sukses: Boolean? = null
)