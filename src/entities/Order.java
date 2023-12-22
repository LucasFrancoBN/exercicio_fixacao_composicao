package entities;

import entities.enums.OrderStatus;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Order {
  private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").withZone(ZoneId.systemDefault());
  private OrderStatus orderStatus;
  private List<OrderItem> orderItemList;
  private Client client;
  private Instant createdAt;

  public Order() {}

  public Order(OrderStatus orderStatus, List<OrderItem> orderItemList, Client client) {
    this.orderStatus = orderStatus;
    this.orderItemList = orderItemList;
    this.client = client;
    createdAt = Instant.now();
  }

  public void addItem(OrderItem item) {
    orderItemList.add(item);
  }

  public Double total() {
    double total = 0.00;
    for (OrderItem orderItem : orderItemList) {
      total += orderItem.subTotal();
    }
    return total;
  }

  public void removeItem(OrderItem item) {
    orderItemList.remove(item);
  }

  public OrderStatus getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(OrderStatus orderStatus) {
    this.orderStatus = orderStatus;
  }

  public List<OrderItem> getOrderItemList() {
    return orderItemList;
  }

  public void setOrderItemList(List<OrderItem> orderItemList) {
    this.orderItemList = orderItemList;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public static DateTimeFormatter getFmt() {
    return fmt;
  }

  public static void setFmt(DateTimeFormatter fmt) {
    Order.fmt = fmt;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("ORDER SUMMARY: \n");
    sb.append("Order moment: ").append(fmt.format(createdAt)).append("\n");
    sb.append("Order Status").append(orderStatus).append("\n");
    sb.append("Client: ").append(client.toString()).append("\n");
    sb.append("Order items: \n");
    for (OrderItem orderItem: orderItemList) {
      sb.append(orderItem.toString()).append("\n");
    }
    sb.append("Total price: $").append(total());
    return sb.toString();
  }
}
