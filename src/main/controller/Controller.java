package main.controller;

import main.model.Donnee;
import main.model.Item;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Observer;

public class Controller {

    private Adapter adapter;

    public Controller(Adapter adapter_p)
    {
        adapter = adapter_p;
    }

    public void addItem(Item item_p)
    {
        adapter.addItem(item_p);
    }

    public List<Item> getItemList()
    {
        return adapter.getItemList();
    }

    public String getName()
    {
        return adapter.getName();
    }

    public void setName(String name_p)
    {
        adapter.setName(name_p);
    }

    public void deleteItem(Item item_p)
    {
        adapter.deleteItem(item_p);
    }

    public void setSelectedItem(Integer id_p)
    {
        adapter.setSelectedId(id_p);
    }

    public void setIntitule(Integer key_p, String intitule_p)
    {
        adapter.setIntitule(key_p, intitule_p);
    }

    public void setDescription(Integer key_p, String description_p)
    {
        adapter.setDescription(key_p, description_p);
    }

    public void setValeur(Integer key_p, Integer valeur_p)
    {
        adapter.setValeur(key_p, valeur_p);
    }

}
