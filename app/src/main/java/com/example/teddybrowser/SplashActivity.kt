package com.example.teddybrowser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //executando instruções após um determinado tempo
        Handler(Looper.getMainLooper()).postDelayed({

            val mIntent = Intent(this, MainActivity::class.java)

            //Método responsável por executar a Intent
            startActivity(mIntent)

            //Remove a tela da pilha
            finish()
        }, 5000) //tempo em milisegundos
    }
}