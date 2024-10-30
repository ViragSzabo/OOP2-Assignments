package ExamPreparation.Implementation.CafeManagement.System;

import ExamPreparation.Implementation.CafeManagement.Menu.*;
import ExamPreparation.Implementation.CafeManagement.PaymentMethod;
import ExamPreparation.Implementation.CafeManagement.People.Customer;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderID;
    private final Customer customer;
    private List<Food> foodItems;
    private List<Drink> drinkItems;
    private double totalPrice;
    private boolean isFulfilled;
    private PaymentMethod method;
    private Table table;
    private static int orderCount = 0;

    public Order(Customer customer, List<Food> foodItems, List<Drink> drinkItems, Table table) {
        orderID = String.valueOf(orderCount++);
        this.customer = customer;
        this.foodItems = new ArrayList<>(foodItems);
        this.drinkItems = new ArrayList<>(drinkItems);
        this.totalPrice = calculateTotalPrice();
        this.isFulfilled = false;
        this.table = table;

        if(!table.isOccupied()) {
            table.occupyTable();
        } else {
            throw new IllegalArgumentException(
                    "Table " +
                    table.getTableId() +
                    " is already occupied."
            );
        }
    }

    public void fulfillOrder() {
        setFulfilled(true);
        if (table != null) { table.releaseTable(); }
    }

    public String getOrderID() {
        return orderID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public static int getOrderCount() {
        return orderCount;
    }

    public static void setOrderCount(int orderCount) {
        Order.orderCount = orderCount;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public List<Food> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<Food> foodItems) {
        this.foodItems = foodItems;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Drink> getDrinkItems() {
        return drinkItems;
    }

    public void setDrinkItems(List<Drink> drinkItems) {
        this.drinkItems = drinkItems;
    }

    public boolean isFulfilled() {
        return isFulfilled;
    }

    public void setFulfilled(boolean fulfilled) {
        isFulfilled = fulfilled;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public void setMethod(PaymentMethod method) {
        this.method = method;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public double calculateTotalPrice() {
        totalPrice =
                foodItems.stream()
                        .mapToDouble(Food::getPrice)
                        .sum()
                + drinkItems.stream()
                        .mapToDouble(Drink::getPrice)
                        .sum();
        return totalPrice;
    }
}