package com

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.pizza_delivery.R

class HomeScreen : AppCompatActivity() {
    private lateinit var firstName : EditText
    private lateinit var lastName : EditText
    private lateinit var address : EditText
    private lateinit var textPrice : TextView
    private lateinit var btnOrder : Button
    private lateinit var error : TextView
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen2)
        var priceType=0
        var priceingrediant=0
        var type=""
        var ingridiant1=""
        var ingridiant2=""
        var ingridiant3=""
        var ingridiant4=""
        var errorMsg=""
        textPrice=findViewById(R.id.tvPrice)
        firstName=findViewById(R.id.etName)
        firstName.hint="first name"
        lastName=findViewById(R.id.eTLast)
        lastName.hint="last name"
        address=findViewById(R.id.eTAddress)
        address.hint="address"
        error=findViewById(R.id.tvError)
        val radioGroup = findViewById<RadioGroup>(R.id.rgType)
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val selectedRadioButton = findViewById<RadioButton>(checkedId)
            priceType = 0
            if (selectedRadioButton != null) {
                val selectedText = selectedRadioButton.text.toString()

                if(selectedText=="Mini"){
                    priceType+=10
                    type="Mini"
                }else if (selectedText=="Moyenne"){
                    priceType+=14
                    type="Moyenne"
                }else{
                    priceType+=17
                    type="Maxi"

                }
                textPrice.text = (priceingrediant+priceType).toString()+"$"
            }
        }
        val checkBox1 = findViewById<CheckBox>(R.id.checkBox1)
        val checkBox2 = findViewById<CheckBox>(R.id.checkBox2)
        val checkBox3 = findViewById<CheckBox>(R.id.checkBox3)
        val checkBox4 = findViewById<CheckBox>(R.id.checkBox4)
        checkBox1.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                priceingrediant += 3
                ingridiant1="Formage"

            } else {
                priceingrediant -= 3
                ingridiant1=""
            }
            textPrice.text = (priceingrediant+priceType).toString()+"$"
        }
        checkBox2.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                priceingrediant += 5
                ingridiant2="Champignon"
            } else {
                priceingrediant -= 5
                ingridiant2=""
            }
            textPrice.text = (priceingrediant+priceType).toString()+"$"
        }
        checkBox3.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                priceingrediant += 7
                ingridiant3="Pepperoni"
            } else {
                priceingrediant -= 7
                ingridiant3=""
            }
            textPrice.text = (priceingrediant+priceType).toString()+"$"
        }
        checkBox4.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                priceingrediant += 6
                ingridiant4="Pineapple"
            } else {
                priceingrediant -= 6
                ingridiant4=""
            }
            textPrice.text = (priceingrediant+priceType).toString()+"$"
        }
        btnOrder=findViewById(R.id.button)
        btnOrder.setOnClickListener{
            val valueToPass = "your pizza is $type with ${
                if (ingridiant1 == "" && ingridiant2 == "" && ingridiant3 == "" && ingridiant4 == "") {
                    "no additional ingredients"
                } else {
                    "$ingridiant1  $ingridiant2  $ingridiant3  $ingridiant4"
                }
            }\n total price is ${priceType+priceingrediant}"
            if(firstName.text.toString()==""){
                errorMsg="please add your first name"
                error.text=errorMsg
            }else if(lastName.text.toString()==""){
                errorMsg="please add your last name"
                error.text=errorMsg
            }else if(address.text.toString()==""){
                errorMsg="please add your address"
                error.text=errorMsg
            }else if(type==""){
                errorMsg="please select type of pizza"
                error.text=errorMsg
            }else{
                error.text=""
                var emailTosend="order for ${firstName.text} ${lastName.text} in ${address.text} \n" +
                        "$type pizza with ${
                            if (ingridiant1 == "" && ingridiant2 == "" && ingridiant3 == "" && ingridiant4 == "") {
                                "no additional ingredients"
                            } else {
                                "$ingridiant1  $ingridiant2  $ingridiant3  $ingridiant4"
                            }
                        }\n total price is ${priceType+priceingrediant}$"
                val showPopUp = PopupFragment.newInstance(valueToPass,emailTosend)
                showPopUp.show(supportFragmentManager, "popup_fragment")
            }


        }

    }
}