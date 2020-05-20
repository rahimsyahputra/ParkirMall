package id.kotlin.parkirmall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.text.SimpleDateFormat
import java.util.*

class Main2Activity : AppCompatActivity() , View.OnClickListener {

    private var database = FirebaseDatabase.getInstance()
    private var totalKetersediaan = database.getReference()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val btnLantaiSatu: Button = findViewById(R.id.btn_lantai1)
        btnLantaiSatu.setOnClickListener(this)

        val btnLantaiDua: Button = findViewById(R.id.btn_lantai2)
        btnLantaiDua.setOnClickListener(this)

        val showTime : TextView = findViewById(R.id.show_time)
        val someHandler = Handler(getMainLooper())
        someHandler.postDelayed(object:Runnable {
            override fun run() {
                showTime.setText(SimpleDateFormat("EE HH:mm:ss dd.MM.yyyy", Locale.US).format(Date()))
                someHandler.postDelayed(this, 1000)
            }
        }, 10)

        val total: TextView = findViewById(R.id.tv_total_ketersediaan)

        totalKetersediaan = database.getReference().child("total")

        totalKetersediaan.addValueEventListener( object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue().toString()
                total.setText(value)
            }

            override fun onCancelled(databaseError: DatabaseError) {
            }
        })
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_lantai1 -> {
                val moveLantaiSatu = Intent(this, Main3Activity::class.java)
                startActivity(moveLantaiSatu)
            }

            R.id.btn_lantai2 -> {
                val moveLantaiDua = Intent(this, Main4Activity::class.java)
                startActivity(moveLantaiDua)
            }
        }
    }
}
