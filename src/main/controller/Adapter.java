package main.controller;

import main.model.Donnee;
import main.model.Item;
import main.vue.IVue;

import java.util.ArrayList;
import java.util.List;

public class Adapter{

    private Donnee donnee;
    private List<IVue> vues;

    public Adapter(Donnee donnee_p) {
        donnee = donnee_p;
        vues = new ArrayList<>();
    }

    public void addVue(IVue vue_p)
    {
        vues.add(vue_p);
    }

    void addItem(Item item_p) {
        donnee.addItem(item_p);
    }

    List<Item> getItemList() {
        return donnee.getItemList();
    }

    String getName() {
        return donnee.getName();
    }

    void setName(String name_p) {
        donnee.setName(name_p);
        vues.forEach(IVue::notifyChange);
    }

    void deleteItem(Item item_p) {
        donnee.deleteItem(item_p);
    }

    void setSelectedId(Integer selectedId) {
        donnee.setSelectedItem(selectedId);
        vues.forEach(IVue::notifyChange);
    }

    public void setIntitule(Integer key_p, String intitule_p)
    {
       donnee.setIntitule(key_p, intitule_p);
        vues.forEach(IVue::notifyChange);
    }

    public void setDescription(Integer key_p, String description_p)
    {
        donnee.setDescription(key_p, description_p);
        vues.forEach(IVue::notifyChange);
    }

    public void setValeur(Integer key_p, Integer valeur_p)
    {
        donnee.setValeur(key_p, valeur_p);
        vues.forEach(IVue::notifyChange);
    }


}
