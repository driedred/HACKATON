package api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL = "https://api.oilpriceapi.com/v1/"
    private const val API_KEY = "AIzaSyB9ZuFjBU2lXzfWubCncEEJKRVt77rPMR4"  // Замените на свой API ключ

    // Создание кастомного OkHttpClient с добавлением Interceptor для авторизации
    private val client = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer $API_KEY")  // Добавляем API ключ в заголовки
                .build()
            chain.proceed(request)
        }
        .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
        .build()

    // Создание Retrofit экземпляра
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // Создание экземпляра ApiService
    val apiService: ApiService = retrofit.create(ApiService::class.java)
    val api_key:String= API_KEY
}
