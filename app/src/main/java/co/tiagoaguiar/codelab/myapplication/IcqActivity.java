package co.tiagoaguiar.codelab.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class IcqActivity extends AppCompatActivity {

    private EditText editCintura;
    private EditText editQuadril;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icq);

        editCintura = findViewById(R.id.edit_icq_cintura);
        editQuadril = findViewById(R.id.edit_icq_quadril);

        Button btnIcqClean = findViewById(R.id.btn_icq_limpar);
        Button btnIcqCalc = findViewById(R.id.btn_icq_calc);
        RadioButton radioButtonHomem = findViewById(R.id.radioButtonHomem);
        RadioButton radioButtonMulher = findViewById(R.id.radioButtonMulher);


        btnIcqClean.setOnClickListener(view -> {
            editCintura.setText("");
            editQuadril.setText("");
            radioButtonHomem.setChecked(false);
            radioButtonMulher.setChecked(false);
        });

        btnIcqCalc.setOnClickListener(view -> {
            if (!validate()) {
                Toast.makeText(IcqActivity.this, R.string.filds_messages, Toast.LENGTH_LONG).show();
                return;
            }

            String sCintura = editCintura.getText().toString();
            String sQuadril = editQuadril.getText().toString();

            int cintura = Integer.parseInt(sCintura);
            int quadril = Integer.parseInt(sQuadril);

            double result = caluculateIcq(cintura, quadril);
            Log.d("TESTE", "Resultado: " + result);

            int icqResponseId = icqResponse(result);

            AlertDialog dialog = new AlertDialog.Builder(IcqActivity.this)
                    .setTitle(getString(R.string.icq_response, result))
                    .setMessage(icqResponseId)
                    .setPositiveButton(android.R.string.ok, (dialogInterface, i) -> {
                    })
                    .create();

            dialog.show();

            //ESCONDENDO O TECLADO
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(editCintura.getWindowToken(), 0);
            imm.hideSoftInputFromWindow(editQuadril.getWindowToken(), 0);


        });
    }

    @StringRes
    private int icqResponse(double icq) {
        if (icq < 0.80)
            return R.string.icq_severely_low_weight;
        else if (icq < 0.83)
            return R.string.icq_very_low_weight;
        else if (icq < 0.85)
            return R.string.icq_low_weight;
        else if (icq < 0.88)
            return R.string.normal;
        else if (icq < 0.89)
            return R.string.icq_high_weight;
        else if (icq < 0.94)
            return R.string.icq_so_high_weight;
        else
            return R.string.icq_extreme_weight;
    }


    private double caluculateIcq(double cintura, double quadril) {
        // (Cintura / Quadril)
        return quadril / cintura;
    }

    private boolean validate() {
        return (!editCintura.getText().toString().startsWith("0")
                && !editQuadril.getText().toString().startsWith("0")
                && !editCintura.getText().toString().isEmpty()
                && !editQuadril.getText().toString().isEmpty());
    }
}