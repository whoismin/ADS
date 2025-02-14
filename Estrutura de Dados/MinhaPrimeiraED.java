public class MinhaPrimeiraED {
    private Object[] objetos = new Object[10];
    public int totalDeObjetos = 0; 

    public void adiciona(int posicao, Object objeto) { // Add um objeto em uma posição específica
        if (posicao < 0 || posicao > totalDeObjetos) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        if (cheio()) {
            aumentaCapacidade(); // Aumenta a capacidade se o vetor estiver cheio
        }
        for (int i = totalDeObjetos; i > posicao; i--) {
            objetos[i] = objetos[i - 1];
        }
        objetos[posicao] = objeto; // Add o novo objeto na posição especificada
        totalDeObjetos++;
    }
    // Add um objeto ao final do vetor
    public void adiciona(Object objeto) {
        if (cheio()) {
            aumentaCapacidade(); // Aumenta a capacidade se o vetor estiver cheio
        }
        objetos[totalDeObjetos] = objeto; // Add o objeto no final
        totalDeObjetos++;
    }
    private boolean posicaoOcupada(int posicao) {     // Verifica se a posição está ocupada

        return posicao >= 0 && posicao < totalDeObjetos && objetos[posicao] != null;
    }
    private boolean posicaoValida(int posicao) {
        return posicao >= 0 && posicao < totalDeObjetos;
    }
    public void remove(int posicao) { // Remove um objeto de uma posição específica
        if (!posicaoValida(posicao)) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        for (int i = posicao; i < totalDeObjetos - 1; i++) {
            objetos[i] = objetos[i + 1];
        }
        objetos[totalDeObjetos - 1] = null; // Limpa a última posição
        totalDeObjetos--;
    }
    public boolean contem(Object objeto) {
        for (int i = 0; i < totalDeObjetos; i++) {
            if (objetos[i].equals(objeto)) {
                return true; 
            }
        }
        return false; 
    }
    public Object getObjeto(int posicao) {
        if (!posicaoValida(posicao)) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        return objetos[posicao]; 
    }
    public int tamanho() {
        return objetos.length; // Retorna o total de objetos
    }

    // Verifica se o vetor está cheio
    public boolean cheio() {
        return totalDeObjetos == objetos.length; // true se o vetor estiver cheio
    }

    // Verifica se o vetor está vazio
    public boolean vazio() {
        return totalDeObjetos == 0; // true se o vetor estiver vazio
    }

    // Aumenta a capacidade do vetor
    private void aumentaCapacidade() {
        Object[] novoArray = new Object[objetos.length * 2];
        for (int i = 0; i < objetos.length; i++) {
            novoArray[i] = objetos[i]; 
        }
        objetos = novoArray; 
    }

    public static void main(String[] args) {
        MinhaPrimeiraED minhaED = new MinhaPrimeiraED();

        minhaED.adiciona(0, "Objeto 1");
        minhaED.adiciona(1, "Objeto 2");
        minhaED.adiciona(0, "Objeto 3");

        // Testando o método adiciona
        minhaED.adiciona("Objeto 4");

        minhaED.remove(1); // Remove o objeto na posição 1

        System.out.println("Contém 'Objeto 1'? " + minhaED.contem("Objeto 1")); 
        System.out.println("Contém 'Objeto 2'? " + minhaED.contem("Objeto 2")); 

        System.out.println("Objeto na posição 0: " + minhaED.getObjeto(0)); 

        System.out.println("Tamanho da estrutura de dados: " + minhaED.tamanho()); 

        System.out.println("Estrutura de dados cheia? " + minhaED.cheio()); 

        System.out.println("Estrutura de dados vazia? " + minhaED.vazio()); 

        // Add mais objetos para testar o aumento de capacidade
        minhaED.adiciona("Objeto 5");
        minhaED.adiciona("Objeto 6");
        minhaED.adiciona("Objeto 7");
        minhaED.adiciona("Objeto 8");
        minhaED.adiciona("Objeto 9");
        minhaED.adiciona("Objeto 10");
        minhaED.adiciona("Objeto 11"); 

        // Verifica o tamanho após adicionar mais objetos
        System.out.println("Tamanho da estrutura de dados após adições: " + minhaED.tamanho()); // Deve retornar 10

        // Verifica se a estrutura está cheia após as adições
        System.out.println("Estrutura de dados cheia após adições? " + minhaED.cheio()); // Deve retornar true

        // Testando a recuperação de objetos
        for (int i = 0; i < minhaED.tamanho(); i++) {
            System.out.println("Objeto na posição " + i + ": " + minhaED.getObjeto(i));
        }
    }
}