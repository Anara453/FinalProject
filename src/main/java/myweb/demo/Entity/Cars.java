package myweb.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cars {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "mark")
    private String mark;
    @Column(name = "car_year")
    private String carYear;
    @Column(name = "color")
    private String color;
    @Column(name = "price")
    private String price;
    @ManyToOne
    @JoinColumn(name = "user_id")//owner id
    private User user;

}
