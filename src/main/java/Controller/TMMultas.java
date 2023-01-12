
package Controller;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Multas;

public class TMMultas extends AbstractTableModel {

    private List<Multas> lista;

 
    private final int COL_CNPJ = 0;
    private final int COL_DOCUMENTO = 1;
    private final int COL_VENCIMENTO = 2;
    private final int COL_MULTA = 3;
    private final int COL_JUROS = 4;
    private final int COL_TOTAL = 5;
        private final int COL_ID = 6;


    public TMMultas(List<Multas> lstMultas) {
        lista = lstMultas;
    }

    @Override
    public int getRowCount() {
        return this.lista.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
           
            case COL_CNPJ:
                return "Cnpj";

            case COL_DOCUMENTO:

                return "Documento";

            case COL_VENCIMENTO:
                return "Vencimento";

            case COL_MULTA:
                return "Multa";

            case COL_JUROS:
                return "Juros";

            case COL_TOTAL:
                return "Total";

            default:
                break;
        }
        return "";

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Multas aux = new Multas();
        if (lista.isEmpty()) {
            return aux;
        } else {
            aux = (Multas) lista.get(rowIndex);
            //verifica qual valor deve ser retornado
            switch (columnIndex) {
                case -1:
                    return aux;

               
                
                case COL_CNPJ:
                    return aux.getCnpj();

                case COL_DOCUMENTO:
                    return aux.getDocumento();

                case COL_VENCIMENTO:
                    return aux.getVencimento();

                case COL_MULTA:
                    return aux.getMulta();

                case COL_JUROS:
                    return aux.getJuros();

                case COL_TOTAL:
                    return aux.getTotal();

                default:
                    break;
            }
        }
        return aux;
    }

}
