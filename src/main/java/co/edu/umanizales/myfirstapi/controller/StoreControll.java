package co.edu.umanizales.myfirstapi.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/store")
public class StoreControll {
    @GetMapping
    public String hello(){
        return "hola lindos";
    }
}
