package com.ligacalculus.trufalse

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ligacalculus.trufalse.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button4.setOnClickListener {
            startActivity(Intent(applicationContext,LearnActivity::class.java))
        }
        binding.button.setOnClickListener {
            startActivity(Intent(applicationContext,CalculatorActivity::class.java))
        }
        binding.button3.setOnClickListener {
            getSharedPreferences("prefs", Context.MODE_PRIVATE).edit().putStringSet("ans",HashSet<String>()).apply()
        }
        binding.button2.setOnClickListener {
            startActivity(Intent(applicationContext,SavedActivity::class.java))
        }
    }
}