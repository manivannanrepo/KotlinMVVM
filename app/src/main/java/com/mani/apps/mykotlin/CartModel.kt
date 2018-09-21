package com.mani.apps.mykotlin

import kotlin.properties.Delegates
import kotlin.properties.Delegates.observable

class CartModel  {
    var productList = mutableListOf<Person>()

    fun addPerson (person: Person){
        productList.add(person)
    }

}