package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.events.RefreshListFavoriteEvent;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();
    private List<Neighbour> favoriteNeighbour = new ArrayList<>();

    /**
     * {@inheritDoc}
     */

    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    @Override
    public List<Neighbour> getFavoriteNeighbour() {
        return favoriteNeighbour;
    }

    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);

        //if neighbour is on favorite
        if(checkFavoriteNeighbour(neighbour)){
            removeFavoriteNeighbour(neighbour);
        }
    }

    @Override
    public void addingNeighbour(){

        Neighbour neighbour = DummyNeighbourGenerator.generateNeighbourRandom();

        //for the neighbours have unique id
        neighbour.setId(neighbours.get(neighbours.size()).getId());
        neighbours.add(neighbour);
    }

    @Override
    public void addFavoriteNeighbour (Neighbour neighbour){
        favoriteNeighbour.add(neighbour);

    }

    @Override
    public void removeFavoriteNeighbour (Neighbour neighbour){
        favoriteNeighbour.remove(neighbour);

    }

    @Override
    public boolean checkFavoriteNeighbour (Neighbour neighbour){

        if(favoriteNeighbour.size() > 0) {
            for (int i = 0; i < favoriteNeighbour.size(); i++) {

                if (neighbour.equals(favoriteNeighbour.get(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Neighbour findNeighbourWithId(Integer id) {

        for(int i = 0; i < neighbours.size(); i++){
            if(neighbours.get(i).getId().equals(id)){
                return neighbours.get(i);
            }
        }
        return null;
    }


}
