package com.example.puredriveapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.rental_signup_6.*

class RentalSignUp6Activity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rental_signup_6)

        ibtnNext.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}