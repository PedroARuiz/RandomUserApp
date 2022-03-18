package org.edrodev.randomuserapp.data.remote.di

import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import org.edrodev.randomuserapp.BuildConfig
import org.edrodev.randomuserapp.data.remote.buildApiClient
import org.edrodev.randomuserapp.data.remote.buildJsonParser
import org.edrodev.randomuserapp.data.remote.buildOkHttpClient
import org.koin.dsl.module

val remoteModule = module {
    single {
        buildApiClient(
            baseUrl = BuildConfig.HOST,
            jsonParser = get(),
            okHttpClient = get(),
        )
    }

    single<Json> { buildJsonParser() }
    single<OkHttpClient> { buildOkHttpClient() }
}