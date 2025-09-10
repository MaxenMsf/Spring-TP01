package org.bibliotheque;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class BibliothequeTest {

    @Test
    void testAjouterEtSupprimerLivre() {
        Bibliotheque biblio = new Bibliotheque();
        Livre livre = new Livre("1984", "George Orwell", 1949, "1234567890", Categorie.LITTERATURE);

        biblio.ajouterLivre(livre);
        assertTrue(biblio.getLivres().contains(livre));

        biblio.supprimerLivre(livre);
        assertFalse(biblio.getLivres().contains(livre));
    }

    @Test
    void testGetLivresParCategorie() {
        Bibliotheque biblio = new Bibliotheque();
        Livre l1 = new Livre("1984", "George Orwell", 1949, "123", Categorie.LITTERATURE);
        Livre l2 = new Livre("Java", "Sun", 2000, "456", Categorie.INFORMATIQUE);
        biblio.ajouterLivre(l1);
        biblio.ajouterLivre(l2);

        List<Livre> lit = biblio.getLivresParCategorie(Categorie.LITTERATURE);
        assertEquals(1, lit.size());
        assertEquals(l1, lit.get(0));
    }

    @Test
    void testGetCategories() {
        Bibliotheque biblio = new Bibliotheque();
        List<Categorie> cats = biblio.getCategories();
        assertTrue(cats.contains(Categorie.LITTERATURE));
        assertEquals(8, cats.size());
    }
}