/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Valid;

import Exceptions.EmpresaException;
import java.util.InputMismatchException;
import model.Empresa;

/**
 *
 * @author darlan
 */
public class ValidateEmpresa {

    public static boolean validaCNPJ(String cnpj) 
    {
        // considera-se erro CNPJ's formados por uma sequencia de numeros iguais
        if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111")
                || cnpj.equals("22222222222222") || cnpj.equals("33333333333333")
                || cnpj.equals("44444444444444") || cnpj.equals("55555555555555")
                || cnpj.equals("66666666666666") || cnpj.equals("77777777777777")
                || cnpj.equals("88888888888888") || cnpj.equals("99999999999999")
                || (cnpj.length() != 14)) {
            return (false);
        }

        char dig13, dig14;
        int soma, i, resto, num, peso;

        // "try" - protege o código para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            soma = 0;
            peso = 2;
            for (i = 11; i >= 0; i--) {
                // converte o i-ésimo caractere do CNPJ em um número:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posição de '0' na tabela ASCII)
                num = (int) (cnpj.charAt(i) - 48);
                soma = soma + (num * peso);
                peso = peso + 1;
                if (peso == 10) {
                    peso = 2;
                }
            }

            resto = soma % 11;
            if ((resto == 0) || (resto == 1)) {
                dig13 = '0';
            } else {
                dig13 = (char) ((11 - resto) + 48);
            }

            // Calculo do 2o. Digito Verificador
            soma = 0;
            peso = 2;
            for (i = 12; i >= 0; i--) {
                num = (int) (cnpj.charAt(i) - 48);
                soma = soma + (num * peso);
                peso = peso + 1;
                if (peso == 10) {
                    peso = 2;
                }
            }

            resto = soma % 11;
            if ((resto == 0) || (resto == 1)) {
                dig14 = '0';
            } else {
                dig14 = (char) ((11 - resto) + 48);
            }

            // Verifica se os dígitos calculados conferem com os dígitos informados.
            if ((dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13))) {
                return (true);
            } else {
                return (false);
            }
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

    /*public static String imprimeCNPJ(String cnpj) 
    {
        // máscara do CNPJ: 99.999.999.9999-99
        return (cnpj.substring(0, 2) + "." + cnpj.substring(2, 5) + "."
                + cnpj.substring(5, 8) + "." + cnpj.substring(8, 12) + "-"
                + cnpj.substring(12, 14));
    }*/
    
    public Empresa validacao(String nome, String cnpj) {
        Empresa e = new Empresa();
        if (nome.isEmpty()) {
            throw new EmpresaException("Error - Campo vazio: 'nome'.");
        }
        e.setNome(nome);

        if (cnpj.isEmpty()) {
            throw new EmpresaException("Error - Campo vazio: 'cnpj'.");
        }

        ValidateEmpresa validCNPJ = new ValidateEmpresa();
        if (!validCNPJ.validaCNPJ(cnpj)) {
        } else {
            throw new EmpresaException("Error - CNPJ invalido");
        }

        e.setCnpj(cnpj);
     
        return e;
    }
}
