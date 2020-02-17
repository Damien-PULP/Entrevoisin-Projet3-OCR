package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

abstract class DummyNeighbourGenerator {

    public static final List<Neighbour> DUMMY_NEIGHBOURS = Arrays.asList(
            new Neighbour(0, "Caroline", "http://i.pravatar.cc/150?u=a042581f4e29026704d","Saint pierre dumont à 5 km", "+33686679014", "www.facebook.fr/caroline", "Bonjour, je souhaiterai faire de la marche nordique. Pas initié, je recherche une ou plusieurs personne suseptibles de m'accompagner. J'aime les jeux de carte comme la belotte et le tarot"),
            new Neighbour(1, "Jack", "http://i.pravatar.cc/150?u=a042581f4e29026704e","Saint pierre dumont à 5 km", "+33686679014", "www.facebook.fr/caroline", "Bonjour, je souhaiterai faire de la marche nordique. Pas initié, je recherche une ou plusieurs personne suseptibles de m'accompagner. J'aime les jeux de carte comme la belotte et le tarot"),
            new Neighbour(2, "Chloé", "http://i.pravatar.cc/150?u=a042581f4e29026704f","Saint pierre dumont à 5 km", "+33686679014", "www.facebook.fr/caroline", "Bonjour, je souhaiterai faire de la marche nordique. Pas initié, je recherche une ou plusieurs personne suseptibles de m'accompagner. J'aime les jeux de carte comme la belotte et le tarot"),
            new Neighbour(3, "Vincent", "http://i.pravatar.cc/150?u=a042581f4e29026704a","Saint pierre dumont à 5 km", "+33686679014", "www.facebook.fr/caroline", "Bonjour, je souhaiterai faire de la marche nordique. Pas initié, je recherche une ou plusieurs personne suseptibles de m'accompagner. J'aime les jeux de carte comme la belotte et le tarot"),
            new Neighbour(4, "Elodie", "http://i.pravatar.cc/150?u=a042581f4e29026704b","Saint pierre dumont à 5 km", "+33686679014", "www.facebook.fr/caroline", "Bonjour, je souhaiterai faire de la marche nordique. Pas initié, je recherche une ou plusieurs personne suseptibles de m'accompagner. J'aime les jeux de carte comme la belotte et le tarot"),
            new Neighbour(5, "Sylvain", "http://i.pravatar.cc/150?u=a042581f4e29026704c", "Saint pierre dumont à 5 km", "+33686679014", "www.facebook.fr/caroline", "Bonjour, je souhaiterai faire de la marche nordique. Pas initié, je recherche une ou plusieurs personne suseptibles de m'accompagner. J'aime les jeux de carte comme la belotte et le tarot"),
            new Neighbour(6, "Laetitia", "http://i.pravatar.cc/150?u=a042581f4e29026703d","Saint pierre dumont à 5 km", "+33686679014", "www.facebook.fr/caroline", "Bonjour, je souhaiterai faire de la marche nordique. Pas initié, je recherche une ou plusieurs personne suseptibles de m'accompagner. J'aime les jeux de carte comme la belotte et le tarot"),
            new Neighbour(7, "Dan", "http://i.pravatar.cc/150?u=a042581f4e29026703b","Saint pierre dumont à 5 km", "+33686679014", "www.facebook.fr/caroline", "Bonjour, je souhaiterai faire de la marche nordique. Pas initié, je recherche une ou plusieurs personne suseptibles de m'accompagner. J'aime les jeux de carte comme la belotte et le tarot"),
            new Neighbour(8, "Joseph", "http://i.pravatar.cc/150?u=a042581f4e29026704d","Saint pierre dumont à 5 km", "+33686679014", "www.facebook.fr/caroline", "Bonjour, je souhaiterai faire de la marche nordique. Pas initié, je recherche une ou plusieurs personne suseptibles de m'accompagner. J'aime les jeux de carte comme la belotte et le tarot"),
            new Neighbour(9, "Emma", "http://i.pravatar.cc/150?u=a042581f4e29026706d","Saint pierre dumont à 5 km", "+33686679014", "www.facebook.fr/caroline", "Bonjour, je souhaiterai faire de la marche nordique. Pas initié, je recherche une ou plusieurs personne suseptibles de m'accompagner. J'aime les jeux de carte comme la belotte et le tarot"),
            new Neighbour(10, "Patrick", "http://i.pravatar.cc/150?u=a042581f4e29026702d","Saint pierre dumont à 5 km", "+33686679014", "www.facebook.fr/caroline", "Bonjour, je souhaiterai faire de la marche nordique. Pas initié, je recherche une ou plusieurs personne suseptibles de m'accompagner. J'aime les jeux de carte comme la belotte et le tarot"),
            new Neighbour(11, "Ludovic", "http://i.pravatar.cc/150?u=a042581f3e39026702d","Saint pierre dumont à 5 km", "+33686679014", "www.facebook.fr/caroline", "Bonjour, je souhaiterai faire de la marche nordique. Pas initié, je recherche une ou plusieurs personne suseptibles de m'accompagner. J'aime les jeux de carte comme la belotte et le tarot")
    );

    private static final List<Neighbour> DUMMY_NEIGHBOURS_RANDOM = Arrays.asList(

            new Neighbour(12, "Sarah", "http://i.pravatar.cc/150?u=a042581f4e29026704d","Saint pierre dumont à 5 km", "+33686679014", "www.facebook.fr/caroline", "Bonjour, je souhaiterai faire de la marche nordique. Pas initié, je recherche une ou plusieurs personne suseptibles de m'accompagner. J'aime les jeux de carte comme la belotte et le tarot"),
            new Neighbour(13, "George", "http://i.pravatar.cc/150?u=a042581f4e29026704e","Saint pierre dumont à 5 km", "+33686679014", "www.facebook.fr/caroline", "Bonjour, je souhaiterai faire de la marche nordique. Pas initié, je recherche une ou plusieurs personne suseptibles de m'accompagner. J'aime les jeux de carte comme la belotte et le tarot"),
            new Neighbour(14, "Stéphanie", "http://i.pravatar.cc/150?u=a042581f4e29026704f","Saint pierre dumont à 5 km", "+33686679014", "www.facebook.fr/caroline", "Bonjour, je souhaiterai faire de la marche nordique. Pas initié, je recherche une ou plusieurs personne suseptibles de m'accompagner. J'aime les jeux de carte comme la belotte et le tarot"),
            new Neighbour(15, "Jordan", "http://i.pravatar.cc/150?u=a042581f4e29026704a","Saint pierre dumont à 5 km", "+33686679014", "www.facebook.fr/caroline", "Bonjour, je souhaiterai faire de la marche nordique. Pas initié, je recherche une ou plusieurs personne suseptibles de m'accompagner. J'aime les jeux de carte comme la belotte et le tarot"),
            new Neighbour(16, "Joseph", "http://i.pravatar.cc/150?u=a042581f4e29026704b","Saint pierre dumont à 5 km", "+33686679014", "www.facebook.fr/caroline", "Bonjour, je souhaiterai faire de la marche nordique. Pas initié, je recherche une ou plusieurs personne suseptibles de m'accompagner. J'aime les jeux de carte comme la belotte et le tarot")

    );

    static List<Neighbour> generateNeighbours() {
        return new ArrayList<>(DUMMY_NEIGHBOURS);
    }

    static Neighbour generateNeighbourRandom () {

        List<Neighbour> randomNeighbour = new ArrayList<>(DUMMY_NEIGHBOURS_RANDOM);

        Random random = new Random();
        int indexNeighbour = random.nextInt(randomNeighbour.size());

        return randomNeighbour.get(indexNeighbour);
    }
}
