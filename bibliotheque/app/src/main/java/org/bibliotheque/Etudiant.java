package org.bibliotheque;

public class Etudiant {
    private String nom;
    private String prenom;
    private String numeroEtudiant;

    public Etudiant(String nom, String prenom, String numeroEtudiant) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroEtudiant = numeroEtudiant;
    }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getNumeroEtudiant() { return numeroEtudiant; }
    public void setNumeroEtudiant(String numeroEtudiant) { this.numeroEtudiant = numeroEtudiant; }

    @Override
    public String toString() {
        return prenom + " " + nom + " (N°: " + numeroEtudiant + ")";
    }
}
