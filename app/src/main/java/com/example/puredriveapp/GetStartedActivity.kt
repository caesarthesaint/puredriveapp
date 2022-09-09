package com.example.puredriveapp

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.welcome.*

class GetStartedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcome)

        ibtnGetStarted.setOnClickListener{
            loadNextActivity()
        }
    }

    private fun loadNextActivity(){
        val intent = Intent(this,ChooseUserActivity::class.java)
        startActivity(intent)
    }
}