package com.camoutech.controllers;

import com.camoutech.dto.ProduitDTO;
import com.camoutech.entities.Produit;
import com.camoutech.service.ProduitService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin
@AllArgsConstructor
public class ProductController {
    private ProduitService produitService;
    @PostMapping("addpost")
    public ProduitDTO createProduct(@RequestBody Produit produit) {
        return this.produitService.saveProduit(produit);
    }

    @GetMapping("all")
    List<ProduitDTO> getAllProducts() {
        return this.produitService.getAllProduits();
    }
    @GetMapping("getbyid/{id}")
    public ProduitDTO getProduct(@PathVariable Long id) {
        return this.produitService.getProduit(id);
    }
    @PutMapping("updateProd")
    public Produit updateProduct(@RequestBody Produit produit) {
        return this.produitService.updateProduit(produit);
    }
    @DeleteMapping("delprod/{id}")
    public void deleteProduct(@PathVariable Long id) {
        this.produitService.deleteProduitById(id);
    }

    @GetMapping("prodsByName/{nom}")
    public List<Produit> findByNomProduitContains(@PathVariable("nom") String nom) {
        return produitService.findByNomProduitContains(nom);
    }
    @GetMapping("prodcat/{idCat}")
    public List<Produit> getProductBycategorie(@PathVariable("idCat") Long idCat) {
        return this.produitService.findByCategorieIdCat(idCat);
    }


}
