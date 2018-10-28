package br.com.rafael.main.di.module

import br.com.rafael.main.repository.network.API
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
object NetworkModule {

    private const val URL_BASE_SERVICE = "https://bank-app-test.herokuapp.com/api/"
    private const val TIME_OUT_SECONDS = 10L
    private val logging = HttpLoggingInterceptor()

    @Provides
    internal fun provideBankAppApi(retrofit: Retrofit): API {
        return retrofit.create(API::class.java)
    }


    @Provides
    internal fun provideRetrofitInterface(): Retrofit {

        return Retrofit.Builder()
            .baseUrl(URL_BASE_SERVICE)
            .addConverterFactory(GsonConverterFactory.create())
            .client(makeHtppClient())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
    }


    private fun makeHtppClient(): OkHttpClient {


        var build = OkHttpClient.Builder().connectTimeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)

        build.addInterceptor(logging.setLevel(HttpLoggingInterceptor.Level.BODY))



        return build.build()
    }
}