package org.bibliotheque;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    Etudiant findByNumeroEtudiant(String numeroEtudiant);
    List<Etudiant> findByNom(String nom);
    List<Etudiant> findByPrenom(String prenom);
    List<Etudiant> findByNumeroEtudiant(String numeroEtudiant);
}
