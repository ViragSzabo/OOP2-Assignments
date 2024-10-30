package ExamPreparation.Implementation.CafeManagement;

import ExamPreparation.Implementation.CafeManagement.Menu.*;
import ExamPreparation.Implementation.CafeManagement.People.Chef;
import ExamPreparation.Implementation.CafeManagement.People.Customer;
import ExamPreparation.Implementation.CafeManagement.People.Staff;
import ExamPreparation.Implementation.CafeManagement.People.Waiter;
import ExamPreparation.Implementation.CafeManagement.System.Order;
import ExamPreparation.Implementation.CafeManagement.System.Table;
import junit.framework.TestCase;

import java.util.Collections;
import java.util.List;

public class CafeTest extends TestCase {
    private Cafe cafe;
    private Staff waiter1;
    private Staff waiter2;
    private Staff chef;
    private Customer customer;
    private Food foodItem;
    private Drink drinkItem;
    private Order orderItem;
    private PaymentMethod methodItem;
    private List<Food> foods;
    private List<Drink> drinks;
    private Table table;

    @Override
    protected void setUp() {
        cafe = new Cafe();
        customer = new Customer("Alice");
        foodItem = new Food("Sandwich", 5.00, 10);
        drinkItem = new Drink("Coffee", 2.50, 5);
        foods = Collections.singletonList(foodItem);
        drinks = Collections.singletonList(drinkItem);
        table = new Table(2);
        cafe.addFood(foodItem);
        cafe.addDrink(drinkItem);
        cafe.addStaffMember(waiter1);
        cafe.addStaffMember(waiter2);
        cafe.addStaffMember(chef);
        cafe.addTable(table);
        orderItem = cafe.placeOrder(customer, foods, drinks, table);
        waiter1 = new Waiter("John");
        waiter2 = new Waiter("Jim");
        chef = new Chef("Jane");
    }

    public void testPlaceOrder() {
        assertEquals(1, cafe.getOrders().size());
        assertEquals(1, cafe.getMeals().size());
        assertEquals(1, cafe.getDrinks().size());

        double expectedTotal = foodItem.getPrice() + drinkItem.getPrice();
        assertEquals(expectedTotal, cafe.getOrders().get(0).getTotalPrice(), 0.001);
        assertTrue(orderItem.getTable().isOccupied());
    }

    public void testProcessPayment() {
        this.methodItem = PaymentMethod.DEBIT_CARD;
        cafe.processPayment(orderItem, methodItem);
        assertTrue(orderItem.isFulfilled());

        System.out.println(
                "Order: " + orderItem.getFoodItems().get(0).getTitle() +
                        " and " +  orderItem.getDrinkItems().get(0).getTitle()
        );
        System.out.println(
                "The total price: €" + orderItem.getTotalPrice() +
                " paid by " + orderItem.getMethod() +
                " of " + orderItem.getCustomer().getName()
        );
    }

    public void testWaiterPayment() {
        int hoursWorked1 = 8;
        int hoursWorked2 = 10;
        assertEquals(96.0, waiter1.calculatePayment(hoursWorked1));
        assertEquals(120.0, waiter2.calculatePayment(hoursWorked2));
    }

    public void testChefPayment() {
        int hoursWorked = 6;
        assertEquals(120.0, chef.calculatePayment(hoursWorked));
    }
}