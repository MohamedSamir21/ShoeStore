package com.example.shoestore

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class ItemDetail(var name: String? = null, var company: String? = null, var size: String? = null, var description: String? = null)

class ShoeViewModel: ViewModel() {

    private val _shoes = MutableLiveData<ItemDetail>()
    val shoes: LiveData<ItemDetail>
        get() = _shoes

     var shoesList: MutableList<ItemDetail>?
     val shoeListw: MutableList<ItemDetail>?
        get() = shoesList

     lateinit var itemDetail: ItemDetail

    init {
        shoesList = null
        var itemDetail =  ItemDetail()
        shoesList = mutableListOf()
    }
    fun add(name: String, company: String, size: String, description: String){
        itemDetail = ItemDetail(name, company, size, description)
        _shoes.value = itemDetail

        shoesList?.add(itemDetail)

        Log.i("ShoeViewModel", "{${shoesList}}")
    }

}