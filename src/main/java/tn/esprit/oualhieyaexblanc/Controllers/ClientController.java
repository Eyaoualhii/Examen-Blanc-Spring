package tn.esprit.oualhieyaexblanc.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.oualhieyaexblanc.DAO.Entities.Client;
import tn.esprit.oualhieyaexblanc.Services.Client.ClientService;
import tn.esprit.oualhieyaexblanc.Services.Magasin.MagasinService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/clients")
public class ClientController {

    ClientService clientService;

    MagasinService magasinService;

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return  clientService.ajouterClient(client);


    }


}
