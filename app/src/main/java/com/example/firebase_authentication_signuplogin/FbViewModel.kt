package com.example.firebase_authentication_signuplogin

import android.os.Message
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.firebase_authentication_signuplogin.ui.theme.Event
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import java.lang.Exception
import javax.inject.Inject


@HiltViewModel
class FbViewModel @Inject constructor(
    val auth: FirebaseAuth
) : ViewModel() {
    val signedIn= mutableStateOf(false)
    val inProgress= mutableStateOf(false)
    val popupNotification= mutableStateOf<Event<String>?>(null)
    fun onSignup(email:String,pass:String){
        inProgress.value=true
        auth.createUserWithEmailAndPassword(email,pass)
            .addOnCompleteListener {
                if (it.isSuccessful){
                    signedIn.value=true
                    handleException(it.exception,"Kayıt Başaraılı")}

                else{
                    handleException(it.exception,"Kayıt Başarısız")
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
                    handleException(it.exception,"Giriş Başarılı")
                }
                else{
                    handleException(it.exception,"Giriş Başarısız")
                }
                inProgress.value=false
            }


    }
    fun handleException(exception: Exception?=null,customMessage:String=""){
        exception?.printStackTrace()
        val errorMsg=exception?.localizedMessage?:""
        val message=if(customMessage.isEmpty())errorMsg else "$customMessage:$errorMsg"
        popupNotification.value=Event(message)

    }

}