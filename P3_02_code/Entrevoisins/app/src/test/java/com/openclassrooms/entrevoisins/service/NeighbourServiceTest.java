package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
public class NeighbourServiceTest {

    private NeighbourApiService service;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void getNeighboursWithSuccess() {
        //Given : init list ApiService
        List<Neighbour> neighbours = service.getNeighbours();
        //When : recuperate list in generator for compare
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        //Then : compare the list Api with the list generator
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
    }

    @Test
    public void getFavoriteNeighbourWithSuccess() {

        //Given : add a neighbour in the list in the favorite so that the list is not null
        service.addFavoriteNeighbour(service.getNeighbours().get(0));
        //When : recuperate the list favorite
        List<Neighbour> expectedFavoriteNeighbour = service.getFavoriteNeighbour();
        //Then : check if the size of the list is one
        assertEquals(1, expectedFavoriteNeighbour.size());
    }

    @Test
    public void deleteNeighbourWithSuccess() {
        //Given : init a neighbour of the list at delete
        Neighbour neighbourToDelete = service.getNeighbours().get(0);
        //When : remove the neighbour of the list
        service.deleteNeighbour(neighbourToDelete);
        //Then : check if the neighbour is well not in the list
        assertFalse(service.getNeighbours().contains(neighbourToDelete));
    }

    @Test
    public void addingNeighbourWithSuccess() {
        //Given : create new list of neighbour empty and add all element of list neighbour of ApiService
        List<Neighbour> neighbours = new ArrayList<>();
        neighbours.addAll(service.getNeighbours());
        //When : add a neighbour of the list neighbour of ApiService
        service.addingNeighbour();
        //Then = compare the size of list create ( + 1 ) and the size of list ApiService
        assertEquals(neighbours.size() + 1, service.getNeighbours().size());
    }

    @Test
    public void addingFavoriteNeighbourWithSuccess(){
        //Given : init a neighbour of the list at add in favorite
        Neighbour neighbourToAdd = service.getNeighbours().get(0);
        //When : add the neighbour of the list favorite
        service.addFavoriteNeighbour(neighbourToAdd);
        //Then : check if the neighbour is in the list
        assertTrue(service.getFavoriteNeighbour().contains(neighbourToAdd));
    }

    @Test
    public void removeFavoriteNeighbourWithSuccess (){
        //Given : init a neighbour of the list at remove of favorite
        Neighbour neighbourToAddAndRemove = service.getNeighbours().get(0);
        //When : adding and remove the neighbour of the list
        service.addFavoriteNeighbour(neighbourToAddAndRemove);
        service.removeFavoriteNeighbour(neighbourToAddAndRemove);
        //Then : check if the neighbour is well not in the list
        assertFalse(service.getFavoriteNeighbour().contains(neighbourToAddAndRemove));
    }

    @Test
    public void checkFavoriteNeighbourWithSuccess(){
        //Given : init the list neighbour of ApiService
        List<Neighbour> neighbours = service.getNeighbours();
        //When : adding neighbours of the favorite list
        service.addFavoriteNeighbour(neighbours.get(0));
        service.addFavoriteNeighbour(neighbours.get(1));
        service.addFavoriteNeighbour(neighbours.get(2));
        //Then : check if the neighbour is in the favorite list or not
        assertTrue(service.checkFavoriteNeighbour(neighbours.get(0)));
        assertFalse(service.checkFavoriteNeighbour(neighbours.get(4)));
    }
    @Test
    public void findNeighbourWithIdWithSuccess (){
        //Given : init neighbour for compare
        List<Neighbour> neighbours = service.getNeighbours();
        Neighbour neighbour = neighbours.get(0);
        //When : recuperate id of neighbour for compare
        Integer idNeighbour = neighbour.getId();
        //Then : use methode of ApiService for find neighbour with id and compare if is equals
        assertEquals(service.findNeighbourWithId(idNeighbour), neighbour);
    }
}
