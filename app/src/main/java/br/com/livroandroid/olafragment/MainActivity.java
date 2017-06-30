package br.com.livroandroid.olafragment;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;





import br.com.livroandroid.olafragment.persistence.ListaDB;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState == null) {
            android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction t = fm.beginTransaction();
            Fragment f = new Fragment();
            t.add(R.id.frag, f, "Fragment");
            t.commit();
        }
    }

    public void FragmentCadastro(View view) {
        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction t = fm.beginTransaction();
        Fragment_Cadastro f = new Fragment_Cadastro();
        t.replace(R.id.frag, f, "Fragment_Cadastro");
        t.addToBackStack(null);
        t.commit();
    }

    public void Cadastro(View view) {
        EditText edtnome = (EditText) findViewById(R.id.hortfrut);
        EditText edttipo = (EditText) findViewById(R.id.tipo);

        Hortfrut_Produtos hf = new Hortfrut_Produtos();
        hf.setNome(edtnome.getText().toString());
        hf.setTipo(edttipo.getText().toString());

        ListaDB listaDB = new ListaDB(getApplicationContext());

        if (listaDB.Salvar(hf) > 0) {
            Toast.makeText(getApplicationContext(), "Hortfrut cadastrada", Toast.LENGTH_LONG)
                    .show();
        } else {
            Toast.makeText(getApplicationContext(), "Erro ao cadastrar", Toast.LENGTH_LONG)
                    .show();
        }
    }


}
