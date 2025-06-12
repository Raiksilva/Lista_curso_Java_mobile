package devandroid.raik.applistacurso.Controller;

import android.util.Log;

import devandroid.raik.applistacurso.Model.Pessoa;

public class PessoaController {

    public void logDebug() {
        Log.d("MVC_Controller", "Controller iniciado...");
    }

    public void salvar(Pessoa pessoa) {
        Log.d("MVC_Controller", "Salvando pessoas..."+pessoa.toString());
    }
}
