package co.edu.umanizales.myfirstapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter

public class Location {
    private String municipality;
    private String code;
}
