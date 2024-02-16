package tn.esprit.oualhieyaexblanc.Services.Client;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.oualhieyaexblanc.DAO.Entities.Client;
import tn.esprit.oualhieyaexblanc.DAO.Repository.ClientRepository;

@Service
@AllArgsConstructor
public class ClientService implements IClientService{

    ClientRepository clientRepository;

    @Override
    public Client ajouterClient(Client c) {
        return clientRepository.save(c);
    }
}
