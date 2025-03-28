package com.ecommerce.dao;

import com.ecommerce.entity.OrderItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.ecommerce.util.HibernateUtil;

import java.util.List;

public class OrderItemDAO {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public void saveOrderItem(OrderItem orderItem) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(orderItem);
        session.getTransaction().commit();
    }

    public List<OrderItem> getAllOrderItems() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<OrderItem> orderItems = session.createQuery("from OrderItem", OrderItem.class).getResultList();
        session.getTransaction().commit();
        return orderItems;
    }
}
