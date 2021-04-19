package com.paulo.imckotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        val campoAltura = alturaEDT
        val campoPeso = pesoEDT
        calcularBTN?.setOnClickListener {
        calcularIMC(campoPeso.text.toString(), campoAltura.text.toString())}
    }

    private fun calcularIMC (peso: String, altura: String) {
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()
        if (peso != null && altura != null) {
            val imc = peso/ (altura * altura)
            if(imc < 18.5) {
                titleTXT.text = "Seu IMC é: %.2f - Abaixo do Peso".format(imc)
            }
            else if (imc < 24.9){
                titleTXT.text = "Seu IMC é: %.2f - Peso Normal".format(imc)
            }
            else if(imc < 29.9) {
                titleTXT.text = "Seu IMC é: %.2f - Peso Sobrepeso".format(imc)
            }
            else if(imc < 34.9) {
                titleTXT.text = "Seu IMC é: %.2f - Obsidade Grau I".format(imc)
            }
            else if(imc <= 39.9) {
                titleTXT.text = "Seu IMC é: %.2f - Obsidade Grau II".format(imc)
            }
            else {
                titleTXT.text = "Seu IMC é: %.2f - Obsidade Grau III".format(imc)
            }
        }
    }
}