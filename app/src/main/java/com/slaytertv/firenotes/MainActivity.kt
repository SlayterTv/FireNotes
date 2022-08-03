package com.slaytertv.firenotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //
        val user : MutableMap<String, Any> = HashMap()
        user["first"] = "Give me a like"
        user["last"] = "and subscribe"
        user["born"] = 1995

        FirebaseFirestore.getInstance().collection("users")
            .add(user)
            .addOnSuccessListener {
                Log.d("tag","add ${it.id}")
            }
            .addOnFailureListener { e ->
            Log.w("tag","error $e")

            }
    }
}