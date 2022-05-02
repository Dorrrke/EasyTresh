package com.example.easytresh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var clientBtn: Button
        var workerBtn: Button
        findViewById<Button>(R.id.clientBtn).also { clientBtn = it }
        findViewById<Button>(R.id.workerBtn).also { workerBtn = it }

        clientBtn.setOnClickListener {
            val choice = Intent(this, ClientActivity::class.java)
            startActivity(choice)
        }
    }

}