package com.example.listartimes.data

import com.example.listartimes.model.Endpoint
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkUtils {

    companion object {

        /** Retorna uma Instância do Client Retrofit para Requisições
         * @param path Caminho Principal da API
         */
       // private const val BASE_URL = " https://api.api-futebol.com.br/v1/ "
        fun getRetro(accessToken: String,path : String): Endpoint {
            val client = OkHttpClient.Builder()
                .addInterceptor(OAuthInterceptor("test_407ed37e2ed5ea2b77642fcdebb9b8", accessToken))
                .build()

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(path)
                .client(client)
                .build()

            return retrofit.create(Endpoint::class.java)
        }
    }
}
