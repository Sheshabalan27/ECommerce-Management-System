package com.ecommerce.main;

import com.ecommerce.dao.*;
import com.ecommerce.entity.*;

import java.util.Date;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        // Initialize DAOs
        CategoryDAO categoryDAO = new CategoryDAO();
        ProductDAO productDAO = new ProductDAO();
        CustomerDAO customerDAO = new CustomerDAO();
        OrderDAO orderDAO = new OrderDAO();
        OrderItemDAO orderItemDAO = new OrderItemDAO();

        // Insert Categories (Only if they don't exist)
        if (categoryDAO.getAllCategories().isEmpty()) {
            Category electronics = new Category("Electronics");
            Category clothing = new Category("Clothing");
            Category books = new Category("Books");
            Category homeAppliances = new Category("Home Appliances");
            Category sports = new Category("Sports");

            categoryDAO.saveCategory(electronics);
            categoryDAO.saveCategory(clothing);
            categoryDAO.saveCategory(books);
            categoryDAO.saveCategory(homeAppliances);
            categoryDAO.saveCategory(sports);
        }

        // Fetch existing categories to avoid duplication
        List<Category> categories = categoryDAO.getAllCategories();
        Category electronics = categories.stream().filter(c -> c.getName().equals("Electronics")).findFirst().orElse(null);
        Category clothing = categories.stream().filter(c -> c.getName().equals("Clothing")).findFirst().orElse(null);
        Category books = categories.stream().filter(c -> c.getName().equals("Books")).findFirst().orElse(null);
        Category homeAppliances = categories.stream().filter(c -> c.getName().equals("Home Appliances")).findFirst().orElse(null);
        Category sports = categories.stream().filter(c -> c.getName().equals("Sports")).findFirst().orElse(null);

        // Insert Products (Only if they don't exist)
        if (productDAO.getAllProducts().isEmpty()) {
            Product product1 = new Product(electronics, "Smartphone", 500.00);
            Product product2 = new Product(clothing, "T-Shirt", 20.00);
            Product product3 = new Product(books, "Java Programming", 40.00);
            Product product4 = new Product(homeAppliances, "Microwave", 150.00);
            Product product5 = new Product(sports, "Football", 30.00);

            productDAO.saveProduct(product1);
            productDAO.saveProduct(product2);
            productDAO.saveProduct(product3);
            productDAO.saveProduct(product4);
            productDAO.saveProduct(product5);
        }

        // Insert Customers (Only if they don't exist)
        if (customerDAO.getAllCustomers().isEmpty()) {
            Customer customer1 = new Customer("John Doe", "john@example.com", "9876543210", "123 Street, City");
            Customer customer2 = new Customer("Alice Smith", "alice@example.com", "9123456789", "456 Avenue, Town");

            customerDAO.saveCustomer(customer1);
            customerDAO.saveCustomer(customer2);
        }

        // Fetch Customers
        List<Customer> customers = customerDAO.getAllCustomers();
        Customer customer1 = customers.get(0);
        Customer customer2 = customers.get(1);

        // Insert Orders (Only if they don't exist)
        if (orderDAO.getAllOrders().isEmpty()) {
            Order order1 = new Order(customer1, 520.00, new Date());
            Order order2 = new Order(customer2, 70.00, new Date());

            orderDAO.saveOrder(order1);
            orderDAO.saveOrder(order2);

            // Fetch Products
            List<Product> products = productDAO.getAllProducts();
            Product p1 = products.get(0);
            Product p2 = products.get(1);
            Product p3 = products.get(2);
            Product p4 = products.get(3);
            Product p5 = products.get(4);

            // Insert Order Items
            OrderItem orderItem1 = new OrderItem(order1, p1, 1, 500.00);
            OrderItem orderItem2 = new OrderItem(order1, p2, 1, 20.00);
            OrderItem orderItem3 = new OrderItem(order2, p5, 2, 60.00);
            OrderItem orderItem4 = new OrderItem(order2, p3, 1, 40.00);

            orderItemDAO.saveOrderItem(orderItem1);
            orderItemDAO.saveOrderItem(orderItem2);
            orderItemDAO.saveOrderItem(orderItem3);
            orderItemDAO.saveOrderItem(orderItem4);
        }

        System.out.println("\n✅ Data Insertion Completed Successfully!");
    }
}
