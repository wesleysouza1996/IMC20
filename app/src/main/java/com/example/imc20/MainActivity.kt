package com.example.imc20

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // R = res (setContentView para chamar a tela através do kotlin)


        // Recuperar o que tem dentro do XML
        val edtPeso = findViewById<TextInputEditText>(R.id.edt_peso)
        val edtAlura = findViewById<TextInputEditText>(R.id.edt_altura)
        val btnCalcular = findViewById<Button>(R.id.btn_calcular)

        // Colocar ação no botão setOnClickListener
        // Recuperar o texto digitado no edt_peso
        btnCalcular.setOnClickListener {

            val pesoStr = edtPeso.text.toString()
            val alturaStr = edtAlura.text.toString()

            if(pesoStr == "" || alturaStr == ""){
            // Mostrar mensagem ao usuário que os campos devem ser preenchidos

                Snackbar.make(
                    edtPeso,
                    "Preencha todos os campos",
                    Snackbar.LENGTH_LONG
                )
                .show()
            }else{
                val peso = pesoStr.toFloat()
                val altura = alturaStr.toFloat()

                val alturaq2 = altura * altura
                val resultado = peso / alturaq2



                // Navegar para a próxima tela
                // Criar o layout da próxima tela
                // Passar dados(resultado) para a próxima tela

                // Intent = Classe do próprio android

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(KEY_RESULT_IMC, resultado)
                startActivity(intent)



                println("Ação!!!" + resultado)

            }



        }


    }
}
