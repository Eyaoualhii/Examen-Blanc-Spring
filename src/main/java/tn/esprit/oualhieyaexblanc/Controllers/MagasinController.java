package tn.esprit.oualhieyaexblanc.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.oualhieyaexblanc.DAO.Entities.CarteFId;
import tn.esprit.oualhieyaexblanc.DAO.Entities.Client;
import tn.esprit.oualhieyaexblanc.DAO.Entities.Magasin;
import tn.esprit.oualhieyaexblanc.Services.Magasin.MagasinService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/magasins")
public class MagasinController {

    MagasinService magasinService;

    @PostMapping
    public Magasin addMagasinAndPersonnels(@RequestBody Magasin magasin) {
        return  magasinService.ajouterMagasinEtPersonnels(magasin);


    }

    @PostMapping("/{idMagasin}/clients/{idClient}")
    public void affecterClientAMagasin(@PathVariable int idMagasin, @PathVariable int idClient) {
        magasinService.affecterClientAMagasin(idClient, idMagasin);
    }

    @PostMapping("/{cin}/carte")
    public void ajouterCarteEtAffecterClient(@RequestBody CarteFId carteFId, @PathVariable long cin) {
        magasinService.ajouterCarteEtAffecterClient(carteFId, cin);
    }

    @GetMapping("/magasin/{nomMagasin}")
    public List<Client> afficherClientsByMagasin(@PathVariable String nomMagasin) {
        return magasinService.afficherClients(nomMagasin);
    }

}
