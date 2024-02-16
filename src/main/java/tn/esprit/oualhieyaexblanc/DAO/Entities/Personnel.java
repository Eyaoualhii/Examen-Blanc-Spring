package tn.esprit.oualhieyaexblanc.DAO.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Personnel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPersonnel;

    private String nomPersonnel;

    private String prenomPersonnel;

    private LocalDate dateNaissance;

    private TypePersonnel typePersonnel;
    @OneToOne
    Magasin magasin;

    @ManyToOne
    Magasin magasin2;

}
