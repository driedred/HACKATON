package api

import okhttp3.Interceptor
import okhttp3.Response

// Класс Interceptor для добавления API ключа в заголовки запросов
class AuthInterceptor(private val apiKey: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        // Создаем новый запрос, добавляя API-ключ в заголовки
        val request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer $apiKey")  // Добавляем API ключ
            .build()
        // Передаем запрос дальше по цепочке
        return chain.proceed(request)
    }
}