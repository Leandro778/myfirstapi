package co.edu.umanizales.myfirstapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
public class Sale {
    private short quantity;
    private String date;
    private String seller;
    private String store;


}
