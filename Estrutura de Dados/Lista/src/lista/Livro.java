/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lista;

/**
 *
 * @author FATEC ZONA LESTE
 */
public class Livro {
    private int ano; 
    private String nome; 
    private double preco; 
    private Livro anterior;

    public Livro(String nome, int ano, double preco) {
        this.ano= ano; 
        this.nome = nome; 
        this.preco = preco; 
        this.anterior = null;
    }


    public String getNome() {
        return nome; 
    }

    public void setNome(String nome) {
        this.nome = nome; 
    }

    public int getAno() {
        return ano; 
    }

    public void setAno(int ano) {
        this.ano = ano; 
    }
    
    public double getPreco() {
        return preco; 
    }

    
    public void setPreco(double preco) {
        this.preco = preco; 
    }
    
    public Livro getAnterior(Livro anterior) {
        return anterior; 
    }

  
    public void setAnterior(Livro anterior) {
        this.anterior = anterior;
    }

    Livro getAnterior() {
                return anterior; 

    }



   

}
    


