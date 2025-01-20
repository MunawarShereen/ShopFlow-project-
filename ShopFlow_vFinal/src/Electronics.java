
class Electronics extends Product {
    // Attributes
    private String brand;
    private String model;


    // Constructors
    public Electronics() {
        super();
    }

    public Electronics(int ID, String name, double price, String brand, String model, int quantity_in_stock) {
        super(ID, name, price, quantity_in_stock);
        this.brand = brand;
        this.model = model;


    }

    public void display() {

        System.out.println("ID: " + getID());
        System.out.println("Category: " + getCategory());
        System.out.println("Name: " + getName());
        System.out.println("Price: " + getPrice());
        System.out.println("Quantity in Stock: " + getQuantity_in_stock());
        System.out.println("Quantity sold: " + getQuantity_sold());
        System.out.println("Brand: " + getBrand());
        System.out.println("Model: " + getModel());
        System.out.println();
    }

    // Setters and Getters
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    // Methods
    @Override
    public String getCategory() {
        return "Electronics";
    }
}
