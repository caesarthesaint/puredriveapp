package com.example.puredriveapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.rental_signup_3.*

class RentalSignUp3Activity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rental_signup_3)

        ibtnNext.setOnClickListener{
            startActivity(Intent(this,RentalSignUp4Activity::class.java))
        }
    }
}