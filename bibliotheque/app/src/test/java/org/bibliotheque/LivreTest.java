package org.bibliotheque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class LivreTest {

    @Test
    void testConstructeurEtGetters() {
        Livre livre = new Livre("1984", "George Orwell", 1949, "1234567890", Categorie.LITTERATURE);
        assertEquals("1984", livre.getTitre());
        assertEquals("George Orwell", livre.getAuteur());
        assertEquals(1949, livre.getAnneePublication());
        assertEquals("1234567890", livre.getIsbn());
        assertEquals(Categorie.LITTERATURE, livre.getCategorie());
    }

    @Test
    void testSetters() {
        Livre livre = new Livre("Titre", "Auteur", 2000, "0000", Categorie.SCIENCES);
        livre.setTitre("Nouveau Titre");
        livre.setAuteur("Nouvel Auteur");
        livre.setAnneePublication(2020);
        livre.setIsbn("9999");
        livre.setCategorie(Categorie.INFORMATIQUE);

        assertEquals("Nouveau Titre", livre.getTitre());
        assertEquals("Nouvel Auteur", livre.getAuteur());
        assertEquals(2020, livre.getAnneePublication());
        assertEquals("9999", livre.getIsbn());
        assertEquals(Categorie.INFORMATIQUE, livre.getCategorie());
    }

    @Test
    void testToString() {
        Livre livre = new Livre("Le Nom de la Rose", "Umberto Eco", 1980, "1111", Categorie.LITTERATURE);
        String attendu = "Le Nom de la Rose (Umberto Eco, 1980, 1111) - LITTERATURE";
        assertEquals(attendu, livre.toString());
    }
}
