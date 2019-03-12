package com.example.cadastroproduto

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.support.v7.app.AlertDialog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        var app: App = App()
        //add produto
        /*var p: Produto = Produto("celular",2000.0, Categoria.MOBILE, "Celular Sansung J4+")
        app.produtos.add(p);*/

        var spinner = findViewById(R.id.spinnercategorias) as Spinner

        /*val adapter = ArrayAdapter.createFromResource(this,
            R.array.categorias, android.R.layout.simple_spinner_item)*/

        var categorias: ArrayList<Categoria> =
            arrayListOf(Categoria.MOBILE, Categoria.BAGS, Categoria.COMPUTADORES, Categoria.DISPOSITIVOS)

        val adapter = ArrayAdapter<Categoria>(this, android.R.layout.simple_spinner_item, categorias)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter


        var btcadastrar = findViewById(R.id.btcadastrar) as Button
        btcadastrar.setOnClickListener({

            var nome = findViewById(R.id.inpnome) as EditText
            var desc = findViewById(R.id.inpdesc) as EditText
            var preco = findViewById(R.id.inppreco) as EditText
            var categ = findViewById(R.id.spinnercategorias) as Spinner

            var p: Produto = Produto(
                nome = nome.text.toString(), preco = preco.text.toString().toDouble(),
                descricao = desc.toString(), categoria = categ.getSelectedItem() as Categoria)

            app.produtos.add(p);

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Ok")
            builder.setMessage("Produto Cadastrado com Sucesso")
            builder.show()
        })
    }
}
