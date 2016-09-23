package main.model;

public class Item {

    private String intitule;
    private String description;
    private Integer valeur;
    private Integer key;

    private static Integer gen = 0;

    public Item(String intitule_p, String description_p, Integer valeur_p)
    {
        intitule = intitule_p;
        description = description_p;
        valeur = valeur_p;
        key = gen;
        gen++;
    }

    public String getIntitule()
    {
        return intitule;
    }

    public String getDescription()
    {
        return description;
    }

    public int getValeur()
    {
        return valeur;
    }

    void setIntitule(String intitule_p)
    {
        intitule = intitule_p;
    }

    void setDescription(String description_p)
    {
        description = description_p;
    }

    void setValeur(Integer valeur_p)
    {
        valeur = valeur_p;
    }

    Integer getKey()
    {
        return key;
    }
}
