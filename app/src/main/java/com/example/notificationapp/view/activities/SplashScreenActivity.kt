package com.example.notificationapp.view.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.notificationapp.databinding.ActivitySplashScreenBinding
import com.google.firebase.auth.FirebaseAuth

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen().setKeepOnScreenCondition { true }
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        mAuth = FirebaseAuth.getInstance()

        binding.image.animate().translationY(-1600f).setDuration(1000).startDelay = 3000
        binding.text.animate().translationY(1400f).setDuration(1000).startDelay = 3000

        if (mAuth.currentUser != null) {
            if (mAuth.currentUser!!.isEmailVerified) {
                startActivity(Intent(applicationContext, MainActivity::class.java))
            } else {
                mAuth.signOut()
                Toast.makeText(applicationContext, "Please Verify Your Email.", Toast.LENGTH_LONG).show()
            }
        } else {
            startActivity(Intent(applicationContext, IntroSliderActivity::class.java))
        }
        finish()
    }
}