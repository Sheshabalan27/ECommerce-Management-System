package com.ecommerce.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.ecommerce.entity.*;  // Import all your entity classes

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
            // Create SessionFactory from Hibernate configuration file
            sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                                                 .addAnnotatedClass(Category.class)
                                                 .addAnnotatedClass(Product.class)
                                                 .addAnnotatedClass(Customer.class)
                                                 .addAnnotatedClass(Order.class)
                                                 .addAnnotatedClass(OrderItem.class)
                                                 .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("SessionFactory creation failed: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
