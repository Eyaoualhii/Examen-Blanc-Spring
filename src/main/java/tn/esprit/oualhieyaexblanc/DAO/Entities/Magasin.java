package tn.esprit.oualhieyaexblanc.DAO.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Magasin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMagasin;

    private String nomMagasin;

    private String adresseMagsin;

    private long contactMagasin;

    @OneToOne(mappedBy = "magasin")
    Personnel directeur;

    @OneToMany(mappedBy = "magasin2")
    List<Personnel> caissiers;


    @ManyToMany(mappedBy = "magasinsCt")
    List<Client> clients;

}
