/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.MultasDAO;
import Exceptions.MultaException;
import Valid.ValidateMultas;
import java.util.List;
import javax.swing.JTable;
import model.Multas;
import model.Empresa;
import model.Projetos;

/**
 *
 * @author Joao Pedro
 */
public class MultasController {

    private MultasDAO repositorio;

    public MultasController() {
        repositorio = new MultasDAO();
    }

    public void cadastrarMultas(String cnpj, String documento, String multa, String vencimento, String juros, String total) {
        ValidateMultas valid = new ValidateMultas();
        Multas novaMulta = valid.validacao(cnpj, documento, multa, vencimento, juros, total);

        if (repositorio.findByCnpj(cnpj) == null) {
            repositorio.save(novaMulta);
        } else {
            throw new MultaException("Error - Já existe uma multa com este 'CNPJ'.");
        }
    }

    public void atualizarMultas(long idMultas, String cnpj, String documento, String multa, String vencimento, String juros, String total) {
        
        ValidateMultas valid = new ValidateMultas();
        Multas novaMulta;
        novaMulta = valid.validacao(cnpj, documento, multa, vencimento, juros, total);
        novaMulta.setId(idMultas);
        repositorio.update(novaMulta);
    }

    public Multas buscarMultas(String cnpj) {
        return (Multas) this.repositorio.findByCnpj(cnpj);
    }

    public void atualizarTabela(JTable grd) {
        Util.jTableShow(grd, new TMMultas(repositorio.findAll()), null);

    }

    public void excluirMultas(Multas multas) {
        if (multas != null) {
            repositorio.delete(multas);
        } else {
            throw new MultaException("Error - Multa inexistente.");
        }
    }
}
