package org.bibliotheque;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bibliotheque")
public class BibliothequeController {

    private Bibliotheque bibliotheque;

    public BibliothequeController() {
        bibliotheque = new Bibliotheque();

        // Ajout de quelques livres
        bibliotheque.ajouterLivre(new Livre("1984", "George Orwell", 1949, "9780451524935", Categorie.SCIENCES));
        bibliotheque.ajouterLivre(new Livre("Le Petit Prince", "Antoine de Saint-Exupéry", 1943, "9780156013987", Categorie.PHILOSOPHIE));
        bibliotheque.ajouterLivre(new Livre("Clean Code", "Robert C. Martin", 2008, "9780132350884", Categorie.INFORMATIQUE));

        // Ajout de quelques étudiants
        bibliotheque.ajouterEtudiant(new Etudiant("Alice", "Durand", "alice.durand@etu.univ.fr"));
        bibliotheque.ajouterEtudiant(new Etudiant("Bob", "Martin", "bob.martin@etu.univ.fr"));
    }

    // 1. Tous les livres
    @GetMapping("/livres")
    public List<Livre> getLivres() {
        return bibliotheque.getLivres();
    }

    // 2. Tous les étudiants
    @GetMapping("/etudiants")
    public List<Etudiant> getEtudiants() {
        return bibliotheque.getEtudiants();
    }

    // 3. Livres disponibles
    @GetMapping("/livres/disponibles")
    public List<Livre> getLivresDisponibles() {
        return bibliotheque.getLivresDisponibles();
    }

    // 4. Livres empruntés
    @GetMapping("/livres/empruntes")
    public List<Livre> getLivresEmpruntes() {
        return bibliotheque.getLivresEmpruntes();
    }

    // 6. Livres par catégorie
    @GetMapping("/livres/categorie/{categorie}")
    public List<Livre> getLivresParCategorie(@PathVariable Categorie categorie) {
        return bibliotheque.getLivresParCategorie(categorie);
    }

    // 7. Livre par ISBN
    @GetMapping("/livres/{isbn}")
    public Livre getLivreByIsbn(@PathVariable String isbn) {
        Livre livre = bibliotheque.getLivreByIsbn(isbn);
        if (livre == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Livre non trouvé");
        }
        return livre;
    }

    // 8. Étudiant par numéro
    @GetMapping("/etudiants/{numero}")
    public Etudiant getEtudiantByNumero(@PathVariable String numero) {
        Etudiant etudiant = bibliotheque.getEtudiantByNumero(numero);
        if (etudiant == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Étudiant non trouvé");
        }
        return etudiant;
    }

    // 9. Livres empruntés par un étudiant
    @GetMapping("/etudiants/{numero}/livres")
    public List<Livre> getLivresEmpruntesParEtudiant(@PathVariable String numero) {
        List<Livre> livres = bibliotheque.getLivresEmpruntesParEtudiant(numero);
        if (livres == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Étudiant non trouvé");
        }
        return livres;
    }

    @GetMapping("/annee/{annee}")
    public List<Livre> getLivresParAnnee(@PathVariable int annee) {
        return bibliotheque.getLivres().stream()
                .filter(livre -> livre.getAnneePublication() == annee)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/livres/{isbn}")
    public void supprimerLivre(@PathVariable String isbn) {
        Livre livre = bibliotheque.getLivreByIsbn(isbn);
        if (livre == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Livre non trouvé");
        }
        bibliotheque.supprimerLivre(livre);
    }

    @DeleteMapping("/etudiants/{numeroEtudiant}")
    public void supprimerEtudiant(@PathVariable String numeroEtudiant) {
        Etudiant etudiant = bibliotheque.getEtudiantByNumero(numeroEtudiant);
        if (etudiant == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Etudiant non trouvé");
        }
        bibliotheque.supprimerEtudiant(etudiant);
    }

    @PostMapping("/emprunts/{isbn}/{numeroEtudiant}")
    public void emprunterLivre(
            @PathVariable String isbn,
            @PathVariable String numeroEtudiant) {
        Livre livre = bibliotheque.getLivreByIsbn(isbn);
        Etudiant etudiant = bibliotheque.getEtudiantByNumero(numeroEtudiant);

        if (livre == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Livre non trouvé");
        }
        if (etudiant == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Étudiant non trouvé");
        }
        if (livre.isEmprunte()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Livre déjà emprunté");
        }
        livre.setEmprunte(true);
    }
}