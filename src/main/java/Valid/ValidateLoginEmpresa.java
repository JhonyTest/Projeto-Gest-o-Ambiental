/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Valid;

import Exceptions.EmpresaException;
import model.Empresa;

/**
 *
 * @author darlan
 */
public class ValidateLoginEmpresa {

    public void validEntrada(String cnpj, String senha) {
        if (cnpj.isEmpty()) {
            throw new EmpresaException("Error - Campo vazio 'cnpj'.");
        }

        if (senha.isEmpty()) {
            throw new EmpresaException("Error - Campo vazio 'senha'.");
        }
    }

    public void validLogin(Empresa empresa, String senha) {

        if (empresa == null) {
            throw new EmpresaException("Erro - Empresa nao cadastrada.");
        }

        if (empresa.getSenha() == null ? senha != null : !empresa.getSenha().equals(senha)) {
            throw new EmpresaException("Erro - Senha incorreta.");
        }
    }

}
