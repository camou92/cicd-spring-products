package com.camoutech.controllers;

import com.camoutech.entities.Categorie;
import com.camoutech.repository.CategoryRepositiry;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cat")
@CrossOrigin("*")
@AllArgsConstructor
public class CategoryController {

    private CategoryRepositiry categoryRepositiry;

    @GetMapping
    public List<Categorie> getAllCategories() {
        return categoryRepositiry.findAll();
    }

    @PostMapping
    public Categorie categorieSave(Categorie categorie) {
        return categoryRepositiry.save(categorie);
    }

    @GetMapping("{id}")
    public Categorie getCategorieById(@PathVariable Long id){
        return categoryRepositiry.findById(id).get();
    }
}
