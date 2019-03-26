package com.example.appcadprod_testes

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class ListarActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar)
        setTitle("Listar Produtos")
        var app = App

        val myListAdapter = CustomList(this, arrayOf("a", "b", "c"), App.produtos)
        var listView = findViewById(R.id.listview) as ListView
        listView.adapter = myListAdapter


        /*var listView = findViewById(R.id.listview) as ListView
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, app.produtos)
        listView.adapter = adapter*/
    }
}