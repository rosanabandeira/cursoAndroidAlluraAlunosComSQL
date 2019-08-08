package android.studio.agenda.model;

import android.studio.agenda.R;
import android.studio.agenda.ui.activity.FormularioAlunoActivity;
import android.widget.EditText;
import android.widget.RatingBar;

public class FormularioHelper {

    private EditText campoNome;
    private EditText campoEmail;
    private EditText campoTelefone;
    private RatingBar campoNota;
    private Aluno aluno;


    public FormularioHelper(FormularioAlunoActivity activity) {
        campoNome = activity.findViewById(R.id.activity_formuario_aluno_nome);
        campoEmail = activity.findViewById(R.id.activity_formuario_aluno_email);
        campoTelefone = activity.findViewById(R.id.activity_formuario_aluno_telefone);
        campoNota = activity.findViewById(R.id.activity_formulario_aluno_rating);
        aluno = new Aluno();
    }

    public Aluno pegaAluno() {
        Aluno aluno = new Aluno();
        aluno.setNome(campoNome.getText().toString());
        aluno.setEmail(campoEmail.getText().toString());
        aluno.setTelefone(campoTelefone.getText().toString());
        aluno.setNota(Double.valueOf(campoNota.getProgress()));
        return aluno;
    }

    public void preencheFormulario(Aluno aluno) {
        campoNome.setText(aluno.getNome());
        campoEmail.setText(aluno.getEmail());
        campoTelefone.setText(aluno.getTelefone());
       campoNota.setProgress(aluno.getNota().intValue());
        this.aluno = aluno;

    }
}
