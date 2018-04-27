package model;

/**
 * Created by julia on 4/21/2018.
 */

public class Medication {

    private int idMed;
    private String name;
    private String ingredients;
    private String manufacturer;
    private String price;
    private String quantity;
    private String price2;

    public Medication(int idMed, String name, String ingredients, String manufacturer, String price,
                      String quantity) {
        this.idMed = idMed;
        this.name = name;
        this.ingredients = ingredients;
        this.manufacturer = manufacturer;
        this.price = price;
        this.quantity = quantity;
    }

    public Medication(String name, String ingredients, String manufacturer, String price,
                      String quantity) {
        this.name = name;
        this.ingredients = ingredients;
        this.manufacturer = manufacturer;
        this.price = price;
        this.quantity = quantity;
    }
    
    public Medication(int idMed, String name, String ingredients, String manufacturer, int price2,
            String quantity) {
		this.idMed = idMed;
		this.name = name;
		this.ingredients = ingredients;
		this.manufacturer = manufacturer;
		this.price2 = price;
		this.quantity = quantity;
    }
    

    public int getIdMed() {
        return idMed;
    }

    public void setIdMed(int idMed) {
        this.idMed = idMed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }




}
