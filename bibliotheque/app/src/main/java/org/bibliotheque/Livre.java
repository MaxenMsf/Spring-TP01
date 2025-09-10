package org.bibliotheque;

public class Livre {
    private String titre;
    private String auteur;
    private int anneePublication;
    private String isbn;
    private Categorie categorie;

    public Livre(String titre, String auteur, int anneePublication, String isbn, Categorie categorie) {
        this.titre = titre;
        this.auteur = auteur;
        this.anneePublication = anneePublication;
        this.isbn = isbn;
        this.categorie = categorie;
    }

    // Getters et setters
    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public String getAuteur() { return auteur; }
    public void setAuteur(String auteur) { this.auteur = auteur; }

    public int getAnneePublication() { return anneePublication; }
    public void setAnneePublication(int anneePublication) { this.anneePublication = anneePublication; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public Categorie getCategorie() { return categorie; }
    public void setCategorie(Categorie categorie) { this.categorie = categorie; }

    @Override
    public String toString() {
        return titre + " (" + auteur + ", " + anneePublication + ", " + isbn + ") - " + categorie;
    }
}