/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Joao Pedro
 */
public class Empresa {

    public String nome;
    public String cnpj;

    public Empresa() {
        this.nome = "";
        this.cnpj = "00.000.000/000-00";
    }

    public void Copiar(Empresa outro) {
        this.nome = outro.getNome();
        this.cnpj = outro.getCnpj();
    }

    public String imprimirParaString() {
        String saida = "";
        saida = "--------Dados da Empresa-------\n"
                + "Nome:" + this.nome + "\n"
                + "Cnpj:" + this.cnpj + "\n"
                + "----------------------------\n";
        return saida;
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
}
