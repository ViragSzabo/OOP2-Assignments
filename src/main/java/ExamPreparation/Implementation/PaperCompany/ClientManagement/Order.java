package ExamPreparation.Implementation.PaperCompany.ClientManagement;

import ExamPreparation.Implementation.PaperCompany.PaperProductInventory.PaperProduct;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private String orderId;
    private Map<PaperProduct, Integer> products;
    private double totalAmount;
    private double discountRate; // e.g., bulk discount for large orders

    public Order(String orderId, double discountRate) {
        this.orderId = orderId;
        this.products = new HashMap<>();
        this.totalAmount = 0.0;
        this.discountRate = discountRate;
    }

    public void addProduct(PaperProduct product, int quantity) {
        products.put(product, quantity);
        this.totalAmount += product.getPricePerUnit() * quantity;
    }

    public double calculateTotalAmount() {
        return totalAmount * (1 - discountRate);
    }

    public String getOrderId() { return orderId; }
    public Map<PaperProduct, Integer> getProducts() { return products; }
}