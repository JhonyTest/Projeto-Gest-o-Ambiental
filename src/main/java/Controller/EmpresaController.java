
package Controller;

import model.DAO.EmpresaDAO;
import Exceptions.EmpresaException;
import model.Valid.ValidateEmpresa;
import model.Valid.ValidateLoginEmpresa;

import java.util.List;
import javax.swing.JTable;
import model.Empresa;


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

    public void atualizarEmpresa(long idEmpresa, String nome, String cnpj, String senha) {
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
