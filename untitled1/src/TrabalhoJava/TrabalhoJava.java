package TrabalhoJava;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TrabalhoJava {
    public static void inserirAluno(String[][] matriz, int linhas, int colunas) {
        Scanner scanner = new Scanner(System.in);
        int linha;

        mostrarAlunos(matriz, linhas, colunas);

        do {
            System.out.println("Informe onde você deseja inserir o aluno com valores de 1 a " + linhas);
            try {
                linha = scanner.nextInt();

                if (linha < 1 || linha > linhas) {
                    System.out.println("Quantidade ou número incorreto. Tente novamente.");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido. Tente novamente.");
                scanner.next();
                continue;
            }
            break;

        } while (true);

        System.out.println("Insira o nome do aluno: ");
        matriz[linha - 1][0] = scanner.next();
        System.out.println("Insira a idade do aluno: ");
        matriz[linha - 1][1] = scanner.next();
        matriz[linha - 1][2] = "Ausente";
        matriz[linha - 1][3] = "0";
        System.out.println("Aluno adicionado.");
    }

    // Função para mostrar a lista de alunos na tela
    public static void mostrarAlunos(String[][] matriz, int linhas, int colunas) {
        System.out.println("Nome | Idade | Presente | Faltas");
        for (int i = 0; i < linhas; i++) {
            System.out.print((i + 1) + " - ");
            for (int j = 0; j < colunas; j++) {
                System.out.print(matriz[i][j] + " | ");
            }
            System.out.println();
        }
    }

    // Função para registrar a falta de um aluno
    public static void registrarFalta(String[][] matriz, int linhas) {
        Scanner scanner = new Scanner(System.in);
        mostrarAlunos(matriz, linhas, 4);

        System.out.println("Informe o número do aluno que está faltando:");

        int aluno;
        try {
            aluno = scanner.nextInt();

            if (aluno < 1 || aluno > linhas) {
                System.out.println("Aluno não encontrado.");
                return;
            }
        } catch (InputMismatchException e) {
            System.out.println("Valor inválido. Tente novamente.");
            scanner.next();
            return;
        }

        matriz[aluno - 1][2] = "Ausente";

        int faltas = Integer.parseInt(matriz[aluno - 1][3]) + 1;
        matriz[aluno - 1][3] = String.valueOf(faltas);

        System.out.println("Falta registrada.");
    }

    // Função para consultar os dados de um aluno específico
    public static void consultarAluno(String[][] matriz, int linhas) {
        Scanner scanner = new Scanner(System.in);
        mostrarAlunos(matriz, linhas, 4);

        System.out.println("Informe o número do aluno que deseja consultar:");

        int aluno;
        try {
            aluno = scanner.nextInt();

            if (aluno < 1 || aluno > linhas) {
                System.out.println("Aluno não encontrado.");
                return;
            }
        } catch (InputMismatchException e) {
            System.out.println("Valor inválido. Tente novamente.");
            scanner.next();
            return;
        }

        System.out.println("Nome: " + matriz[aluno - 1][0]);
        System.out.println("Idade: " + matriz[aluno - 1][1]);
        System.out.println("Presente: " + matriz[aluno - 1][2]);
        System.out.println("Faltas: " + matriz[aluno - 1][3]);
    }

    // Função para ordenar os alunos por nome em ordem alfabética
    public static void ordenarAlunosPorNome(String[][] matriz, int linhas) {
        Arrays.sort(matriz, Comparator.comparing(a -> a[0].toLowerCase()));//Diferencia as letras maiusculas da minusculas e também deter

        System.out.println("Alunos ordenados por nome em ordem alfabética:");
        mostrarAlunos(matriz, linhas, 4);
    }

    // Função para marcar a presença de um aluno
    public static void marcarPresenca(String[][] matriz, int linhas) {
        Scanner scanner = new Scanner(System.in);
        mostrarAlunos(matriz, linhas, 4);

        System.out.println("Informe o número do aluno que está presente:");

        int aluno;
        try {
            aluno = scanner.nextInt();

            if (aluno < 1 || aluno > linhas) {
                System.out.println("Aluno não encontrado.");
                return;
            }
        } catch (InputMismatchException e) {
            System.out.println("Valor inválido. Tente novamente.");
            scanner.next();
            return;
        }

        matriz[aluno - 1][2] = "Presente";
        System.out.println("Presença registrada.");
    }


    public static void main(String[] args) {
        String[][] lista = null;
        int alunos = 0;
        int opcao = 0;
        int colunas = 4;
        String professor = null;
        Scanner scanner = new Scanner(System.in);


        do {
            System.out.println("Escolha uma opção:\n1 - Determinar a quanitdade de aluno."
                    + "\n2 - Inserir aluno na lista de chamada."
                    + "\n3 - Ordenar alunos por nome em ordem alfabética"
                    + "\n4 - Consultar dados de um aluno"
                    + "\n5-  Registrar Falta."
                    + "\n6 - Marcar Presença."
                    + "\n7 - Mostrar lista de chamada"
                    + "\n8 - Identificar professor."
                    + "\n0 - Finalizar.");

            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida! Digite um número.");
                scanner.nextLine();
                continue;
            }

            switch (opcao) {
                case 0:
                    System.out.println("Obrigado por utilizar esse sistema de lista de chamada. Até a próxima :)");
                    break;
                case 1:
                    if (alunos == 0) {
                        System.out.println("Insira a quantidade de alunos para a lista de chamada:");
                        try {
                            alunos = scanner.nextInt();
                            lista = new String[alunos][colunas];
                        } catch (InputMismatchException ex) {
                            System.out.println("Quantidade inválida de alunos. Tente novamente.");
                           scanner.nextLine();
                        }
                    } else {
                        System.out.println("Não é possivel determinar a quantidade mais de uma vez!");
                    }
                    break;
                case 2:
                    inserirAluno(lista, alunos, colunas);
                    break;
                case 3:
                    ordenarAlunosPorNome(lista, alunos);
                    break;
                case 4:
                    consultarAluno(lista, alunos);
                    break;
                case 5:
                    registrarFalta(lista, alunos);
                    break;
                case 6:
                    marcarPresenca(lista, alunos);
                    break;
                case 7:
                    mostrarAlunos(lista, alunos, colunas);
                    break;
                case 8:
                     if (professor == null) {
                         System.out.println("Informe o nome do professor:");
                         professor = scanner.next();
                         System.out.println("Professor identificado: " + professor);
                     } else {
                         System.out.println("O professor já está identificado como: " + professor);
                     }
                     break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }
}