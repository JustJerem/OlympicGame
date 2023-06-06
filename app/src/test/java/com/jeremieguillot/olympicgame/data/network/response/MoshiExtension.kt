package com.jeremieguillot.olympicgame.data.network.response

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.lang.reflect.Type


// DATA TO JSON
fun toJson(data: List<Any>): String {
    return getMoshi().adapter<List<Any>>(
        Types.newParameterizedType(
            MutableList::class.java,
            Any::class.java
        )
    )
        .toJson(data)
}

fun toJsonList(data: Any): String {
    return toJson(listOf(data))
}

fun toJson(data: Any): String {
    return getMoshi().adapter(Any::class.java).toJson(data)
}

// / JSON TO DATA

inline fun <reified K> jsonToList(data: String): List<K> {

    val listType: Type = Types.newParameterizedType(
        MutableList::class.java,
        K::class.java
    )
    val adapter: JsonAdapter<List<K>> = getMoshi().adapter(listType)
    return adapter.fromJson(data) ?: emptyList()
}

inline fun <reified K> jsonToData(data: String): K {
    val jsonAdapter: JsonAdapter<K> = getMoshi().adapter(K::class.java)
    return jsonAdapter.fromJson(data) ?: throw Exception("Invalid json to parse")
}

fun getMoshi(): Moshi =
    Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()