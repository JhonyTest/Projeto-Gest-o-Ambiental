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
public class Fiscal {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    private String nome;
    private char sexo;
    private int idade;
    private String cpf;

    public Fiscal() {
        this.nome = "";
        this.sexo = ' ';
        this.idade = 0;
        this.cpf = "000.000.000-00";
        this.id = -1;
    }

    public void copiar(Fiscal outro) {
       this.id = outro.getId();
        this.nome = outro.getNome();
        this.sexo = outro.getSexo();
        this.idade = outro.getIdade();
        this.cpf = outro.getCpf();
    }

    public String imprimirParaString() {
        String saida = "";
        saida = "--------Dados do Fiscal-------\n"
                + "id: " + this.id + "\n"
                + "Nome:" + this.nome + "\n"
                + "Sexo:" + this.sexo + "\n"
                + "Idade:" + this.idade + "\n"
                + "Cpf:" + this.cpf + "\n"
                + "----------------------------\n";
        return saida;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }
    
    
    
    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
