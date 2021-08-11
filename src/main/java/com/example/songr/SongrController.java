package com.example.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class SongrController {

    @Autowired
    AlbumRepository albumRepository;

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
//
//    @Pos("AllAlbums")
    public RedirectView addAlbum( @RequestParam(value="title") String title,
                                  @RequestParam(value="artist")String artist,
                                  @RequestParam(value="songCount") int songCount,
                                  @RequestParam(value="length") String length,
                                  @RequestParam(value="imageUrl") String imageUrl){
        Album album = new Album(title, artist, songCount, imageUrl, length);
        albumRepository.save(album);
        return new RedirectView("/albums");
    }
}
