package com.ufukgungor.kpssydsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.ufukgungor.kpssydsapp.databinding.ActivityGoogleLoginBinding


class GoogleLogin : AppCompatActivity() {
    private lateinit var binding: ActivityGoogleLoginBinding
    lateinit var mGoogleSignInClient: GoogleSignInClient
    private val RC_SIGN_IN=9001


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGoogleLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val gso=GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken("404463704958-od8li7kcop0lsb8ntq25d1j4j98nt7tg.apps.googleusercontent.com").requestEmail().build()

        mGoogleSignInClient=GoogleSignIn.getClient(this,gso)
        binding.googleLoginBtn.setOnClickListener(){
            signIn()
        }

    }
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
            Log.e(
                "failed code=",e.stackTraceToString()
            )
        }
    }
    private fun signOut() {
        mGoogleSignInClient.signOut()
            .addOnCompleteListener(this) {
                // Update your UI here
            }
    }
}