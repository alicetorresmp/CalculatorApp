package com.alice.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    lateinit var editText : EditText
    private var numberOne : Float = 0.0f
    var isPlus = false
    var isMinus = false
    var isDivide = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.number_edit_text)
    }
    fun operationFunction(view: View) {

        when (view.id) {
            R.id.button_one -> {
                numberClicked(1)
            }

            R.id.button_two -> {
                numberClicked(2)
            }

            R.id.button_three -> {
                numberClicked(3)
            }

            R.id.button_four -> {
                numberClicked(4)
            }

            R.id.button_five -> {
                numberClicked(5)
            }

            R.id.button_six -> {
                numberClicked(6)
            }

            R.id.button_seven -> {
                numberClicked(7)
            }

            R.id.button_eight -> {
                numberClicked(8)
            }

            R.id.button_nine -> {
                numberClicked(9)
            }

            R.id.button_zero -> {
                numberClicked(0)
            }

            R.id.button_dot -> {
                dotClicked()
            }

            R.id.button_clear -> {
                editText.setText("")
            }

            R.id.button_plus -> {
                plusClicked()
            }

            R.id.button_minus -> {
                minusClicked()
            }

            R.id.button_divide -> {
                divideClicked()

            }

            R.id.button_equal -> {
                equalClicked()
            }
        }
    }

    private fun dotClicked(){
        val text = this.editText.text.toString()
        val dot = "."
        if (dot !in text) {
            val number = "$text."
            editText.setText(number)
        } else {
            var newText = text.replace(".", "")
            newText = "$newText."
            editText.setText(newText)
        }
    }

    private fun numberClicked(numberClicked : Int) {
        val number = editText.text.toString() + numberClicked.toString()
        editText.setText(number)
    }

    private fun plusClicked() {
        isPlus = true
        numberOne = editText.text.toString().toFloat()
        editText.setText("")
    }

    private fun minusClicked() {
        isMinus = true
        numberOne = editText.text.toString().toFloat()
        editText.setText("")
    }

    private fun divideClicked() {
        isDivide = true
        numberOne = editText.text.toString().toFloat()
        editText.setText("")
    }

    private fun equalClicked() {
        when {
            isPlus -> {
                plus()
            }
            isMinus -> {
                minus()
            }
            isDivide -> {
                divide()
            }
        }
    }

    private fun plus() {
        val numberTwo = editText.text.toString().toFloat()
        val result = numberOne + numberTwo
        editText.setText(result.toString())
        isPlus = false
    }

    private fun minus() {
        val numberTwo = editText.text.toString().toFloat()
        val result = numberOne - numberTwo
        editText.setText(result.toString())
        isMinus = false
    }

    private fun divide() {
        val numberTwo = editText.text.toString().toFloat()
        val result = numberOne / numberTwo
        editText.setText(result.toString())
        isDivide = false
    }
}
