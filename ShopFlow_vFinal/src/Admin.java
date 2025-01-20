import java.util.ArrayList;
import java.util.Scanner;

class Admin {
    private static final ArrayList<Product> catalog = new ArrayList<Product>();
    private static final String username = "admin123";
    private static final String password = "admin123";


    public static ArrayList<Product> getCatalog() {
        return catalog;
    }

    public static void addOnlyToCatalog(Product product) {
        catalog.add(product);
    }

    public static Admin login() {
        Scanner sc = new Scanner(System.in);
        int counter = 0;
        while (true) {
            if (counter < 3) {
                System.out.println("Enter username: ");
                String username1 = sc.next();
                System.out.println("Enter password: ");
                String password1 = sc.next();


                if (username1.equals(username) && password1.equals(password)) {
                    System.out.println("\nLogin Successful!");
                    Admin admin = new Admin();
                    return admin;
                }
                counter++;
                System.err.printf("\nIncorrect username or Password! %d tries left\n", 3 - counter);
            } else {
                return null;
            }
        }
    }

    public Product addItem() {

        Scanner sc = new Scanner(System.in);

        System.out.println("\nEnter category of Product:\n1. Medical Care\n2. Clothes\n3. Accessories\n4. Electronics");
        int category = sc.nextInt();

        while (true) {

            switch (category) {
                case 1:
                    MedicalCare medicalCare = new MedicalCare();
                    System.out.println("\nEnter product ID: ");
                    medicalCare.setID(sc.nextInt());

                    System.out.println("\nEnter product name: ");
                    medicalCare.setName(sc.next());
                    sc.nextLine();

                    System.out.println("\nEnter product price: ");
                    medicalCare.setPrice(sc.nextInt());

                    System.out.println("\nEnter product brand: ");
                    medicalCare.setBrand(sc.next());
                    sc.nextLine();

                    System.out.println("\nEnter product dosage: ");
                    medicalCare.setDosage(sc.next());
                    sc.nextLine();

                    System.out.println("\nEnter product quantity in stock: ");
                    medicalCare.setQuantity_in_stock(sc.nextInt());


                    medicalCare.writeToFile(medicalCare, "Inventory.txt");
                    return medicalCare;

                case 2:
                    Clothes clothes = new Clothes();
                    System.out.println("\nEnter product ID: ");
                    clothes.setID(sc.nextInt());

                    System.out.println("\nEnter product name: ");
                    clothes.setName(sc.next());
                    sc.nextLine();

                    System.out.println("\nEnter product price: ");
                    clothes.setPrice(sc.nextInt());

                    System.out.println("\nEnter product brand: ");
                    clothes.setBrand(sc.next());
                    sc.nextLine();

                    System.out.println("\nEnter product size: ");
                    clothes.setSize(sc.next());
                    sc.nextLine();


                    System.out.println("\nEnter product quantity in stock: ");
                    clothes.setQuantity_in_stock(sc.nextInt());

                    clothes.writeToFile(clothes, "Inventory.txt");
                    return clothes;


                case 3:
                    Accessories accessories = new Accessories();
                    System.out.println("\nEnter product ID: ");
                    accessories.setID(sc.nextInt());

                    System.out.println("\nEnter product name: ");
                    accessories.setName(sc.next());
                    sc.nextLine();

                    System.out.println("\nEnter product price: ");
                    accessories.setPrice(sc.nextInt());

                    System.out.println("\nEnter product brand: ");
                    accessories.setBrand(sc.next());
                    sc.nextLine();

                    System.out.println("\nEnter product color: ");
                    accessories.setColor(sc.next());
                    sc.nextLine();

                    System.out.println("\nEnter product quantity in stock: ");
                    accessories.setQuantity_in_stock(sc.nextInt());

                    accessories.writeToFile(accessories, "Inventory.txt");
                    return accessories;

                case 4:
                    Electronics electronics = new Electronics();
                    System.out.println("\nEnter product ID: ");
                    electronics.setID(sc.nextInt());

                    System.out.println("\nEnter product name: ");
                    electronics.setName(sc.next());
                    sc.nextLine();

                    System.out.println("\nEnter product price: ");
                    electronics.setPrice(sc.nextInt());

                    System.out.println("\nEnter product brand: ");
                    electronics.setBrand(sc.next());
                    sc.nextLine();

                    System.out.println("\nEnter product model: ");
                    electronics.setModel(sc.next());
                    sc.nextLine();

                    System.out.println("\nEnter product quantity in stock: ");
                    electronics.setQuantity_in_stock(sc.nextInt());

                    electronics.writeToFile(electronics, "Inventory.txt");
                    return electronics;

                default:
                    System.err.println("\nEnter valid choice");
            }
        }
    }
}
