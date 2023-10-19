import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    GerenciadorAlunos gerenciador = new GerenciadorAlunos();
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println();
      System.out.println("===== Gerenciador de Alunos =====");
      System.out.println("1. Adicionar Aluno");
      System.out.println("2. Listar Alunos");
      System.out.println("3. Atualizar Aluno");
      System.out.println("4. Remover Aluno");
      System.out.println("5. Sair");
      System.out.println();
      System.out.print("Escolha uma opção: ");

      int opcao = scanner.nextInt();
      scanner.nextLine(); // Limpar a quebra de linha

      switch (opcao) {
        case 1:
          System.out.print("Digite o nome do aluno: ");
          String nome = scanner.nextLine();
          System.out.print("Digite o curso do aluno: ");
          String curso = scanner.nextLine();
          gerenciador.adicionarAluno(nome, curso);
          break;
          
        case 2:
          gerenciador.listarAlunos();
          break;
                  
        case 3:
          System.out.print("Digite a matrícula do aluno a ser atualizado: ");
          int matriculaAtualizar = scanner.nextInt();
          scanner.nextLine();
          System.out.print("Digite o novo nome do aluno: ");
          String novoNome = scanner.nextLine();
          System.out.print("Digite o novo curso do aluno: ");
          String novoCurso = scanner.nextLine();
          gerenciador.atualizarAluno(matriculaAtualizar, novoNome, novoCurso);
          break;
          
        case 4:
          System.out.print("Digite a matrícula do aluno a ser removido: ");
          int matriculaRemover = scanner.nextInt();
          gerenciador.removerAluno(matriculaRemover);
          break;
          
        case 5:
          System.out.println("Saindo do programa...");
          return;
      }
    }
  }
}
