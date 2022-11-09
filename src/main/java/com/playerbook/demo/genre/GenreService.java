package com.playerbook.demo.genre;

import com.playerbook.demo.game.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    // create
    public Genre addGenre(Genre genre){
        return genreRepository.save(genre);
    }

    // read
    public List<Genre> findAllGenres(){
        return genreRepository.findAll();
    }

    public Genre findGenreById(Long id){
        return genreRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("sorry, id " + id + " not found")
        );
    }

    // update
    public Genre updateGenreById(Long id, Genre genre){
        Genre genreFound = genreRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("sorry, id " + id + " not found")
        );
        genreFound.setName(genre.getName());
        genreFound.setGameList(genre.getGameList());

        return genreRepository.save(genreFound);
    }

    // delete

    public void deleteGenreById(Long id){
        genreRepository.deleteById(id);
    }

}
