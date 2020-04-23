package com.rhysnguyen.customermanager.dao;

import com.rhysnguyen.customermanager.entity.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query = entityManager
                .createQuery("select c from Customer c", Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer findById(Long id) {
        TypedQuery<Customer> query = entityManager
                .createQuery("select c from Customer c where c.id = ?1", Customer.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }

    @Override
    public void save(Customer model) {
        if (model.getId() != null) {
            entityManager.merge(model);
        } else {
            entityManager.persist(model);
        }
    }

    @Override
    public void remove(Long id) {
        Customer customer = findById(id);
        if(customer != null){
            entityManager.remove(customer);
        }
    }
}
