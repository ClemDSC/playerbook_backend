package com.playerbook.demo.genre;

import com.playerbook.demo.game.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genre")
public class GenreController {

    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    // create
    @PostMapping("/add")
    public ResponseEntity<Genre> addGenre(@RequestBody Genre genre){
        Genre newGenre = genreService.addGenre(genre);
        return new ResponseEntity<>(newGenre, HttpStatus.OK);
    }

    // read
    @GetMapping
    public ResponseEntity<List<Genre>> getAllGenres() {
        List<Genre> allGenres = genreService.findAllGenres();
        return new ResponseEntity<>(allGenres, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genre> getOneGenre(@PathVariable("id") Long id) {
        Genre oneGenre = genreService.findGenreById(id);
        return new ResponseEntity<>(oneGenre, HttpStatus.OK);
    }

    // update
    @PutMapping("/{id}")
    public ResponseEntity<Genre> updateGenre(@PathVariable("id") Long id, @RequestBody Genre genre) {
        Genre updatedGenre = genreService.updateGenreById(id, genre);
        return new ResponseEntity<>(updatedGenre, HttpStatus.OK);
    }

    // delete
    @DeleteMapping("/{id}")
    public void deleteGenre(@PathVariable("id") Long id){
        genreService.deleteGenreById(id);
        new ResponseEntity<>(HttpStatus.OK);
    }
}
