package com.example.calculator20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import me.grantland.widget.AutofitTextView
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception



class MainActivity : AppCompatActivity() {
//    var autofitTextView: AutofitTextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        autofitTextView = findViewById(R.id.math_operation)

        key_0.setOnClickListener{setTextFields("0")}
        key_1.setOnClickListener{setTextFields("1")}
        key_2.setOnClickListener{setTextFields("2")}
        key_3.setOnClickListener{setTextFields("3")}
        key_4.setOnClickListener{setTextFields("4")}
        key_5.setOnClickListener{setTextFields("5")}
        key_6.setOnClickListener{setTextFields("6")}
        key_7.setOnClickListener{setTextFields("7")}
        key_8.setOnClickListener{setTextFields("8")}
        key_9.setOnClickListener{setTextFields("9")}
        key_min.setOnClickListener{setTextFields("-")}
        key_plus.setOnClickListener{setTextFields("+")}
        key_mult.setOnClickListener{setTextFields("*")}
        key_div.setOnClickListener{setTextFields("/")}
        close_bracket.setOnClickListener{setTextFields(")")}
        open_bracket.setOnClickListener{setTextFields("(")}

        key_erase.setOnClickListener{
            math_operation.text = ""
            result_text.text = ""
        }

        key_back.setOnClickListener{
            val str = math_operation.text.toString()
            if (str.isNotEmpty()){
                math_operation.text = str.substring(0,str.length - 1)
                result_text.text = ""
            }
        }
        key_equal.setOnClickListener{
            try {
                val ex = ExpressionBuilder(math_operation.text.toString()).build()
                val result = ex.evaluate()

                val longRes = result.toLong()
                if (result == longRes.toDouble())
                    result_text.text = longRes.toString()
                else
                    result_text.text = result.toString()
            }catch (e:Exception){
                Log.d("Ошибка", "сообщение: ${e.message}")
            }


        }

    }

    fun setTextFields (str:String){
        if (result_text.text != ""){
            math_operation.text = result_text.text
            result_text.text = ""
        }
        math_operation.append(str)
    }

}