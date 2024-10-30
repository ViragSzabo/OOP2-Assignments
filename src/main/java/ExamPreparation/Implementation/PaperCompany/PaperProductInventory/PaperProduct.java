package ExamPreparation.Implementation.PaperCompany.PaperProductInventory;

public class PaperProduct {
    private final String productId;
    private final String name;
    private final double pricePerUnit;
    private int stockQuantity;
    private final String size; // e.g., A4, Letter
    private final double weight; // e.g., 80 GSM

    public PaperProduct(String productId, String name, double pricePerUnit, int stockQuantity, String size, double weight) {
        this.productId = productId;
        this.name = name;
        this.pricePerUnit = pricePerUnit;
        this.stockQuantity = stockQuantity;
        this.size = size;
        this.weight = weight;
    }

    public void updateStock(int quantity) {
        this.stockQuantity += quantity;
    }

    public double calculateInventoryValue() {
        return this.stockQuantity * this.pricePerUnit;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public String getSize() {
        return size;
    }

    public double getWeight() {
        return weight;
    }
}