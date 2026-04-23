import java.util.Comparator;

public class ComparadorPorValor implements Comparator<Pedido>{

	@Override
	public int compare(Pedido pedido1, Pedido pedido2) {
		//por valor
        int comparar = Double.compare(pedido1.valorFinal(), pedido2.valorFinal());
        return comparar;
	}
}

