package com.aguilar.semana4lab

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import com.aguilar.semana4lab.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)


        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setContentView(R.layout.activity_second)
        val username = intent.getStringExtra("username")
        binding.tvWelcome.text="Bienvenido $username"
        binding.btnLogout.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}