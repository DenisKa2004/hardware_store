package com.example.test_application

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_aut)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val user_login: EditText = findViewById(R.id.user_login_aut)
        val user_pass: EditText = findViewById(R.id.user_pass_aut)
        val button: Button = findViewById(R.id.button_aut)

        val link_reg: TextView = findViewById(R.id.link_reg)
        link_reg.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        button.setOnClickListener{
            val login = user_login.text.toString().trim()
            val pass = user_pass.text.toString().trim()

            if (login.isEmpty() || pass.isEmpty()){
                Toast.makeText(this, "Заполните все поля формы !", Toast.LENGTH_SHORT).show()
            } else{

                val db = DB(this, null)
                val isAut = db.getUser(login, pass)
                if (isAut){
                    Toast.makeText(this, "Пользыватель $login авторизован", Toast.LENGTH_SHORT).show()
                    user_pass.text.clear()
                    user_login.text.clear()

                    val intent = Intent(this, ItemsActivity::class.java)
                    startActivity(intent)

                } else
                    Toast.makeText(this, "Пользыватель $login не найден", Toast.LENGTH_SHORT).show()



            }
        }
    }
}