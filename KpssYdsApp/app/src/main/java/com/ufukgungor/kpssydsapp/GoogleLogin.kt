package com.ufukgungor.kpssydsapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.ufukgungor.kpssydsapp.databinding.ActivityGoogleLoginBinding


class GoogleLogin : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    var userEmail = ""
    var password = ""
    private lateinit var binding: ActivityGoogleLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGoogleLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        auth = Firebase.auth
        val currentUser = auth.currentUser

        if (currentUser != null) {
            val intent = Intent(applicationContext, ProfileActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    fun signInClicked(view: View) {
        userEmail = binding.userEmailText.text.toString()
        password = binding.passwordText.text.toString()

        if (userEmail.isNotEmpty() && password.isNotEmpty()) {
            auth.signInWithEmailAndPassword(userEmail, password).addOnCompleteListener { task ->

                if (task.isSuccessful) {
                    //Signed In
                    Toast.makeText(
                        applicationContext,
                        "Welcome: ${auth.currentUser?.email.toString()}",
                        Toast.LENGTH_LONG
                    ).show()
                    val intent = Intent(applicationContext, ProfileActivity::class.java)
                    startActivity(intent)
                    finish()

                }

            }.addOnFailureListener { exception ->
                Toast.makeText(applicationContext, exception.localizedMessage, Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

    fun signUpClicked(view: View) {

        userEmail = binding.userEmailText.text.toString()
        password = binding.passwordText.text.toString()

        if (userEmail.isNotEmpty() && password.isNotEmpty()) {
            auth.createUserWithEmailAndPassword(userEmail, password).addOnCompleteListener { task ->

                if (task.isSuccessful) {
                    val intent = Intent(applicationContext, ProfileActivity::class.java)
                    startActivity(intent)
                    finish()
                }

            }.addOnFailureListener { exception ->
                Toast.makeText(applicationContext, exception.localizedMessage, Toast.LENGTH_LONG)
                    .show()

            }
        }
    }

}