package com.jeremieguillot.olympicgame.data.network.response

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Types
import retrofit2.Response

//inline fun <reified T> getJsonListDataFromResource(jsonName: String): List<T> {
//    val jsonFile = ClassLoader.getSystemResource(jsonName).readText()
//    val parameterizedType =
//        Types.newParameterizedType(Response::class.java, T::class.java)
//    val jsonAdapter: JsonAdapter<Response<T>> = getMoshi().adapter(parameterizedType)
//    return jsonAdapter.fromJson(jsonFile)?.body() ?: throw Exception("Invalid json to parse")
//}

inline fun <reified T> getResponseDataFromResource(jsonName: String): T {
    val jsonFile = ClassLoader.getSystemResource(jsonName).readText()
    val parameterizedType = Types.newParameterizedType(Response::class.java, T::class.java)
    val jsonAdapter: JsonAdapter<Response<T>> = getMoshi().adapter(parameterizedType)
    val response = jsonAdapter.fromJson(jsonFile) ?: throw Exception("Invalid json to parse")
    return response.body() ?: throw Exception("Response body is null")
}


inline fun <reified T> getJsonDataFromResource(jsonName: String): T {
    val jsonFile = ClassLoader.getSystemResource(jsonName).readText()
    val parameterizedType = Types.newParameterizedType(Response::class.java, T::class.java)
    val jsonAdapter: JsonAdapter<Response<T>> = getMoshi().adapter(parameterizedType)
    return jsonAdapter.fromJson(jsonFile)?.body() ?: throw Exception("Invalid json to parse")
}