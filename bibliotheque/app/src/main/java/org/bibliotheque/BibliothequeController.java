package org.bibliotheque;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bibliotheque")
public class BibliothequeController {

    private final EmpruntService empruntService;
    private final LivreService livreService;
    private final EtudiantService etudiantService;

    public BibliothequeController(EmpruntService empruntService, LivreService livreService, EtudiantService etudiantService) {
        this.empruntService = empruntService;
        this.livreService = livreService;
        this.etudiantService = etudiantService;
    }

    // 1. Tous les livres
    @GetMapping("/livres")
    public List<Livre> getLivres() {
        return livreService.getLivres();
    }

    // 2. Tous les étudiants
    @GetMapping("/etudiants")
    public List<Etudiant> getEtudiants() {
        return etudiantService.getEtudiants();
    }

    // 3. Livres disponibles
    @GetMapping("/livres/disponibles")
    public List<Livre> getLivresDisponibles() {
        return livreService.getLivresDisponibles();
    }

    // 4. Livres empruntés
    @GetMapping("/livres/empruntes")
    public List<Livre> getLivresEmpruntes() {
        return livreService.getLivresEmpruntes(true);
    }

    // 6. Livres par catégorie
    @GetMapping("/livres/categorie/{categorie}")
    public List<Livre> getLivresParCategorie(@PathVariable Categorie categorie) {
        return livreService.getLivresParCategorie(categorie);
    }

    // 7. Livre par ISBN
    @GetMapping("/livres/{isbn}")
    public Livre getLivreByIsbn(@PathVariable String isbn) {
        Livre livre = livreService.getLivreByIsbn(isbn);
        if (livre == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Livre non trouvé");
        }
        return livre;
    }

    // 8. Étudiant par numéro
    @GetMapping("/etudiants/{numero}")
    public Etudiant getEtudiantByNumero(@PathVariable String numero) {
        Etudiant etudiant = etudiantService.getEtudiantParNumero(numero);
        if (etudiant == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Étudiant non trouvé");
        }
        return etudiant;
    }

    // 9. Livres empruntés par un étudiant
    @GetMapping("/etudiants/{numero}/livres")
    public List<Livre> getLivresEmpruntesParEtudiant(@PathVariable String numero) {
        Etudiant etudiant = etudiantService.getEtudiantParNumero(numero);
        if (etudiant == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Étudiant non trouvé");
        }
        return empruntService.getLivresEmpruntesParEtudiant(numero);
    }

    @GetMapping("/annee/{annee}")
    public List<Livre> getLivresParAnnee(@PathVariable int annee) {
        return livreService.getLivres().stream()
                .filter(livre -> livre.getAnneePublication() == annee)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/livres/{isbn}")
    public void supprimerLivre(@PathVariable String isbn) {
        Livre livre = livreService.getLivreByIsbn(isbn);
        if (livre == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Livre non trouvé");
        }
        livreService.supprimerLivre(livre);
    }

    @DeleteMapping("/etudiants/{numeroEtudiant}")
    public void supprimerEtudiant(@PathVariable String numeroEtudiant) {
        Etudiant etudiant = etudiantService.getEtudiantParNumero(numeroEtudiant);
        if (etudiant == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Etudiant non trouvé");
        }
        etudiantService.supprimerEtudiant(etudiant);
    }

    @PostMapping("/emprunts/{isbn}/{numeroEtudiant}")
    public void emprunterLivre(
            @PathVariable String isbn,
            @PathVariable String numeroEtudiant) {
        Livre livre = livreService.getLivreByIsbn(isbn);
        Etudiant etudiant = etudiantService.getEtudiantParNumero(numeroEtudiant);

        if (livre == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Livre non trouvé");
        }
        if (etudiant == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Étudiant non trouvé");
        }
        if (livre.isEmprunte()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Livre déjà emprunté");
        }
        empruntService.emprunterLivre(livre, etudiant);
    }
}