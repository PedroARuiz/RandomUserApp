package org.edrodev.randomuserapp.data.remote

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

fun buildApiClient(
    baseUrl: String,
    okHttpClient: OkHttpClient,
    jsonParser: Json,
):Retrofit = Retrofit.Builder()
    .baseUrl(baseUrl)
    .client(okHttpClient)
    .addConverterFactory(jsonParser.asConverterFactory("application/json".toMediaType()))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .build()

fun buildOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
    .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
    .build()

fun buildJsonParser(): Json = Json {
    ignoreUnknownKeys = true
}
