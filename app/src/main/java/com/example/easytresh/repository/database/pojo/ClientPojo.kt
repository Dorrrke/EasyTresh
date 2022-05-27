package com.example.easytresh.repository.database.pojo

import com.google.gson.annotations.SerializedName

data class ClientPojo(

	@field:SerializedName("ClientPojo")
	val clientPojo: List<ClientPojoItem?>? = null
)

data class ClientPojoItem(

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("phone")
	val phone: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("registrationDate")
	val registrationDate: String? = null,

	@field:SerializedName("userId")
	val userId: Int? = null
)
