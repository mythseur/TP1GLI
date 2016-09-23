package main.vue;

import main.controller.Controller;
import main.model.Donnee;
import main.model.Item;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class ControlPanel extends JPanel implements IVue {

    JLabel label1;
    JLabel label2;
    JLabel label3;
    JButton leftArrow;
    JButton rightArrow;
    Donnee donnee;
    Controller controller;

    public ControlPanel(Donnee donnee_p, Controller controller_p) {
        controller = controller_p;
        donnee = donnee_p;
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        leftArrow = new JButton(new ImageIcon(this.getClass().getResource("../resources/left.png")));
        leftArrow.addActionListener(e -> decreaseSelected());
        rightArrow = new JButton(new ImageIcon(this.getClass().getResource("../resources/right.png")));
        rightArrow.addActionListener(e -> increaseSelected());

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(label1);
        this.add(label2);
        this.add(label3);
        JPanel buttonPanel_l = new JPanel();
        buttonPanel_l.add(leftArrow);
        buttonPanel_l.add(rightArrow);
        this.add(buttonPanel_l);
        this.setMaximumSize(new Dimension(200, 600));
    }

    @Override
    public void notifyChange() {
        if (donnee.getSelectedItem() != null) {
            Item item_l = donnee.getItemList().get(donnee.getSelectedItem());
            label1.setText(item_l.getIntitule());
            label2.setText(item_l.getDescription());
            label3.setText(String.valueOf(item_l.getValeur()));
        }
        else
        {
            label1.setText("");
            label2.setText("");
            label3.setText("");
        }
    }

    public void increaseSelected()
    {
        if(donnee.getSelectedItem() != null)
        {
            controller.setSelectedItem((donnee.getSelectedItem()+1)%donnee.getItemList().size());
        }
    }

    public void decreaseSelected()
    {
        if(donnee.getSelectedItem() != null)
        {
            int newValue = donnee.getSelectedItem() -1;
            if(newValue < 0)
            {
                newValue = donnee.getItemList().size()-1;
            }
            controller.setSelectedItem(newValue);
        }
    }
}
