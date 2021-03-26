package com.example.nmeromgico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner intentos;
    Button iniciar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciar = findViewById(R.id.btniniciar);

        intentos = findViewById(R.id.intentos);
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this, R.array.combo_intentos, android.R.layout.simple_spinner_item);
        intentos.setAdapter(adapter);

        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btniniciar:
                        Intent intent = new Intent(v.getContext(), GameActivity.class);
                        int seleccion = Integer.valueOf(intentos.getSelectedItem().toString());
                        intent.putExtra("intSelect", seleccion);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
            }
        });
    }
}