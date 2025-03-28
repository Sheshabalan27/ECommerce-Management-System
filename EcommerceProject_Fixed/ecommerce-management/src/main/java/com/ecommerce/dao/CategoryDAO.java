package com.ecommerce.dao;

import com.ecommerce.entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.ecommerce.util.HibernateUtil;

import java.util.List;

public class CategoryDAO {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public void saveCategory(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(category);
        session.getTransaction().commit();
    }

    public List<Category> getAllCategories() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Category> categories = session.createQuery("from Category", Category.class).getResultList();
        session.getTransaction().commit();
        return categories;
    }
}
