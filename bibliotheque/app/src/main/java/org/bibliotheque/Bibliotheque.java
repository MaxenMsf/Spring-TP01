package org.bibliotheque;

import java.util.*;

public class Bibliotheque {
    private List<Livre> livres = new ArrayList<>();

    public void ajouterLivre(Livre livre) {
        livres.add(livre);
    }

    public void supprimerLivre(Livre livre) {
        livres.remove(livre);
    }

    public List<Livre> getLivres() {
        return Collections.unmodifiableList(livres);
    }

    public List<Livre> getLivresParCategorie(Categorie categorie) {
        List<Livre> result = new ArrayList<>();
        for (Livre livre : livres) {
            if (livre.getCategorie() == categorie) {
                result.add(livre);
            }
        }
        return result;
    }

    public List<Categorie> getCategories() {
        return Arrays.asList(Categorie.values());
    }
}