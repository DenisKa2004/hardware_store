package com.example.test_application

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val user_login: EditText = findViewById(R.id.user_login)
        val user_email: EditText = findViewById(R.id.user_email)
        val user_pass: EditText = findViewById(R.id.user_pass)
        val button: Button = findViewById(R.id.button_reg)

        val link_aut: TextView = findViewById(R.id.link_aut)
        link_aut.setOnClickListener{
            val intent = Intent(this,AutActivity::class.java)
            startActivity(intent)
        }

        button.setOnClickListener{
            val login = user_login.text.toString().trim()
            val email = user_email.text.toString().trim()
            val pass = user_pass.text.toString().trim()

            if (login.isEmpty() || email.isEmpty() || pass.isEmpty()){
                Toast.makeText(this, "Заполните все поля формы !", Toast.LENGTH_SHORT).show()
            } else{
                val user = User(login, email, pass)

                val db = DB(this, null)
                db.AddUser(user)
                Toast.makeText(this, "Пользыватель $login зарегестрирован", Toast.LENGTH_SHORT).show()

                user_pass.text.clear()
                user_email.text.clear()
                user_login.text.clear()
            }
        }


    }
}