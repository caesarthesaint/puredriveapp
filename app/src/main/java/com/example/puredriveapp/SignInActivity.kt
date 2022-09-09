package com.example.puredriveapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.puredriveapp.R
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_sign_in.*
import okhttp3.*
import okio.IOException
import java.util.*

class SignInActivity : AppCompatActivity() {
    var progressBar: ProgressBar? = null
    var count = 1
    var loginUser = User()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        progressBar = findViewById<ProgressBar>(R.id.progressBar) as ProgressBar

        btnSignIn.setOnClickListener{
            txtIndicator.text = "Fetching.."
            progressBar!!.setProgress(count)
            progressBar!!.visibility = View.VISIBLE
            fetchJson()
        }
    }

    private fun fetchJson() {

        val enteredUsername = etUsername.text.toString()
        val url = "https://my-python-test-api.herokuapp.com/api/login/customer/" + enteredUsername
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()

        client.newCall(request).enqueue(object: Callback {
            override fun onResponse(call: Call, response: Response) {

                val body = response?.body?.string()
                println(body)

                val gson = GsonBuilder().create()

                val user = gson.fromJson(body, User::class.java)
                val username: String = user.Username.toString()
                val password: String = user.Password.toString()

                loginUser.Username = username
                loginUser.Password = password

                runOnUiThread{
                    txtIndicator.text = "Fetched.."
                    val Username = loginUser.Username
                    val Password = loginUser.Password
                    val enteredUsername = etUsername.text.toString()
                    val enteredPassword = etPassword.text.toString()

                    count = 100
                    progressBar!!.setProgress(count)
                    progressBar!!.visibility = View.INVISIBLE

                    if(Username == enteredUsername) {
                        if (Password == enteredPassword) {
                            txtIndicator.text = "Logged in successfully"
                            loadMainActivity()
                        } else {
                            txtIndicator.text = "Incorrect Password"
                        }
                    } else {
                        txtIndicator.text = "Incorrect Username"
                    }
                }

            }
            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute request")
            }
        })

    }

    private fun loadMainActivity(){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }

    data class User(
        var UserID: Int = 0,
        var RoleID: Int = 0,
        var CreatedDateTime: String = "",
        var UpdatedDateTime: String = "",
        var Username: String = "",
        var Password: String = "",
        var EmailAddress: String = "",
        var Fname: String = "",
        var Mname: String = "",
        var Lname: String = "",
        var Gender: String = "",
        var PhoneNo: String = "",
        var DateOfBirth: String = ""
    )

    data class Customer(val customerID: Int, val userID: Int, val billingLocationID: Int, val shippingLocationID: Int, val recentSearch: String, val lastRentedVehicle: Int, val lastUsedPayment: String)

    data class Location(val locationID: Int, val lotno: String, val addressline: String, val addressline2: String, val state: String, val city: String, val country: String, val zipcode: String)

    data class Jemma(val jemmaname: String)
}