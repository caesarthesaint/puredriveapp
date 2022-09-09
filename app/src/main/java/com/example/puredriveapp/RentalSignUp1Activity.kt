package com.example.puredriveapp

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.rental_signup_1.*

class RentalSignUp1Activity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rental_signup_1)

        ibtnNext.setOnClickListener{
            startActivity(Intent(this,RentalSignUp2Activity::class.java))
        }
    }
}