package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;


/**
 * Neighbour API client
 */
public interface NeighbourApiService {

    /**
     * Get all my Neighbours
     * @return {@link List}
     */
    List<Neighbour> getNeighbours();

    /**
     * Get all my favorite Neighbours
     * @return {neighbour List}
     */

    List<Neighbour> getFavoriteNeighbour();

    /**
     * Deletes a neighbour
     * @param neighbour
     */
    void deleteNeighbour(Neighbour neighbour);

    /**
     * Add a neighbour random
     */
    void addingNeighbour();

    /**
     * Add a favorite Neighbour in list
     * @param neighbour
     * */
    void addFavoriteNeighbour (Neighbour neighbour);

    /**
     * remove a favorite neighbour
     * @param neighbour
     */
    void removeFavoriteNeighbour(Neighbour neighbour);

    /**
     * Check if a neighbour is on the favorite list Neighbour
     * @param neighbour
     */
    boolean checkFavoriteNeighbour(Neighbour neighbour);

    /**
     * Find a neighbour in the list with id
     * @param id
     * @return
     */
    Neighbour findNeighbourWithId (Integer id);
}
