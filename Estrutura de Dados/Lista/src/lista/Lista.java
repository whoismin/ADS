/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lista;

/**
 *
 * @author FATEC ZONA LESTE
 */
public class Lista {
private Livro cabeca;

public Lista(){
    this.cabeca = null;
}
public void adicionar(Livro livro){
    if(cabeca == null){
        cabeca = livro;
    }else{
        livro.setAnterior(cabeca);
        cabeca = livro;
    }
}
public void remover (){
    if(cabeca !=null){ cabeca = cabeca.getAnterior();
}
}
public Livro getCabeca(){
    return cabeca;
}
public void listarLivros(){
    Livro atual = cabeca;
    while (atual != null){
        System.out.println("Nome:" + atual.getNome() + ", Ano: " + atual.getAno() + ", Preço: " + atual.getPreco());
        atual = atual.getAnterior();
    }
  
}

// Método Main dentro da própria classe Lista
    public static void main(String[] args) {
        Lista lista = new Lista();
 
        lista.adicionar(new Livro("O Senhor dos Anéis", 1954, 99.90));
        lista.adicionar(new Livro("O Hobbit", 1937, 49.90));
        lista.adicionar(new Livro("Dom Quixote", 1605, 39.90));
 
        System.out.println("Lista de Livros:");
        lista.listarLivros();
 
        System.out.println("\nRemovendo um livro...");
        lista.remover();
 
        System.out.println("\nLista de Livros após remoção:");
        lista.listarLivros();
    }
}
 
