package com.cookandroid.calculatorapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class FourArithmeticCalculatorActivity : AppCompatActivity() {

    lateinit var num1: TextView
    lateinit var num2: TextView
    lateinit var num3: TextView
    lateinit var num4: TextView
    lateinit var num5: TextView
    lateinit var num6: TextView
    lateinit var num7: TextView
    lateinit var num8: TextView
    lateinit var num9: TextView
    lateinit var num0: TextView
    lateinit var num00: TextView
    lateinit var result: TextView
    lateinit var plus: TextView
    lateinit var minus: TextView
    lateinit var multiple: TextView
    lateinit var divide: TextView
    lateinit var equal: TextView
    lateinit var clear: TextView
    lateinit var delete: TextView
    lateinit var point: TextView

    var inputNumber: String = ""
    var resultTemp: String = ""
    var temp = mutableListOf<String>()
    var oper = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_four_arithmetic_calculator)

        findViewById()
        setNumberOnCLickListener()

        plus.setOnClickListener {
            if (inputNumber != "") {
                temp.add(inputNumber)
                inputNumber = ""
            } else {
                temp.add(resultTemp)
                resultTemp = ""
            }
            oper.add("plus")
        }

        minus.setOnClickListener {
            if (inputNumber != "") {
                temp.add(inputNumber)
                inputNumber = ""
            } else {
                temp.add(resultTemp)
                resultTemp = ""
            }
            oper.add("minus")
        }

        multiple.setOnClickListener {
            if (inputNumber != "") {
                temp.add(inputNumber)
                inputNumber = ""
            } else {
                temp.add(resultTemp)
                resultTemp = ""
            }
            oper.add("multiple")
        }

        divide.setOnClickListener {
            if (inputNumber != "") {
                temp.add(inputNumber)
                inputNumber = ""
            } else {
                temp.add(resultTemp)
                resultTemp = ""
            }
            oper.add("divide")
        }

        equal.setOnClickListener {
            temp.add(inputNumber)
            inputNumber = ""
            var operTemp: Double = 0.0
            for (i in oper.indices) {
                when (oper[i]) {
                    "plus" -> {
                        operTemp = temp[i].toDouble() + temp[i + 1].toDouble()
                    }
                    "minus" -> {
                        operTemp = temp[i].toDouble() - temp[i + 1].toDouble()
                    }
                    "multiple" -> {
                        operTemp = temp[i].toDouble() * temp[i + 1].toDouble()
                    }
                    "divide" -> {
                        operTemp = temp[i].toDouble() / temp[i + 1].toDouble()
                    }
                }
                temp[i + 1] = operTemp.toString()
            }
            resultTemp = temp.last()
            result.text = resultTemp
            temp.clear()
            oper.clear()
        }

        clear.setOnClickListener {
            result.text = "0.0"
            inputNumber = ""
            resultTemp = ""
            temp.clear()
            oper.clear()
        }

        delete.setOnClickListener {
            inputNumber = if (resultTemp != "") resultTemp.dropLast(1)
            else inputNumber.dropLast(1)
            result.text = inputNumber
        }
    }

    fun findViewById() {
        num1 = findViewById(R.id.num1)
        num2 = findViewById(R.id.num2)
        num3 = findViewById(R.id.num3)
        num4 = findViewById(R.id.num4)
        num5 = findViewById(R.id.num5)
        num6 = findViewById(R.id.num6)
        num7 = findViewById(R.id.num7)
        num8 = findViewById(R.id.num8)
        num9 = findViewById(R.id.num9)
        num0 = findViewById(R.id.num0)
        num00 = findViewById(R.id.num00)
        result = findViewById(R.id.result)
        plus = findViewById(R.id.plus)
        minus = findViewById(R.id.minus)
        multiple = findViewById(R.id.multiple)
        divide = findViewById(R.id.divide)
        equal = findViewById(R.id.equal)
        clear = findViewById(R.id.clear)
        delete = findViewById(R.id.delete)
        point = findViewById(R.id.point)

    }

    fun setNumberOnCLickListener() {
        val numberList: List<TextView> =
            listOf(num1, num2, num3, num4, num5, num6, num7, num8, num9, num0, num00)
        val listener = object : View.OnClickListener {
            override fun onClick(v: View?) {
                inputNumber += (v as TextView).text
                result.text = inputNumber
            }
        }
        numberList.forEach {
            it.setOnClickListener(listener)
        }
        point.setOnClickListener {
            inputNumber = if(inputNumber == "") true
            if(inputNumber.contains())

        }
    }


}