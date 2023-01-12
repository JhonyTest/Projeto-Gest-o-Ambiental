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
public class Multas {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    public long id;
    public String cnpj;
    public String documento;
    public String vencimento;
    public int multa;
    public int juros;
    public int total;

    public Multas() {
        
        this.cnpj = "";
        this.documento = "";
        this.vencimento = "";
        this.multa = 0;
        this.juros = 0;
        this.total = 0;
    }

    public void Copiar(Multas outro) {
        
        this.cnpj = outro.getCnpj();
        this.documento = outro.getDocumento();
        this.vencimento = outro.getVencimento();
        this.multa = outro.getMulta();
        this.juros = outro.getJuros();
        this.total = outro.getTotal();
    }

    public String imprimirParaString() {
        String saida = "";
        saida = "--------Dados da Empresa-------\n"
                + "Id:" + this.id + "\n"
                + "Cnpj:" + this.cnpj + "\n"
                + "Nome:" + this.documento + "\n"
                + "Cnpj:" + this.vencimento + "\n"
                + "Multa:" + this.multa + "\n"
                + "Juros:" + this.juros + "\n"
                + "Total:" + this.total + "\n"
                + "----------------------------\n";
        return saida;
    }

    public int getId() {
        return (int) id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getVencimento() {
        return this.vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    public int getMulta() {
        return this.multa;
    }

    public void setMulta(int multa) {
        this.multa = multa;
    }

    public int getJuros() {
        return this.juros;
    }

    public void setJuros(int juros) {
        this.juros = juros;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}
