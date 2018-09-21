package com.mani.apps.mykotlin

class CartViewModel {

    var navigator: Navigator? = null

    fun addPerson(name: String, gender: Boolean, dob: String) {
        val person = Person(name, gender, dob)
        CartModelNew.addPerson(person)
    }

    fun addPerson() {
        navigator?.addPerson()
    }

    fun showList() {
        navigator?.showList()
    }

}