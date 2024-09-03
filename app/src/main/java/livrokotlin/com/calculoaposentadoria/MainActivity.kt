package livrokotlin.com.calculoaposentadoria

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Spinner
import android.widget.EditText
import android.widget.ArrayAdapter

class MainActivity: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //definindo arquivo de Layout
        setContentView(R.layout.activity_main)

        //Acesso ao Spinner
        val spn_sexo = findViewById<Spinner>(R.id.spn_sexo)

        //Acesso ao EditText
        val txt_idade = findViewById<EditText>(R.id.txt_idade)

        //Acesso ao Button de Calcular
        val btn_calcular = findViewById<Button>(R.id.btn_calcular)

        //Acesso ao TextView de Resultado
        val txt_resultado = findViewById<TextView>(R.id.txt_resultado)

        //Definindo os Sexos masculino e feminino no Spinner
        spn_sexo.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listOf("Masculino", "Feminino"))

        btn_calcular.setOnClickListener{
            // codigo executado quando houver clique no btn
            val sexo = spn_sexo.selectedItem as String
            val idade = txt_idade.text.toString().toInt()
            var resultado = 0
            if(sexo == "Masculino"){
            resultado = 65 - idade
            }else{
                resultado = 60 - idade
            }
            //Atualizando a tela com o resultado do input
            txt_resultado.text = "Faltam $resultado anos para você se aposentar"
        }


    }

}