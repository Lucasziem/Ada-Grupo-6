import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RED = "\u001B [31m";
    public static final String ANSI_CIAN = "\u001B [36m";
    public static void cadastrarAtor(Scanner sc, IMDB imdb) {
        try {
            System.out.println("\n--- Cadastro de Ator ---");
            System.out.println("Digite o nome do ator: ");
            String nomeAtor = sc.nextLine();
            System.out.println("Digite a idade do ator: ");
            int idadeAtor = sc.nextInt();
            sc.nextLine();
            Ator ator = new Ator(nomeAtor, idadeAtor);
            imdb.adicionarAtor(ator);
            System.out.println(ANSI_GREEN + "Ator cadastrado!" + ANSI_RESET);
        } catch (InputMismatchException e) {
            System.out.println(ANSI_RED + "Precisa ser um número!" + ANSI_RESET);
            sc.nextLine();
            cadastrarAtor(sc, imdb);
        }
    }

    public static void cadastrarDiretor(Scanner sc, IMDB imdb) {
        try {
            System.out.println("\n--- Cadastro de Diretor ---");
            System.out.println("Digite o nome do diretor: ");
            String nomeDiretor = sc.nextLine();
            System.out.println("Digite a idade do diretor: ");
            int idadeDiretor = sc.nextInt();
            sc.nextLine();
            Diretor diretor = new Diretor(nomeDiretor, idadeDiretor);
            imdb.adicionarDiretor(diretor);
            System.out.println(ANSI_GREEN + "Diretor cadastrado!" + ANSI_RESET);
        } catch (InputMismatchException e) {
            System.out.println(ANSI_RED + "Precisa ser um número!" + ANSI_RESET);
            sc.nextLine();
            cadastrarDiretor(sc, imdb);
        }
    }

    public static  void cadastrarFilme(Scanner sc, IMDB imdb) {
        try {
            System.out.println("\n--- Cadastro de Filme ---");
            System.out.println("Digite o nome do filme: ");
            String nomeFilme = sc.nextLine();
            System.out.println("Digite a descrição do filme: ");
            String descricaoFilme = sc.nextLine();
            System.out.println("Digite a data de lançamento do filme no fomato dd/MM/yyyy: ");
            String dataDeLancamento = sc.nextLine();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = formatter.parse(dataDeLancamento);
            System.out.println("Digite o orçamento do filme: ");
            double orcamento = sc.nextDouble();
            Filme filme = new Filme(nomeFilme, descricaoFilme, date, orcamento);
            imdb.adicionarFilme(filme);
            System.out.println(ANSI_GREEN + "Filme cadastrado!" + ANSI_RESET);
        } catch (ParseException e) {
            System.out.println(ANSI_RED + "Formato de data errado. Tente novamente." + ANSI_RESET
            );
            cadastrarFilme(sc, imdb);
        } catch (InputMismatchException e) {
            System.out.println(ANSI_RED + "Precisa ser um número!" + ANSI_RESET);
            sc.nextLine();
            cadastrarFilme(sc, imdb);
        }
    }

    public static boolean fluxoDoSistema(Scanner sc, IMDB imdb) {
        System.out.println(ANSI_CIAN + "\n----------------------------------");
        System.out.println("1 - Cadastrar Ator");
        System.out.println("2 - Exibir todos os atores");
        System.out.println("3 - Cadastrar Diretor");
        System.out.println("4 - Exibir todos os diretores");
        System.out.println("5 - Cadastrar Filme");
        System.out.println("6 - Adicionar diretor em um filme");
        System.out.println("7 - Adicionar atores em um filme");
        System.out.println("8 - Exibir todos os filmes");
        System.out.println("9 - Pesquisar filme por nome");
        System.out.println("10 - Sair");
        System.out.println("----------------------------------\n" + ANSI_RESET);

        System.out.println("Digite o numero da opção desejada: ");

        try {
            int opcao = sc.nextInt();

            sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    cadastrarAtor(sc, imdb);
                    return true;
                }
                case 2 -> {
                    System.out.println(ANSI_PURPLE + "\n--- Lista de Atores ---" + ANSI_RESET);
                    imdb.exibirTodosAtores();
                    return true;
                }
                case 3 -> {
                    cadastrarDiretor(sc, imdb);
                    return true;
                }
                case 4 -> {
                    System.out.println(ANSI_PURPLE + "\n--- Lista de Diretores ---" + ANSI_RESET);
                    imdb.exibirTodosDiretores();
                    return true;
                }
                case 5 -> {
                    cadastrarFilme(sc, imdb);
                    return true;
                }
                case 6 -> {
                    System.out.println(ANSI_PURPLE + "\n--- Adicionar Diretor em um Filme ---" + ANSI_RESET);
                    System.out.println("Primeiro digite o nome do filme que deseja atualizar: ");
                    String nomeFilmeAtualizar = sc.nextLine();
                    System.out.println("Primeiro digite o nome do diretor que deseja adicionar: ");
                    String nomeDiretorAdd = sc.nextLine();
                    imdb.adicionarDiretorEmFilme(nomeFilmeAtualizar, nomeDiretorAdd);
                    System.out.println(ANSI_GREEN + "Filme atualizado!" + ANSI_RESET);
                    return true;
                }
                case 7 -> {
                    System.out.println(ANSI_PURPLE + "\n--- Adicionar Ator em um Filme ---" + ANSI_RESET);
                    System.out.println("Primeiro digite o nome do filme que deseja atualizar: ");
                    String nomeFilmeAtualizarAtor = sc.nextLine();
                    System.out.println("Primeiro digite o nome do ator que deseja adicionar: ");
                    String nomeAtorAdd = sc.nextLine();
                    imdb.adicionarAtorEmFilme(nomeFilmeAtualizarAtor, nomeAtorAdd);
                    System.out.println(ANSI_GREEN + "Filme atualizado" + ANSI_RESET);
                    return true;
                }
                case 8 -> {
                    System.out.println(ANSI_PURPLE + "\n--- Lista de Filmes ---" + ANSI_RESET);
                    imdb.exibirTodosFilmes();
                    return true;
                }
                case 9 -> {
                    System.out.println(ANSI_PURPLE + "\n--- Pesquisa de Filme ---" + ANSI_RESET);
                    System.out.println("Digite o nome do filme: ");
                    String nomeBusca = sc.next();
                    System.out.println(imdb.buscarFilmePorNome(nomeBusca));
                    return true;
                }
                case 10 -> {
                    return false;
                }
                default -> {
                    System.out.println("Opção não encontrada, tente novamente!");
                    return true;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println(ANSI_RED + "Precisa ser um número de 1 a 10." + ANSI_RESET);
            return true;
        }
    }

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        IMDB imdb = new IMDB();
        boolean controle = true;

        while(controle) {
            controle = fluxoDoSistema(sc, imdb);
        }
    }
}