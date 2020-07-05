package com.example.listartimes.model

import retrofit2.Call
import retrofit2.http.GET

interface Endpoint {


    @GET("posts")
    fun getPosts() : Call<List<Post>>
}