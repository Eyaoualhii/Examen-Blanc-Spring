package tn.esprit.oualhieyaexblanc.DAO.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.oualhieyaexblanc.DAO.Entities.Client;
import tn.esprit.oualhieyaexblanc.DAO.Entities.Magasin;

public interface MagasinRepository extends JpaRepository<Magasin,Integer> {

    @Query("select m from Magasin m where m.nomMagasin=?1")
    Magasin findByNom(String nomMagasin);
}
