package com.aguilar.semana4lab

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
//Transicion entre activitys
import android.content.Intent
import android.widget.Toast
import com.aguilar.semana4lab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //declarar la variable binding
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //iniciar el binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //configurar boton pa iniciar sesion
        binding.btnLogin.setOnClickListener {
            val userName = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (userName.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Rellena los campos", Toast.LENGTH_LONG).show()
            } else if (userName != "Elquin" || password != "Aguilar") {
                // Si el nombre de usuario o la contraseña no coinciden, mostrar mensaje de error
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_LONG).show()
            } else {
                // Si el nombre de usuario y la contraseña son correctos, continuar con la segunda actividad
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("username", userName)
                startActivity(intent)
            }
        }



    }


    }
