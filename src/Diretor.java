import java.util.ArrayList;

public class Diretor implements Pessoa {

    private String nome;
    private int idade;

    private ArrayList<Filme> filmes = new ArrayList<Filme>();

    public Diretor(String nome, int idade) {
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
