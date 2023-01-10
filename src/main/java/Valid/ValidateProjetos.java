/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Valid;

import Exceptions.ProjetosException;
import model.Projetos;

/**
 *
 * @author Joao Pedro
 */
public class ValidateProjetos {
    
 
     public Projetos validacao(String nome, String cidade ,String estado , String orcamento) {
        Projetos p = new Projetos();
        if (nome.isEmpty()) {
            throw new ProjetosException("Error - Campo vazio: 'nome'.");
        }
        p.setNome(nome);
        
        if (cidade.isEmpty()) {
            throw new ProjetosException("Error - Campo vazio: 'cidade'.");
        }
        p.setCidade(cidade);
        
        
        if (estado.isEmpty()) {
            throw new ProjetosException("Error - Campo vazio: 'estado'.");
        }
        p.setEstado(estado);
        
        
        int orcamentoInt = 0;
        if (orcamento.isEmpty()) {
            throw new ProjetosException("Error - Campo vazio: 'idade'.");
        }

        if (!orcamento.matches("[0-9]*")) {
            throw new ProjetosException("Error - Valor inválido no campo 'idade'.");
        }

        orcamentoInt = Integer.parseInt(orcamento);
        p.setOrcamento(orcamentoInt);

        if (orcamento.isEmpty()) {
            throw new ProjetosException("Error - Campo vazio: 'orcamento'.");
        }
        return p;
     }
}

