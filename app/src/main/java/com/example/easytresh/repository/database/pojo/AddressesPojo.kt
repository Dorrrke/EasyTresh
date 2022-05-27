package com.example.easytresh.repository.database.pojo

import com.google.gson.annotations.SerializedName

data class AddressesPojo(

	@field:SerializedName("AddressesPojo")
	val addressestPojo: List<AddressesPojoItem?>? = null
)

data class AddressesPojoItem(

	@field:SerializedName("country")
	val country: String? = null,

	@field:SerializedName("frontDoor")
	val frontDoor: Int? = null,

	@field:SerializedName("clientId")
	val clientId: Int? = null,

	@field:SerializedName("city")
	val city: String? = null,

	@field:SerializedName("street")
	val street: String? = null,

	@field:SerializedName("flat")
	val flat: Int? = null,

	@field:SerializedName("houseNumber")
	val houseNumber: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("floor")
	val floor: Int? = null,

	@field:SerializedName("frame")
	val frame: Int? = null
)
