package com.example.customviewtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val customView: CustomView = findViewById(R.id.custom_view)
        val editText: EditText = findViewById(R.id.edit_text)
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            customView.scale = editText.text.toString().toFloat()
        }
    }
}