/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package minhasegundaed;

/**
 *
 * @author FATEC ZONA LESTE
 */
public class MinhaSegundaED {

    // Array que armazena os nomes, com uma posição para cada letra do alfabeto
    private String[] nomes = new String[26];
    public int total_nomes = 0; // Contador de nomes adicionados

    // Método para validar se o nome é válido (não nulo, não vazio e começa com uma letra de A a Z)
    private boolean validaNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return false;
        }
        char primeiraLetra = Character.toUpperCase(nome.charAt(0));
        return primeiraLetra >= 'A' && primeiraLetra <= 'Z';
    }

    // Método para obter a posição do nome no array, baseado na primeira letra
    public int getIndice(String nome) {
        char primeiraLetra = Character.toUpperCase(nome.charAt(0));

        // Switch para mapear cada letra do alfabeto para um índice de 0 a 25
        switch (primeiraLetra) {
            case 'A': return 0;
            case 'B': return 1;
            case 'C': return 2;
            case 'D': return 3;
            case 'E': return 4;
            case 'F': return 5;
            case 'G': return 6;
            case 'H': return 7;
            case 'I': return 8;
            case 'J': return 9;
            case 'K': return 10;
            case 'L': return 11;
            case 'M': return 12;
            case 'N': return 13;
            case 'O': return 14;
            case 'P': return 15;
            case 'Q': return 16;
            case 'R': return 17;
            case 'S': return 18;
            case 'T': return 19;
            case 'U': return 20;
            case 'V': return 21;
            case 'W': return 22;
            case 'X': return 23;
            case 'Y': return 24;
            case 'Z': return 25;
            default:
                throw new IllegalArgumentException("Nome deve começar com uma letra de A a Z.");
        }
    }

    // Método para adicionar um nome na posição correspondente do array
    public void adiciona(String nome) {
        if (!validaNome(nome)) {
            System.out.println("Nome inválido: " + nome);
            return;
        }

        int posicao = getIndice(nome);

        if (!posicaoOcupada(posicao)) {
            nomes[posicao] = nome;
            total_nomes++;
            System.out.println("Nome '" + nome + "' adicionado na posição " + posicao);
        } else {
            System.out.println("A posição " + posicao + " já está ocupada por " + nomes[posicao] + ". Não foi possível adicionar " + nome + ".");
        }
    }

    // Verifica se uma posição já está ocupada
    private boolean posicaoOcupada(int posicao) {
        return nomes[posicao] != null;
    }

    // Remove um nome da lista, se ele existir
    public void remove(String nome) {
        if (!validaNome(nome)) {
            System.out.println("Nome inválido para remoção: " + nome);
            return;
        }

        int posicao = getIndice(nome);

        if (posicaoOcupada(posicao) && nomes[posicao].equals(nome)) {
            nomes[posicao] = null;
            total_nomes--;
            System.out.println(nome + " foi removido da lista.");
        } else {
            System.out.println("Nome " + nome + " não encontrado na lista.");
        }
    }

    // Verifica se um nome está na lista
    public boolean contem(String nome) {
        if (!validaNome(nome)) {
            return false;
        }

        int posicao = getIndice(nome);
        return posicaoOcupada(posicao) && nomes[posicao].equals(nome);
    }

    // Retorna o nome armazenado em determinada posição
    public String getNome(int posicao) {
        if (posicao < 0 || posicao >= 26) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        return nomes[posicao];
    }

    // Retorna a quantidade total de nomes na lista
    public int totalNomes() {
        return total_nomes;
    }

    // Exibe todos os nomes armazenados na lista
    public void exibirLista() {
        System.out.println("\nLista de nomes armazenados:");
        for (int i = 0; i < 26; i++) {
            if (nomes[i] != null) {
                System.out.println("Posição " + i + " (" + (char) ('A' + i) + "): " + nomes[i]);
            }
        }
    }

    // Método principal para testar a classe
    public static void main(String[] args) {
        MinhaSegundaED lista = new MinhaSegundaED();

        // Adicionando alguns nomes
        lista.adiciona("Aline");
        lista.adiciona("Alice"); // Tentando adicionar um nome com a mesma inicial
        lista.adiciona("Bernardo");
        lista.adiciona("Carlos");
        lista.adiciona("Daniel");
        lista.adiciona("Erika");
        lista.adiciona("Fernanda");
        lista.adiciona("Gustavo");
        lista.adiciona("Hugo");
        lista.adiciona("Isabela");
        lista.adiciona("Juliana");

        // Tentando adicionar um nome inválido
        lista.adiciona("123Mariana");

        // Exibindo os nomes armazenados
        lista.exibirLista();

        // Verificando se alguns nomes estão na lista
        System.out.println("\nA lista contém 'Carlos'? " + lista.contem("Carlos"));
        System.out.println("A lista contém 'Miguel'? " + lista.contem("Miguel"));

        // Removendo alguns nomes
        lista.remove("Carlos");
        lista.remove("Juliana");
        lista.remove("Lucas"); // Nome não existe na lista

        // Exibindo a lista após remoções
        System.out.println("\nApós remover alguns nomes:");
        lista.exibirLista();
    }
}
