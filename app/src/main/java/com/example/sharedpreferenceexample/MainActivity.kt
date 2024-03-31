package com.example.sharedpreferenceexample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sharedpreferenceexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val editor = getSharedPreferences("MY_SETTING", MODE_PRIVATE)
        binding.Et1.setText(editor.getString(Constants.KEY_EMAIL,""))
        binding.Et2.setText(editor.getString(Constants.KEY_PASSWORD,""))

        binding.button1.setOnClickListener {
            val editor = getSharedPreferences("MY_SETTING", MODE_PRIVATE).edit()
            editor.putString(Constants.KEY_EMAIL, binding.Et1.text.toString())
            editor.putString(Constants.KEY_PASSWORD, binding.Et2.text.toString())
            editor.apply()
            startActivity(Intent
                (this,MainActivity2::class.java))
        }
    }
}
