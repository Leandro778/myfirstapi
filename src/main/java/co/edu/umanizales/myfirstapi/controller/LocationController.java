package co.edu.umanizales.myfirstapi.controller;


import co.edu.umanizales.myfirstapi.model.Location;
import co.edu.umanizales.myfirstapi.model.Seller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/location")
public class LocationController {
    @GetMapping

    public String Getlocation() {

        Seller juan = new Seller("12345678", "juan", "ospina", 'M', (byte)23, new Location("05001", "medellin"));
        Seller alex = new Seller("09876453", "alex", "navarro", 'M', (byte)29, new Location("05002", "medellin"));
        Seller daniela = new Seller("49831276", "daniela", "gallego", 'F', (byte)56, new Location("05003", "medellin"));
        return "ukraina";

    }
}
