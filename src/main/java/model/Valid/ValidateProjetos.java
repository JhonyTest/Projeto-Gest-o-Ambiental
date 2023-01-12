
package model.Valid;

import Exceptions.ProjetosException;
import model.Projetos;


public class ValidateProjetos{    

 public Projetos validacao(String nome, String cidade, String estado, String orcamento, String situacao) {
        Projetos p = new Projetos();
        if (nome.isEmpty()) {
            throw new ProjetosException("Error - Campo vazio: 'nome'.");
        }
        p.setNome(nome);

        if (cidade.isEmpty()) {
            throw new ProjetosException("Error - Campo vazio: 'cidade'.");
        }
        p.setCidade(cidade);
        
        int orcamentoInt = 0;
        if (orcamento.isEmpty()) {
            throw new ProjetosException("Error - Campo vazio: 'orcamento'.");
        }

        if (!orcamento.matches("[0-9]*")) {
            throw new ProjetosException("Error - Valor inválido no campo 'orcamento'.");
        }
        
        if (estado.isEmpty()) {
            throw new ProjetosException("Error - Campo vazio: 'estado'.");
        }
        p.setEstado(estado);
        
        if (situacao.isEmpty()) {
            throw new ProjetosException("Error - Campo vazio: 'situacao'.");
        }
        p.setSituacao(situacao);

        orcamentoInt = Integer.parseInt(orcamento);
        p.setOrcamento(orcamentoInt);

        return p;

    }

}

    
       
       

    


