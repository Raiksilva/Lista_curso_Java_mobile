package devandroid.raik.applistacurso.View;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import devandroid.raik.applistacurso.Controller.PessoaController;
import devandroid.raik.applistacurso.Model.Pessoa;
import devandroid.raik.applistacurso.R;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;
    public static final String NOME_PREFERENCES = "pref_listvip";

    Pessoa pessoa;
    PessoaController controller;

    EditText editNome;
    EditText editSobNome;
    EditText editNomeCurso;
    EditText editTelContato;

    Button  btnLimpar;
    Button  btnSalvar;
    Button  btnFinalizar;

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

        preferences = getSharedPreferences(NOME_PREFERENCES, 0);
        @SuppressLint("CommitPrefEdits") SharedPreferences.Editor listaVip = preferences.edit();


        pessoa = new Pessoa();
        controller = new PessoaController();
        controller.logDebug();

        pessoa.setPrimeiroNome("Antonio");
        pessoa.setSobreNome("Silva");
        pessoa.setCursoDesejado("Java");
        pessoa.setTelefoneContato("81 9 9930-1025");


        editNome = findViewById(R.id.editNome);
        editSobNome = findViewById(R.id.editSobNome);
        editNomeCurso = findViewById(R.id.editNomeCurso);
        editTelContato = findViewById(R.id.editTelContato);

        btnSalvar = findViewById(R.id.btnSalvar);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        editNome.setText(pessoa.getPrimeiroNome());
        editSobNome.setText(pessoa.getSobreNome());
        editNomeCurso.setText(pessoa.getCursoDesejado());
        editTelContato.setText(pessoa.getTelefoneContato());

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editNome.setText("");
                editSobNome.setText("");
                editNomeCurso.setText("");
                editTelContato.setText("");
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Volte Sempre", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pessoa.setPrimeiroNome(editNome.getText().toString());
                pessoa.setSobreNome(editSobNome.getText().toString());
                pessoa.setCursoDesejado(editNomeCurso.getText().toString());
                pessoa.setTelefoneContato(editTelContato.getText().toString());

                Toast.makeText(MainActivity.this, "Salvo", Toast.LENGTH_LONG).show();

                listaVip.putString("primeiroNome",pessoa.getPrimeiroNome());
                listaVip.putString("sobreNome",pessoa.getSobreNome());
                listaVip.putString("cursoDesejado",pessoa.getCursoDesejado());
                listaVip.putString("telefoneContato",pessoa.getTelefoneContato());
                listaVip.apply();

                controller.salvar(pessoa);
            }
        });
    }
}