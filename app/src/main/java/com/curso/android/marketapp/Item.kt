package com.curso.android.marketapp

class Item(itemImg: Int, itemName: String, itemDescription: String) {
    private val _itemImg: Int = itemImg
    private val _itemName: String = itemName
    private val _itemDescription: String = itemDescription

    fun getItemImg(): Int {
        return _itemImg
    }

    fun getItemName(): String {
        return _itemName
    }

    fun getItemDescription(): String {
        return _itemDescription
    }
}
