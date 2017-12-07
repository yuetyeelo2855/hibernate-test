package com.sherrylo.hibernate.testing.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class BaseDao<T, K extends Serializable> {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseDao.class);

    private SessionFactory sessionFactory;

    private Class<T> type;

    @SuppressWarnings("unchecked")
    BaseDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        Type t = getClass().getGenericSuperclass();
        if (t instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) t;
            type = (Class<T>) pt.getActualTypeArguments()[0];
        }
    }

    /**
     * Getting session from transaction manager. If fail, it will open a new
     * session from session factory and raise an warning log.
     *
     * @return Current session from transaction manager if success. Otherwises,
     * return a new opened session.
     */
    Session getSession() {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
            LOGGER.trace("Getting Session from transaction manager - working correctly");
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
            LOGGER.warn("Getting Session via openSession(). Something must wrong in transaction manager");
        }
        return session;
    }

    @SuppressWarnings("unchecked")
    public T read(K id) {
        DetachedCriteria criteria = DetachedCriteria.forClass(type);
        criteria.add(Restrictions.eq("id", id));
        return (T) criteria.getExecutableCriteria(getSession()).uniqueResult();
    }

    public void create(T entity) {
        getSession().save(entity);
    }

    public void update(T entity) {
        getSession().update(entity);
    }

    public void delete(T entity) {
        getSession().delete(entity);
    }
}
