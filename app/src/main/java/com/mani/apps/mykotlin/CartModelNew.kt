package com.mani.apps.mykotlin

import android.arch.lifecycle.MutableLiveData

object CartModelNew {

    private var personList = MutableLiveData<MutableList<Person>>()

    init {
        personList.value = mutableListOf()
    }

    fun addPerson(person: Person): MutableLiveData<MutableList<Person>> {
        personList.value?.add(person)
        return personList
    }
    fun getPersonList(): MutableLiveData<MutableList<Person>>{
        return personList
    }
}