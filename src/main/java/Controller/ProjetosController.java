/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ProjetosDAO;
import Exceptions.ProjetosException;
import Valid.ValidateLoginFiscal;
import Valid.ValidateProjetos;
import javax.swing.JTable;
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

    public void cadastrarProjeto(String nome, String cidade, String estado, String orcamento, int id ) {
        ValidateProjetos valid = new ValidateProjetos();
        Projetos novoProjetos = valid.validacao(nome, cidade, estado, orcamento);

        if (repositorio.findById(id) == null) {
            repositorio.save(novoProjetos);
        } else {
            throw new ProjetosException("Error - Já existe um fiscal com este 'ID'.");
        }
    }

    public void atualizarProjetos(String nome, String cidade, String estado, String orcamento, int id) {
        ValidateProjetos valid = new ValidateProjetos();
        Projetos novoProjetos = valid.validacao(nome, cidade, estado, orcamento);
        novoProjetos.setId(id);

        repositorio.update(novoProjetos);

    }

    public Projetos buscarProjetos(int id) {
        return (Projetos) this.repositorio.findById(id);
    }

    public void atualizarTabela(JTable grd) {
        Util.jTableShow(grd, new TMProjetos(repositorio.findAll()), null);
    }

    public void excluirProjetos(Projetos projetos) {
        if (projetos != null) {
            repositorio.delete(projetos);
        } else {
            throw new ProjetosException("Error - Fiscal inexistente.");
        }
    }

  
}

