package com.example.firebase_authentication_signuplogin

import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class HitModule {
    @Provides
    fun provideAuthentication():FirebaseAuth= Firebase.auth


}