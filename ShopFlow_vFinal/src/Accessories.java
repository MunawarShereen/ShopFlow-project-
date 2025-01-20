
class Accessories extends Product {
    // Attributes
    private String brand;
    private String color;


    // Constructors
    public Accessories() {
        super();
    }

    public Accessories(int ID, String name, double price, String brand, String color, int quantity_in_stock) {
        super(ID, name, price, quantity_in_stock);
        this.brand = brand;
        this.color = color;

    }

    public void display() {
        System.out.println("ID: " + getID());
        System.out.println("Category: " + getCategory());
        System.out.println("Name: " + getName());
        System.out.println("Price: " + getPrice());
        System.out.println("Quantity in Stock: " + getQuantity_in_stock());
        System.out.println("Quantity sold: " + getQuantity_sold());
        System.out.println("Brand: " + getBrand());
        System.out.println("Color: " + getColor());
        System.out.println();
    }

    // Setters and Getters
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Methods
    @Override
    public String getCategory() {
        return "Accessories";
    }
}
