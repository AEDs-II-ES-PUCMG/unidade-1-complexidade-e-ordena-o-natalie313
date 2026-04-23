public class BubbleSort<T> extends AbstractOrdenador<T> {

    @Override
    public T[] ordenar(T[] dados) {
        T[] v = copiar(dados);
        iniciarContadores();

        for (int i = 0; i < v.length - 1; i++) {
            boolean trocou = false;
            for (int j = 0; j < v.length - 1 - i; j++) {
                if (comparar(v[j], v[j + 1]) > 0) {
                    swap(v, j, j + 1);
                    trocou = true;
                }
            }
            if (!trocou) {
                break;
            }
        }

        terminarContadores();
        return v;
    }
}
