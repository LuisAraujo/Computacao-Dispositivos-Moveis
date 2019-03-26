package com.example.appcadprod_testes

class Produto(internal  var nome: String,
              internal  var preco: Double?,
              internal  var categoria: Categoria,
              internal  var descricao: String){


    override fun toString(): String{
        return nome
    }
}

