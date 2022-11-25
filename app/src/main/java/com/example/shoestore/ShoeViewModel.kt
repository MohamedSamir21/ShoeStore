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

     private var _shoesList: MutableList<ItemDetail>?
     val shoesList: MutableList<ItemDetail>?
        get() = _shoesList

     lateinit var itemDetail: ItemDetail

    init {
        _shoesList = null
        _shoesList = mutableListOf()
    }

    fun add(name: String, company: String, size: String, description: String){
        itemDetail = ItemDetail(name, company, size, description)
        _shoes.value = itemDetail

        _shoesList?.add(itemDetail)
    }

}