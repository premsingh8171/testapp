package com.psd.test

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var search_value: String? = ""
    var check: Int? = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onClick()
    }

    private fun onClick() {
        passVisible.setOnClickListener {
            if (check == 0) {
                btn_signup.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                check = 1
            } else {
                btn_signup.setInputType(InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)
                check = 0
            }
        }

        btn_signup.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                search_value = s.toString()
                if (search_value!!.length == 0) {
                    bTn_InScreenlogin.visibility = View.GONE
                } else {
                    bTn_InScreenlogin.visibility = View.VISIBLE
                }

            }
        })

        bTn_InScreenlogin.setOnClickListener { view ->
            if (enter_usernameEt.getText()!!.isEmpty()) {

            } else if (btn_signup.getText()!!.isEmpty()) {

            } else {
                this.startActivity(Intent(this, MainActivity2::class.java))
            }
        }

    }

}