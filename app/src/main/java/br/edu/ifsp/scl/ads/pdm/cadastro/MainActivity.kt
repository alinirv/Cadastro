package br.edu.ifsp.scl.ads.pdm.cadastro

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.ifsp.scl.ads.pdm.cadastro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val amb: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)

        // Configuração do Spinner (UF)
        amb.estadoSp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedState = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Não fazer nada
            }
        }

        // Ação do botão "Salvar"
        amb.salveBt.setOnClickListener {
            val nomeCompleto = amb.nomeCompletoEt.text.toString()
            val telefone = amb.foneEt.text.toString()
            val email = amb.emailEt.text.toString()
            val ingressarListaEmails = amb.listaEmailsCb.isChecked
            val sexo = when (amb.sexoRg.checkedRadioButtonId) {
                amb.masculinoRb.id -> "Masculino"
                amb.femininoRb.id -> "Feminino"
                else -> ""
            }
            val cidade = amb.cidadeEt.text.toString()
            val uf = amb.estadoSp.selectedItem.toString() // Pegando o valor do Spinner

            // Criando o objeto Formulario
            val formulario = Formulario(
                nomeCompleto, telefone, email, ingressarListaEmails, sexo, cidade, uf
            )

            // Exibindo os dados do formulário em um Toast
            Toast.makeText(this@MainActivity, formulario.toString(), Toast.LENGTH_LONG).show()
        }

        // Ação do botão "Limpar"
        amb.limparBt.setOnClickListener {
            amb.nomeCompletoEt.text.clear()
            amb.foneEt.text.clear()
            amb.emailEt.text.clear()
            amb.listaEmailsCb.isChecked = false
            amb.sexoRg.clearCheck()
            amb.cidadeEt.text.clear()
            amb.estadoSp.setSelection(0) // Reseta o Spinner para o primeiro item
        }
    }
}