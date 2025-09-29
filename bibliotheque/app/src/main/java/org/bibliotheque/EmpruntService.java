package org.bibliotheque;

import org.springframework.stereotype.Service;

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
        return empruntRepository.findByDateEmprunt(dateEmprunt);
    }
}
