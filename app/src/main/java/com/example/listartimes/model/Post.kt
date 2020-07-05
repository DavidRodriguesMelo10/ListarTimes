package com.example.listartimes.model

import com.google.gson.annotations.SerializedName

data class Post (

    @SerializedName("time_id")
    var time_id : Int,
    @SerializedName("nome_popular")
    var nome_popular : String,
    @SerializedName("nome")
    var nome : String,
    @SerializedName("sigla")
    var sigla : String,
    @SerializedName("apelido")
    var apelido : String
    )
