package myweb.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarsModel {
    private String mark;
    private String carYear;
    private String color;
    private String price;
    private Long userId;
    private String volume;
    private String privod;
    private String kuzov;
    private String korobkaPeredach;
    private String rul;
}
