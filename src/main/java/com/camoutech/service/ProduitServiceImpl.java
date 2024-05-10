package com.camoutech.service;

import com.camoutech.dto.ProduitDTO;
import com.camoutech.entities.Categorie;
import com.camoutech.entities.Produit;
import com.camoutech.repository.ProduitRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProduitServiceImpl implements ProduitService{

    private ModelMapper modelMapper;
    private ProduitRepository produitRepository;
    @Override
    public ProduitDTO saveProduit(Produit p) {
        return convertEntityToDto(produitRepository.save(p));
    }

    @Override
    public Produit updateProduit(Produit p) {
        return produitRepository.save(p);
    }

    @Override
    public void deleteProduit(Produit p) {
        this.produitRepository.delete(p);
    }

    @Override
    public void deleteProduitById(Long id) {
        this.produitRepository.deleteById(id);
    }

    @Override
    public ProduitDTO getProduit(Long id) {

        return convertEntityToDto(this.produitRepository.findById(id).get());
    }

    @Override
    public List<ProduitDTO> getAllProduits() {

        return produitRepository.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());

        /*List<Produit> prods = produitRepository.findAll();
        List<ProduitDTO> listprodDto = new ArrayList<>(prods.size());

        for (Produit p: prods)
            listprodDto.add(convertEntityToDto(p));

        return listprodDto;*/
    }

    @Override
    public List<Produit> findByNomProduit(String nom) {

        return this.produitRepository.findByNomProduit(nom);
    }

    @Override
    public List<Produit> findByNomProduitContains(String nom) {
        return this.produitRepository.findByNomProduitContains(nom);
    }

    @Override
    public List<Produit> findByNomPrix(String nom, Double prix) {
        return this.produitRepository.findByNomPrix(nom, prix);
    }

    @Override
    public List<Produit> findByCategorie(Categorie categorie) {
        return this.produitRepository.findByCategorie(categorie);
    }

    @Override
    public List<Produit> findByCategorieIdCat(Long id) {
        return this.produitRepository.findByCategorieIdCat(id);
    }

    @Override
    public ProduitDTO convertEntityToDto(Produit p) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        ProduitDTO produitDTO = modelMapper.map(p, ProduitDTO.class);
        return produitDTO;

       /* ProduitDTO produitDTO = new ProduitDTO();
        produitDTO.setIdProduit(p.getIdProduit());
        produitDTO.setNomProduit(p.getNomProduit());
        produitDTO.setPrixProduit(p.getPrixProduit());
        produitDTO.setCategorie(p.getCategorie());
        return produitDTO;*/

       /* return ProduitDTO.builder()
                .idProduit(p.getIdProduit())
                .nomProduit(p.getNomProduit())
                .prixProduit(p.getPrixProduit())
                .dateCreation(p.getDateCreation())
                .nomCat(p.getCategorie().getNomCat())
                //.categorie(p.getCategorie())
                .build();*/
    }

    @Override
    public Produit convertDtoToEntity(ProduitDTO p) {
        Produit produit = modelMapper.map(p, Produit.class);
        return produit;
    }

   /* @Override
    public List<Produit> findByOrderByNomProduitAsc() {
        return this.produitRepository.findByOrderByNomProduitASC();
    }

    @Override
    public List<Produit> trierProduitsNomsPrix() {
        return this.produitRepository.trierProduitsNomsPrix();
    }*/
}
