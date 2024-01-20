/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package icecreamshop;

import java.util.*;

// Enums
enum OrderStatus {
    PLACED, IN_PREPARATION, OUT_FOR_DELIVERY, DELIVERED
}

enum PaymentMethod {
    CREDIT_CARD, DIGITAL_WALLET
}

// Products
class Flavor {
    private String name;
    private double cost;

    public Flavor(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}

class Topping {
    private String name;
    private double cost;

    public Topping(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}

class Syrup {
    private String name;
    private double cost;

    public Syrup(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}

// Order Components
class OrderItem {
    private Flavor flavor;
    private List<Topping> toppings;
    private List<Syrup> syrups;

    public double getCost() {
        // calculate cost based on selected items
        return 0.0;
    }

    public Flavor getFlavor() {
        return flavor;
    }

    public void setFlavor(Flavor flavor) {
        this.flavor = flavor;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    public List<Syrup> getSyrups() {
        return syrups;
    }

    public void setSyrups(List<Syrup> syrups) {
        this.syrups = syrups;
    }

}

// Behavioral Patterns
// Builder Pattern
class IceCreamBuilder {
    private final OrderItem orderItem;

    public IceCreamBuilder() {
        this.orderItem = new OrderItem();
    }

    public IceCreamBuilder addFlavor(Flavor flavor) {
        orderItem.setFlavor(flavor);
        return this;
    }

    public IceCreamBuilder addToppings(List<Topping> toppings) {
        orderItem.setToppings(toppings);
        return this;
    }

    public IceCreamBuilder addSyrups(List<Syrup> syrups) {
        orderItem.setSyrups(syrups);
        return this;
    }

    public OrderItem build() {
        return orderItem;
    }
}

// Observer Pattern
interface OrderObserver {
    void update(OrderStatus status);
}

class RealTimeOrderTracker implements OrderObserver {
    // update method implementation
    @Override
    public void update(OrderStatus status) {
        System.out.println("Order status updated: " + status);
    }
}

// Strategy Pattern
interface PaymentStrategy {
    void processPayment(double amount, PaymentMethod method);
}

class CreditCardPaymentStrategy implements PaymentStrategy {
    // processPayment implementation for credit card
    @Override
    public void processPayment(double amount, PaymentMethod method) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}

class DigitalWalletPaymentStrategy implements PaymentStrategy {
    // processPayment implementation for digital wallet
    @Override
    public void processPayment(double amount, PaymentMethod method) {
        System.out.println("Processing digital wallet payment of $" + amount);
    }
}

// Chain of Responsibility Pattern
abstract class OrderHandler {
    protected OrderHandler nextHandler;

    public void setNextHandler(OrderHandler handler) {
        this.nextHandler = handler;
    }

    public abstract void handleRequest(OrderItem orderItem);
}

class FlavorHandler extends OrderHandler {
    // handleRequest implementation for flavor customization
    @Override
    public void handleRequest(OrderItem orderItem) {
        System.out.println("Handling flavor customization");
        // Handle flavor customization logic
    }
}

class ToppingHandler extends OrderHandler {
    // handleRequest implementation for topping customization
    @Override
    public void handleRequest(OrderItem orderItem) {
        System.out.println("Handling topping customization");
        // Handle topping customization logic
    }
}

class SyrupHandler extends OrderHandler {
    // handleRequest implementation for syrup customization
    @Override
    public void handleRequest(OrderItem orderItem) {
        System.out.println("Handling syrup customization");
        // Handle syrup customization logic
    }
}

// State Pattern
interface OrderState {
    void handle(Order order);
}

class PlacedOrderState implements OrderState {
    // handle method for placed order state
    @Override
    public void handle(Order order) {
        System.out.println("Order is placed");
    }
}

class PreparationOrderState implements OrderState {
    // handle method for order in preparation state
    @Override
    public void handle(Order order) {
        System.out.println("Order is in preparation");
    }
}

class OutForDeliveryOrderState implements OrderState {
    // handle method for order out for delivery state
    @Override
    public void handle(Order order) {
        System.out.println("Order is out for delivery");
    }
}

class DeliveredOrderState implements OrderState {
    // handle method for delivered order state
    @Override
    public void handle(Order order) {
        System.out.println("Order is delivered");
    }
}

// Command Pattern
interface OrderCommand {
    void execute();
}

class PlaceOrderCommand implements OrderCommand {
    // execute method for placing an order
    @Override
    public void execute() {
        System.out.println("Placing an order");
    }
}

class ProvideFeedbackCommand implements OrderCommand {
    // execute method for providing feedback
    @Override
    public void execute() {
        System.out.println("Providing feedback");
    }
}

// Decorator Pattern
abstract class OrderDecorator extends OrderItem {
    protected OrderItem decoratedOrderItem;

    public OrderDecorator(OrderItem decoratedOrderItem) {
        this.decoratedOrderItem = decoratedOrderItem;
    }
}

class GiftWrappingDecorator extends OrderDecorator {
    // additional features for gift wrapping
    public GiftWrappingDecorator(OrderItem decoratedOrderItem) {
        super(decoratedOrderItem);
    }
}

class SpecialPackagingDecorator extends OrderDecorator {
    // additional features for special packaging
    public SpecialPackagingDecorator(OrderItem decoratedOrderItem) {
        super(decoratedOrderItem);
    }
}

// Main Classes
class Order {
    private String orderId;
    private Customer customer;
    private List<OrderItem> items;
    private OrderStatus status;
    private OrderState currentState;

    public Order(String orderId, Customer customer, List<OrderItem> items) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = items;
        this.status = OrderStatus.PLACED;
        this.currentState = new PlacedOrderState();
    }

    // getters and setters

    public void setState(OrderState state) {
        this.setCurrentState(state);
        getCurrentState().handle(this);
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public OrderState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(OrderState currentState) {
        this.currentState = currentState;
    }

    public void process() {
        // perform common order processing tasks
        getCurrentState().handle(this);
    }

    void addObserver(RealTimeOrderTracker orderTracker) {
    orderTracker.update(status);
    }

    void setStatus(OrderStatus orderStatus) {
        status = orderStatus;
    }
}

class Customer {
    private String name;
    private String email;
    private List<Order> favorites;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.favorites = new ArrayList<>();
    }

    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Order> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Order> favorites) {
        this.favorites = favorites;
    }
}

class Payment {
    private double amount;
    private PaymentMethod paymentMethod;

    public Payment(double amount, PaymentMethod paymentMethod) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    // getters and setters

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}

class LoyaltyProgram {
    private int points;

    public void earnPoints(double amount) {
        // logic to calculate points based on the purchase amount
    }
}

// System Facade
class IceCreamOrderingSystem {
    private Menu menu;
    private OrderProcessor orderProcessor;
    private UserDatabase userDatabase;
    private PaymentProcessor paymentProcessor;

    public IceCreamOrderingSystem() {
        // initialize components
    }

    // other functionalities
}

// Menu Class
class Menu {
    // Implementation of the Menu class, containing flavors, toppings, syrups, and their respective methods
}

// OrderProcessor Class
class OrderProcessor {
    // Implementation of the OrderProcessor class, handling order processing logic
}

// UserDatabase Class
class UserDatabase {
    // Implementation of the UserDatabase class, managing user profiles
}

// PaymentProcessor Class
class PaymentProcessor {
    // Implementation of the PaymentProcessor class, handling payment processing logic
}

public class IceCreamShop {
    public static void main(String[] args) {
        // Example usage of the Ice Cream Shop Food Ordering System
        IceCreamOrderingSystem iceCreamShop = new IceCreamOrderingSystem();

        // Sample data for demonstration purposes
        Flavor chocolateFlavor = new Flavor("Chocolate", 2.50);
        Topping nutsTopping = new Topping("Nuts", 1.00);
        Syrup caramelSyrup = new Syrup("Caramel", 0.75);

        List<Topping> toppings = new ArrayList<>();
        toppings.add(nutsTopping);

        List<Syrup> syrups = new ArrayList<>();
        syrups.add(caramelSyrup);

        IceCreamBuilder iceCreamBuilder = new IceCreamBuilder();
        OrderItem customIceCream = iceCreamBuilder
                .addFlavor(chocolateFlavor)
                .addToppings(toppings)
                .addSyrups(syrups)
                .build();

        Customer customer = new Customer("John Doe", "john@example.com");
        List<OrderItem> orderItems = new ArrayList();
        orderItems.add(customIceCream);
        Order order = new Order("12345", customer, orderItems);

        // Place an order
        OrderCommand placeOrderCommand = new PlaceOrderCommand();
        placeOrderCommand.execute();

        // Provide feedback
        OrderCommand provideFeedbackCommand = new ProvideFeedbackCommand();
        provideFeedbackCommand.execute();

        // Process payment
        Payment payment = new Payment(5.25, PaymentMethod.CREDIT_CARD);
        PaymentStrategy paymentStrategy = new CreditCardPaymentStrategy();
        paymentStrategy.processPayment(payment.getAmount(), payment.getPaymentMethod());

        // Update order status
        RealTimeOrderTracker orderTracker = new RealTimeOrderTracker();
       order.setStatus(OrderStatus.OUT_FOR_DELIVERY);
       order.addObserver(orderTracker);
        

        // Apply decorator (gift wrapping)
        OrderDecorator giftWrappedIceCream = new GiftWrappingDecorator(customIceCream);
    }
}

