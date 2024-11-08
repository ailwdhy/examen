package com.example.switchingmenu;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Actividad2 extends AppCompatActivity {

    EditText textito1, textito2;
    TextView res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculadora);
        textito1 = findViewById(R.id.numero1);
        textito2 = findViewById(R.id.numero2);
        res=findViewById(R.id.textoc);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        getSupportActionBar().setTitle("Calculadora");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int x;
        int y;
        if (!textito1.getText().toString().isEmpty() && !textito2.getText().toString().isEmpty()) {
            x = Integer.parseInt(textito1.getText().toString());
            y = Integer.parseInt(textito2.getText().toString());
        } else {
            x = 0;
            y = 0;
        }
        Operaciones operaciones = new Operaciones(x, y);

        if (item.getItemId()==R.id.suma||item.getItemId()==R.id.sumat)
            res.setText("resultado de la suma: " + operaciones.suma());
        else if (item.getItemId()==R.id.resta||item.getItemId()==R.id.restat)
            res.setText("resultado de la resta: " + operaciones.resta());
        else if (item.getItemId()==R.id.multiplicar||item.getItemId()==R.id.multiplicart)
            res.setText("resultado de la multiplicación: "+ operaciones.multi());
        else if (item.getItemId()==R.id.dividir||item.getItemId()==R.id.dividirt)
            res.setText("resultado de la división: " + operaciones.divi());
        return super.onOptionsItemSelected(item);
    }
}
