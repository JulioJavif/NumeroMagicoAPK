package com.example.nmeromgico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    Button probar, reiniciar;
    EditText numero;
    TextView historial;
    int cont = 0, intSelect;
    int rand = (int) (Math.random()*100);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        probar = findViewById(R.id.btnprobar);
        reiniciar = findViewById(R.id.btnreset);
        numero = (EditText) findViewById(R.id.edtnumero);
        historial = findViewById(R.id.tvhistorial);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        intSelect = bundle.getInt("intSelect");

        probar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btnprobar:
                        int num = 0;
                        if (cont < intSelect) {
                            num = Integer.valueOf(numero.getText().toString());
                            if (num < rand) {
                                //Toast.makeText(getApplicationContext(), "Es menor ..."+rand, Toast.LENGTH_LONG).show();
                                cont++;
                                historial.setText(historial.getText() + "\nTu número es menor. Intento:" + cont + " Número: " + num);
                                probar.setEnabled(true);
                            } else if (num > rand) {
                                //Toast.makeText(getApplicationContext(), "Es mayor ..."+rand, Toast.LENGTH_LONG).show();
                                cont++;
                                historial.setText(historial.getText() + "\nTú número es mayor. Intento:" + cont + " Número: " + num);
                                probar.setEnabled(true);
                            } else if (num == rand) {
                                //Toast.makeText(getApplicationContext(), "Adivinaste, el numero era "+num, Toast.LENGTH_LONG).show();
                                cont++;
                                historial.setText(historial.getText() + "\nGanaste!!\nEn el turno " + cont + "\nEra el " + num);
                                probar.setEnabled(false);
                            }
                        }
                        if (cont==intSelect && (num!=rand)) {
                            historial.setText(historial.getText() + "\nPerdiste!!\nAgotaste tus " +
                                    intSelect + " intentos\nEl número era " + rand + "\nDale atrás y vuelve a intentar!!");
                            probar.setEnabled(false);
                        }
                        break;
                    default:
                        break;
                }
            }
        });

        reiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btnreset:
                        Intent intentmain = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intentmain);
                        break;
                }
            }
        });
    }
}