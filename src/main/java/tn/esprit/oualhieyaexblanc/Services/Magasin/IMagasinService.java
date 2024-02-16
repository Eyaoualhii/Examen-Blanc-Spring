package tn.esprit.oualhieyaexblanc.Services.Magasin;

import tn.esprit.oualhieyaexblanc.DAO.Entities.CarteFId;
import tn.esprit.oualhieyaexblanc.DAO.Entities.Client;
import tn.esprit.oualhieyaexblanc.DAO.Entities.Magasin;

import java.util.List;

public interface IMagasinService {

    Magasin ajouterMagasinEtPersonnels(Magasin magasin);


    void affecterClientAMagasin(int idClient , int idMagasin);

    void  ajouterCarteEtAffecterClient(CarteFId carteFId,long cin);


    List<Client> afficherClients(String nomMagasin);
    void totalSolde();


}
