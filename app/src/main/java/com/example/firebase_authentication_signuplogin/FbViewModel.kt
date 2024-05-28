package com.example.firebase_authentication_signuplogin

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class FbViewModel @Inject constructor(
    val auth: FirebaseAuth
) : ViewModel() {
    val signedIn= mutableStateOf(false)
    val inProgress= mutableStateOf(false)
    val popupNotification= mutableStateOf(null)
    fun onSignup(email:String,pass:String){
        inProgress.value=true
        auth.createUserWithEmailAndPassword(email,pass)
            .addOnCompleteListener {
                if (it.isSuccessful){
                    signedIn.value=true}
                else{

                }
                inProgress.value=false
            }

    }

    fun login(email: String,pass: String){
        inProgress.value=true
        auth.signInWithEmailAndPassword(email,pass)
            .addOnCompleteListener {
                if (it.isSuccessful){
                    signedIn.value=true
                }
                else{

                }
                inProgress.value=false
            }


    }

}