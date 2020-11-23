package cz.blackchameleon.vanocka.di

import cz.blackchameleon.vanocka.UrlConst.BASE_URL
import cz.blackchameleon.vanocka.framework.CartApi
import cz.blackchameleon.vanocka.framework.ProductApi
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

/**
 * @author Karolina Klepackova on 23.11.2020.
 */
val retrofitModule = module {
    single { provideDefaultOkhttpClient() }
    single { provideRetrofit(get()) }

    single { provideRetrofitService<ProductApi>(get()) }
    single { provideRetrofitService<CartApi>(get()) }
}

// Creates new Okhttp client for API calls
private fun provideDefaultOkhttpClient(): OkHttpClient =
    OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.MINUTES)
        .readTimeout(5, TimeUnit.MINUTES)
        .build()


// Creates an instance of retrofit for given OkHttpClient
private fun provideRetrofit(client: OkHttpClient): Retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .client(client)
    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
    .build()

// Extension function for creating retrofit service
private inline fun <reified T> provideRetrofitService(retrofit: Retrofit): T =
    retrofit.create(T::class.java)