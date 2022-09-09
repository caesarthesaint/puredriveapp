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
    lateinit var userType: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        progressBar = findViewById<ProgressBar>(R.id.progressBar) as ProgressBar

        btnSignIn.setOnClickListener{
            tvLoginTitle.text = "Logging in.."
            progressBar!!.setProgress(count)
            progressBar!!.visibility = View.VISIBLE
            fetchLogin()
        }

        tvSignUp.setOnClickListener{
            loadSignUpActivity()
        }
    }

    private fun fetchLogin() {

        val enteredUsername = etUsername.text.toString()
        val url = "https://my-python-test-api.herokuapp.com/api/login/customer/" + enteredUsername
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()

        client.newCall(request).enqueue(object: Callback {
            override fun onResponse(call: Call, response: Response) {

                try{
                    val body = response?.body?.string()

                    val gson = GsonBuilder().create()

                    val user = gson.fromJson(body, User::class.java)
                    val username: String = user.Username.toString()
                    val password: String = user.Password.toString()

                    loginUser.Username = username
                    loginUser.Password = password
                }catch (e: Exception){
                    e.printStackTrace()
                }

                runOnUiThread{
                    // tvLoginTitle.text = "Fetched.."
                    val Username = loginUser.Username
                    val Password = loginUser.Password
                    val enteredUsername = etUsername.text.toString()
                    val enteredPassword = etPassword.text.toString()

                    count = 100
                    progressBar!!.setProgress(count)
                    progressBar!!.visibility = View.INVISIBLE

                    if(Username == enteredUsername) {
                        if (Password == enteredPassword) {
                            tvLoginTitle.text = "Logged in successfully"
                            loadMainActivity()
                        } else {
                            tvLoginTitle.text = "Incorrect Password"
                        }
                    } else {
                        tvLoginTitle.text = "Invalid Username"
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

    private fun loadSignUpActivity(){

        userType = intent.getStringExtra("User type").toString()

        if (userType == "Customer"){
            startActivity(Intent(this,CustomerSignUp1Activity::class.java))
        }

        if (userType == "Staff"){

        }

        if (userType == "Rental"){
            startActivity(Intent(this,RentalSignUp1Activity::class.java))
        }
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

}