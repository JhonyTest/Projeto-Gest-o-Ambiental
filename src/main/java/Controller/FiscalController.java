/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.FiscalDAO;
import Exceptions.FiscalException;
import Valid.ValidateFiscal;
import Valid.ValidateLoginFiscal;
import java.util.List;
import javax.swing.JTable;
import model.Fiscal;

/**
 *
 * @author Joao Pedro
 */
public class FiscalController {

    private FiscalDAO repositorio;

    public FiscalController() {
        repositorio = new FiscalDAO();
    }

    public void cadastrarFiscal(String nome, String sexo, String idade, String cpf, String pass) {
        ValidateFiscal valid = new ValidateFiscal();
        Fiscal novoFiscal = valid.validacao(nome, sexo, idade, cpf, pass);

        if (repositorio.findByCpf(cpf) == null) {
            repositorio.save(novoFiscal);
        } else {
            throw new FiscalException("Error - Já existe um fiscal com este 'CPF'.");
        }
    }

    public void atualizarFiscal(long idFiscal,String nome, String sexo, String idade, String cpf, String pass) {
        ValidateFiscal valid = new ValidateFiscal();
        Fiscal novoFiscal = valid.validacao(nome, sexo, idade, cpf, pass);
        novoFiscal.setId((int) idFiscal);

        repositorio.save(novoFiscal);

    }

    public Fiscal buscarFiscal(String cpf) {
        return (Fiscal) this.repositorio.findByCpf(cpf);
    }

    public void atualizarTabela(JTable grd) {
        List<Fiscal> lst = repositorio.findAll();

        TMFiscal tmFiscal = new TMFiscal(lst);
        grd.setModel(tmFiscal);
    }

    public void excluirFiscal(Fiscal fiscal) {
        if (fiscal != null) {
            repositorio.delete(fiscal);
        } else {
            throw new FiscalException("Error - Fiscal inexistente.");
        }
    }

    public void checkLogin(String cpf, String senha) {
        ValidateLoginFiscal valid = new ValidateLoginFiscal();
        valid.validEntrada(cpf, senha);
        valid.validLogin(this.buscarFiscal(cpf), senha);
    }
}
