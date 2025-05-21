/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.time.LocalDate;

/**
 *
 * @author unifbnascimento
 */
public class Artista {
    private String nome, biografia;
    private LocalDate nacionalidade;
    private int id;
   
    public Artista(){
        
    }

    public Artista(String nome, String biografia, LocalDate nacionalidade,
                                                                int id) {
        this.nome = nome;
        this.biografia = biografia;
        this.nacionalidade = nacionalidade;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public LocalDate getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(LocalDate nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Artista{" + "nome=" + nome + ", biografia=" + biografia +
                    ", nacionalidade=" + nacionalidade + ", id=" + id + '}';
    }
    
    
    
}
