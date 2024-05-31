package com.example.firebase_authentication_signuplogin.aut

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.firebase_authentication_signuplogin.DestinaitonScreen
import com.example.firebase_authentication_signuplogin.FbViewModel
import com.example.firebase_authentication_signuplogin.R

@Composable
fun GirisSCreen(navController: NavController, vm: FbViewModel){
    val emty by remember { mutableStateOf("") }//silme tuşu için
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    var errorE by remember { mutableStateOf(false) }
    var errorP by remember { mutableStateOf(false) }
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
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 150.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "Giris Yap",
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(40.dp))
            if (errorE) {
                Text(text = "email giriniz", color = Color.Red,)
            }
            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text(text = "Email giriniz") },
                leadingIcon = { Icon(painter = painterResource(id = R.drawable.p1), contentDescription = null ) },
                trailingIcon = {
                    if(email.isNotEmpty()) {
                        Icon(
                            painter = painterResource(id = R.drawable.sil),
                            contentDescription = null,
                            Modifier.clickable { email = emty }
                        )
                    }
                }
            )
            Spacer(modifier = Modifier.height(40.dp))
            if (errorP) {
                Text(text = "Şifre giriniz", color = Color.Red)
            }
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(text = "Şifre giriniz") },
                leadingIcon = { Icon(painter = painterResource(id = R.drawable.lock), contentDescription = null ) },
                trailingIcon = {
                    if (password.isNotEmpty()) {
                        val visibilityIcon = if (passwordVisibility) {
                            painterResource(id = R.drawable.kapali)
                        } else {
                            painterResource(id = R.drawable.acik)
                        }
                        Icon(
                            painter = visibilityIcon,
                            contentDescription = null,
                            Modifier.clickable { passwordVisibility = !passwordVisibility }
                        )
                    }
                },
                visualTransformation = if (passwordVisibility) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                }
            )
            Spacer(modifier = Modifier.height(40.dp))
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(50.dp))
                    .background(color = Color.White)
            ) {
                Button(
                    onClick = {
                        if (email.isNotEmpty()) {
                            errorE = false
                            if (password.isNotEmpty()) {
                                errorP = false
                                vm.login(email, password)
                            } else {
                                errorP = true
                            }
                        } else {
                            errorE = true
                        }
                    },
                    colors = ButtonDefaults.buttonColors(Color.Transparent)
                ) {
                    Text(text = "Giris Yap", fontWeight = FontWeight.Bold, color = Color.Black)
                }
                if (vm.signedIn.value) {
                    navController.navigate(DestinaitonScreen.Success.route)
                }
                vm.signedIn.value = false
            }
        }


    }
}





