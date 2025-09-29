
package org.bibliotheque;

import org.springframework.stereotype.Service;
import java.util.List;
import java.time.LocalDate;

@Service
public class EmpruntService {
    private final EmpruntRepository empruntRepository;

    public EmpruntService(EmpruntRepository empruntRepository) {
        this.empruntRepository = empruntRepository;
    }

    public Emprunt creerEmprunt(Emprunt emprunt) {
        return empruntRepository.save(emprunt);
    }
    public Emprunt getEmpruntParId(Long id) {
        return empruntRepository.findById(id).orElse(null);
    }
    public List<Emprunt> getEmpruntsParEtudiant(Etudiant etudiant) {
        return empruntRepository.findByEtudiant(etudiant);
    }
    public List<Emprunt> getEmpruntsParLivre(Livre livre) {
        return empruntRepository.findByLivre(livre);
    }
    public List<Emprunt> getEmpruntsParDate(LocalDate dateEmprunt) {
        // Adapter si EmpruntRepository attend java.util.Date
        return empruntRepository.findByDateEmprunt(java.sql.Date.valueOf(dateEmprunt));
    }

    // Ajout des méthodes manquantes pour le controller
    public List<Livre> getLivresEmpruntesParEtudiant(String numeroEtudiant) {
        // À adapter selon ton besoin réel (ici, il faudrait injecter EtudiantService ou passer l'objet Etudiant)
        return null;
    }

    public void emprunterLivre(Livre livre, Etudiant etudiant) {
        // À compléter selon ta logique métier
    }
}
