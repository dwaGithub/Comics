package com.example.comics.controllers;

import com.example.comics.models.Comic;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.comics.repositories.ComicRepository;

import java.util.List;

@Api(value = "Comics controller", description = "REST endpoints for comics")
@RestController
public class Comics {

    @Autowired
    ComicRepository comic;

    @GetMapping("/comics")
    public List<Comic> getComics(){
        return comic.findAll();
    }

  @GetMapping("/comics/{id}")
  public Comic getComicById(@PathVariable long id){
        return comic.getById(id);
  }

  @PostMapping("/comics")
  public Comic addComic(@RequestBody Comic newComic){
        newComic.setId(null);
        return comic.save(newComic);
  }

    @PutMapping("/comics/{id}")
    public String updateComicById(@PathVariable Long id, @RequestBody Comic comicToUpdate) {
        return comic.findById(id).map(foundComic -> {
            foundComic.setName(comicToUpdate.getName());
            foundComic.setSuperpower(comicToUpdate.getSuperpower());
            comic.save(foundComic);
            return "Comic updated";
        }).orElse("Comic not found");
    }

    @DeleteMapping("/comics/{id}")
    public void deleteComicById(@PathVariable Long id) {
        comic.deleteById(id);
    }
}
