package main.vue;

import main.controller.Adapter;
import main.controller.Controller;
import main.model.Donnee;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    private JSplitPane splitPane;
    private JTable table;
    private JPanel leftPanel;

    public Window(Donnee donnee_p) {
        //Init Controller
        Adapter adapter_l = new Adapter(donnee_p);
        Controller controller_l = new Controller(adapter_l);

        //Init diagram view
        Diagram diag_l = new Diagram(controller_l, donnee_p);
        adapter_l.addVue(diag_l);

        //InitControlPanel
        ControlPanel controlPanel_l = new ControlPanel(donnee_p, controller_l);
        adapter_l.addVue(controlPanel_l);

//        //InitLeftPanel
        leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.LINE_AXIS));
        leftPanel.add(diag_l);
        leftPanel.add(controlPanel_l);


        //Init JTable
        table = new DonneeTable(controller_l, donnee_p);

        //Init SplitPanel
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        setContentPane(splitPane);
        splitPane.addMouseListener(diag_l);

        //Adding Component in the SplitPanel
        splitPane.add(leftPanel);
//        splitPane.add(Box.createVerticalGlue());
        splitPane.add(table);

        //Definining Size and Window properties
        Dimension minimumSize = new Dimension(800, 200);
        splitPane.getLeftComponent().setMinimumSize(minimumSize);
        this.setMinimumSize(new Dimension(1200, 600));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
