package tn.esprit.oualhieyaexblanc.DAO.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.oualhieyaexblanc.DAO.Entities.Magasin;
import tn.esprit.oualhieyaexblanc.DAO.Entities.Personnel;

public interface PersonnelRepository extends JpaRepository<Personnel,Integer> {
}
