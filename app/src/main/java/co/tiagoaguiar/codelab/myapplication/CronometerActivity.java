package co.tiagoaguiar.codelab.myapplication;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CronometerActivity extends AppCompatActivity {

    TextView chronometer;
    private int min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cronometer);
        View btn_15seg = findViewById(R.id.btn_15);
        View btn_30seg = findViewById(R.id.btn_30);
        View btn_45seg = findViewById(R.id.btn_45);
        View btn_60seg = findViewById(R.id.btn_60);
        View btn_75seg = findViewById(R.id.btn_75);
        View btn_90seg = findViewById(R.id.btn_90);
        chronometer = findViewById(R.id.txtView);

        btn_15seg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciarSoma ();
            }

            final Intent intent = new Intent("ALARME");
            final PendingIntent segundos = PendingIntent.getBroadcast(CronometerActivity.this,0, intent, 0);


            private void iniciarSoma() {
                String seg = Integer.valueOf(15*1000).toString();
                long valor = Long.parseLong(seg);
                CountDownTimer conta = new CountDownTimer(valor,1000) {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onTick(long l) {
                        long tempo = l/1000;
                        long minutos = (int) (tempo % 60);
                        long segundos = tempo % 60;
                        @SuppressLint("DefaultLocale") String minutos_mostrar = String.format("%02d", minutos);
                        @SuppressLint("DefaultLocale") String segundos_mostrar = String.format("%02d", segundos);
                        chronometer.setText("" +segundos_mostrar);
                    }


                    @Override
                    public void onFinish() {
                        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
                        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),notification);

                        mp.start();

                        Toast.makeText(CronometerActivity.this, "15 SEGUNDOS ACABOU, CONTINUE ASSIM E BOM TREINO!",Toast.LENGTH_LONG).show();
                        chronometer.setText("");


                    }
                }.start();
                 

            }
        });


        btn_30seg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciarSoma ();
            }

            private void iniciarSoma() {
                String seg = Integer.valueOf(30*1000).toString();
                long valor = Long.parseLong(seg);
                CountDownTimer conta = new CountDownTimer(valor,1000) {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onTick(long l) {
                        long tempo = l/1000;
                        long minutos = (int) (tempo % 60);
                        long segundos = tempo % 60;
                        @SuppressLint("DefaultLocale") String minutos_mostrar = String.format("%02d", minutos);
                        @SuppressLint("DefaultLocale") String segundos_mostrar = String.format("%02d", segundos);
                        chronometer.setText("" +segundos_mostrar);
                    }


                    @Override
                    public void onFinish() {
                        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
                        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),notification);
                        mp.start();

                        Toast.makeText(CronometerActivity.this, "30 SEGUNDOS ACABOU, CONTINUE ASSIM E BOM TREINO!", Toast.LENGTH_LONG).show();
                        chronometer.setText("");

                    }
                }.start();


            }
        });

        btn_45seg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciarSoma ();
            }

            private void iniciarSoma() {
                String seg = Integer.valueOf(45*1000).toString();
                long valor = Long.parseLong(seg);
                CountDownTimer conta = new CountDownTimer(valor,1000) {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onTick(long l) {
                        long tempo = l/1000;
                        long minutos = (int) (tempo % 60);
                        long segundos = tempo % 60;
                        @SuppressLint("DefaultLocale") String minutos_mostrar = String.format("%02d", minutos);
                        @SuppressLint("DefaultLocale") String segundos_mostrar = String.format("%02d", segundos);
                        chronometer.setText("" +segundos_mostrar);
                    }


                    @Override
                    public void onFinish() {
                        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
                        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),notification);
                        mp.start();

                        Toast.makeText(CronometerActivity.this, "45 SEGUNDOS ACABOU, CONTINUE ASSIM E BOM TREINO!", Toast.LENGTH_LONG).show();
                        chronometer.setText("");

                    }
                }.start();


            }
        });

        btn_60seg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciarSoma ();
            }

            private void iniciarSoma() {
                String seg = Integer.valueOf(60*1000).toString();
                long valor = Long.parseLong(seg);
                CountDownTimer conta = new CountDownTimer(valor,1000) {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onTick(long l) {
                        long tempo = l/1000;
                        long minutos = (int) (tempo / 60);
                        long segundos = tempo % 60;
                        @SuppressLint("DefaultLocale") String minutos_mostrar = String.format("%01d", minutos);
                        @SuppressLint("DefaultLocale") String segundos_mostrar = String.format("%02d", segundos);
                        chronometer.setText(""+minutos_mostrar+":" +segundos_mostrar);
                    }


                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onFinish() {
                        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
                        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),notification);
                        mp.start();

                        Toast.makeText(CronometerActivity.this, "60 SEGUNDOS ACABOU, CONTINUE ASSIM E BOM TREINO!", Toast.LENGTH_LONG).show();
                        chronometer.setText("00:00:00");

                    }
                }.start();


            }
        });

        btn_75seg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciarSoma ();
            }

            private void iniciarSoma() {
                String seg = Integer.valueOf(75*1000).toString();
                long valor = Long.parseLong(seg);
                CountDownTimer conta = new CountDownTimer(valor,1000) {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onTick(long l) {
                        long tempo = l/1000;
                        long minutos = (int) (tempo / 60);
                        long segundos = tempo % 60;
                        @SuppressLint("DefaultLocale") String minutos_mostrar = String.format("%02d", minutos);
                        @SuppressLint("DefaultLocale") String segundos_mostrar = String.format("%02d", segundos);
                        chronometer.setText(""+minutos_mostrar+":" +segundos_mostrar);
                    }


                    @Override
                    public void onFinish() {
                        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
                        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),notification);
                        mp.start();

                        Toast.makeText(CronometerActivity.this, "75 SEGUNDOS ACABOU, CONTINUE ASSIM E BOM TREINO!", Toast.LENGTH_LONG).show();
                        chronometer.setText("");

                    }
                }.start();


            }
        });

        btn_90seg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciarSoma ();
            }

            private void iniciarSoma() {
                String seg = Integer.valueOf(90*1000).toString();
                long valor = Long.parseLong(seg);
                CountDownTimer conta = new CountDownTimer(valor,1000) {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onTick(long l) {
                        long tempo = l/1000;
                        long minutos = (int) (tempo / 60);
                        long segundos = tempo % 60;
                        @SuppressLint("DefaultLocale") String minutos_mostrar = String.format("%02d", minutos);
                        @SuppressLint("DefaultLocale") String segundos_mostrar = String.format("%02d", segundos);
                        chronometer.setText(""+minutos_mostrar+":" +segundos_mostrar);
                    }

                    @Override
                    public void onFinish() {
                        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
                        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),notification);
                        mp.start();

                        Toast.makeText(CronometerActivity.this, "90 SEGUNDOS ACABOU, CONTINUE ASSIM E BOM TREINO!", Toast.LENGTH_LONG).show();
                        chronometer.setText("");

                    }
                }.start();


            }
        });





    }
}
