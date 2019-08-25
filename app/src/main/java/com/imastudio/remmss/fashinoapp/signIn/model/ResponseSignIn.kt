package com.imastudio.remmss.fashinoapp.signIn.model

import com.google.gson.annotations.SerializedName

data class ResponseSignIn(

	@field:SerializedName("pesan")
	val pesan: String? = null,

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("sukses")
	val sukses: Boolean? = null
)