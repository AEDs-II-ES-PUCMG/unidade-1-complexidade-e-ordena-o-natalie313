public class MergeSort<T> extends AbstractOrdenador<T> {

    @Override
    public T[] ordenar(T[] dados) {
        T[] v = copiar(dados);
        iniciarContadores();
        mergeSort(v, 0, v.length - 1);
        terminarContadores();
        return v;
    }

    private void mergeSort(T[] v, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(v, inicio, meio);
            mergeSort(v, meio + 1, fim);
            intercalar(v, inicio, meio, fim);
        }
    }

    @SuppressWarnings("unchecked")
    private void intercalar(T[] v, int inicio, int meio, int fim) {
        Object[] aux = new Object[fim - inicio + 1];
        int i = inicio;
        int j = meio + 1;
        int k = 0;

        while (i <= meio && j <= fim) {
            if (comparar(v[i], v[j]) <= 0) {
                aux[k++] = v[i++];
            } else {
                aux[k++] = v[j++];
            }
            movimentacoes++;
        }

        while (i <= meio) {
            aux[k++] = v[i++];
            movimentacoes++;
        }

        while (j <= fim) {
            aux[k++] = v[j++];
            movimentacoes++;
        }

        for (int p = 0; p < aux.length; p++) {
            v[inicio + p] = (T) aux[p];
            movimentacoes++;
        }
    }
}
