/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.EmpresaDAO;
import Exceptions.EmpresaException;
import Valid.ValidateEmpresa;
import Valid.ValidateLoginEmpresa;

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

    public void cadastrarEmpresa(String nome, String cnpj, String senha) {
        ValidateEmpresa valid = new ValidateEmpresa();
        Empresa novoEmpresa = valid.validacao(nome, cnpj, senha);

        if (repositorio.findByCnpj(cnpj) == null) {
            repositorio.save(novoEmpresa);
        } else {
            throw new EmpresaException("Error - Já existe uma empresa com este 'CNPJ'.");
        }
    }

    public void atualizarEmpresa(long idEmpresa,String nome, String cnpj, String senha) {
        ValidateEmpresa valid = new ValidateEmpresa();
        Empresa novoEmpresa = valid.validacao(nome, cnpj, senha);
        novoEmpresa.setId((int) idEmpresa);

        repositorio.save(novoEmpresa);
    }

    public Empresa buscarEmpresa(String cnpj) {
        return (Empresa) this.repositorio.findByCnpj(cnpj);
    }

    public void atualizarTabela(JTable grd) {
        List<Empresa> lst = repositorio.findAll();

        TMEmpresa tmEmpresa = new TMEmpresa(lst);
        grd.setModel(tmEmpresa);

    }

    public void excluirEmpresa(Empresa empresa) {
        if (empresa != null) {
            repositorio.delete(empresa);
        } else {
            throw new EmpresaException("Error - Empresa inexistente.");
        }
    }

    public void checkLogin(String cnpj, String senha) {
        ValidateLoginEmpresa valid = new ValidateLoginEmpresa();
        valid.validEntrada(cnpj, senha);
        valid.validLogin(this.buscarEmpresa(cnpj), senha);
    }
}
