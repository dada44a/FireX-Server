package com.firex.firex.interfaces;

import java.util.Map;

/**
 * Generic REST controller interface defining standard CRUD operations.
 *
 * @param <I> The type of entity the controller manages
 */
public interface RestControllerInterface<I> {

    /**
     * Creates a new entity.
     *
     * @param data The entity to create
     * @return The created entity
     */
    I create(I data);

    /**
     * Updates an existing entity by ID.
     *
     * @param id   The ID of the entity to update
     * @param data The updated entity data
     * @return The updated entity
     */
    I update(long id, I data);

    /**
     * Retrieves an entity by its ID.
     *
     * @param id The ID of the entity to retrieve
     * @return The requested entity
     */
    I read(long id);

    /**
     * Deletes an entity by its ID.
     *
     * @param id The ID of the entity to delete
     * @return A map indicating the result of the deletion
     */
    Map<String, String> delete(long id);
}
