package com.example.appcadprod_testes
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView

class DeletarActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deletar)

        setTitle("Deletar Produtos")

        val myListAdapter = CustomListBtDel(this, arrayOf("a", "b", "c"), App.produtos)
        var listView = findViewById(R.id.listView) as ListView
        listView.adapter = myListAdapter

    }
}