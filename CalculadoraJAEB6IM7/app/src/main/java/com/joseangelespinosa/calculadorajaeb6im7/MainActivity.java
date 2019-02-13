package com.joseangelespinosa.calculadorajaeb6im7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLOutput;

public class MainActivity extends AppCompatActivity {

    private Double num1, num2, res;
    private String operador;
    private boolean punto = false;
    private boolean negativo = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btClear(View us) {
        TextView text = findViewById(R.id.nums);
        this.num1 = 0.0;
        this.num2 = 0.0;
        punto = false;
        negativo = false;
        text.setText("");
    }

    public void btUno(View us) {
        TextView text = findViewById(R.id.nums);
        text.setText(text.getText() + "1");
    }

    public void btDos(View us) {
        TextView text = findViewById(R.id.nums);
        text.setText(text.getText() + "2");
    }

    public void btTres(View us) {
        TextView text = findViewById(R.id.nums);
        text.setText(text.getText() + "3");
    }

    public void btCuatro(View us) {
        TextView text = findViewById(R.id.nums);
        text.setText(text.getText() + "4");
    }

    public void btCinco(View us) {
        TextView text = findViewById(R.id.nums);
        text.setText(text.getText() + "5");
    }

    public void btSeis(View us) {
        TextView text = findViewById(R.id.nums);
        text.setText(text.getText() + "6");
    }

    public void btSiete(View us) {
        TextView text = findViewById(R.id.nums);
        text.setText(text.getText() + "7");
    }

    public void btOcho(View us) {
        TextView text = findViewById(R.id.nums);
        text.setText(text.getText() + "8");
    }

    public void btNueve(View us) {
        TextView text = findViewById(R.id.nums);
        text.setText(text.getText() + "9");
    }

    public void btCero(View us) {
        TextView text = findViewById(R.id.nums);
        text.setText(text.getText() + "0");
    }

    public void btPunto(View us) {
        if(!punto){
            TextView text = findViewById(R.id.nums);
            text.setText(text.getText() + ".");
            punto = true;
        }
    }

    public void btmenos(View us) {
        if(!negativo){
            TextView text = findViewById(R.id.nums);
            text.setText("-" + text.getText());
            negativo = true;
        }
    }

    public void capturaNum1(View us) {
        TextView text = findViewById(R.id.nums);
        this.num1 = Double.parseDouble(text.getText().toString());
        text.setText("");
    }

    public void suma(View us) {
        this.operador = "+";
        capturaNum1(us);
    }

    public void resta(View us) {
        this.operador = "-";
        capturaNum1(us);
    }

    public void multiplicacion(View us) {
        this.operador = "x";
        capturaNum1(us);
    }

    public void division(View us) {
        this.operador = "/";
        capturaNum1(us);
    }

    public void potencia(View us) {
        this.operador = "^";
        capturaNum1(us);
    }

    public void raiz(View us) {
        TextView text = findViewById(R.id.nums);
        capturaNum1(us);
        this.res = Math.sqrt(this.num1);
        text.setText(Double.toString(this.res));
    }

    public void realizarOperacion(View us) {
        TextView text = findViewById(R.id.nums);
        this.num2 = Double.parseDouble(text.getText().toString());

        try {
            if (operador.equals("+")) {
                this.res = this.num1 + this.num2;
            } else if (operador.equals("-")) {
                this.res = this.num1 - this.num2;
            } else if (operador.equals("x")) {
                this.res = this.num1 * this.num2;
            } else if (operador.equals("/")) {
                this.res = this.num1 / this.num2;
            } else if (operador.equals("^")) {
                this.res = Math.pow(this.num1, this.num2);
            }
            punto = false;
            negativo = false;
            text.setText(Double.toString(this.res));
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText( MainActivity.this , e.getMessage(), Toast.LENGTH_LONG).show();
        }


    }
}