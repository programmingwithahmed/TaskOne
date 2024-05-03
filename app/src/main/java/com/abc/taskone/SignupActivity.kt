package com.abc.taskone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageButton

class SignupActivity : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText

    private lateinit var btnSignup:AppCompatButton
    private lateinit var btnBack:AppCompatImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        etEmail = findViewById(R.id.et_email)
        etPassword = findViewById(R.id.et_password)


        btnSignup = findViewById(R.id.btn_signup)
        btnSignup.setOnClickListener {

            val intent = Intent()
            intent.putExtra(GenConstants.EMAIL, etEmail.text.toString())
            intent.putExtra(GenConstants.PASSWORD, etPassword.text.toString())

            setResult(RESULT_OK, intent)
            finish()
        }


        btnBack = findViewById(R.id.btn_back)
        btnBack.setOnClickListener {
            finish()
        }

    }
}