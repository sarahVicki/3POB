import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GerenciadorAlunos {
  ArrayList<Aluno> alunos = new ArrayList<>();
  private int proximaMatricula = 5020;

  public void adicionarAluno(String nome, String curso) {
    Aluno aluno = new Aluno(proximaMatricula, nome, curso);
    alunos.add(aluno);
    proximaMatricula++;
  }

  public void listarAlunos() {
    for (Aluno aluno : alunos) {
      System.out.println();
      System.out.println("Matrícula: " + aluno.getMatricula());
      System.out.println("Nome: " + aluno.getNome());
      System.out.println("Curso: " + aluno.getCurso());
      System.out.println();
    }
  }

  public void atualizarAluno(int matricula, String nome, String curso) {
    for (Aluno aluno : alunos) {
      if (aluno.getMatricula() == matricula) {
        Aluno aluno2 = new Aluno(matricula, nome, curso);
        alunos.set(alunos.indexOf(aluno),(aluno2));
        System.out.println("Aluno atualizado com sucesso.");
        return;
      }
    }
    System.out.println("Aluno não encontrado.");
  }

  public void removerAluno(int matricula) {
    for (int i = 0; i < alunos.size(); i++) {
      if (alunos.get(i).getMatricula() == matricula) {
        alunos.remove(i);
        System.out.println("Aluno removido com sucesso.");
        return;
      }
    }
    System.out.println("Aluno não encontrado.");
  }

  public Boolean ValidaNome() {
    Pattern pattern = Pattern.compile("^[a-z]+[\\s][a-z]+$", Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher("Visit WSchools");
    boolean matchFound = matcher.find();
    if(matchFound) {
      System.out.println("Nome Match found");
      return true;
    } else {
      System.out.println("Nome Match not found");
      return false;
    }
  }

}
