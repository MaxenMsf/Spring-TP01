package org.bibliotheque;

import java.util.*;

public class Bibliotheque {
    private List<Livre> livres = new ArrayList<>();
    private List<Etudiant> etudiants = new ArrayList<>();
    private Map<Livre, Etudiant> emprunts = new HashMap<>();

    public void ajouterEtudiant(Etudiant etudiant) {
        etudiants.add(etudiant);
    }

    public void ajouterLivre(Livre livre) {
        livres.add(livre);
    }

    public void supprimerLivre(Livre livre) {
        livres.remove(livre);
    }

    public void supprimerEtudiant(Etudiant etudiant) {
        etudiants.remove(etudiant);
    }

    public List<Livre> getLivres() {
        return Collections.unmodifiableList(livres);
    }

    public List<Etudiant> getEtudiants() {
        return Collections.unmodifiableList(etudiants);
    }

    public boolean livreEstEmprunte(Livre livre) {
        return livre.isEmprunte();
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

    public List<Livre> getLivresDisponibles() {
        List<Livre> result = new ArrayList<>();
        for (Livre livre : livres) {
            if (!livreEstEmprunte(livre)) {
                result.add(livre);
            }
        }
        return result;
    }

    public List<Livre> getLivresEmpruntes() {
        List<Livre> result = new ArrayList<>();
        for (Livre livre : livres) {
            if (livreEstEmprunte(livre)) {
                result.add(livre);
            }
        }
        return result;
    }

    public List<Livre> getEmprunts() {
        List<Livre> empruntes = new ArrayList<>();
        for (Livre livre : livres) {
            if (livre.isEmprunte()) {
                empruntes.add(livre);
            }
        }
        return empruntes;
    }

    public Livre getLivreByIsbn(String isbn) {
        for (Livre livre : livres) {
            if (livre.getIsbn().equals(isbn)) {
                return livre;
            }
        }
        return null;
    }

    public Etudiant getEtudiantByNumero(String numero) {
        for (Etudiant etudiant : etudiants) {
            if (etudiant.getNumeroEtudiant().equals(numero)) {
                return etudiant;
            }
        }
        return null;
    }

    public List<Livre> getLivresEmpruntesParEtudiant(String numero) {
        Etudiant etudiant = getEtudiantByNumero(numero);
        if (etudiant == null) {
            return null;
        }
        return new ArrayList<>(getEmprunts());
    }

    public List<Categorie> getCategories() {
        return Arrays.asList(Categorie.values());
    }
}