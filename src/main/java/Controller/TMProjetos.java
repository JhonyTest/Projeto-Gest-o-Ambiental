/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Projetos;

/**
 *
 * @author Joao Pedro
 */
public class TMProjetos extends AbstractTableModel {
       private List<Projetos> lista;

    private final int COL_ID = 0;
    private final int COL_NOME = 1;
    private final int COL_ESTADO = 2;
    private final int COL_ORÇAMENTO = 3;

    public TMProjetos(List<Projetos> lstProjetos) {
        lista = lstProjetos;
    }

    @Override
    public int getRowCount() {
        return this.lista.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case COL_ID:
                return "ID";

            case COL_NOME:
                return "Nome";

            case COL_ESTADO:
                return "Estado";

            case COL_ORÇAMENTO:
                return "Orçamento";

            default:
                break;
        }
        return "";

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Projetos aux = new Projetos();
        if (lista.isEmpty()) {
            return aux;
        } else {
            aux = (Projetos) lista.get(rowIndex);
            //verifica qual valor deve ser retornado
            switch (columnIndex) {
                case -1:
                    return aux;

                case COL_ID:
                    return aux.getId();

                case COL_NOME:
                    return aux.getNome();
                case COL_ESTADO:
                    return aux.getEstado();
                case COL_ORÇAMENTO:
                    return aux.getOrçamento();
                
                default:
                    break;
            }
        }
        return aux;
    }

}

