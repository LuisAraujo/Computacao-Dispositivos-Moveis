package com.example.cadastroproduto

class Produto (
    internal var nome:String,
    internal var preco: Double,
    internal var categoria: Categoria,
    internal var descricao: String )
{

    override  fun toString(): String{
        return this.nome
    }
}
