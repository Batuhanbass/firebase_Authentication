package com.example.firebase_authentication_signuplogin.aut

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.firebase_authentication_signuplogin.FbViewModel

@Composable
fun BasarılıGiris(navController: NavController, vm: FbViewModel){
    Column(horizontalAlignment = Alignment.CenterHorizontally
    , verticalArrangement = Arrangement.Center) {
        Text(text = "Başarılı Giriş", color = Color.White, fontSize = 120.sp, fontWeight = FontWeight.Bold)
    }




}