package com.example.apppizza;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class TelaPIzza extends AppCompatActivity {
   String valorMusa, valorPepe,valorAtum,valorFrango;
    Intent it;
    Button btnCalcular,MaisMusa,MaisPeperoni,MaisAtum,MaisFrango,MenosMusa,MenosPeperoni,MenosAtum,MenosFrango;
    TextView qntdMusa,qntdPeperoni,qntdAtum,qntdFrango;
    int contadorFrango = 0,contadorAtum = 0,contadorMussa = 0, contadorPepe=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_pizza);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnCalcular = findViewById(R.id.btnCalcular);

        MaisMusa = findViewById(R.id.btnMaismussarela);
        MaisPeperoni = findViewById(R.id.btnMaispepperoni);
        MaisAtum = findViewById(R.id.btnMaisatum);
        MaisFrango = findViewById(R.id.btnMaisfrango);

        MenosMusa = findViewById(R.id.btnMenosmussarela);
        MenosPeperoni = findViewById(R.id.btnMenospepperoni);
        MenosAtum = findViewById(R.id.btnMenosatum);
        MenosFrango = findViewById(R.id.btnMenosfrango);

        qntdMusa = findViewById(R.id.txtQntdMussarela);
        qntdPeperoni = findViewById(R.id.txtQntdPeperoni);
        qntdAtum = findViewById(R.id.txtQntdAtum);
        qntdFrango = findViewById(R.id.txtQntdFrango);


        atualizarStatusBotao(MenosMusa, contadorMussa);
        atualizarStatusBotao(MenosPeperoni, contadorPepe);
        atualizarStatusBotao(MenosAtum, contadorAtum);
        atualizarStatusBotao(MenosFrango, contadorFrango);

        MaisMusa.setOnClickListener(v -> {
            contadorMussa++;
            qntdMusa.setText(String.valueOf(contadorMussa));
            atualizarStatusBotao(MenosMusa, contadorMussa);
        });

        MenosMusa.setOnClickListener(v -> {
            if (contadorMussa > 0) {
                contadorMussa--;
                qntdMusa.setText(String.valueOf(contadorMussa));
                atualizarStatusBotao(MenosMusa, contadorMussa);
            }
        });

// --- Lógica para Pepperoni ---
        MaisPeperoni.setOnClickListener(v -> {
            contadorPepe++;
            qntdPeperoni.setText(String.valueOf(contadorPepe));
            atualizarStatusBotao(MenosPeperoni, contadorPepe);
        });

        MenosPeperoni.setOnClickListener(v -> {
            if (contadorPepe > 0) {
                contadorPepe--;
                qntdPeperoni.setText(String.valueOf(contadorPepe));
                atualizarStatusBotao(MenosPeperoni, contadorPepe);
            }
        });

// --- Lógica para Atum ---
        MaisAtum.setOnClickListener(v -> {
            contadorAtum++;
            qntdAtum.setText(String.valueOf(contadorAtum));
            atualizarStatusBotao(MenosAtum, contadorAtum);
        });

        MenosAtum.setOnClickListener(v -> {
            if (contadorAtum > 0) {
                contadorAtum--;
                qntdAtum.setText(String.valueOf(contadorAtum));
                atualizarStatusBotao(MenosAtum, contadorAtum);
            }
        });

// --- Lógica para Frango ---
        MaisFrango.setOnClickListener(v -> {
            contadorFrango++;
            qntdFrango.setText(String.valueOf(contadorFrango));
            atualizarStatusBotao(MenosFrango, contadorFrango);
        });

        MenosFrango.setOnClickListener(v -> {
            if (contadorFrango > 0) {
                contadorFrango--;
                qntdFrango.setText(String.valueOf(contadorFrango));
                atualizarStatusBotao(MenosFrango, contadorFrango);
            }
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(contadorPepe == 0 && contadorAtum == 0 && contadorFrango == 0 && contadorMussa == 0 ){
                    Snackbar.make(findViewById(android.R.id.content), "Nenhuma pizza selecionada", Snackbar.LENGTH_LONG)
                            .setBackgroundTint(Color.parseColor("#4B0011")) // Cor vinho para combinar com seu app
                            .setTextColor(Color.WHITE)
                            .show();
                }else {
                    valorPepe = String.format("%.2f",contadorPepe * 62.50);
                    valorFrango = String.format("%.2f",contadorFrango * 68.70);
                    valorMusa = String.format("%.2f",contadorMussa * 55.90);
                    valorAtum = String.format("%.2f",contadorAtum * 70.90);
                    Double totalGeral = Double.parseDouble(valorAtum) + Double.parseDouble(valorFrango)+Double.parseDouble(valorMusa)+Double.parseDouble(valorPepe);
                    String extrato =("-").repeat(90)+"\nExtrato:"+(" ").repeat(80)+"Total\n";
                    extrato += (contadorPepe > 0) ? ""+qntdPeperoni.getText().toString() +"X  Peperoni("+"R$62.50):"+(" ").repeat(44)+"R$"+valorPepe+ "\n": "";
                    extrato += (contadorFrango > 0) ? qntdFrango.getText().toString() +"X  Frango c/catupiry("+"R$68.70):"+(" ").repeat(28)+"R$"+valorFrango+ "\n": "";
                    extrato += (contadorMussa > 0) ? qntdMusa.getText().toString() +"X  Mussarela("+"R$55.90):"+(" ").repeat(41)+"R$"+valorMusa+ "\n": "";
                    extrato += (contadorAtum > 0) ? qntdAtum.getText().toString() +"X  Atum c/catupiry("+"R$70.90):"+(" ").repeat(31)+"R$"+valorAtum+ "\n": "";
                    extrato +=("-").repeat(90)+"\n";
                    it = new Intent(getApplicationContext(), TelaResultado.class);
                    it.putExtra("extrato", extrato);
                    String totalFormatado = String.format("%.2f", totalGeral);
                    it.putExtra("ValorTotal", "Valor da conta: "+(" ").repeat(33)+"R$"+totalFormatado);
                    startActivity(it);
                }
            }
        });

    }
    private void atualizarStatusBotao(Button botao, int quantidade) {
        if (quantidade <= 0) {
            botao.setEnabled(false);
            botao.setBackgroundTintList(android.content.res.ColorStateList.valueOf(android.graphics.Color.GRAY));
        } else {
            botao.setEnabled(true);
            botao.setBackgroundTintList(android.content.res.ColorStateList.valueOf(android.graphics.Color.parseColor("#4B0011")));
        }
    }
}