package com.imastudio.remmss.fashinoapp.signUp.model

import com.google.gson.annotations.SerializedName

data class ResponseSignUp(

	@field:SerializedName("pesan")
	val pesan: String? = null,

	@field:SerializedName("sukses")
	val sukses: Boolean? = null
)