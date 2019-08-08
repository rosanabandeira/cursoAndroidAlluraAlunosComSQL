package android.studio.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.studio.agenda.DAO.AlunoDaoSQL;
import android.studio.agenda.R;
import android.studio.agenda.model.Aluno;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ListaAlunosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        Toolbar toolbar = findViewById(R.id.formulario_toolbar);
        toolbar.setTitle("Lista de alunos");

        //LISTA ESTATICA DOS ALUNOS QUE VAI SER SUBSTITUIDA PELO DAO
        /*String[] alunos = {"Aluno1", "aluno2", "Aluno3"};
        ListView listaAlunos = findViewById(R.id.activity_lista_de_alunos_listview);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, alunos);
        listaAlunos.setAdapter(adapter);*/


        AlunoDaoSQL alunoDaoSQL = new AlunoDaoSQL(this);
        List<Aluno> alunos = alunoDaoSQL.buscaAlunos();

        ListView listaAlunos = findViewById(R.id.activity_lista_de_alunos_listview);
        ArrayAdapter<Aluno> adapter = new ArrayAdapter<Aluno>(this, android.R.layout.simple_list_item_1, alunos);
        listaAlunos.setAdapter(adapter);


        FloatingActionButton floatingActionButton = findViewById(R.id.lista_alunos_fab_novo_aluno);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListaAlunosActivity.this, FormularioAlunoActivity.class);
                startActivity(intent);
            }
        });


    }
}
