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
public class CarteFId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCarte;

    @Column(unique = true)
    private long numeroCarte;

    private long solde;

    private LocalDate dateCreation;

}
