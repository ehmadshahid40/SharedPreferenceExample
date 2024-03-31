package com.example.shatedpreferenceexample

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.shatedpreferenceexample.databinding.ActivityMainBinding

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
