package api

import kz.ada.app2.OilPriceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    // Получение исторических данных о ценах на нефть
    @GET("historical-prices")  // Замените на реальный путь к вашему API
    fun getHistoricalPrices(): Call<List<OilPriceResponse>>

    // Получение прогноза цен на нефть
    @GET("price-forecast")  // Замените на реальный путь к вашему API
    fun getPriceForecast(): Call<List<OilPriceResponse>>

    // Получение новостей и аналитики отрасли
    @GET("industry-news")  // Замените на реальный путь к вашему API
    fun getIndustryNews(): Call<List<String>>
}