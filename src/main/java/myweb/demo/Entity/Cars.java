package myweb.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    @Column(name = "volume")
    private String volume;
    @Column(name = "price")
    private String price;
    @Column(name = "privod")
    private String privod;
    @Column(name = "kuzov")
    private String kuzov;
    @Column(name = "korobkaPeredach")
    private String korobkaPeredach;
    @Column(name = "rul")
    private String rul;
    @ManyToOne
    @JoinColumn(name = "user_id")//owner id
    private User user;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpload;

    @PrePersist
    public void persistCreate(){
        this.dateCreated = LocalDateTime.now();
    }
    @PreUpdate
    public void persistUpdate(){
        this.dateUpload = LocalDateTime.now();
    }
}

