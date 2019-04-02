package com.example.appcadprod_testes


import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.*
import java.io.IOException

class CustomList(private val context: Activity, private val titulos: Array<String>, private val produtos: ArrayList<Produto>)
    : ArrayAdapter<Produto>(context, R.layout.list_custom, produtos) {

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.list_custom, null, true)

        val titleText = rowView.findViewById(R.id.titletext_lis) as TextView
        val descText = rowView.findViewById(R.id.desctext_lis) as TextView

        titleText.text = "${produtos[position].nome} - R$ ${produtos[position].preco}"
        descText.text = produtos[position].descricao


        return rowView
    }

}