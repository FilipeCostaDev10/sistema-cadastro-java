import java.util.ArrayList;
import java.util.Scanner;

class Aluno {
    private String nome;
    private String matricula;
    private String curso;

    public Aluno(String nome, String matricula, String curso) {
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
    }

    public String getMatricula() {
        return matricula;
    }

    @Override
    public String toString() {
        return "Matrícula: " + matricula + " | Nome: " + nome + " | Curso: " + curso;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Aluno> alunos = new ArrayList<>();
        int opcao = 0;

        while (opcao != 4) {
            System.out.println("\n==== SISTEMA DE CADASTRO DE ALUNOS ====");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Listar Todos os Alunos");
            System.out.println("3. Rastrearor Matrícula");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do teclado

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do aluno: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite a matrícula: ");
                    String matricula = scanner.nextLine();
                    System.out.print("Digite o curso: ");
                    String curso = scanner.nextLine();

                    alunos.add(new Aluno(nome, matricula, curso));
                    System.out.println("-> Aluno cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("\n--- Lista de Alunos Cadastrados ---");
                    if (alunos.isEmpty()) {
                        System.out.println("Nenhum aluno cadastrado.");
                    } else {
                        for (Aluno aluno : alunos) {
                            System.out.println(aluno);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Digite a matrícula para buscar: ");
                    String busca = scanner.nextLine();
                    boolean encontrado = false;

                    for (Aluno aluno : alunos) {
                        if (aluno.getMatricula().equalsIgnoreCase(busca)) {
                            System.out.println("\nAluno encontrado: " + aluno);
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("-> Aluno não encontrado com essa matrícula.");
                    }
                    break;

                case 4:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }

        scanner.close();
    }
}
