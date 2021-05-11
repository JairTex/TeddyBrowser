package com.example.teddybrowser

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.teddybrowser.databinding.ActivityMainBinding
import java.net.URL

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webViewStatus()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun webViewStatus(){
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.wbvSite.settings.javaScriptEnabled = true
        //binding.wbvSite.settings.safeBrowsingEnabled = true

        binding.wbvSite.loadUrl("https://www.startpage.com/")

        binding.wbvSite.webViewClient = WebViewClient()
        //Danso função ao botão home para retornar para o buscador
        binding.btnhome.setOnClickListener{
            val mIntent = Intent(this,MainActivity::class.java)
            startActivity(mIntent)
        }
        binding.btnSearch.setOnClickListener{
            val URL:String = binding.edtxtSearch.text.toString()
            binding.wbvSite.loadUrl(URL)
        }
    }

    //Tempo de inicialização quando botão back for pressionado
    private var backPressedTime = 0L

    override fun onBackPressed() {
        when {
            //Indicando para o app retornar para ultima tela quando o botão back for pressionado
            binding.wbvSite.canGoBack() -> binding.wbvSite.goBack()

            //indicando para o sistema iniciar a contagem após o back ser pressionado
            backPressedTime + 2000 > System.currentTimeMillis() -> super.onBackPressed()

            else -> {
                //Texto que aparecerá quando o botão back for pressionado
                Toast.makeText(applicationContext, "Pressione novamente para fechar.", Toast.LENGTH_SHORT).show()
            }
        }
        backPressedTime = System.currentTimeMillis()
    }
}