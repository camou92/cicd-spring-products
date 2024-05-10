package com.camoutech;

import com.camoutech.entities.Categorie;
import com.camoutech.entities.Produit;
import com.camoutech.repository.ProduitRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class ProductsApplicationTests {
	@Autowired
	ProduitRepository produitRepository;

    /*@Test
	public void testCreateProduct() {
		Produit produit = new Produit("Pc Hp", 132.25, new Date());
		this.produitRepository.save(produit);
	}*/

	/*@Test
	public void testFindByProduct() {
		Produit p = this.produitRepository.findById(1L).get();
		System.out.println(p);
	}*/

	/*@Test
	public void testUpdateProduct() {
		Produit p = this.produitRepository.findById(1L).get();
		p.setNomProduit("Dell 360");
		this.produitRepository.save(p);
	}*/

	@Test
	public void testDeleteProduct() {
		this.produitRepository.deleteById(1L);
	}

	@Test
	public void testListProduct() {
		List<Produit> produits = this.produitRepository.findAll();

		for (Produit p : produits) {
			System.out.println(p);
		}
	}

	@Test
	public void testProductByNom(){
		List<Produit> p = this.produitRepository.findByNomProduit("Pc Hp");
		for (Produit produit : p){
			System.out.println(p);
		}

	}

	@Test
	public void testProductByNomContains(){
		List<Produit> p = this.produitRepository.findByNomProduitContains("P");
		for (Produit produit : p){
			System.out.println(produit);
		}

	}

	@Test
	public void testProductByNomPrix(){
		List<Produit> p = this.produitRepository.findByNomPrix("Pc Hp", 130.5);
		for (Produit produit : p){
			System.out.println(produit);
		}

	}

	@Test
	public void testFindByCategorie() {
		Categorie cat = new Categorie();
		cat.setIdCat(1L);

		List<Produit> prods = this.produitRepository.findByCategorie(cat);
		for (Produit produit : prods){
			System.out.println(produit);
		}
	}

	/*public void testFindByCategorieIdCat() {
		List<Produit> prods = produitRepository.findByCategorieIdCat(1L);
		for (Produit produit : prods){
			System.out.println(produit);
		}
	}*/

	/*@Test
	public void testFindByOrderByNomProduct() {
		List<Produit> prods = produitRepository.findByOrderByNomProduitASC();
		for (Produit produit : prods){
			System.out.println(produit);
		}
	}*/


}
