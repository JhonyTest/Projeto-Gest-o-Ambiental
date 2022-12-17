/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Joao Pedro
 */
public class Projetos {
       @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    private String nome;
    private String estado;
    private int orçamento;

    public Projetos() {
        this.nome = "";
        this.estado = "";
        this.orçamento = 0;
        this.id = -1;
       
    }

    public void copiar(Projetos outro) {
        this.id = outro.getId();
        this.nome = outro.getNome();
        this.estado = outro.getEstado();
        this.orçamento = outro.getOrçamento();
    }

    public String imprimirParaString() {
        String saida = "";
        saida = "--------Dados do Fiscal-------\n"
                + "id: " + this.id + "\n"
                + "Nome:" + this.nome + "\n"
                + "Sexo:" + this.estado + "\n"
                + "Idade:" + this.orçamento + "\n"        
                + "----------------------------\n";
        return saida;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(int idade) {
        this.estado = estado;
    }

    public int getOrçamento() {
        return orçamento;
    }

    public void setOrçamento(int orçamento) {
        this.orçamento = orçamento;
    }

  

}
