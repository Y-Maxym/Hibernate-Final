package org.project.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.project.domain.entity.Country;

import java.util.List;

public class CountryDAO {

    private final SessionFactory sessionFactory;

    public CountryDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Country> getAll() {
        Query<Country> query = sessionFactory.getCurrentSession().createQuery("select c from Country c JOIN FETCH c.languages", Country.class);
        return query.list();
    }
}
