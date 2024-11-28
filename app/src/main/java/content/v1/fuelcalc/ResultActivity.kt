package content.v1.fuelcalc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val fuelCost = intent.getDoubleExtra("FUEL_COST", 0.0)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        tvResult.text = "$fuelCost"
    }
}