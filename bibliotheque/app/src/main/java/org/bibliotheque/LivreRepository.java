
package org.bibliotheque;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LivreRepository extends JpaRepository<Livre, Long> {
    Livre findByIsbn(String isbn);
    List<Livre> findByTitre(String titre);
    List<Livre> findByAuteur(String auteur);
    List<Livre> findByCategorie(Categorie categorie);
    List<Livre> findByEmprunte(boolean emprunte);
    List<Livre> findByAnneePublication(int anneePublication);
}
