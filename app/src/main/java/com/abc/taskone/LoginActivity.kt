package com.abc.taskone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton

class LoginActivity : AppCompatActivity() {

    private lateinit var btnLogin: AppCompatButton
    private lateinit var btnCreate: AppCompatButton

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin = findViewById(R.id.btn_login)
        btnLogin.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Email or Password empty", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val intent = Intent(this, MainActivity::class.java)

            intent.putExtra(GenConstants.EMAIL, email)
            intent.putExtra(GenConstants.PASSWORD, password)

            startActivity(intent)
        }
        btnCreate = findViewById(R.id.btn_create)
        btnCreate.setOnClickListener {
            startActivityForResult(Intent(this, SignupActivity::class.java), 100)
        }

        etEmail = findViewById(R.id.et_email)
        etPassword = findViewById(R.id.et_password)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK && requestCode == 100) {

            val bundle = data?.extras
            bundle?.let {
                val email = bundle.getString(GenConstants.EMAIL)
                val password = bundle.getString(GenConstants.PASSWORD)

                etEmail.setText(email)
                etPassword.setText(password)
            }

        }

    }
}