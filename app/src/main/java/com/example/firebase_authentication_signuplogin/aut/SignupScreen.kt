package com.example.firebase_authentication_signuplogin.aut

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.firebase_authentication_signuplogin.FbViewModel
import com.example.firebase_authentication_signuplogin.R

@Composable
fun SignupScreen(navController: NavController,vm:FbViewModel) {
    val emty by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var cpassword by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    var cpasswordVisibility by remember { mutableStateOf(false) }
    var errorE by remember { mutableStateOf(false) }
    var errorCP by remember { mutableStateOf(false) }
    var errorC by remember { mutableStateOf(false) }
    var plength by remember { mutableStateOf(false) }
    Image(
        painter = painterResource(id = R.drawable.arkaplan),
        contentDescription = "arkaplan",
        contentScale = ContentScale.FillBounds//içeriğin tamamını ekrana göre ayarlar
        , modifier = Modifier.fillMaxSize()
    )
    Column (modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){

        if(vm.inProgress.value){
            CircularProgressIndicator()
        }

    }
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 150.dp)
            .verticalScroll(rememberScrollState())){
        
        Text(text = "KAYIT OL", fontWeight = FontWeight.Bold, fontSize =40.sp )
        Spacer(modifier = Modifier.height(40.dp))
        if(errorE){
            Text(text = "email giriniz", color = Color.Red)
        }
        TextField(value =email , onValueChange ={email=it}, label = { Text(text = "Email giriniz")})

    }



}