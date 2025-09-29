
package org.bibliotheque;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    Etudiant findByNumeroEtudiant(String numeroEtudiant);
    List<Etudiant> findByNom(String nom);
    List<Etudiant> findByPrenom(String prenom);
}
