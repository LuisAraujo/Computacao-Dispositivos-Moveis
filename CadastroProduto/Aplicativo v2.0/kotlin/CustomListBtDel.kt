package com.example.appcadprod_testes


import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.*
import java.io.IOException

class CustomListBtDel(private val context: Activity, private val titulos: Array<String>, private val produtos: ArrayList<Produto>)
    : ArrayAdapter<Produto>(context, R.layout.button_custom, produtos) {

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.button_custom, null, true)

        val titleText = rowView.findViewById(R.id.inptext_del) as TextView
        val buttonDel = rowView.findViewById(R.id.btprod_del) as Button

        titleText.text = produtos[position].nome

        buttonDel.setOnClickListener {
                var app = App
                try {
                    if( app.produtos.remove(produtos[position])){
                        Toast.makeText(context, "Item Deletado", Toast.LENGTH_LONG).show()
                        this.notifyDataSetChanged()
                    }else
                        Toast.makeText(context, "o Item Não Deletado", Toast.LENGTH_LONG).show()

                }catch (e: IOException){
                    Toast.makeText(context, "Ocorreu um erro ao deletar produto", Toast.LENGTH_LONG).show()
                }
            }
        return rowView
    }

}