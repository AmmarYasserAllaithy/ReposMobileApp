package app.ammar.rippletask.di.module

import android.content.Context
import app.ammar.rippletask.BuildConfig
import app.ammar.rippletask.data.api.ApiHelper
import app.ammar.rippletask.data.api.ApiHelperImpl
import app.ammar.rippletask.data.api.ApiService
import app.ammar.rippletask.utils.NetworkHelper
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val appModule = module {
    single { provideOkHttpClient() }
    single { provideRetrofit(get(), BuildConfig.BASE_URL) }
    single { provideApiService(get()) }
    single { provideNetworkHelper(androidContext()) }

    single<ApiHelper> { return@single ApiHelperImpl(get()) }
}


private fun provideNetworkHelper(context: Context) = NetworkHelper(context)


private fun provideOkHttpClient() =
    if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

    } else OkHttpClient.Builder().build()


private fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL: String) =
    Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()


private fun provideApiService(retrofit: Retrofit) = retrofit.create(ApiService::class.java)
