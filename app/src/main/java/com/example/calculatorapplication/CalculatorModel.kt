package com.example.calculatorapplication

import java.util.*


class CalculatorModel{
    var total : Double = 0.0
    init {

    }
   fun calculateTotal(operandsList : List<Int>,operatorList : List<String>) : Double{
       total = operandsList.get(0).toDouble()
       for(i in 0..operandsList.size-2){
           if(operatorList.get(i).contentEquals("+")){
               total = total +operandsList.get(i+1)
           }else if(operatorList.get(i).contentEquals("-")){
               total = total - operandsList.get(i+1)
           }else if(operatorList.get(i).contentEquals("*")){
               total = total * operandsList.get(i+1)
           }else if(operatorList.get(i).contentEquals("/")){
               total = total/operandsList.get(i+1).toDouble()
           }
       }
       return total
   }
}