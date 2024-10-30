package ExamPreparation.Implementation.CafeManagement.People;

public class Customer {
private String customerId;
    private String name;
    private static int customerCount = 0;

    public Customer(String name) {
        this.customerId = String.valueOf(customerCount++);
        this.name = name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getCustomerCount() {
        return customerCount;
    }

    public static void setCustomerCount(int customerCount) {
        Customer.customerCount = customerCount;
    }
}