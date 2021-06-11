package com.fozimat.firebasecrashlytics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fozimat.firebasecrashlytics.databinding.ActivityMainBinding
import com.google.firebase.crashlytics.FirebaseCrashlytics
import timber.log.Timber
import java.lang.RuntimeException

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Timber.d("Test debugging")

        binding.btnCrash.setOnClickListener {
            FirebaseCrashlytics.getInstance().log("Clicked on button")
            FirebaseCrashlytics.getInstance().setCustomKey("str_key", "some_data")
            try {
                throw RuntimeException("Test Crash")
            } catch (e: Exception) {
                Timber.e("Test non fatal exception")
            }
        }
    }
}