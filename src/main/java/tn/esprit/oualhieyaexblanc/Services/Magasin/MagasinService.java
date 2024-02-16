package tn.esprit.oualhieyaexblanc.Services.Magasin;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.oualhieyaexblanc.DAO.Entities.CarteFId;
import tn.esprit.oualhieyaexblanc.DAO.Entities.Client;
import tn.esprit.oualhieyaexblanc.DAO.Entities.Magasin;
import tn.esprit.oualhieyaexblanc.DAO.Entities.Personnel;
import tn.esprit.oualhieyaexblanc.DAO.Repository.CarteFIdRepository;
import tn.esprit.oualhieyaexblanc.DAO.Repository.ClientRepository;
import tn.esprit.oualhieyaexblanc.DAO.Repository.MagasinRepository;
import tn.esprit.oualhieyaexblanc.DAO.Repository.PersonnelRepository;

import java.time.LocalDate;
import java.util.List;
@Service
@AllArgsConstructor
public class MagasinService implements  IMagasinService{

    MagasinRepository magasinRepository;
    PersonnelRepository personnelRepository;
    ClientRepository clientRepository;

    CarteFIdRepository carteFIdRepository;
    @Override
    public Magasin ajouterMagasinEtPersonnels(Magasin magasin) {
        List<Personnel> caiss = magasin.getCaissiers();
        personnelRepository.saveAll(caiss);
        return magasinRepository.save(magasin);
    }

    @Override
    public void affecterClientAMagasin(int idClient, int idMagasin) {
        Client client = clientRepository.findById(idClient).get();
        Magasin magasin = magasinRepository.findById(idMagasin).get();

        magasin.getClients().add(client);
        magasinRepository.save(magasin);
    }

    @Override
    public void ajouterCarteEtAffecterClient(CarteFId carteFId, long cin) {
        Client c = clientRepository.findByCIN(cin);
        carteFId.setSolde(0);
        carteFId.setDateCreation(LocalDate.now());
        c.setCarteFId(carteFId);
        clientRepository.save(c);
    }

    @Override
    public List<Client> afficherClients(String nomMagasin) {
        Magasin magasin = magasinRepository.findByNom(nomMagasin);
        if (magasin != null) {
            return magasin.getClients();
        }
        return null;
    }



    @Scheduled(cron = "0 0 8 * * ?")
    public void totalSolde() {
        List<Magasin> magasins = magasinRepository.findAll();

        for (Magasin magasin : magasins) {
            int totalSolde = calculTotalSolde(magasin);
            System.out.println("Magasin " + magasin.getNomMagasin() + " - Total Solde: " + totalSolde);
        }
    }

    private int calculTotalSolde(Magasin magasin) {
        List<Client> clients = magasin.getClients();
        int totalSolde = 0;

        for (Client client : clients) {
            CarteFId carteFId = client.getCarteFId();
            if (carteFId != null) {
                totalSolde += carteFId.getSolde();
            }
        }

        return totalSolde;
    }

}
