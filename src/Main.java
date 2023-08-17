import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Vai ser chamdo dentro de createFilme.
    public Diretor createDiretor(Scanner scanner) {}

    // Vai ser chamdo dentro de createFilme.
    public Ator createAtor(Scanner scanner) {}

    // Recebe o scanner para realizar a lógica de criação do filme.
    public Filme createFilme(Scanner scanner) {}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Filme> filmes = new ArrayList<Filme>()
        boolean continuar = true;

        while(continuar) {
            System.out.println("Digite 1 se quiser inserir um filme e 0 se não: ");
            String auxiliar = scanner.next();

            if (auxiliar == "0") {
                continuar = false;
                break;
            }

            Filme filme = this.createFilme(scanner);
            filmes.add(filme);
        }

        continuar = true;
        while (continuar) {
            System.out.println("Digite 1 se quiser pesquisar um filme e 0 se não: ");
            String auxiliar = scanner.next();

            if (auxiliar == "0") {
                continuar = false;
                break;
            }

            System.out.println("Digite o nome do filme: ");
            String nomeDoFilme = scanner.next();
            boolean encontrado = false;
            for (Filme filme : filmes) {
                if (filme.getNome == nomeDoFilme) {
                    filme.toString();
                    encontrado = true;
                    break;
                }
            }
            if (encontrado == false) {
                System.out.println("O nome não foi inserido.");
            }
        }

        scanner.close();
    }
}