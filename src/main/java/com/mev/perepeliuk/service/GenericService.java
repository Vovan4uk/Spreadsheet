package com.mev.perepeliuk.service;

import com.mev.perepeliuk.domain.BasicDomain;

import java.util.List;

public interface GenericService<T extends BasicDomain> {

    /**
     * Persist entity in the database.
     *
     * @param entity Entity to save
     * @return created Entity
     */
    T save(T entity);

    /**
     * Update entity in the database.
     *
     * @param entity Entity to update
     * @return updated Entity
     */
    T update(T entity);

    /**
     * Find entity in the database by primary key.
     *
     * @param id - entity id
     * @return Entity
     */
    T getById(Long id);

    /**
     * Find all entities in the database.
     *
     * @return List<T> - list of entities
     */
    List<T> getAll();

}
