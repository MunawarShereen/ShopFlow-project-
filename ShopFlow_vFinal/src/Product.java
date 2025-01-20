import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

abstract class Product {
    private int ID;
    private String name;
    private double price;
    private int quantity_in_stock;
    private int quantity_sold;
    private int quantityToBeSold;


    public Product() {

    }

    public Product(int ID, String name, double price, int quantity_in_stock) {

        this.ID = ID;
        this.name = name;
        this.price = price;
        this.quantity_in_stock = quantity_in_stock;
        this.quantity_sold = 0;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity_in_stock() {
        return quantity_in_stock;
    }

    public void setQuantity_in_stock(int quantity_in_stock) {
        this.quantity_in_stock = quantity_in_stock;
    }

    public int getQuantity_sold() {
        return quantity_sold;
    }

    public void setQuantity_sold(int quantity_sold) {
        this.quantity_sold = quantity_sold;
    }

    public int getQuantityToBeSold() {
        return quantityToBeSold;
    }

    public void setQuantityToBeSold(int quantityToBeSold) {
        this.quantityToBeSold = quantityToBeSold;
    }

    public void display() {
        System.out.println("\nProduct ID: " + getID() +
                "\nProduct Name: " + getName() +
                "\nProduct Price: " + getPrice() +
                "\nQuantity in Stock: " + getQuantity_in_stock() +
                "\nQuantity sold: " + getQuantity_sold());
    }

    abstract public String getCategory();

    public void writeToFile(Product product, String fileName) {
        File f = new File(fileName);

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f, true));
            bufferedWriter.write(product.getID() + "," + product.getCategory() + "," + product.getName() + "," + product.getPrice() + "," + product.getQuantity_in_stock() + "," + product.getQuantity_sold());

            if (product instanceof MedicalCare medicalCare) {
                bufferedWriter.write("," + medicalCare.getBrand() + "," + medicalCare.getDosage());

            } else if (product instanceof Clothes clothes) {
                bufferedWriter.write("," + clothes.getBrand() + "," + clothes.getSize());

            } else if (product instanceof Electronics electronics) {
                bufferedWriter.write("," + electronics.getBrand() + "," + electronics.getModel());

            } else if (product instanceof Accessories accessories) {
                bufferedWriter.write("," + accessories.getBrand() + "," + accessories.getColor());

            }

            bufferedWriter.write(System.lineSeparator());
            bufferedWriter.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
