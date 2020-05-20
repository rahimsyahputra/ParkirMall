package id.kotlin.parkirmall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextClock
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class Main3Activity : AppCompatActivity() , View.OnClickListener {

    private var database = FirebaseDatabase.getInstance()
    private var totalKetersediaan = database.reference
    private var ktrultrasatulantaisatu = database.reference
    private var ktrultra2lantai1 = database.reference
    private var ktrultra3lantai1 = database.reference
    private var ktrultra4lantai1 = database.reference
    private var ktrultra5lantai1 = database.reference
    private var ktrultra6lantai1 = database.reference
    private var totalInFloorOne = database.reference

    val total = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val backToActivity2 : Button = findViewById(R.id.btn_kembali)
        backToActivity2.setOnClickListener(this)

        //var totalLantaiSatu : TextView = findViewById(R.id.tv_total_ketersediaan_lantai1)

        val showTime : TextView = findViewById(R.id.show_time)
        val someHandler = Handler(getMainLooper())
        someHandler.postDelayed(object:Runnable {
            override fun run() {
                showTime.setText(SimpleDateFormat("EE HH:mm:ss dd.MM.yyyy", Locale.US).format(Date()))
                someHandler.postDelayed(this, 1000)
            }
        }, 10)

        //val sdf = SimpleDateFormat("E HH:mm:ss dd.MM.yyyy")
        //val currentDateandTime = sdf.format(Date())
        //showTime.setText(currentDateandTime)

        val posisiSatu : ImageView = findViewById(R.id.ultra1_lt1)
        ktrultrasatulantaisatu = database.getReference().child("ultra1")
        ktrultrasatulantaisatu.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val valueUltraSatu = dataSnapshot.getValue().toString().toInt()
                when (valueUltraSatu) {
                    1 -> {
                        posisiSatu.setImageDrawable(
                            ContextCompat.getDrawable(
                                applicationContext, // Context
                                R.drawable.merah // Drawable
                            )
                        )
                        val totalPengunjungSlot1 = total - 1
                        totalInFloorOne.setValue(totalPengunjungSlot1.toString())

                    }

                    else -> {
                        posisiSatu.setImageDrawable(
                            ContextCompat.getDrawable(
                                applicationContext, // Context
                                R.drawable.hijau // Drawable
                            )
                        )
                        val totalPengunjungSlot1 = total + 1
                        totalInFloorOne.setValue(totalPengunjungSlot1.toString())
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
            }
        })

        val posisiDua : ImageView = findViewById(R.id.ultra2_lt1)
        totalInFloorOne = database.getReference().child("totalLantai1")
        ktrultra2lantai1 = database.getReference().child("ultra2")
        ktrultra2lantai1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val valueUltraDua = dataSnapshot.getValue().toString().toInt()
                when (valueUltraDua) {
                    1 -> {
                        posisiDua.setImageDrawable(
                            ContextCompat.getDrawable(
                                applicationContext, // Context
                                R.drawable.merah // Drawable
                            )
                        )
                        val totalPengunjungSlot2 = total - 1
                        totalInFloorOne.setValue(totalPengunjungSlot2.toString())
                    }
                    else -> {
                        posisiDua.setImageDrawable(
                            ContextCompat.getDrawable(
                                applicationContext, // Context
                                R.drawable.hijau) // Drawable
                        )
                        val totalPengunjungSlot2 = total + 1
                        totalInFloorOne.setValue(totalPengunjungSlot2.toString())
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
            }
        })

        val thirdPosition : ImageView = findViewById(R.id.ultra3_lt1)
        ktrultra3lantai1 = database.getReference().child("ultra3")
        ktrultra3lantai1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val valueUltraTiga = dataSnapshot.getValue().toString().toInt()
                when (valueUltraTiga) {
                    1 -> {
                        thirdPosition.setImageDrawable(
                            ContextCompat.getDrawable(
                                applicationContext, // Context
                                R.drawable.merah // Drawable
                            )
                        )
                        val totalPengunjungSlot3 = total - 1
                        totalInFloorOne.setValue(totalPengunjungSlot3.toString())
                    }
                    else -> {
                        thirdPosition.setImageDrawable(
                            ContextCompat.getDrawable(
                                applicationContext, // Context
                                R.drawable.hijau) // Drawable
                        )
                        val totalPengunjungSlot3 = total + 1
                        totalInFloorOne.setValue(totalPengunjungSlot3.toString())
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
            }
        })

        val fourthPosition : ImageView = findViewById(R.id.ultra4_lt1)
        ktrultra4lantai1 = database.getReference().child("ultra4")
        ktrultra4lantai1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val valueFourthUltra = dataSnapshot.getValue().toString().toInt()
                when (valueFourthUltra) {
                    1 -> {
                        fourthPosition.setImageDrawable(
                            ContextCompat.getDrawable(
                                applicationContext, // Context
                                R.drawable.merah // Drawable
                            )
                        )
                        val totalPengunjungSlot4 = total - 1
                        totalInFloorOne.setValue(totalPengunjungSlot4.toString())
                    }
                    else -> {
                        fourthPosition.setImageDrawable(
                            ContextCompat.getDrawable(
                                applicationContext, // Context
                                R.drawable.hijau
                            ) // Drawable
                        )
                        val totalPengunjungSlot4 = total + 1
                        totalInFloorOne.setValue(totalPengunjungSlot4.toString())
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
            }
        })

        val fifthPosition : ImageView = findViewById(R.id.ultra5_lt1)
        ktrultra5lantai1 = database.getReference().child("ultra5")
        ktrultra5lantai1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val valueFifthUltra = dataSnapshot.getValue().toString().toInt()
                when (valueFifthUltra) {
                    1 -> {
                        fifthPosition.setImageDrawable(
                            ContextCompat.getDrawable(
                                applicationContext, // Context
                                R.drawable.merah // Drawable
                            )
                        )
                        val totalPengunjungSlot5 = total - 1
                        totalInFloorOne.setValue(totalPengunjungSlot5.toString())
                    }
                    else -> {
                        fifthPosition.setImageDrawable(
                            ContextCompat.getDrawable(
                                applicationContext, // Context
                                R.drawable.hijau
                            ) // Drawable
                        )
                        val totalPengunjungSlot5 = total + 1
                        totalInFloorOne.setValue(totalPengunjungSlot5.toString())
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
            }
        })

        val sixthPosition : ImageView = findViewById(R.id.ultra6_lt1)
        ktrultra6lantai1 = database.getReference().child("ultra6")
        ktrultra6lantai1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val valueSixthUltra = dataSnapshot.getValue().toString().toInt()
                when (valueSixthUltra) {
                    1 -> {
                        sixthPosition.setImageDrawable(
                            ContextCompat.getDrawable(
                                applicationContext, // Context
                                R.drawable.merah // Drawable
                            )
                        )
                        val totalPengunjungSlot6 = total - 1
                        totalInFloorOne.setValue(totalPengunjungSlot6.toString())
                    }
                    else -> {
                        sixthPosition.setImageDrawable(
                            ContextCompat.getDrawable(
                                applicationContext, // Context
                                R.drawable.hijau
                            ) // Drawable
                        )
                        val totalPengunjungSlot6 = total + 1
                        totalInFloorOne.setValue(totalPengunjungSlot6.toString())
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
            }
        })


    }


    override fun onClick(v: View) {
        when (v.id){

            R.id.btn_kembali -> {
                val moveBack = Intent(this, Main2Activity::class.java)
                startActivity(moveBack)
            }
        }
    }

}