package com.ligacalculus.trufalse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ligacalculus.trufalse.databinding.ActivityLearnBinding

class LearnActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLearnBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLearnBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button5.setOnClickListener {
            finish()
        }
    }
}