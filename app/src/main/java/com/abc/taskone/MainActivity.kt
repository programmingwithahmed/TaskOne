package com.abc.taskone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var tvData: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvData = findViewById(R.id.tv_data)

        val bundle = intent.extras
        bundle?.let {
            val email = bundle.getString(GenConstants.EMAIL)
            val password = bundle.getString(GenConstants.PASSWORD)

            tvData.setText("$email  ::: $password")
        }

    }
}