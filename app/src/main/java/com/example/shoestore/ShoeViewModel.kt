package com.example.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class ItemDetail(
    var name: String,
    var company: String,
    var size: String,
    var description: String
)

class ShoeViewModel : ViewModel() {

    private val _shoes = MutableLiveData<ItemDetail>()
    val shoes: LiveData<ItemDetail>
        get() = _shoes

    private var _shoesList: MutableList<ItemDetail>? = null
    val shoesList: MutableList<ItemDetail>?
        get() = _shoesList

    lateinit var itemDetail: ItemDetail

    init {
        _shoesList = mutableListOf()
    }

    fun add(name: String, company: String, size: String, description: String) {
        itemDetail = ItemDetail(name, company, size, description)
        _shoes.value = itemDetail

        _shoesList?.add(itemDetail)
    }

}