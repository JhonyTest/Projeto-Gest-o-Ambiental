
package model.Valid;

import Exceptions.FiscalException;
import model.Fiscal;

public class ValidateLoginFiscal {

    public void validEntrada(String cpf, String senha) {
        if (cpf.isEmpty()) {
            throw new FiscalException("Error - Campo vazio 'cpf'.");
        }

        if (senha.isEmpty()) {
            throw new FiscalException("Error - Campo vazio 'senha'.");
        }
    }

    public void validLogin(Fiscal fiscal, String senha) {

        if (fiscal == null) {
            throw new FiscalException("Erro - Funcionario nao cadastrado.");
        }

        if (fiscal.getSenha() == null ? senha != null : !fiscal.getSenha().equals(senha)) {
            throw new FiscalException("Erro - Senha incorreta.");
        }
    }

}
