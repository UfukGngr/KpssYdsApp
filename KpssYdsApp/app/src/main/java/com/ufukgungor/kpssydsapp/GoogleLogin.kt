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
    /*
    lateinit var mGoogleSignInClient: GoogleSignInClient
    private val RC_SIGN_IN=9001*/

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
        /*
        val gso=GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken("404463704958-od8li7kcop0lsb8ntq25d1j4j98nt7tg.apps.googleusercontent.com").requestEmail().build()

        mGoogleSignInClient=GoogleSignIn.getClient(this,gso)
        binding.googleLoginBtn.setOnClickListener(){
            signIn()
        }*/
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

/*
        private fun signIn(){
        val signInIntent=mGoogleSignInClient.signInIntent
        startActivityForResult (signInIntent,RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val task =
                GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }
    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>){
        try {
            val account=completedTask.getResult(ApiException::class.java)
            //signed in succesfully
            val googleId=account?.id?:""
            Log.i("Google ID",googleId)

            val googleFirstName = account?.givenName ?: ""
            Log.i("Google First Name", googleFirstName)

            val googleLastName = account?.familyName ?: ""
            Log.i("Google Last Name", googleLastName)

            val googleEmail = account?.email ?: ""
            Log.i("Google Email", googleEmail)

            val googleProfilePicURL = account?.photoUrl.toString()
            Log.i("Google Profile Pic URL", googleProfilePicURL)

            val googleIdToken = account?.idToken ?: ""
            Log.i("Google ID Token", googleIdToken)

        }catch (e:Exception){
            // Sign in was unsuccessful
            Log.w(
                "failed code=",e.stackTraceToString()
            )
        }
    }
    private fun signOut() {
        mGoogleSignInClient.signOut()
            .addOnCompleteListener(this) {
            //Update UI
            }
    }*/
}