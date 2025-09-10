package org.bibliotheque;

import java.time.LocalDate;

public class Emprunt {
    private Livre livre;
    private String etudiant;
    private LocalDate dateEmprunt;

    public Emprunt(Livre livre, String etudiant, LocalDate dateEmprunt) {
        this.livre = livre;
        this.etudiant = etudiant;
        this.dateEmprunt = dateEmprunt;
    }

    public Livre getLivre() { return livre; }
    public String getEtudiant() { return etudiant; }
    public LocalDate getDateEmprunt() { return dateEmprunt; }
}
