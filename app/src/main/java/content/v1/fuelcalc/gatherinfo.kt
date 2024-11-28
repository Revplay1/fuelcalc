package content.v1.fuelcalc

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

@Suppress("DEPRECATION")
class gatherinfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_gatherinfo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_FULLSCREEN or
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                )

            val etDistance = findViewById<EditText>(R.id.etDistance)
            val etFuelPrice = findViewById<EditText>(R.id.etFuelPrice)
            val btnCalculate = findViewById<Button>(R.id.btnCalculate)

            btnCalculate.setOnClickListener {
                val distanceStr = etDistance.text.toString()
                val fuelPriceStr = etFuelPrice.text.toString()

                if (distanceStr.isNotEmpty() && fuelPriceStr.isNotEmpty()) {
                    val distance = distanceStr.toDouble()
                    val fuelPrice = fuelPriceStr.toDouble()
                    val fuelCost = distance * fuelPrice

                    // Use Intent to send data to ResultActivity
                    val intent = Intent(this, ResultActivity::class.java).apply {
                        putExtra("FUEL_COST", fuelCost)
                    }
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }