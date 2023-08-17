import java.util.ArrayList;
import java.util.Date;

public class Filme {
    private String nome, descricao;

    private Date diaDeLancamento;
    private double orcamento;

    private Diretor diretor;

    private ArrayList<Ator> atores = new ArrayList<Ator>();

    public Filme(String nome, String descricao, Date diaDeLancamento, double orcamento, Diretor diretor, ArrayList<Ator> atores) {
        this.nome = nome;
        this.descricao = descricao;
        this.diaDeLancamento = diaDeLancamento;
        this.orcamento = orcamento;
        this.diretor = diretor;

        for (Ator ator : atores) {
            this.atores.add(ator);
        }
    }

    public String getNome() {
        return this.nome;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", diaDeLancamento=" + diaDeLancamento +
                ", orcamento=" + orcamento +
                ", diretor=" + diretor +
                ", atores=" + atores +
                '}';
    }
}
