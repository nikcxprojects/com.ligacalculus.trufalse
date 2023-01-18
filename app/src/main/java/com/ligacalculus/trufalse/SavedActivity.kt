package com.ligacalculus.trufalse

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ligacalculus.trufalse.databinding.ActivitySavedBinding

class SavedActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySavedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySavedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button7.setOnClickListener {
            finish()
        }
        var adapter = MyAdapter(this)
        binding.list.adapter = adapter
        binding.button6.setOnClickListener {
            adapter.deleteAll()
        }
    }

}