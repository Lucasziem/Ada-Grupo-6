import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome do diretor: ");
        String nomeDiretor = sc.next();
        System.out.println("Digite a idade do diretor: ");
        int idadeDiretor = sc.nextInt();

        Diretor diretor = new Diretor(nomeDiretor, idadeDiretor);
    }
}