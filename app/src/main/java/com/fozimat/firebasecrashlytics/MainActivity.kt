package com.fozimat.firebasecrashlytics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fozimat.firebasecrashlytics.databinding.ActivityMainBinding
import com.google.firebase.crashlytics.FirebaseCrashlytics
import java.lang.RuntimeException

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCrash.setOnClickListener {
            FirebaseCrashlytics.getInstance().log("Clicked on button")
            FirebaseCrashlytics.getInstance().setCustomKey("str_key", "some_data")
            throw RuntimeException("Test Crash")
        }
    }
}