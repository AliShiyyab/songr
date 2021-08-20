package com.example.songr.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @GetMapping("/helloWorld")
    public String getHelloWorld(){
        return "helloWorld.html";
    }

    @GetMapping("/capital/{words}")
    @ResponseBody
    public String getCapital(@PathVariable(value = "words") String words){
        return words.toUpperCase();
    }
}
