import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class Product {
    // properties
    private String id;
    private String pname;
    private int qty;
    private double price;
    private double totalPrice;

    // constructor
    Product(String id, String pname, int qty, double price, double totalPrice) {
        this.id = id;
        this.pname = pname;
        this.qty = qty;
        this.price = price;
        this.totalPrice = totalPrice;
    }

    // getter methods
    public String getId() {
        return id;
    }

    public String getPname() {
        return pname;
    }

    public int getQty() {
        return qty;
    }

    public double getPrice() {
        return price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    // display format
    public static void displayFormat() {
        System.out.format("-------------------------------------------------------------------------------------------------------------------\n");
        System.out.print("Product ID \t\tName\t\tQuantity\t\tRate \t\t\tTotal Price\n");
        System.out.format("-------------------------------------------------------------------------------------------------------------------\n");
    }

    // display product details
    public void display() {
        System.out.format("   %-9s             %-9s      %5d               %9.2f                       %14.2f\n", id, pname, qty, price, totalPrice);
    }
}
public class ShoppingBill {
    public static void main(String args[]) {
        // variables
        String id;
        String productName;
        int quantity;
        double price;
        double totalPrice;
        double overAllPrice = 0.0;
        double cgst, sgst, subtotal = 0.0, discount = 0.0;
        char choice;

        System.out.println("\t\t\t\t--------------------Invoice-----------------");
        System.out.println("\t\t\t\t\tMVJ Mart");
        System.out.println("\t\t\t\t\tChannasandra");
        System.out.println("\t\t\t\t\tMVJ");
        System.out.println("GSTIN: 02xxxxxxxxxxxxx\t\t\t\t\t\t\tContact: (+91) XXXXXXXXXX");

        // format of date and time
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        String[] days = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        // print current date and time
        System.out.println("Date: " + formatter.format(date) + "  " + days[calendar.get(Calendar.DAY_OF_WEEK) - 1] + "\t\t\t\t\t(+91) XXXXXXXXXX");
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Customer Name: ");
        String customerName = scan.nextLine();

        // creating an ArrayList to store the product
        List<Product> product = new ArrayList<>();

        do {
            // read input values
            System.out.println("Enter the product details: ");
            System.out.print("Product ID: ");
            id = scan.nextLine();
            System.out.print("Product Name: ");
            productName = scan.nextLine();
            System.out.print("Quantity: ");
            quantity = scan.nextInt();
            System.out.print("Price (per unit): ");
            price = scan.nextDouble();

            // calculate total price for a particular product
            totalPrice = price * quantity;

            // calculate overall price
            overAllPrice += totalPrice;

            // create Product class object and add it to the list
            product.add(new Product(id, productName, quantity, price, totalPrice));

            // ask for continue shopping
            System.out.print("Want to add more items? (y or n): ");
            choice = scan.next().charAt(0);

            // read remaining characters, don't store
            scan.nextLine();
        } while (choice == 'y' || choice == 'Y');

        // display all products with their properties
        Product.displayFormat();
        for (Product p : product) {
            p.display();
        }

        // price calculation
        System.out.println("\n\t\t\t\t\t\t\t\t\t\tTotal Amount (Rs.) " + overAllPrice);

        // calculating discount
        discount = overAllPrice * 2 / 100;
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t    Discount (Rs.) " + discount);

        // total amount after discount
        subtotal = overAllPrice - discount;
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t          Subtotal " + subtotal);

        // calculating amount to be paid by buyer
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t     Invoice Total " + subtotal);

        System.out.println("\t\t\t\t----------------Thank You for Shopping!!-----------------");
        System.out.println("\t\t\t\t                     Visit Again");

        // close Scanner
        scan.close();
    }
}

