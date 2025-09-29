package org.bibliotheque;

import org.springframework.stereotype.Service;

@Service
public class LivreService {

    private final LivreRepository livreRepository;

    public LivreService(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }

    public Livre creerLivre(Livre livre) {
        return livreRepository.save(livre);
    }
    public Livre getLivreParIsbn(String isbn) {
        return livreRepository.findByIsbn(isbn);
    }
    public List<Livre> getLivresParTitre(String titre) {
        return livreRepository.findByTitre(titre);
    }
    public List<Livre> getLivresParAuteur(String auteur) {
        return livreRepository.findByAuteur(auteur);
    }
    public List<Livre> getLivresParCategorie(Categorie categorie) {
        return livreRepository.findByCategorie(categorie);
    }
    public List<Livre> getLivresEmpruntes(boolean emprunte) {
        return livreRepository.findByEmprunte(emprunte);
    }
}
