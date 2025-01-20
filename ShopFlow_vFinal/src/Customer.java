import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Customer {

    // Attributes
    private static int id_counter = 0;
    private final int ID;
    private ArrayList<Product> cart = new ArrayList<Product>();
    private double bill = 0;
    // Attributes
    private String username = "null";
    private String password = "NULL";
    private ArrayList<Product> wish_list = new ArrayList<Product>();
    private ArrayList<Order> orders = new ArrayList<Order>();

    // Constructors
    public Customer() {
        id_counter++;
        this.ID = id_counter;
    }

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;

        id_counter++;
        this.ID = id_counter;

    }

    // Setters and Getters

    public ArrayList<Product> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Product> cart) {
        this.cart = cart;
    }

    public ArrayList<Product> getWish_list() {
        return wish_list;
    }

    public void setWish_list(ArrayList<Product> wish_list) {
        this.wish_list = wish_list;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public void viewWish_list() {
        for (int i = 0; i < wish_list.size(); i++) {
            wish_list.get(i).display();
        }
    }

    public void addToWish_list(Product wish) {
        this.wish_list.add(wish);
    }

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getID() {
        return ID;
    }

    public ArrayList addToCart(Product product) {
        cart.add(product);
        product.writeToFile(product, "Sales.txt");

        return cart;
    }

    public Order createOrder() {
        Order order = new Order();
        return order;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    class Order {
        static int orderIDCount = 0;
        int orderID;


        public Order() {
            this.orderID = ++orderIDCount;
        }

        public boolean PlaceOrder() {
            Scanner sc = new Scanner(System.in);

            bill = 0;
            for (int i = 0; i < cart.size(); i++) {
                cart.get(i).display();


                //Admin.getCatalog().get(i).setQuantityToBeSold(Admin.getCatalog().get(i).getQuantity_in_stock()-Admin.getCatalog().get(i).getQuantity_sold());
                if (Admin.getCatalog().get(i).getQuantityToBeSold() <= Admin.getCatalog().get(i).getQuantity_in_stock()) {
                    bill += cart.get(i).getPrice() * cart.get(i).getQuantityToBeSold();
                    System.out.println("Quantity to be sold: " + cart.get(i).getQuantity_sold());
                } else {
                    System.out.println("Quantity to be sold is not present ");
                }


            }

            System.out.println("\nTotal Bill: " + bill);
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Sales.txt", true));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Proceed to Checkout..Press y");
            String c = sc.next();

            if (c.equals("Y") || c.equals("y")) {
                int c1;
                int c2;
                System.out.println("\nChoose one of the following:\n1. Takeaway\n2. Home Delivery");
                c1 = sc.nextInt();
                if (c1 == 2) {
                    System.out.println("Choose one:\n1. Online Payment\n2. Cash on delivery");
                    c2 = sc.nextInt();
                }
                if (c1 == 2 || c1 == 1) {
                    System.out.println("\n\n\t\t\tORDER PLACED SUCCESSFULLY!");
                    System.out.println("                         \n" +
                            "                         .*((((((((((((((((((((((((((/,                         \n" +
                            "                    ./(((((((((((((((((((((((((((((((((((((,                    \n" +
                            "                 *((((((((((((((((((((((((((((((((((((((((((((/.                \n" +
                            "              *((((((((((((((((((((((((((((((((((((((((((((((((((/              \n" +
                            "            /(((((((((((((((((((((((((((((((((((((((((((((((((((((((,           \n" +
                            "          /((((((((((((((((((((((((((((((((((((((((((((((,/(((((((((((,         \n" +
                            "        *(((((((((((((((((((((((((((((((((((((((((((((/     ,(((((((((((        \n" +
                            "       (((((((((((((((((((((((((((((((((((((((((((((,         .((((((((((*      \n" +
                            "     .((((((((((((((((((((((((((((((((((((((((((((               *((((((((/     \n" +
                            "    .((((((((((((((((((((((((((((((((((((((((((/                 *(((((((((*    \n" +
                            "    /((((((((((((((((((((((((((((((((((((((((.                .(((((((((((((,   \n" +
                            "   *((((((((((((((((((((((((((((((((((((((/                 *(((((((((((((((/   \n" +
                            "   (((((((((((((((((((/(((((((((((((((((,                .(((((((((((((((((((,  \n" +
                            "  .(((((((((((((((((,    ((((((((((((/                 ,(((((((((((((((((((((/  \n" +
                            "  .((((((((((((((/         *(((((((*                 /((((((((((((((((((((((((  \n" +
                            "  .((((((((((((*             .((/.                ,((((((((((((((((((((((((((*  \n" +
                            "   (((((((((((*                                 *((((((((((((((((((((((((((((.  \n" +
                            "   ,(((((((((((((.                           .((((((((((((((((((((((((((((((/   \n" +
                            "    /((((((((((((((*                       *((((((((((((((((((((((((((((((((.   \n" +
                            "     ((((((((((((((((/                   ((((((((((((((((((((((((((((((((((,    \n" +
                            "      ((((((((((((((((((,             ,(((((((((((((((((((((((((((((((((((,     \n" +
                            "       /((((((((((((((((((/         (((((((((((((((((((((((((((((((((((((.      \n" +
                            "        .((((((((((((((((((((.   .(((((((((((((((((((((((((((((((((((((/        \n" +
                            "          ,(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((          \n" +
                            "            ,((((((((((((((((((((((((((((((((((((((((((((((((((((((/            \n" +
                            "               /(((((((((((((((((((((((((((((((((((((((((((((((((,              \n" +
                            "                  *(((((((((((((((((((((((((((((((((((((((((((.                 \n" +
                            "                     ./(((((((((((((((((((((((((((((((((((,                     \n" +
                            "                           ,/(((((((((((((((((((((((*. ");
                    cart.clear();
                    return true;


                } else {
                    System.err.println("\nInvalid input!");
                }
            }

            return false;

        }


    }

}
