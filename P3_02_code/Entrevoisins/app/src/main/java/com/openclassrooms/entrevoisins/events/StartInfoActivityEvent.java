package com.openclassrooms.entrevoisins.events;

import com.openclassrooms.entrevoisins.model.Neighbour;

/**
 * Event fired when a user request more information on a Neighbour
 */
public class StartInfoActivityEvent {

    /** Neighbour to request info */
    public Neighbour neighbour;

    /**
     * Constructor
     * @param neighbour
     * */
    public StartInfoActivityEvent(Neighbour neighbour) {
        this.neighbour = neighbour;
    }
}
