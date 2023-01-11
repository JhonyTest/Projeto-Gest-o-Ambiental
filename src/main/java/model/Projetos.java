/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Joao Pedro
 */
@Entity
public class Projetos {
       @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long  id;
    private String nome;
    private String cidade;
    private String estado;
    private String situacao;
    private int orcamento;

    public Projetos() {
        
        
        
        this.nome = "";
        this.situacao = "";
        this.cidade = "";
        this.estado = "";
        this.orcamento = 0;
        this.id = -1;
       
    }

    public void copiar(Projetos outro) {
        this.nome = outro.getNome();        
        this.cidade = outro.getCidade();
        this.situacao = outro.getSituacao();
        this.estado = outro.getEstado();
        this.orcamento =  (int) outro.getOrcamento();
    }

    public String imprimirParaString() {
        String saida = "";
        saida = "--------Dados do Fiscal-------\n"
                + "id: " + this.id + "\n"
                + "Nome:" + this.nome + "\n"
                + "Situacao:" + this.situacao + "\n"
                + "Cidade:" + this.cidade + "\n"
                + "Estado:" + this.estado + "\n"
                + "Orçamento:" + this.orcamento + "\n"
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
        return (int) id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    
    
     public String getSituacao() {
        return this.situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    
    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
   
    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getOrcamento() {
        return  orcamento;
    }

    public void setOrcamento(int orcamento) {
        this.orcamento = orcamento;
    }

    



  

}
