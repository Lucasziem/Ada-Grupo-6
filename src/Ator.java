import java.util.ArrayList;

public class Ator implements Pessoa {
    private String nome;
    private int idade;

    private ArrayList<Filme> filmes = new ArrayList<Filme>();

    public Ator(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public int getIdade() {
        return this.idade;
    }

    public void setFilme(Filme filme) {
        this.filmes.add(filme);
    }

    @Override
    public String toString() {
        return nome + ", " + idade + " anos.";
    }
}
