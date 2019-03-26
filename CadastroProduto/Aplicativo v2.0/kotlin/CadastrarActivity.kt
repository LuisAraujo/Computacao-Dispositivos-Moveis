package com.example.appcadprod_testes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.*
import java.lang.NumberFormatException

class CadastrarActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastra)
        setTitle("Cadastrar Produto")

        var app: App = App

        var btCadastrar = findViewById(R.id.btcad) as Button
        var inpNome = findViewById(R.id.inpnome) as EditText
        var inpPreco = findViewById(R.id.inppreco) as EditText
        var inpDesc = findViewById(R.id.inpdesc) as EditText
        var inpCat = findViewById(R.id.inpcat) as Spinner

        //array de categorias
        var arrayCat: ArrayList<Categoria> = arrayListOf(
            Categoria.Bags, Categoria.Computadores, Categoria.Mobile
        )

        val adaptador = ArrayAdapter<Categoria>(
            this, android.R.layout.simple_spinner_item,
            arrayCat
        )

        adaptador.setDropDownViewResource(
            android.R.layout.simple_dropdown_item_1line
        )

        inpCat.adapter = adaptador

        btCadastrar.setOnClickListener{

            var nome = inpNome.text.toString()
            var preco: Double
            var descricao = inpDesc.toString()
            var categoria = inpCat.getSelectedItem() as Categoria

            try {
                preco = inpPreco.text.toString().toDouble()
            }catch(e: NumberFormatException) {
                Toast.makeText(this, "Preco deve ser um número válido", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if((nome =="") || (descricao == "") || (categoria == null)){
                Toast.makeText(this, "Todos os campos são obrigatórios", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            var p = Produto(nome, preco, categoria, descricao)

            if(app.produtos.add(p)){
                Toast.makeText(this, "Produto Cadastrado com Sucesso", Toast.LENGTH_LONG).show()
                 inpNome.setText("")
                 inpPreco.setText("")
                 inpDesc.setText("")
            }else{
                Toast.makeText(this, "Erro ao Cadastrar Produto", Toast.LENGTH_LONG).show()
            }

        }


    }
}
