/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Joao Pedro
 */
public class Fiscal 
{
    private String nome;
    private String sexo;
    private int idade;
    private String cpf;

    public Fiscal() 
    {
        this.nome = "";
        this.sexo = "";
        this.idade = 0;
        this.cpf = "000.000.000-00";
    }

    public void copiar(Fiscal outro){
        this.nome = outro.getNome();
        this.sexo = outro.getSexo();
        this.idade = outro.getIdade();
        this.cpf = outro.getCpf();
    }
    
    
    
    
   public String getNome(){
       return this.nome;
   }
   public int getIdade(){
       return this.idade;
   }
  
   public String getSexo(){
       return this.sexo;
   }
    public String getCpf(){
       return this.cpf;
   }
}
