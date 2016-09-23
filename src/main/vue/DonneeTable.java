package main.vue;

import main.controller.Controller;
import main.model.Donnee;
import main.model.Item;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.StringContent;

public class DonneeTable extends JTable implements IVue{

    DonneeTable(Controller controller_p, Donnee donnee_p)
    {
        super();
        this.setModel(new DonneeModel(controller_p, donnee_p));
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return true;
    }

    @Override
    public void notifyChange() {
        ((AbstractTableModel)getModel()).fireTableDataChanged();
    }

    private class DonneeModel extends AbstractTableModel{

        Donnee modele;

        Controller controller;

        DonneeModel(Controller controller_p, Donnee donnee_p)
        {
            modele = donnee_p;
            controller = controller_p;
        }

        @Override
        public int getRowCount() {
            return modele.getItemList().size();
        }

        @Override
        public int getColumnCount() {
            return 3;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if(columnIndex == 2)
            {
                return Integer.class;
            }
            else
            {
                return String.class;
            }
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
                if(columnIndex == 0)
                {
                    controller.setIntitule(rowIndex, aValue.toString());
                }
                else if(columnIndex == 1)
                {
                    controller.setDescription(rowIndex, aValue.toString());
                }
                else
                {
                    controller.setValeur(rowIndex, (Integer) aValue);
                }
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Item item = modele.getItemList().get(rowIndex);

            if(columnIndex == 0)
            {
                return item.getIntitule();
            }
            else if(columnIndex == 1)
            {
                return item.getDescription();
            }
            else
            {
                return item.getValeur();
            }
        }
    }
}
