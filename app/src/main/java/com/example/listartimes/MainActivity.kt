package com.example.listartimes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.listartimes.data.NetworkUtils
import com.example.listartimes.model.Endpoint
import com.example.listartimes.model.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getData()
    }

    fun getData() {
        val retrofitClient = NetworkUtils
            .getRetro("https://api.api-futebol.com.br/v1/")

        val endpoint = retrofitClient.create(Endpoint::class.java)
        val callback = endpoint.getPosts()

        callback.enqueue(object : Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                response.body()!!.forEach {
                    textView.text = textView.text.toString().plus(it.body)
                }
            }
        })

    }
}