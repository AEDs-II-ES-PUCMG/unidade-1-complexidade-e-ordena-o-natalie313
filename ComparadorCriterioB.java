import java.util.Comparator;

/**
 * Critério B - Volume Total de Itens (crescente).
 * Desempate 1: Data do Pedido.
 * Desempate 2: Código Identificador do pedido.
 */
public class ComparadorCriterioB implements Comparator<Pedido> {

    @Override
    public int compare(Pedido pedido1, Pedido pedido2) {
        //compara as formas de pagamento (1 ou 2)
        int identificarFormaPagamento = Integer.compare(pedido1.getFormaDePagamento(), pedido2.getFormaDePagamento());
        
        //pagamento à vista = 1
        if (identificarFormaPagamento == 1) {
            if (pedido1.getFormaDePagamento() == 1) {
                pedido1.valorFinal();
            }
            else {
                pedido2.valorFinal();
            }
            return identificarFormaPagamento;
        }

        //pagamento parcelado = 2
        else if (identificarFormaPagamento == 2) {
            return identificarFormaPagamento;
        }

        //desempate - valor final 
        identificarFormaPagamento = Double.compare(pedido1.valorFinal(), pedido2.valorFinal());
        if (identificarFormaPagamento != 0) {
            return identificarFormaPagamento;
        }

        //desempate - identificador
        return Integer.compare(pedido1.compareTo(pedido1), pedido2.compareTo(pedido2));    
    }
}



/* ANALISE DA QUESTÃO 

* A ordenação deve listar primeiro os pedidos pagos à vista = 1

* os pedidos pagos de forma parcelada = 2

* Lembre-se da regra de negócio estabelecida: pedidos pagos à vista 
recebem um desconto percentual sobre o valor total = DESCONTO_PG_A_VISTA

* enquanto pedidos parcelados não recebem desconto.

* o Desempate: utilize o Valor Final do Pedido =  valorFinal

* em seguida, o Código Identificador = compareTo

*/