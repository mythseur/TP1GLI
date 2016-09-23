package main;

import main.controller.Adapter;
import main.controller.Controller;
import main.model.Donnee;
import main.model.Item;
import main.vue.Window;

public class App{

    public static void main(String[] args) {

        Donnee donnee_l  = new Donnee("Budget");

        donnee_l.addItem(new Item("1", "je suis un item", 20));

        donnee_l.addItem(new Item("2", "je suis un autre item", 70));
//
        donnee_l.addItem(new Item("3", "Je suis encore un item", 10));
//        donnee_l.addItem(new Item("4", "d", 10));
//        donnee_l.addItem(new Item("5", "e", 60));
//        donnee_l.addItem(new Item("6", "f", 50));
//        donnee_l.addItem(new Item("7", "g", 10));

        Window frame_l = new Window(donnee_l);

        frame_l.setVisible(true);
    }
}
