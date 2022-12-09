/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.EmpresaDAO;
import Exceptions.EmpresaException;
import Valid.ValidateEmpresa;
import java.util.List;
import javax.swing.JTable;
import model.Empresa;

/**
 *
 * @author Joao Pedro
 */
public class EmpresaController {

    private EmpresaDAO repositorio;

    public EmpresaController() {
        repositorio = new EmpresaDAO();
    }

    public void cadastrarEmpresa(String nome, String cnpj) {
        ValidateEmpresa valid = new ValidateEmpresa();
        Empresa novoEmpresa = valid.validacao(nome, cnpj);

        if (repositorio.findByCnpj(cnpj) == null) {
            repositorio.save(novoEmpresa);
        } else {
            throw new EmpresaException("Error - Já existe uma empresa com este 'CNPJ'.");
        }
    }

    public void atualizarEmpresa(String nome, String cnpj) {
        ValidateEmpresa valid = new ValidateEmpresa();
        Empresa novoEmpresa = valid.validacao(nome, cnpj);
        novoEmpresa.setCnpj(cnpj);

        repositorio.update(novoEmpresa);
    }

    public Empresa buscarEmpresa(String cnpj) {
        return (Empresa) this.repositorio.findByCnpj(cnpj);
    }

    public void atualizarTabela(JTable grd) 
    {
        Util.jTableShow(grd, new TMEmpresa(repositorio.findAll()), null);
    }

    public void excluirEmpresa(Empresa empresa) {
        if (empresa != null) {
            repositorio.delete(empresa);
        } else {
            throw new EmpresaException("Error - Empresa inexistente.");
        }
    }
}
