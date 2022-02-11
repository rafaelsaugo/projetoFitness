package co.tiagoaguiar.codelab.myapplication

import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import co.tiagoaguiar.codelab.myapplication.model.calcular_beberAgua
import java.text.NumberFormat
import java.util.*

class BeberAgua : AppCompatActivity() {

    private lateinit var edit_peso: EditText
    private lateinit var edit_idade: EditText

    private lateinit var text_result: TextView
    private lateinit var text_hora: TextView
    private lateinit var text_seconds: TextView

    private lateinit var ic_redefinir: ImageView

    private lateinit var btn_agua_calc: Button
    private lateinit var app_alarm: Button
    private lateinit var app_lembrete: Button


    //utilizando classe
    private lateinit var calcular_beberAgua : calcular_beberAgua

    private var resultadoMl = 0.0

    lateinit var timePickerDialog: TimePickerDialog
    lateinit var calendar: Calendar
    var horaAtual = 0
    var minutoAtual = 0

    //ESCONDENDO O TECLADO



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beber_agua)

    //startando Metodo

        IniciarComponetes()
        calcular_beberAgua = calcular_beberAgua()

        btn_agua_calc.setOnClickListener{

            if (edit_peso.text.toString().isEmpty()){
                Toast.makeText(this, R.string.toast_informe_peso,Toast.LENGTH_SHORT).show()
            } else if (edit_idade.text.toString().isEmpty()){
                Toast.makeText(this, R.string.toast_informe_idade,Toast.LENGTH_SHORT).show()
            }else{
                val peso = edit_peso.text.toString().toDouble()
                val idade = edit_idade.text.toString().toInt()
                calcular_beberAgua.CalcularTotalMl(peso,idade)
                resultadoMl = calcular_beberAgua.ResultadoMl()

                //covert para mudar . em ,
                val formatar = NumberFormat.getNumberInstance(Locale("pt","BR"))
                formatar.isGroupingUsed = false

                text_result.text = formatar.format(resultadoMl) + " " + "ml"
            }
        }
        ic_redefinir.setOnClickListener{

            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setTitle(R.string.dialog_title)
                .setMessage(R.string.dialog_message)
                .setPositiveButton("OK", {dialogInterface, i ->
                    edit_peso.setText("")
                    edit_idade.setText("")
                    text_result.text = ""
                })
            alertDialog.setNegativeButton("Cancelar",{ dialogInterface, i ->

            })
            val dialog = alertDialog.create()
            dialog.show()
        }
        /** BOTAO LEMBRETE **/
        app_lembrete.setOnClickListener{

            calendar = Calendar.getInstance()
            horaAtual = calendar.get(Calendar.HOUR_OF_DAY)
            minutoAtual = calendar.get(Calendar.MINUTE)
            timePickerDialog = TimePickerDialog(this,{timePicke: TimePicker, hourOfDay: Int, minutes: Int ->
                text_hora.text = String.format("%02d", hourOfDay)
                text_seconds.text = String.format("%02d", minutes)
            }, horaAtual, minutoAtual,true)
            timePickerDialog.show()
        }

        /** BOTAO ALARME **/
        app_alarm.setOnClickListener{

            if (!text_hora.text.toString().isEmpty() && !text_seconds.text.toString().isEmpty()){
                val intent = Intent(AlarmClock.ACTION_SET_ALARM)
                intent.putExtra(AlarmClock.EXTRA_HOUR, text_hora.text.toString().toInt())
                intent.putExtra(AlarmClock.EXTRA_MINUTES, text_seconds.text.toString().toInt())
                intent.putExtra(AlarmClock.EXTRA_MESSAGE,getString(R.string.alarme_message))
                startActivity(intent)

                if (intent.resolveActivity(packageManager) != null){
                    startActivity(intent)
                }
            }
        }


    }
    //metodo inicial
    private fun IniciarComponetes(){
        edit_peso = findViewById(R.id.edit_peso)
        edit_idade = findViewById(R.id.edit_idade)
        btn_agua_calc = findViewById(R.id.btn_agua_calc)
        text_result = findViewById(R.id.text_result)
        ic_redefinir = findViewById(R.id.ic_redefinir)
        app_alarm = findViewById(R.id.app_alarm)
        app_lembrete = findViewById(R.id.app_lembrete)
        text_seconds = findViewById(R.id.text_seconds)
        text_hora = findViewById(R.id.text_hora)
    }
}