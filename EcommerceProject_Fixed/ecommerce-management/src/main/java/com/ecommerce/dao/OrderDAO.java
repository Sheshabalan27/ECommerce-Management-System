package com.ecommerce.dao;

import com.ecommerce.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.ecommerce.util.HibernateUtil;

import java.util.List;

public class OrderDAO {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public void saveOrder(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(order);
        session.getTransaction().commit();
    }

    public List<Order> getAllOrders() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Order> orders = session.createQuery("from Order", Order.class).getResultList();
        session.getTransaction().commit();
        return orders;
    }
}
