package com.example.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import javax.persistence.Id;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


@Controller
public class SongrController {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    songRepository repo;

    @RequestMapping("/")
    public String home(){return "home.html";}

    @RequestMapping("/hello")
    public String hello(){
        return "helloWorld.html";
    }

    @RequestMapping("/capitalize/{hello}")
    @ResponseBody public String capitalize(@PathVariable("hello") String hello){
        String newWrold = hello.toUpperCase();
        return newWrold;
    }

    //Post:

    @GetMapping("/albums")
    public String getBooks(Model model){
        model.addAttribute("album",albumRepository.findAll());
        return "album.html";//album.html
    }

    @GetMapping("/form")
    public String addAlbum(){ return "addedalbums.html";}

    @PostMapping("/addAlbum")
    public RedirectView addAlbum( @RequestParam(value="title") String title,
                                  @RequestParam(value="artist")String artist,
                                  @RequestParam(value="songCount") int songCount,
                                  @RequestParam(value="length") String length,
                                  @RequestParam(value="imageUrl") String imageUrl){
        Album album = new Album(title, artist, songCount, length , imageUrl);
        albumRepository.save(album);
        return new RedirectView("/albums");
    }

    @GetMapping("/album/{id}")
    public String showSong(@PathVariable(value="id") Long id, Model m){
        Album album = albumRepository.findById(id).orElseThrow();
        m.addAttribute("album",album);
        List<Song> songs = album.getSongs();
        m.addAttribute("songs",songs);
        return "songs";
    }

    @PostMapping("/songs/{albumId}")
    public RedirectView addSong(@RequestParam String title ,
                                @RequestParam Long length,
                                @RequestParam Long trackNumber ,
                                @PathVariable Long albumId){
        Song song = new Song(title , length , trackNumber );
        Album album = albumRepository.findById(albumId).orElseThrow();
        song.setAlbum(album);
        repo.save(song);
        return new RedirectView("/albums/{albumId}");
    }
}
