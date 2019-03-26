package com.example.appcadprod_testes

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle("Menu Principal")

        var app = App
        /*teste*/
        app.produtos.add(Produto("Mochila", 200.0, Categoria.Bags, "Mochila para notebook"))
        app.produtos.add(Produto("Notebook DELL", 2000.0, Categoria.Computadores, "4GB de Ram, 1 TB de HD ..."))
        app.produtos.add(Produto("Sansung S10", 4000.0, Categoria.Mobile, "Lançamento da Sansung"))


        var btCadastrar = findViewById(R.id.btcad) as Button
        var btListar = findViewById(R.id.btlist) as Button
        var btDeletar = findViewById(R.id.btdel) as Button
        val contexto: Context = this

        btCadastrar.setOnClickListener{
            val int = Intent(contexto, CadastrarActivity::class.java)
            startActivity(int)
        }

        btListar.setOnClickListener{
            val int = Intent(contexto, ListarActivity::class.java)
            startActivity(int)
        }


        btDeletar.setOnClickListener{
            val int = Intent(contexto, DeletarActivity::class.java)
            startActivity(int)
        }





    }
}
