package com.example.puredriveapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.customer_signup_2.*

class CustomerSignUp2Activity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.customer_signup_2)

        ibtnNext.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}