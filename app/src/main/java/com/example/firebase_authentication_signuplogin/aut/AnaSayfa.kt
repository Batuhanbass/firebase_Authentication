package com.example.firebase_authentication_signuplogin.aut

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.firebase_authentication_signuplogin.DestinaitonScreen
import com.example.firebase_authentication_signuplogin.FbViewModel
import com.example.firebase_authentication_signuplogin.R

@Composable
fun Anasayfa(navController: NavController,vm:FbViewModel){
    Image(painter = painterResource(id = R.drawable.arkaplan),
        contentDescription ="arkaplan",
        contentScale = ContentScale.FillBounds//içeriğin tamamını ekrana göre ayarlar
        , modifier = Modifier.fillMaxSize())
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
        .fillMaxWidth()
        .padding(top = 100.dp)) {
        Text(text = "welcome", color = Color.White, fontSize = 40.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(80.dp))
        Box(modifier = Modifier
            .clip(RoundedCornerShape(50.dp))
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color.Blue, Color.White
                    )
                )
            )
            ){
            Button(onClick = { navController.navigate(DestinaitonScreen.Signup.route) },
                colors = ButtonDefaults.buttonColors(Color.Transparent), modifier = Modifier.width(300.dp)) {
                Text(text = "Giris", color = Color.White, fontSize = 40.sp, fontWeight = FontWeight.Bold)

            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Box(modifier = Modifier
            .clip(RoundedCornerShape(50.dp))
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color.Blue, Color.White
                    )
                )
            )
        ){
            Button(onClick = { navController.navigate(DestinaitonScreen.login.route) },
                colors = ButtonDefaults.buttonColors(Color.Transparent), modifier = Modifier.width(300.dp)) {
                Text(text = "Kayıt ol", color = Color.White, fontSize = 40.sp, fontWeight = FontWeight.Bold)

            }
        }
    }


}