public class MinhaPrimeiraED {

    private Object[] elementos; // Array para armazenar os elementos
    private int tamanho; // Número atual de elementos na estrutura

    // Construtor que inicializa a estrutura com um array de tamanho 10
    public MinhaPrimeiraED() {
        this.elementos = new Object[10];
        this.tamanho = 0;
    }

    /**
     * Adiciona um objeto em uma posição específica do vetor.
     * Se a posição estiver ocupada, desloca os elementos à direita.
     * 
     * @param posicao A posição onde o objeto deve ser adicionado.
     * @param objeto O objeto a ser adicionado.
     * @throws IndexOutOfBoundsException Se a posição não for válida.
     */
    public void adiciona(int posicao, Object objeto) {
        if (!posicaoValida(posicao)) {
            throw new IndexOutOfBoundsException("Índice inválido: " + posicao);
        }
        if (tamanho == elementos.length) {
            expandirCapacidade(); // Expande a capacidade se o vetor estiver cheio
        }
        // Desloca os elementos para a direita
        System.arraycopy(elementos, posicao, elementos, posicao + 1, tamanho - posicao);
        elementos[posicao] = objeto; // Adiciona o novo objeto
        tamanho++; // Incrementa o tamanho
    }

    /**
     * Adiciona um objeto ao final do vetor.
     * 
     * @param objeto O objeto a ser adicionado.
     */
    public void adiciona(Object objeto) {
        if (tamanho == elementos.length) {
            expandirCapacidade(); // Expande a capacidade se o vetor estiver cheio
        }
        elementos[tamanho++] = objeto; // Adiciona o objeto e incrementa o tamanho
    }

    /**
     * Verifica se uma posição específica está ocupada.
     * 
     * @param posicao A posição a ser verificada.
     * @return true se a posição estiver ocupada, false caso contrário.
     */
    private boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < tamanho && elementos[posicao] != null;
    }

    /**
     * Verifica se uma posição é válida para adição de elementos.
     * 
     * @param posicao A posição a ser verificada.
     * @return true se a posição for válida, false caso contrário.
     */
    private boolean posicaoValida(int posicao) {
        return posicao >= 0 && posicao <= tamanho; // Permite adicionar no final
    }

    /**
     * Remove um objeto de uma posição específica do vetor.
     * Desloca os elementos à esquerda para preencher o espaço.
     * 
     * @param posicao A posição do objeto a ser removido.
     * @throws IndexOutOfBoundsException Se a posição não for válida ou não estiver ocupada.
     */
    public void remove(int posicao) {
        if (!posicaoValida(posicao) || !posicaoOcupada(posicao)) {
            throw new IndexOutOfBoundsException("Índice inválido: " + posicao);
        }
        // Desloca os elementos para a esquerda
        System.arraycopy(elementos, posicao + 1, elementos, posicao, tamanho - posicao - 1);
        elementos[--tamanho] = null; // Limpa a última posição
    }

    /**
     * Verifica se um objeto está presente na estrutura.
     * 
     * @param objeto O objeto a ser pesquisado.
     * @return true se o objeto for encontrado, false caso contrário.
     */
    public boolean contem(Object objeto) {
        for (int i = 0; i < tamanho; i++) {
            if ((elementos[i] == null && objeto == null) || (elementos[i] != null && elementos[i].equals(objeto))) {
                return true; // Objeto encontrado
            }
        }
        return false; // Objeto não encontrado
    }

    /**
     * Retorna o objeto em uma posição específica.
     * 
     * @param posicao A posição do objeto a ser retornado.
     * @return O objeto na posição especificada.
     * @throws IndexOutOfBoundsException Se a posição não estiver ocupada.
     */
    public Object getObjeto(int posicao) {
        if (!posicaoOcupada(posicao)) {
            throw new IndexOutOfBoundsException("Índice inválido: " + posicao);
        }
        return elementos[posicao]; // Retorna o objeto na posição
}
        
            /**
     * Retorna o tamanho atual da estrutura.
     * 
     * @return O número de elementos na estrutura.
     */
    public int tamanho() {
        return tamanho;
    }

    /**
     * Expande a capacidade do vetor para acomodar mais elementos.
     */
    private void expandirCapacidade() {
        Object[] novoArray = new Object[elementos.length * 2];
        System.arraycopy(elementos, 0, novoArray, 0, elementos.length);
        elementos = novoArray;
    }

    /**
     * Exibe o conteúdo da estrutura.
     */
    public void exibirLista() {
        System.out.println("Conteúdo da estrutura:");
        for (int i = 0; i < tamanho; i++) {
            System.out.println("Posição " + i + ": " + elementos[i]);
        }
    }

    public static void main(String[] args) {
        MinhaPrimeiraED lista = new MinhaPrimeiraED();
        lista.adiciona("Objeto A");
        lista.adiciona("Objeto B");
        lista.adiciona("Objeto C");
        lista.exibirLista();

        lista.adiciona(1, "Objeto D");
        lista.exibirLista();

        System.out.println("A lista contém 'Objeto B'? " + lista.contem("Objeto B"));
        System.out.println("A lista contém 'Objeto F'? " + lista.contem("Objeto F"));

        lista.remove(2); // Remove um objeto da lista
        lista.exibirLista();

        System.out.println("Elemento na posição 1: " + lista.getObjeto(1));
        System.out.println("Tamanho da lista: " + lista.tamanho());

        for (int i = 0; i < 15; i++) {
            lista.adiciona(i + 1);
        }
        lista.exibirLista();
        System.out.println("Novo tamanho da estrutura: " + lista.elementos.length);
    }
}
