package co.edu.umanizales.myfirstapi.controller;

import co.edu.umanizales.myfirstapi.model.Location;
import co.edu.umanizales.myfirstapi.model.Seller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path = "/seller")
public class SellerController {
@GetMapping
    public String Getseller() {
           /// instanciar 5 sellers
    Seller Juan = new Seller ("10034231", "Juan", "osorio", "M", "23", new Location("05021", "alejandria"));
    Seller andres = new Seller("98235735", "andres", "navarro", "M", "56", new Location("05002","abejorral"));
    Seller sofia = new Seller("38965109", "sofia", "gallego", "F", "34", new Location("05030", "amagá"));//seller pepito = new seller()
    Seller daniela = new Seller("09876543", "daniela", "ospina", "F","50", new Location("05034", "andes"));
    Seller alex = new Seller("12345678", "alex", "savater", "M", "18", new Location("05044", "anzá"));
    return "besarabia";}
    }
