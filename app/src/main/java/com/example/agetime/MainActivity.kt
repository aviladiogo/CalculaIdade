package com.example.agetime

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.agetime.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener{ calculateAge() }
    }
    fun calculateAge() {
        /* Dia em que nasceu
         * Mes em que nasceu
         * Ano em que nasceu respectivamente  */
        val stringInTextField = binding.diaNasceu.text.toString()
        val stringInTextField2 = binding.mesNasceu.text.toString()
        val stringInTextField3 = binding.anoNasceu.text.toString()
        /* Dia em que nasceu para double
         * Mes em que nasceu para double
         * Ano em que nasceu para double respectivamente  */
        val cost = stringInTextField.toDouble()
        val cost2 = stringInTextField2.toDouble()
        val cost3 = stringInTextField3.toDouble()
        /* Inicializa o calendar e pega a data de hoje dia mes e ano*/
        val c = Calendar.getInstance()
        val ano = c.get(Calendar.YEAR)
        var mes = c.get(Calendar.MONTH) + 1
        val dia = c.get(Calendar.DAY_OF_MONTH)

        /* Verifica se o aniversario ja passou */
        val passou =
            /* Se o mes de hoje for menor que o do aniversario -1 ano no calculo*/
            if(mes < cost2) {
                1
            } else {
                /* Se o mes de hoje for maio que o do aniversario -0 ano no calculo*/
                if(mes > cost2) {
                    0
                } else{
                    /* Se o mes de hoje for igual que o do aniversario, e se o Dia de hoje é menor o do aniversario -1 ano no calculo*/
                    if(dia < cost){
                        1
                    }else{
                        /* Se o mes de hoje for igual que o do aniversario, e se o Dia de hoje é maior ou igual o do aniversario -0 ano no calculo*/
                        0
                    }
                }
            }
        /* Ano menos o ano de nascimento menos o fato se o aniversario ja passou ou não*/
        val age: Double = ano - cost3 - passou
        val formattedAge = age.toString()
        binding.ageResult.text = getString(R.string.age_result, formattedAge)
    }
}