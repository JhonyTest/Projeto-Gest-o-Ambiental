
package model.Valid;

import Exceptions.MultaException;
import model.Multas;


public class ValidateMultas {

    public Multas validacao(String cnpj, String documento, String multa, String vencimento, String juros, String total) {
        Multas m = new Multas();

        int jurosInt = 0;
        int totalInt = 0;
        int multaInt = 0;

        if (cnpj.isEmpty()) {
            throw new MultaException("Error - Campo vazio: 'cnpj'.");
        }
        m.setCnpj(cnpj);

        if (documento.isEmpty()) {
            throw new MultaException("Error - Campo vazio: 'documento'.");
        }
        m.setDocumento(documento);

        if (multa.isEmpty()) {
            throw new MultaException("Error - Campo vazio: 'multa'.");
        }
        multaInt = Integer.parseInt(multa);
        m.setMulta(multaInt);

        if (vencimento.isEmpty()) {
            throw new MultaException("Error - Campo vazio: 'vencimento'.");
        }
        m.setVencimento(vencimento);

        if (juros.isEmpty()) {
            throw new MultaException("Error - Campo vazio: 'juros'.");
        }
        jurosInt = Integer.parseInt(juros);
        m.setJuros(jurosInt);

        if (total.isEmpty()) {
            throw new MultaException("Error - Campo vazio: 'total'.");
        }
        totalInt = Integer.parseInt(total);
        m.setTotal(totalInt);

        return m;

    }
}
