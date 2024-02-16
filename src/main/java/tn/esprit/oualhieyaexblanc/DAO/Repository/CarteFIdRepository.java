package tn.esprit.oualhieyaexblanc.DAO.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.oualhieyaexblanc.DAO.Entities.CarteFId;
import tn.esprit.oualhieyaexblanc.DAO.Entities.Client;

public interface CarteFIdRepository extends JpaRepository<CarteFId,Integer> {

    @Query("select cd from CarteFId cd where cd.numeroCarte=?1")
   CarteFId findByNumeroCarte(long numCarte);
}
