import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Customer custom = new Customer("null", "null");

        try {
            File file = new File("Inventory.txt");
            if (!(file.exists())) {
                file.createNewFile();
            }

            BufferedReader bufferedReader = new BufferedReader(new FileReader("Inventory.txt"));
            Scanner scanner = new Scanner(new File("Inventory.txt"));
            String csv;
            while (scanner.hasNextLine()) {

                csv = scanner.nextLine();
                String[] tokens = csv.split(",");
                int ID = Integer.parseInt(tokens[0]);
                String category = tokens[1];
                String name = tokens[2];
                double price = Double.parseDouble(tokens[3]);
                int quantity_in_stock = Integer.parseInt(tokens[4]);
                int quantity_sold = Integer.parseInt(tokens[5]);


                if (category.equals("MedicalCare")) {
                    String brand = tokens[6];
                    String dosage = tokens[7];
                    MedicalCare product = new MedicalCare(ID, name, price, brand, dosage, quantity_in_stock);
                    Admin.addOnlyToCatalog(product);bufferedReader.close();
                } else if (category.equals("Clothes")) {
                    String brand = tokens[6];
                    String size = tokens[7];
                    Clothes product = new Clothes(ID, name, price, brand, size, quantity_in_stock);
                    Admin.addOnlyToCatalog(product);bufferedReader.close();
                } else if (category.equals("Electronics")) {
                    String brand = tokens[6];
                    String model = tokens[7];
                    Electronics product = new Electronics(ID, name, price, brand, model, quantity_in_stock);
                    Admin.addOnlyToCatalog(product);
                    bufferedReader.close();
                } else if (category.equals("Accessories")) {
                    String brand = tokens[6];
                    String color = tokens[7];
                    Accessories product = new Accessories(ID, name, price, brand, color, quantity_in_stock);
                    Admin.addOnlyToCatalog(product);
                    bufferedReader.close();
                }


            }


        } catch (Exception e) {}

        Scanner sc = new Scanner(System.in);
        ArrayList<Customer> customers = new ArrayList<>();

        String sub_choice;
        Boolean T = true;


        b:
        while (T) {

            System.out.println("\n\n" +
                    "ooooooooo.   oooooooooooo   .oooooo.    ooooo  .oooooo..o ooooooooooooo ooooooooo.         .o.       ooooooooooooo ooooo   .oooooo.   ooooo      ooo \n" +
                    "888   `Y88. `888'     `8  d8P'  `Y8b   `888' d8P'    `Y8 8'   888   `8 `888   `Y88.      .888.      8'   888   `8 `888'  d8P'  `Y8b  `888b.     `8' \n" +
                    "888   .d88'  888         888            888  Y88bo.           888       888   .d88'     .8\"888.          888       888  888      888  8 `88b.    8  \n" +
                    "888ooo88P'   888oooo8    888            888   `\"Y8888o.       888       888ooo88P'     .8' `888.         888       888  888      888  8   `88b.  8  \n" +
                    "888`88b.     888    \"    888     ooooo  888       `\"Y88b      888       888`88b.      .88ooo8888.        888       888  888      888  8     `88b.8  \n" +
                    "888  `88b.   888       o `88.    .88'   888  oo     .d8P       888       888  `88b.   .8'     `888.       888       888  `88b    d88'  8       `888  \n" +
                    "o888o  o888o o888ooooood8  `Y8bood8P'   o888o 8\"\"88888P'      o888o     o888o  o888o o88o     o8888o     o888o     o888o  `Y8bood8P'  o8o        `8  \n" +
                    "                                                                                                                                                     \n" +
                    "                                                                                                                                                     \n" +
                    "                                                                                                                                                     ");
            System.out.print("\nEnter appropriate choice:\n1. Admin.\n2. Customer.\n0. Exit.\n");

            int choice = 0;
            try {
                String choice_s = sc.nextLine();
                if (choice_s == null || choice_s.isEmpty()) {
                    throw new NullPointerException("Input is null or empty ");
                }
                choice = Integer.parseInt(choice_s);

                switch (choice) {
                    case 1:
                        Admin admin = new Admin();
                        admin = Admin.login();
                        if (admin == null) {
                            break;
                        }
                        int choice_2 = 1;
                        while (choice_2 != 0) {
                            System.out.println("\nEnter choice:\n1. Add item\n0. Return");
                            String choice2_s = sc.nextLine();

                            try {
                                if (choice2_s == null || choice2_s.isEmpty()) {
                                    throw new NullPointerException("Input is null or empty ");
                                }
                                choice_2 = Integer.parseInt(choice2_s);


                                switch (choice_2) {
                                    case 1:
                                        Admin.getCatalog().add(admin.addItem());
                                        break;
                                    case 0:
                                        break;
                                    default:
                                        System.out.println("\nInvalid choice!");
                                }
                            } catch (NullPointerException e) {
                                System.err.println(e.getMessage());
                            } catch (NumberFormatException e) {
                                System.err.println("Input does not represent a valid integer ");
                            }
                        }
                        break;
                    case 2:

                        c:
                        while (true) {
                            System.out.print("\n1. Login.\n2. Sign up.\n0. Return.\n");

                            sub_choice = sc.nextLine();
                            int sub_choice1 = 0;
                            try {
                                if (sub_choice == null || sub_choice.isEmpty()) {
                                    throw new NullPointerException("Input is null or empty ");
                                }
                                sub_choice1 = Integer.parseInt(sub_choice);

                            } catch (NullPointerException e) {
                                System.err.println(e.getMessage());
                            } catch (NumberFormatException e) {
                                System.err.println("Input does not represent a valid integer ");
                            }
                            switch (sub_choice1) {
                                case 1:
                                    Customer customer = login(customers);
                                    if (customer == null) {
                                        break;
                                    }
                                    program(customer);
                                    break;
                                case 2:
                                    signUp(customers);
                                    break;
                                case 0:
                                    break c;
                                default:
                                    System.err.print("\nInvalid! Enter correct choice!");
                            }
                        }
                        break;

                    case 0:
                        break b;

                    default:
                        System.out.print("\nInvalid! Enter correct choice!");
                }

            } catch (NullPointerException e) {
                System.err.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.err.println("Input does not represent a valid integer ");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

        }
    }


    public static Customer login(ArrayList<Customer> customers) {

        Scanner sc = new Scanner(System.in);
        Boolean T = false;
        while (true) {
            File f = new File("Customer");
            System.out.print("\nEnter your username: ");
            String username = sc.next();

            System.out.print("\nEnter your password: ");
            String password = sc.next();


            for (int i = 0; i < customers.size(); i++) {
                if (customers.get(i).getUsername().equals(username) && customers.get(i).getPassword().equals(password)) {
                    System.out.print("\nLogin Successful!");
                    T = true;
                    return customers.get(i);

                } else {
                    T = false;
                }

            }

            try {
                BufferedReader br = new BufferedReader(new FileReader("Customer.txt"));
                String csv;

                Scanner scanner = new Scanner(new File("Customer.txt"));
                while (scanner.hasNextLine()) {
                    String username1;
                    String password1;

                    csv = scanner.nextLine();
                    String[] tokens = csv.split(",");
                    username1 = tokens[0];
                    password1 = tokens[1];

                    if (username1.equals(username) && password1.equals(password)) {
                        System.out.print("\nLogin Successful!");
                        T = true;
                        Customer customer_2 = new Customer(username1, password1);
                        br.close();

                        return customer_2
                                ;

                    } else {
                        T = false;
                    }
                }


            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


            if (!T) {
                System.err.print("\nIncorrect username or password!");
                System.out.println("\n\nWould you like to return... Press y");
                String z = sc.next();
                if (z.equals("Y") || z.equals("y")) {
                    break;
                }
            } else {
                break;
            }
        }
        return null;
    }


    public static void signUp(ArrayList<Customer> customers) {
        Scanner sc = new Scanner(System.in);
        Boolean T = true;

        try {
            System.out.print("\nEnter your username: ");
            String name = sc.nextLine();

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Customer.txt", true));


            String password = null;
            String password_2 = null;
            while (T) {
                System.out.print("\nSet a password: ");
                password = sc.next();

                if (password.length() >= 8) {
                    break;
                } else {
                    System.err.println("\nPassword must be 8 characters long!");
                }
            }


            while (T) {
                System.out.print("\nRetype password: ");
                password_2 = sc.next();
                if (password.equals(password_2)) {
                    Customer customer = new Customer(name, password);
                    customers.add(customer);
                    System.out.print("\nSignup Successful!");
                    break;
                } else {
                    System.err.print("\nPasswords do not match!");
                }
            }
            bufferedWriter.append(name + "," + password + System.lineSeparator());
            bufferedWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void program(Customer customer) {


        Scanner sc = new Scanner(System.in);
        d:
        while (true) {

            System.out.print("\n\n\n\n\n\n   _____ _                 ______ _                       _____          _       __ _       _                _____ _                       _             \n" +
                    "  / ____| |               |  ____| |                _    |  __ \\        | |     / _(_)     (_)              / ____| |                     (_)            \n" +
                    " | (___ | |__   ___  _ __ | |__  | | _____      __ (_)   | |__) |___  __| | ___| |_ _ _ __  _ _ __   __ _  | (___ | |__   ___  _ __  _ __  _ _ __   __ _ \n" +
                    "  \\___ \\| '_ \\ / _ \\| '_ \\|  __| | |/ _ \\ \\ /\\ / /       |  _  // _ \\/ _` |/ _ \\  _| | '_ \\| | '_ \\ / _` |  \\___ \\| '_ \\ / _ \\| '_ \\| '_ \\| | '_ \\ / _` |\n" +
                    "  ____) | | | | (_) | |_) | |    | | (_) \\ V  V /   _    | | \\ \\  __/ (_| |  __/ | | | | | | | | | | (_| |  ____) | | | | (_) | |_) | |_) | | | | | (_| |\n" +
                    " |_____/|_| |_|\\___/| .__/|_|    |_|\\___/ \\_/\\_/   (_)   |_|  \\_\\___|\\__,_|\\___|_| |_|_| |_|_|_| |_|\\__, | |_____/|_| |_|\\___/| .__/| .__/|_|_| |_|\\__, |\n" +
                    "                    | |                                                                              __/ |                    | |   | |             __/ |\n" +
                    "                    |_|                                                                             |___/                     |_|   |_|            |___/ ");
            System.out.println("\n\n\n");
            System.out.println("1. Product Catalog.");
            System.out.println("2. Cart.");
            System.out.println("3. Wishlist.");
            System.out.println("0. Return.");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    for (int i = 0; i < Admin.getCatalog().size(); i++) {
                        Admin.getCatalog().get(i).display();
                    }
                    int c = 0;
                    while (true) {
                        System.out.print("\nEnter ID of the product you wish to buy: ");
                        String c1 = sc.next();


                        try {

                            if (c1 == null || c1.isEmpty()) {
                                throw new NullPointerException("Input is Empty! ");
                            }
                            c = Integer.parseInt(c1);

                        } catch (NullPointerException e) {
                            System.err.println(e.getMessage());
                        } catch (NumberFormatException e) {
                            System.err.println("Input does not represent a valid integer! ");
                        }
                        if (c != 0) {
                            break;
                        }
                    }

                    System.out.println("\n1. Add to cart\n2. Add to Wishlist");
                    int choice_3 = sc.nextInt();

                    Boolean flag = false;

                    if (choice_3 == 2) {
                        for (int i = 0; i < Admin.getCatalog().size(); i++) {
                            if (Admin.getCatalog().get(i).getID() == c) {
                                customer.addToWish_list(Admin.getCatalog().get(i));
                                break;
                            }
                        }
                        System.out.println("Added to wishlist!");

                        flag = true;
                    } else if (choice_3 == 1) {

                        System.out.println("\nEnter quantity");
                        int quantity = sc.nextInt();

                        for (int i = 0; i < Admin.getCatalog().size(); i++) {

                            if (Admin.getCatalog().get(i).getID() == c) {

                                Admin.getCatalog().get(i).setQuantity_in_stock(Admin.getCatalog().get(i).getQuantity_in_stock()-Admin.getCatalog().get(i).getQuantity_sold());

                                Admin.getCatalog().get(i).setQuantityToBeSold(quantity);

                                if ((Admin.getCatalog().get(i).getQuantity_in_stock() >= quantity) ) {
                                    if (Admin.getCatalog().get(i).getCategory().equals("Clothes")) {

                                        Clothes cloth = (Clothes) Admin.getCatalog().get(i);

                                        System.out.println("\nEnter size: ");
                                        cloth.setSize(sc.next());

                                    }
                                    System.out.println("\nItem added to cart!");
                                    customer.addToCart(Admin.getCatalog().get(i));

                                    Admin.getCatalog().get(i).setQuantity_sold(quantity);

                                    //Admin.getCatalog().get(i).setQuantity_in_stock(Admin.getCatalog().get(i).getQuantity_in_stock()-Admin.getCatalog().get(i).getQuantity_sold());

                                    flag = true;
                                    System.out.println("Enter any key to continue...");
                                    sc.next();
                                    break;
                                } else {
                                    System.err.println("Product in Stock: " + Admin.getCatalog().get(i).getQuantity_in_stock());
                                }

                            }

                        }
                    } else if (!flag) {
                        System.err.println("\nInvalid ID! Product does not exist!");
                    }


                    break;

                case 2:

                    customer.addOrder(customer.createOrder());
                    for (int i = 0; i < customer.getOrders().size(); i++) {
                        Boolean bool = customer.getOrders().get(i).PlaceOrder();
                        if(!bool){
                            break;
                        }
                    }

                    break;

                case 3:
                    customer.viewWish_list();
                    System.out.println("\nPress any key to continue...");
                    sc.next();
                    break;

                case 0:
                    break d;

                default:
                    System.err.println("\nInvalid! Enter correct choice!");
            }


        }
    }
}
