package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    Client client = createClient(sc);

    Order order = createOrder(sc, client);

    System.out.println();
    System.out.println(order);
  }

  public static Client createClient(Scanner sc) {
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    System.out.println("Enter client data:");
    System.out.print("Name: ");
    String name = sc.nextLine();
    System.out.print("Email: ");
    String email = sc.nextLine();
    System.out.print("Birth date (DD/MM/YYYY): ");
    String birthDate = sc.nextLine();
    return new Client(name, email, LocalDate.parse(birthDate, fmt));
  }

  public static Order createOrder(Scanner sc, Client client) {
    System.out.println("Enter order data: ");
    System.out.print("Status: ");
    String status = sc.nextLine();
    System.out.print("How many items to this order? ");
    int numbersOfItems = sc.nextInt();
    List<OrderItem> orderItemList = new ArrayList<>();
    addOrderItem(numbersOfItems, sc, orderItemList);
    return new Order(OrderStatus.valueOf(status), orderItemList, client);
  }

  public static Product createProduct(Scanner sc) {
    System.out.print("Product name: ");
    sc.nextLine();
    String name = sc.nextLine();
    System.out.print("Product price: ");
    double price = sc.nextDouble();
    return new Product(name, price);
  }

  public static void addOrderItem(int numbersOfItems, Scanner sc, List<OrderItem> orderItemList) {
    for (int i = 0; i < numbersOfItems; i++) {
      System.out.printf("Enter #%d item data:%n", i + 1);
      Product product = createProduct(sc);
      System.out.print("Quantity: ");
      int quantity = sc.nextInt();
      orderItemList.add(new OrderItem(quantity, product.getPrice(), product));
    }
  }
}
