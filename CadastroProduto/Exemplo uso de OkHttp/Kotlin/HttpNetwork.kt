package com.example.appwebserviceokhttp3

/*lembrar de add  implementation "com.squareup.okhttp3:okhttp:3.10.0" no
buid.gradle (Module:app)*/
import okhttp3.*
import java.io.InputStream

/*Não funciona sem adicionar a permisão no Manifest
* <uses-permission android:name="android.permission.INTERNET" />
*/
class HttpNetwork{
    //método para obter dados do servidor
    fun get(url: String): InputStream {
        val request = Request.Builder().url(url).get().build();
        val response = OkHttpClient().newCall(request).execute()
        val body = response.body()
        return body!!.byteStream()
    }
    
    //método para enviar dados para o servidor
    fun post(url: String, json: String): InputStream{
        val json_format = "application/json; charset=utf-8"
        val body = RequestBody.create(MediaType.parse(json_format), json)
        val request = Request.Builder().url(url).post(body).build()
        val response = OkHttpClient().newCall(request).execute()
        val body2 = response.body()
        return body2!!.byteStream()

    }
}