/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Empresa;

/**
 *
 * @author Joao Pedro
 */
class TMEmpresa extends AbstractTableModel {

    private List<Empresa> lista;

    private final int COL_ID = 0;
    private final int COL_NOME = 1;
    private final int COL_CNPJ = 2;
    private final int COL_SENHA = 3;
    

    public TMEmpresa(List<Empresa> lstEmpresa) { 
        this.lista = lstEmpresa;
      
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
            case COL_ID:
                return "ID";
            
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
                
                case COL_ID:
                    return aux.getId();
                
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
