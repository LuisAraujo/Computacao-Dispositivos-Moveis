package com.example.appwebserviceokhttp3

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
//importante
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStreamReader
import org.json.JSONArray


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GetJsonWithOkHttpClient(this.text).execute();
    }
    //classe interna
    open class GetJsonWithOkHttpClient(textView: TextView) : AsyncTask<Unit, Unit, String>() {

        val myTextView = textView
        val url_server = "https://server2.planetgroupbd.com/ords/pepsi/v1/outlet/118786"

        override fun doInBackground(vararg params: Unit?): String? {
            val networkClient = HttpNetwork()
            val stream = BufferedInputStream( networkClient.get(url_server) )
            //retornando uma string
            return readStream(stream)
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)

            val l:List<MyObject>
            if(result != null) {
                l = parseJson(result)
                if(l.size > 0)
                    myTextView.text = l.get(0).id;
            }else
            myTextView.text = "sem resultados"
        }


        //converte para uma string
        fun readStream(inputStream: BufferedInputStream): String {
            val bufferedReader = BufferedReader(InputStreamReader(inputStream))
            val stringBuilder = StringBuilder()
            bufferedReader.forEachLine { stringBuilder.append(it) }
            return stringBuilder.toString()
        }

        fun parseJson(json: String): List<MyObject>{
            var oarray = mutableListOf<MyObject>()
            //para teste!!!
            /*var json2 = "[{ " +
                    "\"id\": 117150,\"attr\": \"Kuiskura\"" +
                    "}]"*/
            val jarray = JSONArray(json)

            for(i  in 0 until  jarray.length()){
                val jsonObject = jarray.getJSONObject(i)
                //criando um novo objeto
                val o = MyObject()
                //atribuindo os atributos
                o.id = jsonObject.optString("id")
                o.attr = jsonObject.optString("attr")
                //adicionando na lista
                oarray.add(o)
            }

            return oarray;

        }
    }



}
