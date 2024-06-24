package com.example.fuelcalculater

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_GAS = "ResultActivity.KEY_GAS"
const val KEY_RESULT_AUTONOMY_ALCOHOL = "ResultActivity.KEY_AUTONOMY_ALCOHOL"
const val KEY_RESULT_AUTONOMY_GASOLINE = "ResultActivity.KEY_AUTONOMY_GASOLINE"


class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val resultType = intent.getFloatExtra(KEY_RESULT_GAS, 0f)
        val resultAutonomyAlcohol = intent.getFloatExtra(KEY_RESULT_AUTONOMY_ALCOHOL, 0f)
        val resultAutonomyGasoline = intent.getFloatExtra(KEY_RESULT_AUTONOMY_GASOLINE, 0f)

        val tvResultTypeFinal = findViewById<TextView>(R.id.tv_result_type)

        val classification: String = if (resultType <= 0.7f){
            tvResultTypeFinal.setTextColor(getColor(R.color.Green))
            getString(R.string.result_fuel_alcohol)
        } else{
            tvResultTypeFinal.setTextColor(getColor(R.color.secondary_color))
            getString(R.string.result_fuel_gasoline)
        }
        tvResultTypeFinal.text = classification

        val tvResultAutonomy = findViewById<TextView>(R.id.tv_result_km)

        if (resultType < 0.7f){
            tvResultAutonomy.text = resultAutonomyAlcohol.toString() + " KM"
        } else {
            tvResultAutonomy.text = resultAutonomyGasoline.toString() + " KM"
        }
    }
}