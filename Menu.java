//package com.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class Menu {
  private ArrayList<Aluno> alunos = new ArrayList();
  private int opcao = 0;

  public void Processamento() {
    Scanner sc = new Scanner(System.in);


      do {
        System.out.println("Digite a opção:");
        System.out.println("1- Incluir Aluno: ");
        System.out.println("2- Alterar Aluno: ");
        System.out.println("3- Excluir Aluno: ");
        System.out.println("4- Listar Alunos: ");
        System.out.println("5- Buscar Aluno: ");
        System.out.println("6- Sair ");

        opcao = sc.nextInt();

        System.out.println("opção é: " + opcao);

      //	sc.close();

        switch(opcao)
        {
        case 1:
          IncluirAluno();
          break;
        case 2:
          AlterarAluno();
          break;
        case 3:
          ExcluirAluno();
          break;

        case 4:
          ListarAluno();
          break;

        case 5:
          BuscarAluno();
          break;

        case 6:
          System.exit(0);
          break;

        default:
          System.out.println("Opção inválida. Tente novamente!");
        }


      } while (opcao != 6);


  }
  public Boolean ValidaNome(String nome) {
    Pattern pattern = Pattern.compile("^[a-z]+[\\s][a-z]+$", Pattern.CASE_INSENSITIVE);
      Matcher matcher = pattern.matcher(nome);
      boolean matchFound = matcher.find();
      if(matchFound) {
        System.out.println("Nome valido");
      } else {
        System.out.println("Nome invalido");
      }
     return matchFound;
  }
  public Boolean ValidaCpf(String cpf) {
    Pattern pattern = Pattern.compile("^[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}$");
    Matcher matcher = pattern.matcher(cpf);
      boolean matchFound = matcher.find();
      if(matchFound) {
        System.out.println("CPF valido");
      } else {
        System.out.println("CPF invalido");
      }
      return matchFound;
  }
  public Boolean ValidaData (String dtAux){
    Pattern pattern = Pattern.compile("^[0-3][0-9]/[0-1][0-2]/[1-2][0-9]{3}$");
    Matcher matcher = pattern.matcher(dtAux);
      boolean matchFound = matcher.find();
      if(matchFound) {
        System.out.println("Data valida");
      } else {
        System.out.println("Data invalida");
      }
      return matchFound;
  }
  public Boolean ValidaMatricula(String matricula){
    Pattern pattern = Pattern.compile("^[0-9]{5}$");
    Matcher matcher = pattern.matcher(matricula);
      boolean matchFound = matcher.find();
      if(matchFound) {
        System.out.println("Matricula valida");
      } else {
        System.out.println("Matricula invalida");
      }
      return matchFound;
  }

  public Boolean ValidaCep(String cep){
    Pattern pattern = Pattern.compile("^[2][0-8][0-9]{3}-[0-9]{3}$");//20000-000 28999-999
    Matcher matcher = pattern.matcher(cep);
      boolean matchFound = matcher.find();
      if(matchFound) {
      System.out.println("Cep valido");
      } else {
        System.out.println("Cep invalido");
      }
      return matchFound;
  }
  public Boolean IncluirAluno() {
    String nome = "";
    String cpf = "";
    String dtAux = "";
    String matricula = "";
    String endereco = "";
    String cep = "";
    boolean resp=false;
    Scanner sc = new Scanner(System.in);

    while(!resp){
      System.out.println("Digite seu primeiro nome ");
      nome = sc.nextLine();
      resp=ValidaNome(nome);
    }
    resp=false;

    System.out.println("o nome digitado é: " + nome);

    while(!resp){
      System.out.println("Digite seu CPF (ex: 123.456.789-01): ");
      cpf = sc.nextLine();
      resp = ValidaCpf(cpf);
    }
    resp=false;
      System.out.println("Seu CPF é: " + cpf);

    while(!resp){
      System.out.println("Digite sua data de nascimento: dd/mm/aaaa: ");
      dtAux = sc.nextLine();
      resp = ValidaData(dtAux);
    }
    resp=false;
      System.out.println("sua data de nascimento é: " + dtAux);

    while(!resp){
      System.out.println("Digite sua matricula: ");
      matricula = sc.nextLine();
      resp = ValidaMatricula(matricula);
    }
    resp=false;
      System.out.println("sua data de nascimento é: " + matricula);

      System.out.println("Digite seu Endereço: ");
      endereco = sc.nextLine();
      System.out.println("valor de endereco: " + endereco);

    while(!resp){
      System.out.println("Digite seu CEP (ex: 23000-000): ");
      cep = sc.nextLine();
      resp = ValidaCep(cep);
    }
    resp=false;

      System.out.println("valor de cep: " + cep);

      Aluno aluno = new Aluno(nome, cpf, matricula, dtAux, endereco, cep);

      alunos.add(aluno);

    //sc.close();

    return true;
  }
  public boolean BuscarAluno(){
    String matricula;
    Scanner sc = new Scanner(System.in);
    System.out.println("Digite seu a matricula que você quer buscar: ");
    matricula = sc.nextLine();

    for (int i = 0; i < alunos.size(); i++) {
      if (alunos.get(i).getMatricula().equals(matricula)) {
        System.out.println("Aluno encontrado com sucesso.\n");
        System.out.println(alunos.get(i).getMatricula());
        System.out.println(alunos.get(i).getNome());
        System.out.println(alunos.get(i).getCpf());
        System.out.println(alunos.get(i).getDtNasc());
        System.out.println(alunos.get(i).getEndereco());
        System.out.println(alunos.get(i).getCep());
        return true;

      }
    }
    System.out.println("Aluno não encontrado");
    return false;


  //	sc.close();
  }
  public void ListarAluno() {

    for (int i = 0; i < alunos.size(); i++) {
      System.out.println("\nDados do Aluno:\n");
      System.out.println(alunos.get(i).getMatricula());
      System.out.println(alunos.get(i).getNome());
      System.out.println(alunos.get(i).getCpf());
      System.out.println(alunos.get(i).getDtNasc());
      System.out.println(alunos.get(i).getEndereco());
      System.out.println(alunos.get(i).getCep());
    }
  }

  public boolean ExcluirAluno() {
    String matricula;
    Scanner sc = new Scanner(System.in);
    System.out.println("Digite seu a matricula que você quer Excluir: ");
    matricula = sc.nextLine();
    for (int i = 0; i < alunos.size(); i++) {
      if (alunos.get(i).getMatricula().equals(matricula)) {
        alunos.remove(i);
        System.out.println("Aluno Removido");
        return true;
      }
    }
    System.out.println("Aluno não encontrado");
    return false;
  }
  public boolean AlterarAluno() {
    String matricula;
    Scanner sc = new Scanner(System.in);
    System.out.println("Digite seu a matricula que você quer Alterar: ");
    matricula = sc.nextLine();

    for (int i = 0; i < alunos.size(); i++) {

      if (alunos.get(i).getMatricula().equals(matricula)) {
        alunos.remove(i);
        IncluirAluno();
        System.out.println("Aluno Alterado com sucesso");
        return true;
      }
    }

    System.out.println("Aluno não encontrado");
    return false;
  }
}
