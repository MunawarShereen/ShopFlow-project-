
class MedicalCare extends Product {
    // Attributes
    private String brand;
    private String dosage;

    // Constructors
    public MedicalCare() {
        super();
    }

    public MedicalCare(int ID, String name, double price, String brand, String dosage, int quantity_in_stock) {
        super(ID, name, price, quantity_in_stock);
        this.brand = brand;
        this.dosage = dosage;

    }


    public void display() {
        System.out.println("ID: " + getID());
        System.out.println("Category: " + getCategory());
        System.out.println("Name: " + getName());
        System.out.println("Price: " + getPrice());
        System.out.println("Quantity in Stock: " + getQuantity_in_stock());
        System.out.println("Quantity sold: " + getQuantity_sold());
        System.out.println("Brand: " + getBrand());
        System.out.println("Dosage: " + getDosage());
        System.out.println();
    }


    // Setters and Getters
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    // Methods
    @Override
    public String getCategory() {
        return "MedicalCare";
    }
}
