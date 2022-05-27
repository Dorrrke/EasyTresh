package com.example.easytresh.repository.database.pojo

import com.google.gson.annotations.SerializedName

data class NotRelevantOrdersPojo(

	@field:SerializedName("NotRelevantOrdersPojo")
	val notRelevantOrdersPojo: List<NotRelevantOrdersPojoItem?>? = null
)

data class NotRelevantOrdersPojoItem(

	@field:SerializedName("date")
	val date: String? = null,

	@field:SerializedName("trashType")
	val trashType: String? = null,

	@field:SerializedName("workerId")
	val workerId: Int? = null,

	@field:SerializedName("clientId")
	val clientId: Int? = null,

	@field:SerializedName("size")
	val size: String? = null,

	@field:SerializedName("orderId")
	val orderId: Int? = null,

	@field:SerializedName("relevance")
	val relevance: Boolean? = null,

	@field:SerializedName("addressId")
	val addressId: Int? = null
)
