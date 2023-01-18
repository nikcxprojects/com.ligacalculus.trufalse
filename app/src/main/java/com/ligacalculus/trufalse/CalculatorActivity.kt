package com.ligacalculus.trufalse

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ligacalculus.trufalse.databinding.ActivityCalculatorBinding
import java.math.BigDecimal
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager


class CalculatorActivity : AppCompatActivity(), View.OnClickListener,
    OnTouchListener {
    private var openParenthesis = 0
    private var dotUsed = false
    private var equalClicked = false
    private var lastExpression = ""
    var buttonNumber0: Button? = null
    var buttonNumber1: Button? = null
    var buttonNumber2: Button? = null
    var buttonNumber3: Button? = null
    var buttonNumber4: Button? = null
    var buttonNumber5: Button? = null
    var buttonNumber6: Button? = null
    var buttonNumber7: Button? = null
    var buttonNumber8: Button? = null
    var buttonNumber9: Button? = null
    var buttonClear: Button? = null
    var buttonParentheses: Button? = null
     var buttonDivision: Button? = null
    var buttonMultiplication: Button? = null
    var buttonSubtraction: Button? = null
    var buttonAddition: Button? = null
    var buttonEqual: Button? = null
    var buttonDot: Button? = null
    var textViewInputNumbers: TextView? = null
    var scriptEngine: ScriptEngine? = null
    var c  = false
    var old = ""
    private lateinit var binding: ActivityCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        scriptEngine = ScriptEngineManager().getEngineByName("rhino")
        initializeViewVariables()
        setOnClickListeners()
        setOnTouchListener()
        binding.imageButton.setOnClickListener {
            finish()
        }
        binding.imageButton2.setOnClickListener {
            finish()
        }
        binding.imageButton3.setOnClickListener {
            if(equalClicked) {
                Log.d("TAG","$old = ${binding.textViewInputNumbers.text.toString().trim()}")
               if(c) {
                   var s = binding.textViewInputNumbers.text.toString().trim()
                   var ans = getSharedPreferences("prefs", MODE_PRIVATE).getStringSet("ans",HashSet<String>())
                   var ans1 = HashSet<String>()
                   ans1.addAll(ans!!.toList())
                   ans1.remove("$old = $s")
                   getSharedPreferences("prefs", MODE_PRIVATE).edit().putStringSet("ans",ans1).apply()
                   binding.imageButton3.setImageResource(R.drawable.ic_baseline_star_border_24)
                   c = false
               } else {
                   var s = binding.textViewInputNumbers.text.toString().trim()
                   var ans = getSharedPreferences("prefs", MODE_PRIVATE).getStringSet("ans",HashSet<String>())
                   var ans1 = HashSet<String>()
                   ans1.addAll(ans!!.toList())
                   ans1.add("$old = $s")
                   getSharedPreferences("prefs", MODE_PRIVATE).edit().putStringSet("ans",ans1).apply()
                   binding.imageButton3.setImageResource(R.drawable.ic_baseline_star_24)
                   c = true
               }
            }
        }
    }

    private fun initializeViewVariables() {
        buttonNumber0 = binding.buttonZero
        buttonNumber1 = binding.buttonOne
        buttonNumber2 = binding.buttonTwo
        buttonNumber3 = binding.buttonThree
        buttonNumber4 = binding.buttonFour
        buttonNumber5 = binding.buttonFive
        buttonNumber6 = binding.buttonSix
        buttonNumber7 = binding.buttonSeven
        buttonNumber8 = binding.buttonEight
        buttonNumber9 = binding.buttonNine
        buttonClear = binding.buttonClear
        buttonParentheses = binding.buttonParentheses
        buttonDivision = binding.buttonDivision
        buttonMultiplication = binding.buttonMultiplication
        buttonSubtraction = binding.buttonSubtraction
        buttonAddition = binding.buttonAddition
        buttonEqual = binding.buttonEqual
        buttonDot = binding.buttonDot
        textViewInputNumbers = binding.textViewInputNumbers
    }

    private fun setOnClickListeners() {
        buttonNumber0!!.setOnClickListener(this)
        buttonNumber1!!.setOnClickListener(this)
        buttonNumber2!!.setOnClickListener(this)
        buttonNumber3!!.setOnClickListener(this)
        buttonNumber4!!.setOnClickListener(this)
        buttonNumber5!!.setOnClickListener(this)
        buttonNumber6!!.setOnClickListener(this)
        buttonNumber7!!.setOnClickListener(this)
        buttonNumber8!!.setOnClickListener(this)
        buttonNumber9!!.setOnClickListener(this)
        buttonClear!!.setOnClickListener(this)
        buttonParentheses!!.setOnClickListener(this)
        buttonDivision!!.setOnClickListener(this)
        buttonMultiplication!!.setOnClickListener(this)
        buttonSubtraction!!.setOnClickListener(this)
        buttonAddition!!.setOnClickListener(this)
        buttonEqual!!.setOnClickListener(this)
        buttonDot!!.setOnClickListener(this)
    }

    private fun setOnTouchListener() {
        buttonNumber0!!.setOnTouchListener(this)
        buttonNumber1!!.setOnTouchListener(this)
        buttonNumber2!!.setOnTouchListener(this)
        buttonNumber3!!.setOnTouchListener(this)
        buttonNumber4!!.setOnTouchListener(this)
        buttonNumber5!!.setOnTouchListener(this)
        buttonNumber6!!.setOnTouchListener(this)
        buttonNumber7!!.setOnTouchListener(this)
        buttonNumber8!!.setOnTouchListener(this)
        buttonNumber9!!.setOnTouchListener(this)
        buttonClear!!.setOnTouchListener(this)
        buttonParentheses!!.setOnTouchListener(this)
         buttonDivision!!.setOnTouchListener(this)
        buttonMultiplication!!.setOnTouchListener(this)
        buttonSubtraction!!.setOnTouchListener(this)
        buttonAddition!!.setOnTouchListener(this)
        buttonDot!!.setOnTouchListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.button_zero -> if (addNumber("0")) equalClicked = false
            R.id.button_one -> if (addNumber("1")) equalClicked = false
            R.id.button_two -> if (addNumber("2")) equalClicked = false
            R.id.button_three -> if (addNumber("3")) equalClicked = false
            R.id.button_four -> if (addNumber("4")) equalClicked = false
            R.id.button_five -> if (addNumber("5")) equalClicked = false
            R.id.button_six -> if (addNumber("6")) equalClicked = false
            R.id.button_seven -> if (addNumber("7")) equalClicked = false
            R.id.button_eight -> if (addNumber("8")) equalClicked = false
            R.id.button_nine -> if (addNumber("9")) equalClicked = false
            R.id.button_addition -> if (addOperand("+")) equalClicked = false
            R.id.button_subtraction -> if (addOperand("-")) equalClicked = false
            R.id.button_multiplication -> if (addOperand("x")) equalClicked = false
            R.id.button_division -> if (addOperand("\u00F7")) equalClicked = false
            R.id.button_dot -> if (addDot()) equalClicked = false
            R.id.button_parentheses -> if (addParenthesis()) equalClicked = false
            R.id.button_clear -> {
                textViewInputNumbers!!.text = ""
                openParenthesis = 0
                dotUsed = false
                equalClicked = false
            }
            R.id.button_equal -> if (textViewInputNumbers!!.text.toString() != null && textViewInputNumbers!!.text.toString() != "") calculate(
                textViewInputNumbers!!.text.toString()
            )
        }
    }

    override fun onTouch(view: View, motionEvent: MotionEvent): Boolean {
        when (motionEvent.action) {
            MotionEvent.ACTION_DOWN -> {
                view.background.setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP)
                view.invalidate()
            }
            MotionEvent.ACTION_UP -> {
                view.background.clearColorFilter()
                view.invalidate()
            }
        }
        return false
    }

    private fun addDot(): Boolean {
        var done = false
        if (textViewInputNumbers!!.text.length == 0) {
            textViewInputNumbers!!.text = "0."
            dotUsed = true
            done = true
        } else if (dotUsed == true) {
        } else if (defineLastCharacter(textViewInputNumbers!!.text[textViewInputNumbers!!.text.length - 1].toString() + "") == IS_OPERAND) {
            textViewInputNumbers!!.text = textViewInputNumbers!!.text.toString() + "0."
            done = true
            dotUsed = true
        } else if (defineLastCharacter(textViewInputNumbers!!.text[textViewInputNumbers!!.text.length - 1].toString() + "") == IS_NUMBER) {
            textViewInputNumbers!!.text = textViewInputNumbers!!.text.toString() + "."
            done = true
            dotUsed = true
        }
        return done
    }

    private fun addParenthesis(): Boolean {
        var done = false
        val operationLength = textViewInputNumbers!!.text.length
        if (operationLength == 0) {
            textViewInputNumbers!!.text = textViewInputNumbers!!.text.toString() + "("
            dotUsed = false
            openParenthesis++
            done = true
        } else if (openParenthesis > 0 && operationLength > 0) {
            val lastInput = textViewInputNumbers!!.text[operationLength - 1].toString() + ""
            when (defineLastCharacter(lastInput)) {
                IS_NUMBER -> {
                    textViewInputNumbers!!.text = textViewInputNumbers!!.text.toString() + ")"
                    done = true
                    openParenthesis--
                    dotUsed = false
                }
                IS_OPERAND -> {
                    textViewInputNumbers!!.text = textViewInputNumbers!!.text.toString() + "("
                    done = true
                    openParenthesis++
                    dotUsed = false
                }
                IS_OPEN_PARENTHESIS -> {
                    textViewInputNumbers!!.text = textViewInputNumbers!!.text.toString() + "("
                    done = true
                    openParenthesis++
                    dotUsed = false
                }
                IS_CLOSE_PARENTHESIS -> {
                    textViewInputNumbers!!.text = textViewInputNumbers!!.text.toString() + ")"
                    done = true
                    openParenthesis--
                    dotUsed = false
                }
            }
        } else if (openParenthesis == 0 && operationLength > 0) {
            val lastInput = textViewInputNumbers!!.text[operationLength - 1].toString() + ""
            if (defineLastCharacter(lastInput) == IS_OPERAND) {
                textViewInputNumbers!!.text = textViewInputNumbers!!.text.toString() + "("
                done = true
                dotUsed = false
                openParenthesis++
            } else {
                textViewInputNumbers!!.text = textViewInputNumbers!!.text.toString() + "x("
                done = true
                dotUsed = false
                openParenthesis++
            }
        }
        return done
    }

    private fun addOperand(operand: String): Boolean {
        var done = false
        val operationLength = textViewInputNumbers!!.text.length
        if (operationLength > 0) {
            val lastInput = textViewInputNumbers!!.text[operationLength - 1].toString() + ""
            if (lastInput == "+" || lastInput == "-" || lastInput == "*" || lastInput == "\u00F7" || lastInput == "%") {
                Toast.makeText(applicationContext, "Wrong format", Toast.LENGTH_LONG).show()
            } else if (operand == "%" && defineLastCharacter(lastInput) == IS_NUMBER) {
                textViewInputNumbers!!.text = textViewInputNumbers!!.text.toString() + operand
                dotUsed = false
                equalClicked = false
                lastExpression = ""
                done = true
            } else if (operand != "%") {
                textViewInputNumbers!!.text = textViewInputNumbers!!.text.toString() + operand
                dotUsed = false
                equalClicked = false
                lastExpression = ""
                done = true
            }
        } else {
            Toast.makeText(
                applicationContext,
                "Wrong Format. Operand Without any numbers?",
                Toast.LENGTH_LONG
            ).show()
        }
        return done
    }

    private fun addNumber(number: String): Boolean {
        var done = false
        val operationLength = textViewInputNumbers!!.text.length
        if (operationLength > 0) {
            val lastCharacter = textViewInputNumbers!!.text[operationLength - 1].toString() + ""
            val lastCharacterState = defineLastCharacter(lastCharacter)
            if (operationLength == 1 && lastCharacterState == IS_NUMBER && lastCharacter == "0") {
                textViewInputNumbers!!.text = number
                done = true
            } else if (lastCharacterState == IS_OPEN_PARENTHESIS) {
                textViewInputNumbers!!.text = textViewInputNumbers!!.text.toString() + number
                done = true
            } else if (lastCharacterState == IS_CLOSE_PARENTHESIS || lastCharacter == "%") {
                textViewInputNumbers!!.text = textViewInputNumbers!!.text.toString() + "x" + number
                done = true
            } else if (lastCharacterState == IS_NUMBER || lastCharacterState == IS_OPERAND || lastCharacterState == IS_DOT) {
                textViewInputNumbers!!.text = textViewInputNumbers!!.text.toString() + number
                done = true
            }
        } else {
            textViewInputNumbers!!.text = textViewInputNumbers!!.text.toString() + number
            done = true
        }
        return done
    }

    private fun calculate(input: String) {
        old = input
        var result = ""
        try {
            var temp = input
            if (equalClicked) {
                temp = input + lastExpression
            } else {
                saveLastExpression(input)
            }
            result = scriptEngine!!.eval(
                temp.replace("%".toRegex(), "/100").replace("x".toRegex(), "*")
                    .replace("[^\\x00-\\x7F]".toRegex(), "/")
            ).toString()
            val decimal = BigDecimal(result)
            result = decimal.setScale(8, BigDecimal.ROUND_HALF_UP).toPlainString()
            equalClicked = true
        } catch (e: Exception) {
            Toast.makeText(applicationContext, "Wrong Format", Toast.LENGTH_SHORT).show()
            return
        }
        if (result == "Infinity") {
            Toast.makeText(
                applicationContext,
                "Division by zero is not allowed",
                Toast.LENGTH_SHORT
            ).show()
            textViewInputNumbers!!.text = input
        } else if (result.contains(".")) {
            result = result.replace("\\.?0*$".toRegex(), "")
            textViewInputNumbers!!.text = result
        }
    }

    private fun saveLastExpression(input: String) {
        val lastOfExpression = input[input.length - 1].toString() + ""
        if (input.length > 1) {
            if (lastOfExpression == ")") {
                lastExpression = ")"
                var numberOfCloseParenthesis = 1
                for (i in input.length - 2 downTo 0) {
                    if (numberOfCloseParenthesis > 0) {
                        val last = input[i].toString() + ""
                        if (last == ")") {
                            numberOfCloseParenthesis++
                        } else if (last == "(") {
                            numberOfCloseParenthesis--
                        }
                        lastExpression = last + lastExpression
                    } else if (defineLastCharacter(input[i].toString() + "") == IS_OPERAND) {
                        lastExpression = input[i].toString() + lastExpression
                        break
                    } else {
                        lastExpression = ""
                    }
                }
            } else if (defineLastCharacter(lastOfExpression + "") == IS_NUMBER) {
                lastExpression = lastOfExpression
                for (i in input.length - 2 downTo 0) {
                    val last = input[i].toString() + ""
                    if (defineLastCharacter(last) == IS_NUMBER || defineLastCharacter(
                            last
                        ) == IS_DOT
                    ) {
                        lastExpression = last + lastExpression
                    } else if (defineLastCharacter(last) == IS_OPERAND) {
                        lastExpression = last + lastExpression
                        break
                    }
                    if (i == 0) {
                        lastExpression = ""
                    }
                }
            }
        }
    }

    private fun defineLastCharacter(lastCharacter: String): Int {
        try {
            lastCharacter.toInt()
            return IS_NUMBER
        } catch (e: NumberFormatException) {
        }
        if (lastCharacter == "+" || lastCharacter == "-" || lastCharacter == "x" || lastCharacter == "\u00F7" || lastCharacter == "%") return IS_OPERAND
        if (lastCharacter == "(") return IS_OPEN_PARENTHESIS
        if (lastCharacter == ")") return IS_CLOSE_PARENTHESIS
        return if (lastCharacter == ".") IS_DOT else -1
    }

    companion object {
        private const val EXCEPTION = -1
        private const val IS_NUMBER = 0
        private const val IS_OPERAND = 1
        private const val IS_OPEN_PARENTHESIS = 2
        private const val IS_CLOSE_PARENTHESIS = 3
        private const val IS_DOT = 4
    }
}