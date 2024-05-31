package com.example.firebase_authentication_signuplogin.aut.main

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.firebase_authentication_signuplogin.FbViewModel


@Composable
fun NotificaitonMassage(vm:FbViewModel){
    val notifState=vm.popupNotification.value
    val notifMassage=notifState?.getContentOrNull()
    if(notifMassage!=null){
        Toast.makeText(LocalContext.current,notifMassage,Toast.LENGTH_SHORT).show()
    }



}