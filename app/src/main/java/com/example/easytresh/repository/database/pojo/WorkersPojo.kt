package com.example.easytresh.repository.database.pojo

import com.google.gson.annotations.SerializedName

data class WorkersPojo(

	@field:SerializedName("WorkersPojo")
	val workersPojo: List<WorkersPojoItem?>? = null
)

data class WorkersPojoItem(

	@field:SerializedName("workerId")
	val workerId: Int? = null,

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("phone")
	val phone: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("registrationDate")
	val registrationDate: String? = null
)
