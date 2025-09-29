
package org.bibliotheque;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LivreService {

    private final LivreRepository livreRepository;

    public LivreService(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }

    public Livre creerLivre(Livre livre) {
        return livreRepository.save(livre);
    }
    public Livre getLivreByIsbn(String isbn) {
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
    public List<Livre> getLivres() {
        return livreRepository.findAll();
    }
    public List<Livre> getLivresDisponibles() {
        return livreRepository.findByEmprunte(false);
    }
    public void supprimerLivre(Livre livre) {
        livreRepository.delete(livre);
    }
}
