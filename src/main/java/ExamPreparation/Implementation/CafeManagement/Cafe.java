package ExamPreparation.Implementation.CafeManagement;

import ExamPreparation.Implementation.CafeManagement.Menu.*;
import ExamPreparation.Implementation.CafeManagement.People.Customer;
import ExamPreparation.Implementation.CafeManagement.People.Staff;
import ExamPreparation.Implementation.CafeManagement.System.*;

import java.util.ArrayList;
import java.util.List;

public class Cafe {
    private List<Food> meals;
    private List<Drink> drinks;
    private List<Order> orders;
    private List<Table> tables;
    private List<Staff> staffMembers;
    private List<Customer> customerMembers;

    public Cafe() {
        this.meals = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.tables = new ArrayList<>();
        this.staffMembers = new ArrayList<>();
    }

    public List<Food> getMeals() {
        return meals;
    }

    public void setMeals(List<Food> meals) {
        this.meals = meals;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public List<Staff> getStaffMembers() {
        return staffMembers;
    }

    public void setStaffMembers(List<Staff> staffMembers) {
        this.staffMembers = staffMembers;
    }

    public void addFood(Food food) {
        meals.add(food);
    }

    public void removeFood(Food food) {
        meals.remove(food);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void removeDrink(Drink drink) {
        drinks.remove(drink);
    }

    public void addOrder(Order order) { orders.add(order); }

    public void removeOrder(Order order) {
        orders.remove(order);
    }

    public void addTable(Table table) {
        tables.add(table);
    }

    public void removeTable(Table table) {
        tables.remove(table);
    }

    public void addStaffMember(Staff staffMember) {
        staffMembers.add(staffMember);
    }

    public void removeStaffMember(Staff staffMember) {
        staffMembers.remove(staffMember);
    }

    public List<Customer> getCustomerMembers() { return customerMembers; }

    public void setCustomerMembers(List<Customer> customerMembers) { this.customerMembers = customerMembers; }

    public Order placeOrder(Customer customer, List<Food> foods, List<Drink> drinks, Table table) {
        for (Food food : foods) {
            if (food.getStock() <= 0) {
                throw new IllegalArgumentException("Food item " + food.getTitle() + " is out of stock.");
            }
        }

        for (Drink drink : drinks) {
            if (drink.getStock() <= 0) {
                throw new IllegalArgumentException("Drink item " + drink.getTitle() + " is out of stock.");
            }
        }

        foods.forEach(food -> food.setStock(food.getStock() - 1));
        drinks.forEach(drink -> drink.setStock(drink.getStock() - 1));

        Order order = new Order(customer, foods, drinks, table);
        orders.add(order);
        return order;
    }

    public void processPayment(Order order, PaymentMethod method) {
        order.setMethod(method);
        order.setFulfilled(true);
    }
}