package main.vue;

import javafx.scene.shape.Circle;
import main.controller.Controller;
import main.model.Donnee;
import main.model.Item;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Arc2D;
import java.awt.geom.Rectangle2D;
import java.util.*;
import java.util.List;

public class Diagram extends JComponent implements MouseListener,IVue {

    private Controller controller;
    private Donnee donnee;
    private int compteur;
    private List<Arc2D> arcs;

    Diagram(Controller controller_p, Donnee donnee_p)
    {
        donnee = donnee_p;
        controller = controller_p;
        compteur = -1;

    }

    @Override
    protected void paintComponent(Graphics g) {

        arcs = new ArrayList<>();
        compteur = -1;
        super.paintComponent(g);

        Dimension d = getSize();

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.WHITE);
        Rectangle2D rect2D = new Rectangle(0, 0, 500, 500);
        g2d.fill(rect2D);

        Rectangle2D schemaRect = new Rectangle(50,50,400, 400);

        Rectangle2D whiteCerc = new Rectangle(100,100,300,300);

        Rectangle2D innerCerc = new Rectangle(150,150,200,200);

        g2d.setFont(new Font("Arial", Font.BOLD, 14));
        g2d.setColor(Color.BLACK);

        double total_l = controller.getItemList().stream().mapToInt(Item::getValeur).sum();
        double begin_l = 0.;

        for(Item item : donnee.getItemList()) {
            Double angle_l = (item.getValeur() / total_l) * 360;

            Arc2D.Double arc_l;
            if(donnee.getSelectedItem()!= null && donnee.getSelectedItem() == donnee.getItemList().lastIndexOf(item))
                    arc_l = new Arc2D.Double(rect2D, begin_l+1, angle_l-1, Arc2D.PIE);
            else
                    arc_l = new Arc2D.Double(schemaRect, begin_l+1, angle_l-1, Arc2D.PIE);

            g2d.setColor(getColor());
            g2d.fill(arc_l);
            begin_l += angle_l;
            arcs.add(arc_l);
        }

        Arc2D circle_l = new Arc2D.Double(whiteCerc, 0, 360, Arc2D.PIE);

        g2d.setColor(Color.WHITE);
        g2d.fill(circle_l);

        Arc2D innerCircle_l = new Arc2D.Double(innerCerc, 0, 360, Arc2D.PIE);
        g2d.setColor(new Color(193, 19, 255));
        g2d.fill(innerCircle_l);

        g2d.setColor(Color.BLACK);

        Double x = innerCircle_l.getCenterX();

        Double y = innerCircle_l.getCenterY();

        g2d.drawString(controller.getName() , x.intValue()-25, y.intValue());

        g2d.drawString(total_l +" Euros", x.intValue()-40, y.intValue()+20);
    }

    private Color getColor()
    {
        compteur++;
        if(compteur %3 == 0)
            return Color.BLUE;
        else if(compteur %3 == 1)
            return Color.RED;
        else
            return Color.GREEN;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for(Arc2D arc2D_l : arcs)
        {
            if(arc2D_l.contains(e.getX(), e.getY()))
            {
                setSelected(arcs.lastIndexOf(arc2D_l));
                break;
            }
            else
            {
                setSelected(null);
            }

        }

    }

    private void setSelected(Integer id_p) {
        controller.setSelectedItem(id_p);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void notifyChange() {
        this.repaint();
    }
}
