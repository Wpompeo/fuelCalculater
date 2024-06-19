package com.example.fuelcalculater

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class CalculateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculate)

        val edtAlcoholPrice = findViewById<TextInputEditText>(R.id.edt_price_alcohol)
        val edtGasolinePrice = findViewById<TextInputEditText>(R.id.edt_price_gas)
        val edtRangeAlcohol = findViewById<TextInputEditText>(R.id.edt_km_alcohol)
        val edtRangeGasoline = findViewById<TextInputEditText>(R.id.edt_km_gas)
        val edtFuelCost = findViewById<TextInputEditText>(R.id.edt_cash)
        val btnCalculater = findViewById<Button>(R.id.button_calculater)


        btnCalculater.setOnClickListener {
            val alcoholPriceStr: String = edtAlcoholPrice.text.toString()
            val gasolinePriceStr: String = edtGasolinePrice.text.toString()
            val rangeAlcoholStr: String = edtRangeAlcohol.text.toString()
            val rangeGasolineStr: String = edtRangeGasoline.text.toString()
            val fuelCostStr: String = edtFuelCost.text.toString()

            if( alcoholPriceStr == "" || gasolinePriceStr == "" || rangeAlcoholStr == "" || rangeGasolineStr == "" || fuelCostStr == "" ){
                Snackbar.make(
                    edtAlcoholPrice,
                    "Preencha todos os campos!",
                    Snackbar.LENGTH_LONG
                )
                    .show()
            } else {

                val alcoholPrice = alcoholPriceStr.toFloat()
                val gasolinePrice = gasolinePriceStr.toFloat()
                val rangeAlcohol = rangeAlcoholStr.toFloat()
                val rangeGasoline = rangeGasolineStr.toFloat()
                val fuelCost = fuelCostStr.toFloat()

                val toUse = (alcoholPrice / gasolinePrice)
                val litresAlcohol = (fuelCost / alcoholPrice)
                val litresGasoline = (fuelCost / gasolinePrice)

                val autonomyAlcohol = (litresAlcohol) * (rangeAlcohol)
                val autonomyGasoline = (litresGasoline) * (rangeGasoline)

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(KEY_RESULT_AUTONOMY_GASOLINE, autonomyGasoline)
                intent.putExtra(KEY_RESULT_AUTONOMY_ALCOHOL, autonomyAlcohol)
                intent.putExtra(KEY_RESULT_GAS, toUse)
                startActivity(intent)

            }

        }

    }
}


