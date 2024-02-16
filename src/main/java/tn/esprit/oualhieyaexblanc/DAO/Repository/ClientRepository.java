package tn.esprit.oualhieyaexblanc.DAO.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.oualhieyaexblanc.DAO.Entities.Client;

public interface ClientRepository extends JpaRepository<Client,Integer> {
    @Query("select c from Client c where c.cin=?1")
    Client findByCIN(long cin);
}
