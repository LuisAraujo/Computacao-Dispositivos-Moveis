package com.example.appcadprod_testes

object App{
    internal var produtos: ArrayList<Produto> = ArrayList()

    fun getProdutosSize() : Int{
        return produtos.size;
    }
}