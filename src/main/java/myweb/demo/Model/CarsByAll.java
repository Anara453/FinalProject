package myweb.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarsByAll {
    private String mark;
    private String carYear;
    private String img;
    private String color;
    private String price;
    private Long userId;
}
