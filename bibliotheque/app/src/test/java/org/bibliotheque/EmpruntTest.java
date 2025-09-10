package org.bibliotheque;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EmpruntTest {

    @Test
    void testEmpruntCreation() {
        Livre livre = new Livre("1984", "George Orwell", 1949, "1234567890", Categorie.LITTERATURE);
        String etudiant = "etudiant1";
        LocalDate date = LocalDate.now();

        Emprunt emprunt = new Emprunt(livre, etudiant, date);

        assertEquals(livre, emprunt.getLivre());
        assertEquals(etudiant, emprunt.getEtudiant());
        assertEquals(date, emprunt.getDateEmprunt());
    }
}