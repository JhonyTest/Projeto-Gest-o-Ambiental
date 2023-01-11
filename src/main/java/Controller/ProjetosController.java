/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ProjetosDAO;
import Exceptions.ProjetosException;
import Valid.ValidateLoginEmpresa;
import Valid.ValidateLoginFiscal;
import Valid.ValidateProjetos;
import java.util.List;
import javax.swing.JTable;
import model.Empresa;
import model.Projetos;

/**
 *
 * @author Joao Pedro
 */
public class ProjetosController {
    
   private ProjetosDAO repositorio;

    public ProjetosController() {
        repositorio = new ProjetosDAO();
    }

    public void cadastrarProjetos(String nome, String cidade, String estado, String orcamento, String situacao) {
        ValidateProjetos valid = new ValidateProjetos();
        Projetos novoProjetos = valid.validacao(nome, cidade, estado, orcamento, situacao);
        if (repositorio.findByNome(nome) == null) {
            repositorio.save(novoProjetos);
        } else {
            throw new ProjetosException("Error - Já existe um projeto com este 'nome'.");
        }
    }
    
   

    public void atualizarProjetos(long idProjetos ,String nome, String cidade, String estado, String orcamento, String situacao) {
        
   
        ValidateProjetos valid = new ValidateProjetos();
        Projetos novoProjetos = valid.validacao(nome, cidade, estado, orcamento, situacao);
        novoProjetos.setId(idProjetos);
        repositorio.save(novoProjetos);

    }

    public Projetos buscarProjetos(String nome) {
        return (Projetos) this.repositorio.findByNome(nome);
    }

    public void atualizarTabela(JTable grd) {
         List<Projetos> lst = repositorio.findAll();

        TMProjetos tmProjetos = new TMProjetos(lst);
        grd.setModel(tmProjetos);
    }

    public void excluirProjetos(Projetos projetos) {
        if (projetos != null) {
            repositorio.delete(projetos);
        } else {
            throw new ProjetosException("Error - Projeto inexistente.");
        }
    }
    
   
  
}

