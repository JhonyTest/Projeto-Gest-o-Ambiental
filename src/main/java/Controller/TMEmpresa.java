
package Controller;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Empresa;


class TMEmpresa extends AbstractTableModel {

    private List<Empresa> lista;

   
    private final int COL_NOME = 0;
    private final int COL_CNPJ = 1;
    private final int COL_SENHA = 2;
        private final int COL_ID = 3;

    

    public TMEmpresa(List<Empresa> lstEmpresa) { 
        lista = lstEmpresa;
      
    }

    @Override
    public int getRowCount() {
        return this.lista.size();
      
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            
            
            case COL_NOME:
                return "Nome";

            case COL_CNPJ:
                return "Cnpj";
                
            case COL_SENHA:
                return "Senha";
            
            default:
                break;
        }
        return "";

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Empresa aux = new Empresa();
        if (lista.isEmpty()) {
            return aux;
        } else {
            aux = (Empresa) lista.get(rowIndex);
            //verifica qual valor deve ser retornado
            switch (columnIndex) {
                case -1:
                    return aux;
               
                
                case COL_NOME:
                    return aux.getNome();

                case COL_CNPJ:
                    return aux.getCnpj();
                    
                case COL_SENHA:
                    return aux.getSenha();

                default:    
            }
        }
        return aux;
    }
   
}
