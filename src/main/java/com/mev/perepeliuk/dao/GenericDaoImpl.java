package com.mev.perepeliuk.dao;

import com.mev.perepeliuk.domain.BasicDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public abstract class GenericDaoImpl<T extends BasicDomain> implements GenericDao<T> {

    @PersistenceContext
    private EntityManager entityManager;

    private final Class<T> domainClass;

    protected GenericDaoImpl(Class<T> domainClass) {
        this.domainClass = domainClass;
    }

    private static final Logger logger = LoggerFactory.getLogger(GenericDaoImpl.class);

    @Override
    public T save(T entity) {
        if (entity == null) {
            String errorMessage = "Cannot save with null " + domainClass.getSimpleName();
            logger.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public T update(T entity) {
        if (entity == null) {
            String errorMessage = "Cannot update with null " + domainClass.getSimpleName();
            logger.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
        if (entity.getId() == null) {
            String errorMessage = "Cannot update " + domainClass.getSimpleName() + " with null `id`";
            logger.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
        entityManager.merge(entity);
        return entity;
    }

    @Override
    public T getById(Long id) {
        if (id == null) {
            String errorMessage = "Cannot be find by null `id`";
            logger.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
        T entity = entityManager.find(domainClass, id);
        if (entity == null) {
            String errorMessage = domainClass.getSimpleName() + " with `id` " + id + " doesn't exist.";
            logger.error(errorMessage);
            throw new EntityNotFoundException(errorMessage);
        }
        return entity;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        return entityManager.createQuery("select d from " + domainClass.getName() + " d").getResultList();
    }

}
