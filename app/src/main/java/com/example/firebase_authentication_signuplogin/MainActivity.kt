package com.example.firebase_authentication_signuplogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.firebase_authentication_signuplogin.aut.Anasayfa
import com.example.firebase_authentication_signuplogin.aut.BasarılıGiris
import com.example.firebase_authentication_signuplogin.aut.GirisSCreen
import com.example.firebase_authentication_signuplogin.aut.SignupScreen
import com.example.firebase_authentication_signuplogin.aut.main.NotificaitonMassage
import com.example.firebase_authentication_signuplogin.ui.theme.Firebase_Authentication_SignupLoginTheme
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.FirebaseDatabase
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Write a message to the database
        // Write a message to the database
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("message")
        lateinit var auth: FirebaseAuth;
        auth = Firebase.auth

        setContent {
            window.statusBarColor=getColor(R.color.black)
            window.navigationBarColor=getColor(R.color.black)
            Firebase_Authentication_SignupLoginTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AuthenticaionApp()
                }
            }
        }
    }
}
@Composable
fun AuthenticaionApp(){
    val vm= hiltViewModel<FbViewModel>()
    val navCont= rememberNavController()
    NotificaitonMassage(vm)
    NavHost(navController =navCont , startDestination =DestinaitonScreen.Main.route ) {
        composable(DestinaitonScreen.Main.route){
            Anasayfa(navCont,vm)
        }
        composable(DestinaitonScreen.Signup.route){
            SignupScreen(navCont,vm)
        }
        composable(DestinaitonScreen.login.route){
            GirisSCreen(navCont,vm)
        }
        composable(DestinaitonScreen.Success.route){
            BasarılıGiris(navCont,vm)
        }



        
    }
}
sealed class DestinaitonScreen(val route:String){
    object Main:DestinaitonScreen("main")
    object Signup:DestinaitonScreen("signup")
    object login:DestinaitonScreen("login")
    object Success:DestinaitonScreen("Success")
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Firebase_Authentication_SignupLoginTheme {

    }
}