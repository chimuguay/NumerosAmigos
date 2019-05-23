package com.ArturoNieva.numerosamigos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText ETnum1;
    EditText ETnum2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ETnum1 = findViewById(R.id.ETnum1);
        ETnum2 = findViewById(R.id.ETnum2);
        final TextView textResult = findViewById(R.id.textResult);
        Button verificar = findViewById(R.id.btnVerificar);

        verificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.valueOf(ETnum1.getText().toString());
                int num2 = Integer.valueOf(ETnum2.getText().toString());

                if (sonAmigos(num1, num2)){
                    textResult.setText("Si");
                }else
                    textResult.setText("No");
            }
        });
    }


    private static boolean sonAmigos(int num1, int num2){

        boolean sonAmigos;
        if(num1==sumaDivisores(num2)){
            sonAmigos = num2 == sumaDivisores(num1) ? true:false;
        } else {
            sonAmigos = false;
        }
        return sonAmigos;
    }

    private static int sumaDivisores(int numero){

        int sum = 0;
        for(int i=1;i<numero;i++){
            if(numero%i==0){
                sum += i;
            }
        }
        return sum;
    }
}
