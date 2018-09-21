package com.mani.apps.mykotlin

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class CartViewModelNew : ViewModel() {

    private var personList = MutableLiveData<MutableList<Person>>()

    fun getPersonList() : MutableLiveData<MutableList<Person>> {
        personList = CartModelNew.getPersonList()
        return personList
    }

}