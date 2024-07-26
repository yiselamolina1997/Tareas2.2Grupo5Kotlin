package com.example.tarea2p2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        BOTONES()

        val textView3 = findViewById<View>(R.id.textView3) as TextView
        textView3.text = """
            Integrantes del grupo: 
            - Olvin Figueroa (201320070010)
            - Melvin Orellana (201110510061)
            - Victor Madrid (202110010471)
            - Emely Alexandra Vallecillo (202110120024)
            - Dennis Antonio Landero Ramos(201910070086)
            - Daisy Carolina Pérez Betanco (202010060081) 
            - Kevin Orlando Paredes Funez (202130020046)
            - Yisela Diney Molina Sosa (202010010089)
            """.trimIndent()
    }

    private fun BOTONES() {
        val button = findViewById<View>(R.id.button) as Button
        val button2 = findViewById<View>(R.id.button2) as Button
        button.setOnClickListener {
            val intent = Intent(applicationContext, ActivityPlaceHolder::class.java)
            startActivity(intent)
        }

        button2.setOnClickListener {
            val intent = Intent(applicationContext, ActivityPlaceHolderBuscar::class.java)
            startActivity(intent)
        }
    }
}