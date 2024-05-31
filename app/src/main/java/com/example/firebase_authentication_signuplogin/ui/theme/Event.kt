package com.example.firebase_authentication_signuplogin.ui.theme

open class Event<out T>(private val content:T) {

    var hasbeenHandled=false
        private set
    fun getContentOrNull(): T?{
        return if(hasbeenHandled){
            null
        }
        else{
            hasbeenHandled=true
            content
        }
    }

}