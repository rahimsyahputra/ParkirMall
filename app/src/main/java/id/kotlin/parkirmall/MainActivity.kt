package id.kotlin.parkirmall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() , View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLanjut : Button = findViewById(R.id.btn_lanjut)
        btnLanjut.setOnClickListener(this)

        val showTime : TextView = findViewById(R.id.show_time)
        //val sdf = SimpleDateFormat("E HH:mm:ss dd.MM.yyyy")
        //val currentDateandTime = sdf.format(Date())
        //showTime.setText(currentDateandTime)

        val someHandler = Handler(getMainLooper())
        someHandler.postDelayed(object:Runnable {
            override fun run() {
                showTime.setText(SimpleDateFormat("EE HH:mm:ss dd.MM.yyyy", Locale.US).format(Date()))
                someHandler.postDelayed(this, 1000)
            }
        }, 10)
    }

    override fun onClick(v: View) {
        when (v.id) {

            R.id.btn_lanjut -> {
                val moveLanjut = Intent(this, Main2Activity::class.java)
                startActivity(moveLanjut)
            }
        }
    }
}
