package co.tiagoaguiar.codelab.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class TmbActivity extends AppCompatActivity {

    EditText editHeight, editWeight, editAge;

    double P, A, I, AF, Resultado, Resultado_semana, Resultado_mes;

    public void alerta(String titulo, String mensagem)
    {
        AlertDialog.Builder alerta = new AlertDialog.Builder(TmbActivity.this);

        alerta.setTitle(titulo);
        alerta.setMessage(mensagem);
        alerta.setNeutralButton("OK", null);
        alerta.show();

        //ESCONDENDO O TECLADO
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editWeight.getWindowToken(), 0);
        imm.hideSoftInputFromWindow(editHeight.getWindowToken(), 0);
        imm.hideSoftInputFromWindow(editAge.getWindowToken(), 0);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tmb);

        editHeight = findViewById(R.id.edit_tmb_height);
        editWeight = findViewById(R.id.edit_tmb_weight);
        editAge = findViewById(R.id.edit_tmb_age);

        Button btnTmbCalc = findViewById(R.id.btn_tmb_calc);
        Button btnTmbClean = findViewById(R.id.btn_tmb_limpar);

        RadioButton radioButtonHomem = (RadioButton) findViewById(R.id.radioButtonHomem);
        RadioButton radioButtonMulher = (RadioButton) findViewById(R.id.radioButtonMulher);

        RadioButton radioButtonLeve = (RadioButton) findViewById(R.id.radioButtonLeve);
        RadioButton radioButtonModerado = (RadioButton) findViewById(R.id.radioButtonModerado);
        RadioButton radioButtonPesado = (RadioButton) findViewById(R.id.radioButtonPesado);

        CheckBox checkboxSemana = (CheckBox) findViewById(R.id.semana);
        CheckBox checkboxMes = (CheckBox) findViewById(R.id.mes);


        btnTmbClean.setOnClickListener(view -> {
            editHeight.setText("");
            editWeight.setText("");
            editAge.setText("");

            radioButtonHomem.setChecked(false);
            radioButtonMulher.setChecked(false);
            radioButtonLeve.setChecked(false);
            radioButtonModerado.setChecked(false);
            radioButtonPesado.setChecked(false);
        });

        btnTmbCalc.setOnClickListener(view -> {
            if (
                    editHeight.getText().length() != 0 &&
                            editWeight.getText().length() != 0 &&
                            editAge.getText().length() != 0 &&
                            ((radioButtonHomem.isChecked() || radioButtonMulher.isChecked()) ||
                                    (!radioButtonLeve.isChecked() || !radioButtonModerado.isChecked() || !radioButtonPesado.isChecked()))) {
                                        A = Double.parseDouble(editHeight.getText().toString());
                                        P = Double.parseDouble(editWeight.getText().toString());
                                        I = Double.parseDouble(editAge.getText().toString());

                                        /////////////////////////// SELEÇÃO SE MASCULINO //////////////////////////////
                                        if (radioButtonHomem.isChecked())
                                        {
                                            if(radioButtonLeve.isChecked())
                                            {
                                                AF=1.55;
                                            }
                                            if(radioButtonModerado.isChecked())
                                            {
                                                AF=1.78;
                                            }
                                            if(radioButtonPesado.isChecked())
                                            {
                                                AF=2.10;
                                            }
                                            if(checkboxSemana.isChecked() || checkboxMes.isChecked())
                                            {
                                                if(checkboxSemana.isChecked() && checkboxMes.isChecked())
                                                {
                                                    Resultado = 66.5 + (14 * P) + (5 * A) - (6.7 * I);
                                                    Resultado = Resultado * AF;
                                                    Resultado_semana = Resultado * 7;
                                                    Resultado_mes = Resultado * 30;
                                                    alerta("Taxa Metabólica Basal", "Sua TMB é de " +Resultado+ "Kcal diárias\nSua TMB é de "+Resultado_semana+ " kcal semanal\nSua TMB é de "+Resultado_mes+ " kcal mensal");
                                                    return;
                                                }

                                                if(checkboxSemana.isChecked())
                                                {
                                                    Resultado = 66.5 + (14 * P) + (5 * A) - (6.7 * I);
                                                    Resultado = Resultado * AF;
                                                    Resultado_semana = Resultado * 7;
                                                    alerta("Taxa Metabólica Basal", "Sua TMB é de " +Resultado+ " kcal diárias\nSua TMB é de " +Resultado_semana+ " kcal semanal");
                                                    return;
                                                }

                                                if (checkboxMes.isChecked())
                                                {
                                                    Resultado = 66.5 + (14 * P) + (5 * A) - (6.7 * I);
                                                    Resultado = Resultado * AF;
                                                    Resultado_mes = Resultado * 30;
                                                    alerta("Taxa Metabólica Basal", "Sua TMB é de " +Resultado+ " kcal diárias\nSua TMB é de " +Resultado_mes+ " kcal mensal");
                                                }
                                               else
                                                {
                                                    Resultado = 66.5 + (14 * P) + (5 * A) - (6.7 * I);
                                                    Resultado = Resultado * AF;
                                                    alerta("Taxa Metabólica Basal", "Sua TMB é de " +Resultado+ " kcal diárias");
                                                }
                                            }}
                                            /////////////////////////// SELEÇÃO SE FEMININO //////////////////////////////
                                           else if (radioButtonMulher.isChecked())
                                            {
                                                if(radioButtonLeve.isChecked())
                                                {
                                                    AF = 1.56;
                                                }
                                                if(radioButtonModerado.isChecked())
                                                {
                                                    AF = 1.64;
                                                }
                                                if(radioButtonPesado.isChecked())
                                                {
                                                    AF = 1.82;
                                                }

                                                if(checkboxSemana.isChecked() || checkboxMes.isChecked())
                                                {
                                                    if(checkboxSemana.isChecked() && checkboxMes.isChecked())
                                                    {
                                                        Resultado = 65.5 + (9.6 * P) + (1.8 * A) - (4.7 * I);
                                                        Resultado = Resultado * AF;
                                                        Resultado_semana = Resultado * 7;
                                                        Resultado_mes = Resultado * 30;
                                                        alerta("Taxa Metabólica Basal", "Sua TMB é de " +Resultado+ " kcal diárias\nSua TMB é de " +Resultado_semana+ " kcal semanal\nSua TMB é de " +Resultado_mes+ " kcal mensal");
                                                        return;
                                                    }

                                                    if(checkboxSemana.isChecked())
                                                    {
                                                        Resultado = 65.5 + (9.6 * P) + (1.8 * A) - (4.7 * I);
                                                        Resultado = Resultado * AF;
                                                        Resultado_semana = Resultado * 7;
                                                        alerta("Taxa Metabólica Basal", "Sua TMB é de " +Resultado+ " kcal diárias\nSua TMB é de " +Resultado_semana+ " kcal semanal");
                                                        return;
                                                    }

                                                    if(checkboxMes.isChecked())
                                                    {
                                                        Resultado = 65.5 + (9.6 * P) + (1.8 * A) - (4.7 * I);
                                                        Resultado = Resultado * AF;
                                                        Resultado_mes = Resultado * 30;
                                                        alerta("Taxa Metabólica Basal", "Sua TMB é de " +Resultado+ " kcal diárias\nSua TMB é de " +Resultado_mes+ " kcal mensal");
                                                    }
                                                }
                                                else
                                                {
                                                    Resultado = 65.5 + (9.6 * P) + (1.8 * A) - (4.7 * I);
                                                    Resultado = Resultado * AF;
                                                    alerta("Taxa Metabólica Basal", "Sua TMB é de " +Resultado+ " kcal diárias");
                                                }
                                            }
                                            ////////////////////////////////////////////////////////////////////////////////
                                        }
                                                ////////////////////////////////////////////////////////////////////////////////////


            ///////////////////////////////// CÁLCULO //////////////////////////////////////////
            else{
                alerta("Atenção", "Os dados altura, peso, idade, sexo e nível de atividade física devem ser preenchidos!");
            }

        });
        ////////////////////////////////////////////////////////////////////////////////////////////
    }
}