package com.example.calculatorapplication

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity(),View.OnClickListener{
    var textView : TextView? = null
    var ac_button : Button? = null
    var percent_button : Button? = null
    var div_button : Button? = null
    var multiply_button : Button? = null
    var add_button : Button? = null
    var sub_button : Button? = null
    var one_button : Button? = null
    var two_button : Button? = null
    var three_button : Button? = null
    var four_button : Button? = null
    var five_button : Button? = null
    var six_button : Button? = null
    var seven_button : Button? = null
    var eight_button : Button? = null
    var nine_button : Button? = null
    var zero_button : Button? = null
    var equal_button : Button? = null
    var textVal = ""
    var operatorList = mutableListOf<String>()
    var operandsList = mutableListOf<Int>();
    var result_of_calculation = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        one_button = findViewById(R.id.one_button)
        two_button = findViewById(R.id.two_button)
        three_button = findViewById(R.id.three_button)
        four_button = findViewById(R.id.four_button)
        five_button = findViewById(R.id.five_button)
        six_button = findViewById(R.id.six_button)
        seven_button = findViewById(R.id.seven_button)
        eight_button = findViewById(R.id.eight_button)
        nine_button = findViewById(R.id.nine_button)
        zero_button = findViewById(R.id.zero_button)
        ac_button = findViewById(R.id.Ac_button)
        percent_button = findViewById(R.id.percent_button)
        div_button = findViewById(R.id.div_button)
        multiply_button = findViewById(R.id.multiply_button)
        add_button = findViewById(R.id.add_button)
        sub_button = findViewById(R.id.subtract_button)
        equal_button = findViewById(R.id.equal_button)
        textView = findViewById(R.id.totalTextView)
    }
    fun isOperator(c : Char):Boolean{
       val result = when (c){
            '+' -> true
            '-' -> true
            '%' -> true
             '/' -> true
            '*' -> true
           else -> false
       }
        return result
    }
    fun changeOperator(op : Char) : String{
        if(isOperator(textVal[textVal.length-1])){
            val chars = textVal.toCharArray()
            chars[textVal.length-1] = op
            textVal = String(chars)
            print(textVal)
        }else{
            textVal += op
        }
        return textVal
    }
    fun setText(){
        textView?.text = textVal
    }
    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id){
                R.id.one_button -> {
                    textVal += "1"
                    setText()
                }
                R.id.two_button -> {
                    textVal += "2"
                    setText()
                }
                R.id.three_button -> {
                    textVal += "3"
                    setText()
                }
                R.id.four_button -> {
                    textVal += "4"
                    setText()
                }
                R.id.five_button -> {
                    textVal += "5"
                    setText()
                }
                R.id.six_button -> {
                    textVal += "6"
                    setText()
                }
                R.id.seven_button -> {
                    textVal += "7"
                    setText()
                }
                R.id.eight_button -> {
                    textVal += "8"
                    setText()
                }
                R.id.nine_button -> {
                    textVal += "9"
                    setText()
                }
                R.id.zero_button -> {
                    textVal += "0"
                    setText()
                }
                R.id.add_button->{
                    changeOperator('+')
                    var splits = textVal.split("+")
                    operandsList.add(Integer.parseInt(splits[0]));
                    operatorList.add("+")
                    setText()
                    textVal = ""
                }
                R.id.subtract_button->{
                    changeOperator('-')
                    var splits = textVal.split("-")
                    operandsList.add(Integer.parseInt(splits[0]));
                    operatorList.add("-")
                    setText()
                    textVal = ""
                }
                R.id.div_button->{
                    changeOperator('/')
                    var splits = textVal.split("/")
                    operandsList.add(Integer.parseInt(splits[0]));
                    operatorList.add("/")
                    setText()
                    textVal = ""
                }
                R.id.multiply_button->{
                    changeOperator('*')
                    var splits = textVal.split("*")
                    operandsList.add(Integer.parseInt(splits[0]));
                    operatorList.add("*")
                    setText()
                    textVal = ""
                }
                R.id.Ac_button->{
                    textVal = ""
                    operandsList.clear()
                    operandsList.clear()
                    setText()
                }
                R.id.equal_button->{
                    operandsList.add(Integer.parseInt(textVal))
                    var m = CalculatorModel()
                    result_of_calculation = m.calculateTotal(operandsList,operatorList)
                    textView?.text = "" + result_of_calculation + ""
                }
                R.id.percent_button->{
                    changeOperator('%')
                    setText()
                }
            }
        }
    }
}