package br.com.guimaraescosta.drinknow.br.com.guimaraescosta.drinknow.entity;

/**
 * Created by jguimara on 21/01/2018.
 */

public class Drink {

    private String name;
    private String description;
    private int quantity;

    public Boolean getSelected() {
        return isSelected;
    }

    public void setSelected(Boolean isSelected) {
        this.isSelected = isSelected;

    }

    public boolean isSelected(){
        return isSelected;
    }

    private Boolean isSelected = false;


    public Drink(String nome, String descricao) {
        this.name = nome;
        this.description = descricao;
        //this.quantity = quantidade;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
