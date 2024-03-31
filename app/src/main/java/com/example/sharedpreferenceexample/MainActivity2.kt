package com.example.sharedpreferenceexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sharedpreferenceexample.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        val editor = getSharedPreferences("MY_SETTING", MODE_PRIVATE)
        binding.textView.setText("Hey Your email is ${editor.getString(Constants.KEY_EMAIL,null)}" +
                                  "And Your Password id ${editor.getString(Constants.KEY_PASSWORD,null)}")
    }
}