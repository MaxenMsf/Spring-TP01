package org.bibliotheque;

import org.springframework.stereotype.Service;

@Service
public class EtudiantService {

    private final EtudiantRepository etudiantRepository;

    public EtudiantService(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }
    public Etudiant creerEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }
    public Etudiant getEtudiantParNumero(String numeroEtudiant) {
        return etudiantRepository.findByNumeroEtudiant(numeroEtudiant);
    }
    public List<Etudiant> getEtudiantsParNom(String nom) {
        return etudiantRepository.findByNom(nom);
    }
    public List<Etudiant> getEtudiantsParPrenom(String prenom) {
        return etudiantRepository.findByPrenom(prenom);
    }
}
