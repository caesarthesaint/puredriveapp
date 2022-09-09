package com.example.puredriveapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.welcome_2.*

class ChooseUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcome_2)

        ibtnCustomer.setOnClickListener{
            loadNextActivity("Customer")
        }

        ibtnStaff.setOnClickListener {
            loadNextActivity("Staff")
        }

        ibtnRental.setOnClickListener{
            loadNextActivity("Rental")
        }
    }

    private fun loadNextActivity(userType: String){
        val intent = Intent(this,SignInActivity::class.java)

        intent.putExtra("User type",userType)
        startActivity(intent)
    }
}