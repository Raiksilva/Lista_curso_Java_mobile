package devandroid.raik.applistacurso.Controller;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.util.Log;

import devandroid.raik.applistacurso.Model.Pessoa;
import devandroid.raik.applistacurso.View.MainActivity;

public class PessoaController {

    SharedPreferences preferences;

    @SuppressLint("CommitPrefEdits")
    SharedPreferences.Editor listaVip;

    public static final String NOME_PREFERENCES = "pref_listvip";

    public PessoaController(MainActivity mainActivity) {
        preferences =
                mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }

    public void logDebug() {
        Log.d("MVC_Controller", "Controller iniciado...");
    }

    public void criarSharedPreferences() {

    }

    public void salvar(Pessoa pessoa) {
        listaVip.putString("primeiroNome", pessoa.getPrimeiroNome());
        listaVip.putString("sobreNome", pessoa.getSobreNome());
        listaVip.putString("cursoDesejado", pessoa.getCursoDesejado());
        listaVip.putString("telefoneContato", pessoa.getTelefoneContato());
        listaVip.apply();
    }

    public Pessoa buscar(Pessoa pessoa) {

        pessoa.setPrimeiroNome(preferences.getString("primeiroNome", ""));
        pessoa.setSobreNome(preferences.getString("sobreNome", ""));
        pessoa.setCursoDesejado(preferences.getString("cursoDesejado", ""));
        pessoa.setTelefoneContato(preferences.getString("telefoneContato", ""));

        return pessoa;
    }

    public void limpar() {
        listaVip.clear();
        listaVip.apply();
    }


}
