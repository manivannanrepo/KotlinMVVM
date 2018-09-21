package com.mani.apps.mykotlin

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), Navigator, Observer {

    override fun showList() {
        startActivity(Intent(this, CartActivity::class.java))
    }

    var gender = true
    var cartViewModel = CartViewModel()
    var preText = "Mr"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        cartViewModel.navigator = this

        name_edittext.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {


                if (s.toString().length == 0)
                    name_text.text = ""
                else
                    name_text.text = """$preText $s"""
            }

        })

        genderRadioGroup.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                if (checkedId == male.id) {
                    preText = "Mr."
                    gender = true
                } else {
                    preText = "Ms."
                    gender = false
                }
                name_edittext.text = name_edittext.text
            }

        })

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        dob.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val datePickerDialog = DatePickerDialog(this@MainActivity, dateSetListener, year, month, day)
                datePickerDialog.show()
            }
        })

        submit.setOnClickListener(View.OnClickListener { v-> addPerson() } )
        view_list.setOnClickListener(View.OnClickListener { v-> showList() } )

    }

    @SuppressLint("SetTextI18n")
    val dateSetListener = DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
        dob.text = """$dayOfMonth/$monthOfYear/$year"""
    }


    override fun addPerson() {
        if (name_text.text.length == 0) {
            Toast.makeText(this@MainActivity, "please enter name", Toast.LENGTH_LONG).show()
            return
        }
        Log.i("MainActivity", "dob : " + dob.text.toString())

        if (dob.text.toString().equals("D.O.B", true)) {
            Toast.makeText(this@MainActivity, "please enter date of birth", Toast.LENGTH_LONG).show()
            return
        }
        cartViewModel.addPerson(name_edittext.text.toString(), gender, dob.text.toString())
    }

    override fun update(o: Observable?, arg: Any?) {
        Toast.makeText(this, CartModelNew.getPersonList().value!!.size.toString() + "", Toast.LENGTH_LONG).show()
    }



}

