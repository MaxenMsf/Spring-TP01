package org.bibliotheque;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "livres")
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private String titre;
    private String auteur;
    private int anneePublication;
    private String isbn;
    private Categorie categorie;
    private boolean emprunte = false;

    public Livre(String titre, String auteur, int anneePublication, String isbn, Categorie categorie) {
        this.titre = titre;
        this.auteur = auteur;
        this.anneePublication = anneePublication;
        this.isbn = isbn;
        this.categorie = categorie;
    }
    
    public Livre() {

    }

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

    public boolean isEmprunte() { return emprunte; }

    public void setEmprunte(boolean emprunte) { this.emprunte = true; }

    public void setRetourne(boolean emprunte) { this.emprunte = false; }

    @Override
    public String toString() {
        return titre + " (" + auteur + ", " + anneePublication + ", " + isbn + ") - " + categorie;
    }
}