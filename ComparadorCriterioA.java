import java.util.Comparator;

/**
 * Critério A - Valor Final do Pedido (crescente).
 * Desempate 1: Volume Total de Itens (quantProdutos).
 * Desempate 2: Código Identificador do primeiro item do pedido.
 */
public class ComparadorCriterioA implements Comparator<Pedido> {

    @Override
    public int compare(Pedido pedido1, Pedido pedido2) {
        //financeiro total
        int comparar = Double.compare(pedido1.valorFinal(), pedido2.valorFinal());
        if (comparar != 0) {
            return comparar;
        }

        //desempate - volume total de itens
        comparar = Integer.compare(pedido1.getTotalItens(), pedido2.getTotalItens());
        if (comparar != 0) {
            return comparar;
        }

        //desempate - código identificador
        return Integer.compare(pedido1.compareTo(pedido1), pedido2.compareTo(pedido2));
    } 
}


/* AVALIAÇÃO DA QUESTÃO A
 * A ordenação deve considerar o montante financeiro total consolidado 
 * no carrinho de compras.
 * o Desempate: Em caso de empate, o sistema deve avaliar o Volume Total de Itens e, persistindo o 
 * empate, o Código Identificador do primeiro item do pedido 
*/
