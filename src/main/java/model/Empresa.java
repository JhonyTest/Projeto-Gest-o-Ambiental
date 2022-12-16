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
public class Empresa {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    public int id;
    public String nome;
    public String cnpj;
    public String senha;

    public Empresa() {
        this.id = 0;
        this.nome = "";
        this.cnpj = "";
        this.senha = "";
    }

    public void Copiar(Empresa outro) {
        this.id = outro.getId();
        this.nome = outro.getNome();
        this.cnpj = outro.getCnpj();
        this.senha = outro.getSenha();
    }

    public String imprimirParaString() {
        String saida = "";
        saida = "--------Dados da Empresa-------\n"
                + "Id:" + this.id + "\n"
                + "Nome:" + this.nome + "\n"
                + "Cnpj:" + this.cnpj + "\n"
                + "Senha:" + this.senha + "\n"
                + "----------------------------\n";
        return saida;
    }

    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    public String getSenha() 
    {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
