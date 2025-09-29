package org.bibliotheque;

public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {
    List<Emprunt> findByEtudiant(Etudiant etudiant);
    List<Emprunt> findByLivre(Livre livre);
    List<Emprunt> findByDateEmprunt(java.util.Date dateEmprunt);
    List<Emprunt> findByDateRetour(java.util.Date dateRetour);
    List<Emprunt> findByLivreAndEtudiant(Livre livre, Etudiant etudiant);
}
