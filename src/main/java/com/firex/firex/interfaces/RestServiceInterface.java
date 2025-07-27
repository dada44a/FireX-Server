package com.firex.firex.interfaces;

import java.util.Map;

/**
 * Generic REST service interface to define basic CRUD operations.
 *
 * @param <I> The entity type this service will handle
 */
public interface RestServiceInterface<I> {

    /**
     * Creates a new entity.
     *
     * @param data The entity data to be created
     * @return The created entity
     */
    I create(I data);

    /**
     * Updates an existing entity by its ID.
     *
     * @param id   The ID of the entity to update
     * @param data The new data for the entity
     * @return The updated entity
     */
    I update(long id, I data);

    /**
     * Retrieves an entity by its ID.
     *
     * @param id The ID of the entity to retrieve
     * @return The entity with the specified ID
     */
    I read(long id);

    /**
     * Deletes an entity by its ID.
     *
     * @param id The ID of the entity to delete
     * @return A map indicating the result of the operation
     */
    Map<String, String> delete(long id);
}
