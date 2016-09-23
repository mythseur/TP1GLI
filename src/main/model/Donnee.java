package main.model;

import java.util.ArrayList;
import java.util.List;

public class Donnee {

    private String name;
    private List<Item> itemList;
    private Integer selectedId;

    public Donnee(String name_p)
    {
        name = name_p;
        itemList = new ArrayList<>();
    }

    public void addItem(Item item_p)
    {
        itemList.add(item_p);
    }

    public List<Item> getItemList()
    {
        return itemList;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name_p)
    {
        name = name_p;
    }

    public void deleteItem(Item item_p)
    {
        itemList.remove(item_p);
    }

    public Integer getSelectedItem()
    {
        return selectedId;
    }

    public void setSelectedItem(Integer id_p)
    {
        selectedId = id_p;
    }

    public void setIntitule(Integer key_p, String intitule_p)
    {
        itemList.get(key_p).setIntitule(intitule_p);
    }

    public void setDescription(Integer key_p, String description_p)
    {
        itemList.get(key_p).setDescription(description_p);
    }

    public void setValeur(Integer key_p, Integer valeur_p)
    {
        itemList.get(key_p).setValeur(valeur_p);
    }
}
