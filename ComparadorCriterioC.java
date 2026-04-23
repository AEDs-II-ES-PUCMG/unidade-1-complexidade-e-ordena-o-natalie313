import java.util.Comparator;

/**
 * Critério C - Índice de Economia (decrescente).
 * O índice de economia é a diferença entre o valor de catálogo atual e o valor efetivamente pago.
 * Desempate 1: Valor Final do Pedido (crescente).
 * Desempate 2: Código Identificador do pedido (crescente).
 */
public class ComparadorCriterioC implements Comparator<Pedido> {

    @Override
    public int compare(Pedido pedido1, Pedido pedido2) {
        //razão entre o Valor Final do Pedido e a quantidade
        int comparar = Double.compare(pedido1.valorCatalogoAtual(), pedido2.valorCatalogoAtual());
        if (comparar != 0) {
            return comparar;
        }

        //desempate - Valor Final do Pedido
        comparar = Double.compare(pedido1.valorFinal(), pedido2.valorFinal());
        if (comparar != 0) {
            return comparar;
        }

        //desempate - código de identificador
        return Integer.compare(pedido1.compareTo(pedido1), pedido2.compareTo(pedido2));   
    }
}


/* AVALIAÇÃO DA QUESTÃO C 
 * valor médio gasto por tipo de produto distinto presente no pedido, ou seja, a razão entre o Valor Final do Pedido e a 
 * quantidade de posições ocupadas no vetor do carrinho, independentemente de quantas unidades de cada 
 * produto foram solicitadas.
 * o Desempate: Em caso de empate, utilize o Valor Final do Pedido e, em seguida, o Código 
 * Identificador.
*/