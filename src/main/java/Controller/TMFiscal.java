
package Controller;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Fiscal;


class TMFiscal extends AbstractTableModel {

    private List<Fiscal> lista;

    private final int COL_NOME = 0;
    private final int COL_IDADE = 1;
    private final int COL_SEXO = 2;
    private final int COL_CPF = 3;
    private final int COL_ID = 4;

    public TMFiscal(List<Fiscal> lstFiscal) {
        lista = lstFiscal;
    }

    @Override
    public int getRowCount() {
        return this.lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
          

            case COL_NOME:
                return "Nome";

            case COL_IDADE:
                return "Idade";

            case COL_SEXO:
                return "Sexo";

            case COL_CPF:
                return "Cpf";

            default:
                break;
        }
        return "";

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Fiscal aux = new Fiscal();
        if (lista.isEmpty()) {
            return aux;
        } else {
            aux = (Fiscal) lista.get(rowIndex);
            //verifica qual valor deve ser retornado
            switch (columnIndex) {
                case -1:
                    return aux;

              
                case COL_NOME:
                    return aux.getNome();
                case COL_IDADE:
                    return aux.getIdade();
                case COL_SEXO:
                    return aux.getSexo();
                case COL_CPF:
                    return aux.getCpf();

                default:
                    break;
            }
        }
        return aux;
    }

}
