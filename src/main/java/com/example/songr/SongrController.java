package com.example.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;

@Controller
public class SongrController {

    @RequestMapping("/hello")
    public String hello(){
        return "helloWorld.html";
    }

    @RequestMapping("/capitalize/{hello}")
    @ResponseBody public String capitalize(@PathVariable("hello") String hello){
        String newWrold = hello.toUpperCase();
        return newWrold;
    }


    @RequestMapping("/album")
    public String album(Model modal){
        ArrayList albums = new ArrayList();
        Album first = new Album("ElDorado" , "Shakira" , 15 , "2:30" , "https://upload.wikimedia.org/wikipedia/en/a/a7/Shakira_El_Dorado_cover.png");
        Album second = new Album("Aw'at" , "Nassif Zeytoun" , 1 , "4:30 min" , "https://i1.sndcdn.com/artworks-dNOYF2wGeOP4JqME-6In1eQ-t500x500.jpg");
        Album third = new Album("Album 8" , "Nancy Ajram" , 15 , "1:00:30" , "https://upload.wikimedia.org/wikipedia/ar/f/fa/Nancy_ajram_-_nancy_8_-_2014.jpg");
        albums.add(first);
        albums.add(second);
        albums.add(third);
        modal.addAttribute("album",albums);

        return "album.html";//album.html
    }

}
