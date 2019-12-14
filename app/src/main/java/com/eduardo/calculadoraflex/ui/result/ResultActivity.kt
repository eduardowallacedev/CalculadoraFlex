package com.eduardo.calculadoraflex.ui.result

import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.provider.Settings.Global.getString
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.eduardo.calculadoraflex.R
import com.eduardo.calculadoraflex.R.*
import com.eduardo.calculadoraflex.R.string.*
import com.eduardo.calculadoraflex.extensions.format
import kotlinx.android.synthetic.main.activity_result.*


class ResultActivity : AppCompatActivity() {

   // override fun onCreate(savedInstanceState: Bundle?) {
   //     super.onCreate(savedInstanceState)
   //     setContentView(R.layout.activity_result)
//}
   @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
   @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)

   override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       setContentView(layout.activity_result)
       supportActionBar?.setDisplayHomeAsUpEnabled(true);
       supportActionBar?.setDisplayShowHomeEnabled(true);
       if (intent.extras == null) {
           Toast.makeText(this, "Não foi possível realizar a operação",
               Toast.LENGTH_SHORT).show()
       } else {
           calculate()
       }
   }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)

    private fun calculate() {
        val gasPrice = intent.extras?.getDouble("GAS_PRICE", 0.0)
        val ethanolPrice = intent.extras?.getDouble("ETHANOL_PRICE", 0.0)
        val gasAverage = intent.extras?.getDouble("GAS_AVERAGE", 0.0)
        val ethanolAverage = intent.extras?.getDouble("ETHANOL_AVERAGE", 0.0)
        val performanceOfMyCar = ethanolAverage?.div(gasAverage!!)
        val priceOfFuelIndice = ethanolPrice?.div(gasPrice!!)
        if (priceOfFuelIndice!! <= performanceOfMyCar!!) {
            tvSuggestion.text = getString(com.eduardo.calculadoraflex.R.string.ethanol)

        } else {
            tvSuggestion.text =  getString(com.eduardo.calculadoraflex.R.string.gasoline)
        }
        tvEthanolAverageResult.text = (ethanolPrice / ethanolAverage).format(2)
        tvEthanolAverageResult.text = (gasPrice!! / gasAverage!!).format(2)

        tvGasAverageResult.text = (gasPrice / gasAverage).format(2)
        tvGasAverageResult.text = (gasPrice!! / gasAverage!!).format(2)

        tvFuelRatio.text =
            getString(R.string.label_fuel_ratio,performanceOfMyCar.format(2))
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}


