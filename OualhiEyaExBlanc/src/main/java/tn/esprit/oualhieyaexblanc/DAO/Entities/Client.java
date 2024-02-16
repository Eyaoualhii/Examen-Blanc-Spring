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
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClient;

    private String nomClient;

    private String prenomClient;

    private String adresseClient;
    @Column(unique = true)
    private long cin;

    @OneToOne
    CarteFId carteFId;

    @ManyToMany
    List<Magasin> magasinsCt;

}
