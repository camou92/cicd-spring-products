package com.camoutech.service;

import com.camoutech.dto.ProduitDTO;
import com.camoutech.entities.Categorie;
import com.camoutech.entities.Produit;

import java.util.List;

public interface ProduitService {
    ProduitDTO saveProduit(Produit p);
    ProduitDTO getProduit(Long id);
    List<ProduitDTO> getAllProduits();
    Produit updateProduit(Produit p);
    void deleteProduit(Produit p);
    void deleteProduitById(Long id);
    List<Produit> findByNomProduit(String nom);
    List<Produit> findByNomProduitContains(String nom);
    List<Produit> findByNomPrix(String nom, Double prix);
    List<Produit> findByCategorie(Categorie categorie);
    List<Produit> findByCategorieIdCat(Long id);

    ProduitDTO convertEntityToDto(Produit p);
    Produit convertDtoToEntity(ProduitDTO p);

    /*List<Produit> findByOrderByNomProduitAsc();
    List<Produit> trierProduitsNomsPrix();*/
}
