package com.example.appcadprod_testes
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast

class CustomAdapter(private var c: Context, private var produtos: ArrayList<Produto>) : BaseAdapter(){

    override fun getCount(): Int   {  return produtos.size  }
    override fun getItem(i: Int): Any {  return produtos[i] }
    override fun getItemId(i: Int): Long { return i.toLong()}

    override fun getView(i: Int, view: View,
                         viewGroup: ViewGroup): View {

        return view

    }
}