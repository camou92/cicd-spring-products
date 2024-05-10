package com.camoutech.dto;

import com.camoutech.entities.Categorie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProduitDTO {
    private Long idProduit;
    private String nomProduit;
    private Double prixProduit;
    private Date dateCreation;
    private Categorie categorie;
}
