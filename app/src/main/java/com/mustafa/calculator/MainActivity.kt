package com.mustafa.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.mustafa.calculator.databinding.ActivityMainBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var resultText : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using ActivityMainBinding and establish the connections.
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Connect the "resultText" variable to the "resultText" TextView component via "binding".
        resultText = binding.resultText
    }

    fun calculate(view: View) {
        // Get the input values from EditText components.
        val numberOneValue = binding.numberOne.text.toString()
        val numberTwoValue = binding.numberTwo.text.toString()

        // Perform input validation.
        // If one or both inputs are blank, display the error message from the "R.string.exception" resource.
        if (numberOneValue.isBlank() || numberTwoValue.isBlank()) {
            resultText.setText(R.string.exception)
            return
        }

        // Determine the operator for the calculation (addition, subtraction, multiplication, division).
        // We use the "when" expression to choose the operation type based on the button the user clicked.
        val operator = when (view.id) {
            R.id.sum -> '+'       // If R.id.sum (the addition button) is clicked, select the '+' operator.
            R.id.decal -> '-'     // If R.id.decal (the subtraction button) is clicked, select the '-' operator.
            R.id.times -> '*'     // If R.id.times (the multiplication button) is clicked, select the '*' operator.
            R.id.divide -> '/'    // If R.id.divide (the division button) is clicked, select the '/' operator.
            else -> return        // If none of the cases match, exit the function.
        }

        // Convert the input values to double data type and perform the calculation.
        try {
            val num1 = numberOneValue.toDouble()
            val num2 = numberTwoValue.toDouble()
            val result = when (operator) {
                '+' -> num1 + num2   // If the operator is '+', perform the addition operation.
                '-' -> num1 - num2   // If the operator is '-', perform the subtraction operation.
                '*' -> num1 * num2   // If the operator is '*', perform the multiplication operation.
                '/' -> num1 / num2   // If the operator is '/', perform the division operation.
                else -> return       // If none of the cases match, exit the function.
            }
            // Display the calculation result on the "resultText" TextView component.
            resultText.text = result.toString()
        } catch (e: NumberFormatException) {
            // If there is a NumberFormatException (invalid input), display the error message from the "R.string.exception" resource.
            resultText.setText(R.string.exception)
        }
    }
}
//Secondary Method
/*class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var numberOne: EditText
    private lateinit var numberTwo: EditText
    private lateinit var resultText : TextView
    private val exceptionText= "Invalid input! enter valid numbers!!!"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding : ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        numberOne = binding.numberOne
        numberTwo = binding.numberTwo
        resultText = binding.resultText


    }

    fun sum(view : View) {
        val numberOneValue = numberOne.text.toString()
        val numberTwoValue = numberTwo.text.toString()

        try {
            val num1 = numberOneValue.toDouble()
            val num2 = numberTwoValue.toDouble()
            val result = num1 + num2
            resultText.text = result.toString()

        } catch (e : Exception){
            resultText.text = exceptionText
        }
    }

    fun decal(view: View){
        val numberOneValue = numberOne.text.toString()
        val numberTwoValue = numberTwo.text.toString()

        try {
            val num1 = numberOneValue.toDouble()
            val num2 = numberTwoValue.toDouble()
            val result = num1 - num2
            resultText.text = result.toString()

        }catch (e : Exception){
            resultText.text = exceptionText
        }
    }

    fun times(view: View){
        val numberOneValue = numberOne.text.toString()
        val numberTwoValue = numberTwo.text.toString()

        try {
            val num1 = numberOneValue.toDouble()
            val num2 = numberTwoValue.toDouble()
            val result = num1 * num2
            resultText.text = result.toString()

        }catch (e : Exception){
            resultText.text = exceptionText
        }
    }

    fun dived(view: View){
        val numberOneValue = numberOne.text.toString()
        val numberTwoValue = numberTwo.text.toString()

        try {
            val num1 = numberOneValue.toDouble()
            val num2 = numberTwoValue.toDouble()
            val result = num1 / num2
            resultText.text = result.toString()

        }catch (e : Exception){
            resultText.text = exceptionText
        }
    }


}*/
