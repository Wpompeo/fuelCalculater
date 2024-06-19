package com.example.fuelcalculater

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnInit = findViewById<Button>(R.id.btn_init)
        btnInit.setOnClickListener{

            val intent = Intent(this, CalculateActivity::class.java)
            startActivity(intent)
        }
    }
}