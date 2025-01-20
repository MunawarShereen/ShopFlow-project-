
class Clothes extends Product {
    // Attributes
    private String brand;
    private String size;

    // Constructors
    public Clothes() {
        super();
    }


    public Clothes(int ID, String name, double price, String brand, String size, int quantity_in_stock) {
        super(ID, name, price, quantity_in_stock);
        this.brand = brand;
        this.size = size;

    }

    public void display() {

        System.out.println("ID: " + getID());
        System.out.println("Category: " + getCategory());
        System.out.println("Name: " + getName());
        System.out.println("Price: " + getPrice());
        System.out.println("Quantity in Stock: " + getQuantity_in_stock());
        System.out.println("Quantity sold: " + getQuantity_sold());
        System.out.println("Brand: " + getBrand());
        System.out.println("Size: " + getSize());
        System.out.println();
    }

    // Setters and Getters
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    // Methods
    @Override
    public String getCategory() {
        return "Clothes";
    }
}
