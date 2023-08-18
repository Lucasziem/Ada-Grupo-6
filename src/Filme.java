import java.util.ArrayList;
import java.util.Date;

public class Filme {
    private String nome, descricao;

    private Date diaDeLancamento;
    private double orcamento;

    private Diretor diretor;

    private ArrayList<Ator> atores = new ArrayList<Ator>();

    public Filme(String nome, String descricao, Date diaDeLancamento, double orcamento) {
        this.nome = nome;
        this.descricao = descricao;
        this.diaDeLancamento = diaDeLancamento;
        this.orcamento = orcamento;
    }

    public String getNome() {
        return this.nome;
    }

    public void addAtor(Ator ator) {
        this.atores.add(ator);
    }
    public void setDiretor(Diretor diretorEncontrado) {
    }

    @Override
    public String toString() {
        return  nome +
                "\nDescricao: " + descricao +
                "\nLançado em: " + diaDeLancamento +
                "\nOrçamento: " + orcamento +
                "\nDiretor: " + diretor +
                "\nAtores: " + atores;
    }


}
