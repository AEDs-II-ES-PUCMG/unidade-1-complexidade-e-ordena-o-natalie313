public class Produto {

    String descricao;
    private int tipo;
    private double preco;
    private double peso;

    public Produto(int tipo, String descricao, double preco, double peso) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.preco = preco;
        this.peso = peso;
    }

    public static Produto criarDoTexto(String linha) {
        String[] partes = linha.split(";");
        int tipo = Integer.parseInt(partes[0].trim());
        String descricao = partes[1].trim();
        double preco = Double.parseDouble(partes[2].trim().replace(",", "."));
        double peso = Double.parseDouble(partes[3].trim().replace(",", "."));
        return new Produto(tipo, descricao, preco, peso);
    }

    public String getDescricao() {
        return descricao;
    }

    public int getTipo() {
        return tipo;
    }

    public double getPreco() {
        return preco;
    }

    public double getPeso() {
        return peso;
    }

    public double valorDeVenda() {
        return preco;
    }

    @Override
    public String toString() {
        return String.format("%s - R$ %.2f", descricao, preco);
    }
}
