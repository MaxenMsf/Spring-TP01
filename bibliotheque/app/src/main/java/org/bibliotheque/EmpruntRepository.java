
package org.bibliotheque;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {
    List<Emprunt> findByEtudiant(Etudiant etudiant);
    List<Emprunt> findByLivre(Livre livre);
    List<Emprunt> findByDateEmprunt(java.util.Date dateEmprunt);
    List<Emprunt> findByDateRetour(java.util.Date dateRetour);
    List<Emprunt> findByLivreAndEtudiant(Livre livre, Etudiant etudiant);
}
