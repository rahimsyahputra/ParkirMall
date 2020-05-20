package id.kotlin.parkirmall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.text.SimpleDateFormat
import java.util.*

class Main4Activity : AppCompatActivity() , View.OnClickListener {

    private var database = FirebaseDatabase.getInstance()
    private var totalKetersediaan = database.getReference()
    private var ktrultra1lantai2 = database.reference
    private var ktrultra2lantai2 = database.reference
    private var ktrultra3lantai2 = database.reference
    private var ktrultra4lantai2 = database.reference
    private var ktrultra5lantai2 = database.reference
    private var ktrultra6lantai2 = database.reference
    private var totalInFloorTwo = database.reference

    val total = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val backToActivity : Button = findViewById(R.id.btn_kembali)
        backToActivity.setOnClickListener(this)

        val showTime : TextView = findViewById(R.id.show_time)
        val someHandler = Handler(getMainLooper())
        someHandler.postDelayed(object:Runnable {
            override fun run() {
                showTime.setText(SimpleDateFormat("EE HH:mm:ss dd.MM.yyyy", Locale.US).format(Date()))
                someHandler.postDelayed(this, 1000)
            }
        }, 10)

        //val totalLantaiDua : TextView = findViewById(R.id.tv_total_ketersediaan_lantai2)

        //totalKetersediaan = database.getReference().child("totalLantai2")

        //totalKetersediaan.addValueEventListener( object : ValueEventListener {
            //override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
            //  val value = dataSnapshot.getValue().toString()
              //  totalLantaiDua.setText(value)
            //}

            //override fun onCancelled(databaseError: DatabaseError) {
            //}
        //})

        totalInFloorTwo = database.getReference().child("totalLantai2")

        val posisiSatu : ImageView = findViewById(R.id.ultra1_lt2)
        ktrultra2lantai2 = database.getReference().child("ultra7")
        ktrultra2lantai2.addValueEventListener(object : ValueEventListener {
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
                        totalInFloorTwo.setValue(totalPengunjungSlot1.toString())

                    }

                    else -> {
                        posisiSatu.setImageDrawable(
                            ContextCompat.getDrawable(
                                applicationContext, // Context
                                R.drawable.hijau // Drawable
                            )
                        )
                        val totalPengunjungSlot1 = total + 1
                        totalInFloorTwo.setValue(totalPengunjungSlot1.toString())
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
            }
        })

        val posisiDua : ImageView = findViewById(R.id.ultra2_lt2)

        ktrultra2lantai2 = database.getReference().child("ultra8")
        ktrultra2lantai2.addValueEventListener(object : ValueEventListener {
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
                        totalInFloorTwo.setValue(totalPengunjungSlot2.toString())
                    }
                    else -> {
                        posisiDua.setImageDrawable(
                            ContextCompat.getDrawable(
                                applicationContext, // Context
                                R.drawable.hijau) // Drawable
                        )
                        val totalPengunjungSlot2 = total + 1
                        totalInFloorTwo.setValue(totalPengunjungSlot2.toString())
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
            }
        })

        val thirdPosition : ImageView = findViewById(R.id.ultra3_lt2)
        ktrultra3lantai2 = database.getReference().child("ultra9")
        ktrultra3lantai2.addValueEventListener(object : ValueEventListener {
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
                        totalInFloorTwo.setValue(totalPengunjungSlot3.toString())
                    }
                    else -> {
                        thirdPosition.setImageDrawable(
                            ContextCompat.getDrawable(
                                applicationContext, // Context
                                R.drawable.hijau) // Drawable
                        )
                        val totalPengunjungSlot3 = total + 1
                        totalInFloorTwo.setValue(totalPengunjungSlot3.toString())
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
            }
        })

        val fourthPosition : ImageView = findViewById(R.id.ultra4_lt2)
        ktrultra4lantai2 = database.getReference().child("ultra10")
        ktrultra4lantai2.addValueEventListener(object : ValueEventListener {
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
                        totalInFloorTwo.setValue(totalPengunjungSlot4.toString())
                    }
                    else -> {
                        fourthPosition.setImageDrawable(
                            ContextCompat.getDrawable(
                                applicationContext, // Context
                                R.drawable.hijau
                            ) // Drawable
                        )
                        val totalPengunjungSlot4 = total + 1
                        totalInFloorTwo.setValue(totalPengunjungSlot4.toString())
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
            }
        })

        val fifthPosition : ImageView = findViewById(R.id.ultra5_lt2)
        ktrultra5lantai2 = database.getReference().child("ultra11")
        ktrultra5lantai2.addValueEventListener(object : ValueEventListener {
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
                        totalInFloorTwo.setValue(totalPengunjungSlot5.toString())
                    }
                    else -> {
                        fifthPosition.setImageDrawable(
                            ContextCompat.getDrawable(
                                applicationContext, // Context
                                R.drawable.hijau
                            ) // Drawable
                        )
                        val totalPengunjungSlot5 = total + 1
                        totalInFloorTwo.setValue(totalPengunjungSlot5.toString())
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
            }
        })

        val sixthPosition : ImageView = findViewById(R.id.ultra6_lt2)
        ktrultra6lantai2 = database.getReference().child("ultra12")
        ktrultra6lantai2.addValueEventListener(object : ValueEventListener {
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
                        totalInFloorTwo.setValue(totalPengunjungSlot6.toString())
                    }
                    else -> {
                        sixthPosition.setImageDrawable(
                            ContextCompat.getDrawable(
                                applicationContext, // Context
                                R.drawable.hijau
                            ) // Drawable
                        )
                        val totalPengunjungSlot6 = total + 1
                        totalInFloorTwo.setValue(totalPengunjungSlot6.toString())
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
                val moveToActivity2 = Intent(this, Main2Activity::class.java)
                startActivity(moveToActivity2)
            }
        }
    }
}
