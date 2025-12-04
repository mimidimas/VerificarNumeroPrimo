package emily.fate.numeroprimo;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText etNumeroAdicionado;
    private Button btVerificar;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etNumeroAdicionado = findViewById(R.id.etNumeroAdicionado);
        etNumeroAdicionado.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        tvResult = findViewById(R.id.tvResult);
        tvResult.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        btVerificar = findViewById(R.id.btnVerificar);
        btVerificar.setOnClickListener(v -> calc());

    }

        private void calc() {
            String texto = etNumeroAdicionado.getText().toString();

            if (texto.isEmpty()) {
                tvResult.setText("Digite um valor!");
                return;
            }

            int numero = Integer.parseInt(texto);

            // Validação de positivo
            if (numero <= 0) {
                tvResult.setText("Apenas números positivos!");
                return;
            }

            // Lógica do Primo
            if (numero == 1) {
                tvResult.setText("ESSE NÚMERO É PRIMO!");
            } else {
                boolean ePrimo = true;
                for (int i = 2; i <= numero / 2; i++) {
                    if (numero % i == 0) {
                        ePrimo = false;
                        break;
                    }
                }

                if (ePrimo) {

                    tvResult.setText(" ESSE NÚMERO É PRIMO!");
                    tvResult.setTextColor(Color.BLACK);
                } else {
                    tvResult.setText(" ESSE NÚMERO NÃO É PRIMO!");
                    tvResult.setTextColor(Color.BLACK);
                }
            }
        }

}

