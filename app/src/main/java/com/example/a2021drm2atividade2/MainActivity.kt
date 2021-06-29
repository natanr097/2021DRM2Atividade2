package com.example.a2021drm2atividade2

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sp = getSharedPreferences("login", Context.MODE_PRIVATE)

        btnLogar.setOnClickListener {
            if(edtLogin.text.toString().equals("joao")
                &&
                    edtSenha.text.toString().equals("123")){
                    // SALVAR O LOGIN

                    val d = Date()
                    sp.edit().putString("Ultimo login",d.toString()).apply()
                
                    atualizaUltimoLogin(sp)


                }else{
                Toast.makeText(this,"Login e senha não conferem!",Toast.LENGTH_LONG).show()
             }
        }


    }

    private fun atualizaUltimoLogin(sp: SharedPreferences) {
        val res = sp.getString("ultimo_login", "no")

        if (res.equals("no")) {
            txtUltimoLogin.text = "Não foi efetuado login até o momento"
        } else {
            txtUltimoLogin.text = res
        }
    }
}